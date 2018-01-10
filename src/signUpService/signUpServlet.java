package signUpService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medialive.DAO.impl.liveDAOImpl;

public class signUpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("signUp doPOST");
		resp.setCharacterEncoding("utf-8");
		liveDAOImpl liveDAO = new liveDAOImpl();
		String roomName = req.getParameter("roomName");
		String streamName = req.getParameter("streamName");
		resp.getWriter().println(roomName + streamName);		
	}
	

}
