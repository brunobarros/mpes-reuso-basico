package myservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.IServicoChamado;

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
		
		resp.getWriter().write("<h3>Tipos de Chamados</h3>");
		
		if (servicoChamados == null || servicoChamados.isEmpty()) {
			resp.getWriter().write("<p>Serviços indisponíveis</p>");
		}
		
		resp.getWriter().write("<ul>");
		for (IServicoChamado iServicoChamado : servicoChamados) {
			resp.getWriter().write("<li>" + iServicoChamado.getDescricao() + "</li>");
		}
		resp.getWriter().write("</ul>");

		resp.getWriter().write("<h3>Serviços REST</h3>");
		
		resp.getWriter().write("<ul>");
		resp.getWriter().write("<li><a href='chamados/tiposchamados'>GET http://localhost:8080/chamados/tiposchamados (application/json)</a></li>");
		resp.getWriter().write("<li>POST http://localhost:8080/chamados/ (application/json)</li>");
		resp.getWriter().write("</ul>");
		
		resp.getWriter().write("</body></html>");
	}

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        User user = userService.find(username, password);
//
//        if (user != null) {
//            request.getSession().setAttribute("user", user);
//            response.sendRedirect("home");
//        }
//        else {
//            request.setAttribute("error", "Unknown user, please try again");
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
//        }
    }

	
	public void addServicosChamado(List<IServicoChamado> servicosChamado) {
		this.servicoChamados = servicosChamado;
	}
	
}
