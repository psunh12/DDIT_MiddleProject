package kr.or.ddit.reserve.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reserve.service.IReserveRestaurantService;
import kr.or.ddit.reserve.service.ReserveRestaurantServiceImpl;

@WebServlet("/reserve/restaurantMemberReserveList.do")
public class RestaurantMemberReserveList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IReserveRestaurantService service = ReserveRestaurantServiceImpl.getInstance();
		
		int result = service.changeDayReserveState();
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IReserveRestaurantService service = ReserveRestaurantServiceImpl.getInstance();
		
		String mem_id = request.getParameter("mem_id");
		
		List<Map<String, String>> restRsvList = service.getMemberRestaurantReserve(mem_id);
		
		request.setAttribute("restRsvList", restRsvList);
		
		request.getRequestDispatcher("/view/reserve/restaurantReserveList.jsp").forward(request, response);
	}

}
