package liveService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medialive.DAO.impl.liveDAOImpl;
import medialive.domain.live;

public class liveServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGET");
		resp.setCharacterEncoding("utf-8");
		liveDAOImpl liveDAO = new liveDAOImpl();
		List<live> liveList = liveDAO.list();
		System.out.println(liveList);
	}
	
	

}
