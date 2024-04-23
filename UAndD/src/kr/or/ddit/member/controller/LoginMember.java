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

@WebServlet("/member/loginMember.do")
public class LoginMember extends HttpServlet 
{
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		
		// id, password 가져오기
		String memId = request.getParameter("memId");
		String pass = request.getParameter("pass");
		
		// Service객체 생성
		IMemberService service = MemberServiceImpl.getInstance();
		
		// 가져온 id와 pass를 MemberVO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(pass); 
		
		// DB에 ID와 PASS를 보내서 해당 조건에 맞는 회원정보를 가져온다.
		// 해당 조건에 맞지 않으면 null값이 반환된다.
		MemberVO LoginMemberVo = service.getLoginMember(memVo);
		
		HttpSession session = request.getSession();
		

		
		//로그인성공+저장,로그인오류메세지를 위한 check,로그인을 어떤탭에서했는지저장
		if(LoginMemberVo!=null &&LoginMemberVo.getMem_state()!=0) 
		{
			session.setAttribute("loginMember", LoginMemberVo);
			session.setAttribute("check", "true");
			session.setAttribute("mem_id", memId);
		}else 
		{
		//로그인 실패
			session.setAttribute("check", "false");
		}
		//view 페이지로 이동
		request.getRequestDispatcher("/view/login_out/loginMain.jsp").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}