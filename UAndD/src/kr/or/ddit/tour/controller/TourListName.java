package kr.or.ddit.tour.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.tour.service.ITourService;
import kr.or.ddit.tour.service.TourServiceImpl;
import kr.or.ddit.vo.TourVO;


@WebServlet("/tour/tourListName.do")
public class TourListName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");		   
		   response.setContentType("application/json; charset=utf-8 ");
		   String dong= request.getParameter("dong");
		   TourVO vo= null;
		   List<TourVO> list=null;
		   ITourService service= TourServiceImpl.getInstance();
		   Gson gson =new Gson();
		   
		   list= service.selectNameTour(dong);
		   String res= gson.toJson(list); 
		   PrintWriter out = response.getWriter();
		   out.write(res);
		   out.flush();
		

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
