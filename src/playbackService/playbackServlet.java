package playbackService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import medialive.DAO.impl.playbackDAOImpl;
import medialive.domain.playback;

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
		List<playback> playbackList = playbackDAO.list();
		String jsonString = JSON.toJSONString(playbackList);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println(jsonString);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("playbackdoPOST");
		resp.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		playbackDAOImpl playbackDAO = new playbackDAOImpl();
		playback pbDemo = playbackDAO.getByid(new Long(id));
		resp.getWriter().println(JSON.toJSONString(pbDemo));
		
	}
	
	

}
