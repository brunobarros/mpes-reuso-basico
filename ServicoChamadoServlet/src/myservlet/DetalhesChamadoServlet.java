package myservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chamado.Chamado;
import chamado.ChamadoRepository;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class DetalhesChamadoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = Long.valueOf(req.getParameter("id"));
		List<Chamado> chamados = ChamadoRepository.getChamados();
		
		try {
			if (chamados.contains(new Chamado(id))) {
				Chamado chamado = chamados.get(chamados.indexOf(new Chamado(id)));
			
				Gson gson = new Gson();
				String json = gson.toJson(chamado);
				
				resp.setContentType("application/json");
				resp.getWriter().write(json);
				resp.setStatus(HttpServletResponse.SC_OK);
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				resp.addHeader("mensagem", "Chamado não existe");
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		}
	}

}
