package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

@WebServlet("/board/delete.do")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("brd_no"));
		IBoardService service = BoardServiceImpl.getInstance();
		int cnt = service.deleteBoard(no);
		
		String msg = "";
		if(cnt>0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("msg", msg);
		
		response.sendRedirect(request.getContextPath()+"/board/list.do");
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
