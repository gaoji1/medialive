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
		// ������Ӧ����
		resp.setCharacterEncoding("utf-8");
		// ��ȡDAO����
		liveDAOImpl liveDAO = new liveDAOImpl();
		// ��ȡPOST�������
		String roomName = req.getParameter("roomName");
		String streamName = req.getParameter("streamName");
		// ��ѯ���ݿ�
		live liveDemo_1 = liveDAO.getByroom(roomName);
		live liveDemo_2 = liveDAO.getBystream(streamName);
		// �ж�ֱ�����Ƿ����
		if (liveDemo_1.getId() == null && liveDemo_2.getId() == null) {
			live liveDemo = new live();
			liveDemo.setRoomName(roomName);
			liveDemo.setStreamName(streamName);
			liveDemo.setRed5URL("/myApp");
			liveDAO.save(liveDemo);
			resp.getWriter().println("ֱ����ע��ɹ�!");

		} else if (liveDemo_1.getId() != null && liveDemo_2.getId() == null) {
			resp.getWriter().println("����ֱ����������ͻ,������Ϊֱ�����������");
		} else if (liveDemo_1.getId() == null && liveDemo_2.getId() != null) {
			resp.getWriter().println("����ֱ���������ѱ�ռ��,����������");
		} else {
			resp.getWriter().println("ֱ���������������ƾ���ͻ,����������");
		}

	}

}
