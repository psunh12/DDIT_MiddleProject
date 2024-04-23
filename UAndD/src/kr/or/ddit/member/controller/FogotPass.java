package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.util.SendPassMail;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/fogotPass.do")
public class FogotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		
		// id 가져오기
		String memId = request.getParameter("memId");
		
		// Service 객체 생성
		IMemberService service = MemberServiceImpl.getInstance();
		
		// 서비스 메소드 호출
		String mail = service.setPassAddr(memId);
		
		// 결과값을 request에 저장
		request.setAttribute("memMail", mail);
		
		try 
		{
			// 메일보내기
			SendPassMail.sendMail(mail);
			
			 // 새로운 임시 비밀번호 가져오기
			String tempPass = SendPassMail.getNewPass();
			
			// 가져온 임시비밀번호와 아이디를 MemberVO객체에 저장한다.
			MemberVO memVo = new MemberVO();
			memVo.setMem_pass(tempPass);
			memVo.setMem_id(memId);
			
			// 회원 정보를 DB에 insert한다.
			int cnt = service.updatePass(memVo);
			
			
			if(cnt>0) 
			{
				System.out.println("임시번호 발급 완료");
				
			}else 
			{
				System.out.println("임시번호 발급 실패");
				request.setAttribute("check", "false");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// view페이지로 이동
		request.getRequestDispatcher("/view/login_out/getPassword.jsp").forward(request, response);
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
