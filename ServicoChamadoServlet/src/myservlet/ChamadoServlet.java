package myservlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.IServicoChamado;
import chamado.Chamado;
import chamado.ChamadoRepository;
import chamado.TipoChamado;

@SuppressWarnings("serial")
public class ChamadoServlet extends HttpServlet {
	
	private List<IServicoChamado> servicoChamados;
	
	public ChamadoServlet(List<IServicoChamado> servicoChamados) {
		this.servicoChamados = servicoChamados;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().write("<html><body>");
		resp.getWriter().write("<h2>Chamados</h2>");
		
		resp.getWriter().write("<h3>Tipos de Chamados (bundles OSGi)</h3>");
		
		if (servicoChamados == null || servicoChamados.isEmpty()) {
			resp.getWriter().write("<p>Serviços indisponíveis</p>");
		}
		
		resp.getWriter().write("<ul>");
		for (IServicoChamado iServicoChamado : servicoChamados) {
			resp.getWriter().write("<li>" + iServicoChamado.getDescricao() + "</li>");
		}
		resp.getWriter().write("</ul>");

		resp.getWriter().write("<h3>Serviços REST sobre os Servlets OSGi</h3>");
		
		resp.getWriter().write("<ul>");
		resp.getWriter().write("<li><a href='chamados/tiposchamados'>GET http://localhost:8080/chamados/tiposchamados (application/json)</a></li>");
		resp.getWriter().write("<li>POST http://localhost:8080/chamados (application/x-www-form-urlencoded)");
		resp.getWriter().write("	<ul><li>headers (Content-Type:application/x-www-form-urlencoded)</li><li>body (tipo_chamado=PP&descricao=buraco+na+minha+rua&latitude=-9.6463367&longitude=-35.7352281)</li></ul></li>");
		resp.getWriter().write("<li>PUT http://localhost:8080/chamados (application/x-www-form-urlencoded)");
		resp.getWriter().write("	<ul><li>headers (Content-Type=application/x-www-form-urlencoded)</li><li>body (id=1430794777158&status=P)</li></ul></li>");
		resp.getWriter().write("<li><a href='chamados/lista'>GET http://localhost:8080/chamados/lista (application/json)</a></li>");
		resp.getWriter().write("<li>GET http://localhost:8080/chamados/detalhes?id=1430793960316 (application/json)</li>");
		resp.getWriter().write("</ul>");

		resp.getWriter().write("<h3>Servlet de Mapas</h3>");
		resp.getWriter().write("<a href='chamados/mapa?lat=-8.0372619&lng=-34.8713684'>http://localhost:8080/chamados/mapa?lat=-8.0372619&lng=-34.8713684</a>");
		
		resp.getWriter().write("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		try {
			
			if (req.getParameter("tipo_chamado") != null &&
						req.getParameter("descricao") != null &&
						req.getParameter("latitude") != null &&
						req.getParameter("longitude") != null) {
				
				String codigoTipoChamado = req.getParameter("tipo_chamado");
				String descricao = req.getParameter("descricao");
				double latitude = Double.parseDouble(req.getParameter("latitude"));
				double longitude = Double.parseDouble(req.getParameter("longitude"));
				
				Chamado chamado = new Chamado(descricao, new Date(), Chamado.STATUS_OPEN, latitude, longitude, new TipoChamado(codigoTipoChamado));
				
				ChamadoRepository.save(chamado);
				
				resp.setStatus(HttpServletResponse.SC_CREATED);
				resp.addHeader("mensagem", "Chamado criado com sucesso");
				resp.addHeader("Location", "http://localhost:8080/chamados/detalhes?id=" + chamado.getId());
			} else {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				resp.addHeader("mensagem", "Parâmetros inválidos");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.addHeader("mensagem", "Parâmetros inválidos");
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		String status = req.getParameter("status");
		
		List<Chamado> chamados = ChamadoRepository.getChamados();
		
		try {
			if (chamados.contains(new Chamado(id))) {
				Chamado chamado = chamados.get(chamados.indexOf(new Chamado(id)));
				chamado.setStatus(status);

				resp.setStatus(HttpServletResponse.SC_OK);
				resp.addHeader("mensagem", "Chamado atualizado com sucesso");
				resp.addHeader("Location", "http://localhost:8080/chamados/detalhes?id=" + chamado.getId());
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				resp.addHeader("mensagem", "Chamado não existe");
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		}
	}

	public void addServicosChamado(List<IServicoChamado> servicosChamado) {
		this.servicoChamados = servicosChamado;
	}
	
}
