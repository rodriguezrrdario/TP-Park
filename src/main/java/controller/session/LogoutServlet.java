package controller.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = -7867918589650742322L;
	// service = doGet || doPost
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("user");
		req.setAttribute("success", "Nos vemos la proxima!!");

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/login.jsp");
		dispatcher.forward(req, resp);
	}
}

//@WebServlet("/logout")
//public class LogoutServlet extends HttpServlet {
//	private static final long serialVersionUID = 4224193167109372559L;
//       
//	 @Override
//	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	    	req.getSession().removeAttribute("username");
//			req.setAttribute("flash", "Nos vemos la proxima!!");
//			
//			RequestDispatcher dispatcher = req.getServletContext()
//	  		      .getRequestDispatcher("/login.jsp");
//	  		    dispatcher.forward(req, resp); 
//	    }
//	}