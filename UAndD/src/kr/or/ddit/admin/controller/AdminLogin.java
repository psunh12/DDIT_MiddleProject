package kr.or.ddit.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.admin.service.AdminServiceImpl;
import kr.or.ddit.admin.service.IAdminService;
import kr.or.ddit.vo.AdminVO;


@WebServlet("/admin/adminLogin.do")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		
		// id, password 가져오기
		String adminId = request.getParameter("adminId");
		String adminPass = request.getParameter("adminPass");
		
		// Service객체 생성
		IAdminService service = AdminServiceImpl.getInstance();
		
		// 가져온 id와 pass를 AdminVO객체에 저장한다.
		AdminVO adVo = new AdminVO();
		adVo.setAdmin_id(adminId);
		adVo.setAdmin_pass(adminPass);
		 
		// DB에 ID와 PASS를 보내서 해당 조건에 맞는 회원정보를 가져온다.
		// 해당 조건에 맞지 않으면 null값이 반환된다.
		AdminVO LoginAdminVo = service.getLoginAdmin(adVo);
		
		HttpSession session = request.getSession();
		
		//로그인성공+저장,로그인오류메세지를 위한 check,로그인을 어떤탭에서했는지저장
		if(LoginAdminVo!=null)
		{
			session.setAttribute("loginAdmin", LoginAdminVo);
			session.setAttribute("check", "true");
			session.setAttribute("admin", "true");
		}else
		{
		// 로그인 실패
			session.setAttribute("check", "false");
			
		}
		//view 페이지로 이동
			request.getRequestDispatcher("/view/login_out/adminLogin.jsp").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
