package myservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.IServicoChamado;
import chamado.TipoChamado;

import com.google.gson.Gson;

public class TipoChamadoServlet extends HttpServlet {
	
	private List<IServicoChamado> servicoChamados;
	
	public TipoChamadoServlet(List<IServicoChamado> servicoChamados) {
		this.servicoChamados = servicoChamados;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
		if (servicoChamados == null || servicoChamados.isEmpty()) {
			resp.getWriter().write("Serviços indisponíveis");
		} else {
			List<TipoChamado> tiposChamados = new ArrayList<TipoChamado>();
			for (IServicoChamado iServicoChamado : servicoChamados) {
				tiposChamados.add(iServicoChamado.getTipoChamado());
			}
			
			Gson gson = new Gson();
			String json = gson.toJson(tiposChamados);
			resp.getWriter().write(json);
		}
	}

}
