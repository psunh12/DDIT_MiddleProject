package kr.or.ddit.culture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.culture.service.CultureServiceImpl;
import kr.or.ddit.culture.service.ICultureService;
import kr.or.ddit.vo.CultureVO;

@WebServlet("/culture/mainUsedCulture.do")
public class MainUsedCulture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//service객체 
		ICultureService service= CultureServiceImpl.getInstance();
		
		List<CultureVO> culList = service.selectCulture(1);
		
		request.setAttribute("culList", culList);
		
		request.getRequestDispatcher("/cultureview/mainUsedCulture.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
