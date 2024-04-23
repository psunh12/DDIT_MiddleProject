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


@WebServlet("/member/updateMember.do")
public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원ID에 맞는 회원정보를 검색해서 회원정보 수정폼에 보낸다.
//		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		MemberVO loginMemberVo = (MemberVO)session.getAttribute("loginMember");
//		
//		IMemberService service = MemberServiceImpl.getInstance();
//		
//		MemberVO memVo = service.getSelectMember(loginMemberVo.getMem_id());
//		request.setAttribute(", o);
		request.getRequestDispatcher("/view/update/memberUpdateAll.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		MemberVO loginMemberVo = (MemberVO)session.getAttribute("loginMember");// 세션에서 가지고오는 값
		String memId =loginMemberVo.getMem_id();	
		
		// 회원정보 수정하기
		String memPass= request.getParameter("mem_pass");
		String memName= request.getParameter("mem_name");
		String memTel= request.getParameter("mem_tel");
		String memMail= request.getParameter("mem_mail")+"@"+request.getParameter("domain");
		String memAddr= request.getParameter("roadAddress")+request.getParameter("extraAddress")+request.getParameter("detailAddress");

		// 받아온 회원정보를 VO에 저장하기.
		MemberVO memVo = new MemberVO();

		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_mail(memMail);
		memVo.setMem_addr(memAddr);
		
		// 회원 정보를 DB에 insert한다.
		IMemberService service = MemberServiceImpl.getInstance();
		int result = service.updateMember(memVo);	// 결과값 받기
		
		// 결과값을 request에 저장하기
		request.setAttribute("result", result);
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
		
	}

}
