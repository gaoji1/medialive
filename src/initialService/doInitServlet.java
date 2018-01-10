package initialService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medialive.DAO.impl.liveDAOImpl;
import medialive.DAO.impl.playbackDAOImpl;

public class doInitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化initServlet");
		liveDAOImpl liveDAO = new liveDAOImpl();
		liveDAO.init();
		liveDAO.clear();
		playbackDAOImpl playbackDAO = new playbackDAOImpl();
		playbackDAO.init();
	}


	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("这是初始化servlet,不做业务用");
	}
	
	

	
	

}
