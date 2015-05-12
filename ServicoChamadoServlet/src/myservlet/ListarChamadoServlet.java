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
import com.google.gson.GsonBuilder;

@SuppressWarnings("serial")
public class ListarChamadoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
		List<Chamado> chamados = ChamadoRepository.getChamados();
		
		Gson gson = new GsonBuilder()
		   .setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();
		
		String json = gson.toJson(chamados);
		resp.getWriter().write(json);
		
		resp.setStatus(HttpServletResponse.SC_OK);
	}

}
