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


@WebServlet("/member/loginKakao.do")
public class LoginKakao extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		String memId=request.getParameter("id");
		String memName=request.getParameter("name");
		String memPass="-";
		String memAddr="-";
		String memTel=request.getParameter("tel");
		String memMail=request.getParameter("mail");
		
		// 받아온 회원정보를 VO에 저장하기.
		MemberVO memVo = new MemberVO();

		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_mail(memMail);
		memVo.setMem_addr(memAddr);
		
		 // 회원 정보가 이미 있는지 확인
        IMemberService service = MemberServiceImpl.getInstance();
        MemberVO checkMember = service.getSelectMember(memId);

        if (checkMember == null) {
            // 회원 정보가 없으면 새로 가입
            int result = service.insertMember(memVo);

            if (result > 0) {
                // 가입 성공
            	checkMember = service.getLoginMember(memVo);

                if (checkMember != null) {
                    session.setAttribute("loginMember", checkMember);
                    session.setAttribute("check", "true");
                    session.setAttribute("tab", "member");
                } else {
                    // 로그인 실패
                    session.setAttribute("check", "false");
                }

                // view 페이지로 이동
                request.getRequestDispatcher("/view/login_out/loginMain.jsp").forward(request, response);
            } else {
                // 가입 실패
                request.setAttribute("result", result);
                request.getRequestDispatcher("/view/result.jsp").forward(request, response);
            }
        } else {
            // 이미 가입된 회원이라면 로그인 처리
            session.setAttribute("loginMember", checkMember);
            session.setAttribute("check", "true");
            session.setAttribute("tab", "member");

            // view 페이지로 이동
            request.getRequestDispatcher("/view/login_out/loginMain.jsp").forward(request, response);
        }
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
