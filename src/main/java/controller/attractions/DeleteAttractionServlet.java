package controller.attractions;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AttractionService;

@WebServlet("/attractions/delete.do")
public class DeleteAttractionServlet extends HttpServlet {	
	private static final long serialVersionUID = -8325251143508242409L;
	private AttractionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		attractionService.delete(id);

		resp.sendRedirect("/TP-Park/attractions/index.do");
	}
}
