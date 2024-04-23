package kr.or.ddit.tour.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.culture.service.CultureServiceImpl;
import kr.or.ddit.culture.service.ICultureService;
import kr.or.ddit.tour.service.ITourService;
import kr.or.ddit.tour.service.TourServiceImpl;
import kr.or.ddit.vo.TourVO;


@WebServlet("/tour/tourList.do")
public class TourList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");		   
		   response.setContentType("application/json; charset=utf-8 ");
		  
		   TourVO vo= null;
		   List<TourVO> list=null;
		   ITourService service= TourServiceImpl.getInstance();
		   Gson gson =new Gson();
		   list= service.selectTour();
		   String res= gson.toJson(list); 
		   PrintWriter out = response.getWriter();
		   out.write(res);
		   out.flush();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
