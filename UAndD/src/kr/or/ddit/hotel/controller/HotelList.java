package kr.or.ddit.hotel.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.hotel.service.HotelServiceImpl;
import kr.or.ddit.hotel.service.IHotelSerivce;
import kr.or.ddit.vo.HotelVO;


@WebServlet("/hotel/hotelList.do")
public class HotelList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");		   
		   response.setContentType("application/json; charset=utf-8 ");
		  
		   HotelVO vo= null;
		   List<HotelVO> list=null;
		   IHotelSerivce service= HotelServiceImpl.getInstance();
		   Gson gson =new Gson();
		   list= service.selectHotel();
		   String res= gson.toJson(list); 
		   PrintWriter out = response.getWriter();
		   out.write(res);
		   out.flush();
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
