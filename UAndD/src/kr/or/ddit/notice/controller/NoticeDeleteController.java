package kr.or.ddit.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;

@WebServlet("/notice/delete.do")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("noticeNo"));
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		int cnt = noticeService.deleteNotice(no);
		
		String msg = "";
		if(cnt>0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("msg", msg);
		
		response.sendRedirect(request.getContextPath()+"/notice/list.do");
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
