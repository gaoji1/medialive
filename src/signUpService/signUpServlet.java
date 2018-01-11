package signUpService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medialive.DAO.impl.liveDAOImpl;
import medialive.domain.live;

public class signUpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("signUp doPOST");
		// 设置响应编码
		resp.setCharacterEncoding("utf-8");
		// 获取DAO对象
		liveDAOImpl liveDAO = new liveDAOImpl();
		// 获取POST请求参数
		String roomName = req.getParameter("roomName");
		String streamName = req.getParameter("streamName");
		// 查询数据库
		live liveDemo_1 = liveDAO.getByroom(roomName);
		live liveDemo_2 = liveDAO.getBystream(streamName);
		// 判断直播间是否存在
		if (liveDemo_1.getId() == null && liveDemo_2.getId() == null) {
			live liveDemo = new live();
			liveDemo.setRoomName(roomName);
			liveDemo.setStreamName(streamName);
			liveDemo.setRed5URL("/myApp");
			liveDAO.save(liveDemo);
			resp.getWriter().println("直播间注册成功!");

		} else if (liveDemo_1.getId() != null && liveDemo_2.getId() == null) {
			resp.getWriter().println("您的直播间命名冲突,请重新为直播间起个名字");
		} else if (liveDemo_1.getId() == null && liveDemo_2.getId() != null) {
			resp.getWriter().println("您的直播流名称已被占用,请重新命名");
		} else {
			resp.getWriter().println("直播间名称与流名称均冲突,请重新命名");
		}

	}

}
