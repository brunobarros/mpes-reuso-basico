package myservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.IServicoChamado;
import chamado.TipoChamado;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class TipoChamadoServlet extends HttpServlet {
	
	private List<IServicoChamado> servicoChamados;
	
	public TipoChamadoServlet(List<IServicoChamado> servicoChamados) {
		this.servicoChamados = servicoChamados;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
		resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Content-Range, Content-Disposition, Content-Description");
				
		if (servicoChamados == null || servicoChamados.isEmpty()) {
			resp.getWriter().write("Serviços indisponíveis");
		} else {
			List<TipoChamado> tiposChamados = new ArrayList<TipoChamado>();
			for (IServicoChamado iServicoChamado : servicoChamados) {
				Map<String, String> atributos = iServicoChamado.getAtributosInput();
				
				TipoChamado tipoChamado = new TipoChamado(iServicoChamado.getSigla(), iServicoChamado.getDescricao());
				tipoChamado.setAtributosInput(atributos);
				
				tiposChamados.add(tipoChamado);
			}
			
			Gson gson = new Gson();
			String json = gson.toJson(tiposChamados);
			resp.getWriter().write(json);
		}
	}

}
