package playbackService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medialive.DAO.impl.playbackDAOImpl;

public class playbackServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("playbackdoGET");
		playbackDAOImpl playbackDAO = new playbackDAOImpl();
		playbackDAO.list();
	}
	
	

}
