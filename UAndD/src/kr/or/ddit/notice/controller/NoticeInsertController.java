package kr.or.ddit.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;

@WebServlet("/notice/insert.do")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/view/notice/noticeInsertForm.jsp");
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//int no = Integer.parseInt(request.getParameter("notice_no"));
		String title = request.getParameter("notice_title");
		String content = request.getParameter("notice_content");
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		NoticeVO noticeVO = new NoticeVO(title, content);

		int cnt = service.insertNotice(noticeVO);
		
		response.sendRedirect(request.getContextPath()+"/notice/list.do");
	}

}
