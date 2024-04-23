package kr.or.ddit.notice.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;

@WebServlet("/notice/update.do")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeNoParam = request.getParameter("noticeNo");
		int no = 0;
		if (noticeNoParam != null && !noticeNoParam.isEmpty()) {
		    try {
		        no = Integer.parseInt(noticeNoParam);
		    } catch (NumberFormatException e) {
		       e.printStackTrace();
		    }
		}
		
		
		INoticeService service = NoticeServiceImpl.getInstance();
		 
		NoticeVO noticeVO = service.getNotice(no);
		
		request.setAttribute("noticeVO", noticeVO);
		
		request.getRequestDispatcher("/view/notice/noticeUpdateForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 request.setCharacterEncoding("UTF-8");
		
		String noticeNoParam = request.getParameter("notice_no");
		int no = 0;
		if (noticeNoParam != null && !noticeNoParam.isEmpty()) {
		    try {
		        no = Integer.parseInt(noticeNoParam);
		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		    }
		}
		String title = request.getParameter("notice_title");
		String content = request.getParameter("notice_content");
		
		
		INoticeService service = NoticeServiceImpl.getInstance();
		NoticeVO noticeVO = new NoticeVO(no, title, content);
		
		int cnt = service.updateNotice(noticeVO);
		
		 
		
		response.sendRedirect(request.getContextPath()+"/notice/list.do");
	}

}
