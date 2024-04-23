package kr.or.ddit.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.ReplyVO;




@WebServlet("/reply/replyUpdate.do")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		  ReplyVO vo= new ReplyVO();
	      int renum=Integer.parseInt(request.getParameter("rpl_no"));
	      String cont= request.getParameter("rpl_content");
		  vo.setRpl_no(renum);
		  vo.setRpl_content(cont);    //replyVo에 넣기
		  
		//service.객체 얻기
		  IBoardService service= BoardServiceImpl.getInstance();
		  
		//service 메소드 호출 -int
		  int cnt= service.updateReply(vo);
		//결과값 저장
		   request.setAttribute("result", cnt);
		// view페이지로 이동한다.
	       request.getRequestDispatcher("replyview/result.jsp").forward(request, response);	
		  
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
