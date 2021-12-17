package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import model.User;

@WebFilter(urlPatterns = "*.do")
public class LoggedFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
		if (user != null) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("flash", "Inicie sesión por favor.");

			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}

	}

}

//@WebFilter(urlPatterns = "*.do")
//public class LoggedFilter implements Filter {
//
//	//Sirve para que exista un usuario logueado, sino me manda al login.jsp
//	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//			throws IOException, ServletException {
//		String user = (String) ((HttpServletRequest) req).getSession().getAttribute("user");
//		if (user != null) {
//			chain.doFilter(req, resp);
//		} else {
//			req.setAttribute("flash", "Por favor, inicie sesión");
//			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/login.jsp");
//			dispatcher.forward(req, resp);
//		}
//	}
//}
    
 
