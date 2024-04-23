package kr.or.ddit.reply.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.ReplyVO;


@WebServlet("/reply/replyList.do")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");		   
		   response.setContentType("application/json; charset=utf-8 ");
		//전송 데이터 가져오기 -bonum
		int bonum=Integer.parseInt(request.getParameter("bonum"));
		//service객체 가져오기
		   IBoardService service= BoardServiceImpl.getInstance();
		//service메소드 호출 -list
		  List<ReplyVO> list= service.selectReply(bonum);
          Gson gson =new Gson();
          String res= gson.toJson(list);
          PrintWriter out =response.getWriter();
          out.write(res);
		  out.flush();
		  
		  
		  
		
	}

}
