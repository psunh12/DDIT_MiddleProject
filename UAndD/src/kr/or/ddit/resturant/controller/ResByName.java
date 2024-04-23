package kr.or.ddit.resturant.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.resturant.service.IRestaurantService;
import kr.or.ddit.resturant.service.RestaurantServiceImpl;
import kr.or.ddit.vo.RestaurantVO;

@WebServlet("/restaurant/resByName.do")
public class ResByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");		   
		   response.setContentType("application/json; charset=utf-8 ");
		   String dong= request.getParameter("dong");
		   RestaurantVO vo= null;
		   List<RestaurantVO> list=null;
		   IRestaurantService service= RestaurantServiceImpl.getInstance();
		   Gson gson =new Gson();
		   
		   list= service.selectByName(dong);
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
