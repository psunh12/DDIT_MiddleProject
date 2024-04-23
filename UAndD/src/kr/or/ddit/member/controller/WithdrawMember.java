package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/withdrawMember.do")
public class WithdrawMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		MemberVO loginMemberVo = (MemberVO)session.getAttribute("loginMember");// 세션에서 가지고오는 값
		String memId =loginMemberVo.getMem_id();
		String memPass = loginMemberVo.getMem_pass();
		
		String checkPass = request.getParameter("check_pass");
		// 받아온 회원정보를 VO에 저장하기.
		MemberVO memVo = new MemberVO();

		memVo.setMem_id(memId);
		memVo.setMem_pass(checkPass);
		 
		if(memPass.equals(checkPass)) {
			
			// 회원 정보를 DB에 insert한다.
			IMemberService service = MemberServiceImpl.getInstance();
			int result= service.deleteMember(memVo); //결과값 받기
			
			//결과값을 request에 저장 하기 
			request.setAttribute("result", result);
			request.getRequestDispatcher("/view/result.jsp").forward(request, response);
		}
		
	}

}
