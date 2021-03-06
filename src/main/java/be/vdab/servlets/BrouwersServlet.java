package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.services.BrouwerService;

/**
 * Servlet implementation class BrouwersServlet
 */
@WebServlet("/brouwers.htm")
public class BrouwersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/brouwers.jsp";
	private final transient BrouwerService brouwerService = new BrouwerService();
       
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null){
			request.setAttribute("mandje", session.getAttribute("mandje"));
		}
		request.setAttribute("brouwers", brouwerService.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
