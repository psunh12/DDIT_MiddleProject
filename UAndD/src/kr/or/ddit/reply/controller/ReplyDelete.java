package kr.or.ddit.reply.controller;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.ReplyVO;


@WebServlet("/reply/replyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//전송 데이터 받기 -bonum, name, cont
		 int vnum= Integer.parseInt(request.getParameter("bonum"));
		 
		 IBoardService service= BoardServiceImpl.getInstance();
		 
		//service 메소드 호출 -결과값은 int
		 int cnt= service.deleteReply(vnum);
		 
		//request에 결과값 저장
		request.setAttribute("result", cnt);
		
		//view페이지로 이동
		request.getRequestDispatcher("replyview/result.jsp").forward(request, response);
		
		
		
		
		
		
		
	}

}
