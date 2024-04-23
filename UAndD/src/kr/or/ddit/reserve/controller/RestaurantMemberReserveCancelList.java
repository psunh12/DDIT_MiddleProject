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

@WebServlet("/reserve/restaurantMemberReserveCancelList.do")
public class RestaurantMemberReserveCancelList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IReserveRestaurantService service = ReserveRestaurantServiceImpl.getInstance();
		
		String mem_id = request.getParameter("mem_id");
		
		List<Map<String, String>> restaurantRsvCancelList = service.getMemberRestaurantReserveCancel(mem_id);
		
		request.setAttribute("restaurantRsvCancelList", restaurantRsvCancelList);
		
		request.getRequestDispatcher("/view/reserve/restaurantRsvCancelList.jsp").forward(request, response);
	}

}
