package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/member/checkIdMember.do")
public class CheckIdMember extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memId = request.getParameter("id");	// 요청에서 id값 가지고 오기
	
		IMemberService service = MemberServiceImpl.getInstance();
		
		// 서비스 메소드 호출
		String res = service.selectById(memId);
		
		// 결과값을 request에 저장
		request.setAttribute("res", res);
		
		// view페이지로 이동
		request.getRequestDispatcher("/view/signup/checkId.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
