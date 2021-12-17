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
		
		//Sirve para que exista un usuario logueado, sino me manda al login.jsp
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
//	String user = (String) ((HttpServletRequest) req).getSession().getAttribute("user");

 
