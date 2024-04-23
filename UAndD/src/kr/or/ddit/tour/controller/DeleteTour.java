package kr.or.ddit.tour.controller;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.culture.service.CultureServiceImpl;
import kr.or.ddit.culture.service.ICultureService;
import kr.or.ddit.tour.service.ITourService;
import kr.or.ddit.tour.service.TourServiceImpl;




@WebServlet("/tour/deleteTour.do")
public class DeleteTour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // num가져오기 
		      int bnum= Integer.parseInt(request.getParameter("num"));
		    // service객체 얻기
		      ITourService service= TourServiceImpl.getInstance();
		    // service 메소드 호출-결과값 받기
		      int res= service.deleteTour(bnum);
		    // 결과값 request에 저장
		        request.setAttribute("result", res);
		    // view로 이동
		    request.getRequestDispatcher("tourview/result.jsp").forward(request, response);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
