//falta que verifique si alguien ya esta logueado
// o sea, te deja loguearte otra vez sin cerrar sesion

package controller.session;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import services.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -46688658298314031L;	
	private LoginService loginService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	
    	User user = loginService.login(username, password);
    	
    	if (!user.isNull()) {
    		req.getSession().setAttribute("user", user);
    		resp.sendRedirect("index.jsp");    		
       	} else {
    		req.setAttribute("flash", "Nombre de usuario o contraseña incorrectos");
    		
    		RequestDispatcher dispatcher = getServletContext()
      		      .getRequestDispatcher("/login.jsp");
      		    dispatcher.forward(req, resp);
    	}
    }
}


//cambiar el metodo que chequea la clave, ya que nunca va en texto plano
//hacer una tabla hash 
		//if(!username.isBlank() && password.equals("123")) {
//a la sesion solo se le setean atributos			
		//req.getSession().setAttribute("username", username);
		//// req.getSession().setAttribute("tiempo", ...);
		//// req.getSession().setAttribute("monedas", ...);