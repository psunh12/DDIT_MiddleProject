package kr.or.ddit.reserve.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reserve.service.IReserveRestaurantService;
import kr.or.ddit.reserve.service.ReserveRestaurantServiceImpl;

@WebServlet("/reserve/restaurantGetTime.do")
public class RestaurantGetTime extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IReserveRestaurantService service = ReserveRestaurantServiceImpl.getInstance();
		
		Map<String, String> selectedDate = new HashMap<String, String>();
		selectedDate.put("rest_no", request.getParameter("rest_no"));
		selectedDate.put("selectedDate", request.getParameter("selectedDate"));
		
		java.util.List<String> timeList = new ArrayList<String>();
		
		timeList = service.getRestaurantReservedTime(selectedDate);

		request.setAttribute("timeList", timeList);
		
		request.getRequestDispatcher("/view/reserve/checkReservedTime.jsp").forward(request, response);
	}

}
