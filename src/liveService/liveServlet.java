package liveService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

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
//		�����ݿ�����ȡֱ������Ϣ
		liveDAOImpl liveDAO = new liveDAOImpl();
		List<live> liveList = liveDAO.list();
//		ֱ������Ϣת����json�ַ���
		String jsonString = JSON.toJSONString(liveList);
//		System.out.println(jsonString);
//		��������������ʽ�����
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println(jsonString);
		
	}
	
	

}
