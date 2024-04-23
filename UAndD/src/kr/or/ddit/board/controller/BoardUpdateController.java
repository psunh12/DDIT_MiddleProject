package kr.or.ddit.board.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.BoardVO;


@WebServlet("/board/update.do")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNoParam = request.getParameter("brd_no");
		int no = 0;
		if (boardNoParam != null && !boardNoParam.isEmpty()) {
		    try {
		        no = Integer.parseInt(boardNoParam);
		    } catch (NumberFormatException e) {
		       e.printStackTrace();
		    }
		}
		
		
		IBoardService service = BoardServiceImpl.getInstance();
		 
		BoardVO boardVO = service.getBoard(no);
		
		request.setAttribute("boardVO", boardVO);
		
		request.getRequestDispatcher("/view/board/boardUpdateForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 request.setCharacterEncoding("UTF-8");
		
		String boardNoParam = request.getParameter("brd_no");
		int no = 0;
		if (boardNoParam != null && !boardNoParam.isEmpty()) {
		    try {
		        no = Integer.parseInt(boardNoParam);
		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		    }
		}
		String title = request.getParameter("brd_title");
		String content = request.getParameter("brd_content");
		
		
		IBoardService service = BoardServiceImpl.getInstance();
		BoardVO boardVO = new BoardVO(no, title, content);
		
		int cnt = service.updateBoard(boardVO);
		
		 
		
		response.sendRedirect(request.getContextPath()+"/board/list.do");
	}

}
