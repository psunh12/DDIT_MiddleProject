package kr.or.ddit.reserve.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reserve.service.IReserveRestaurantService;
import kr.or.ddit.reserve.service.ReserveRestaurantServiceImpl;

@WebServlet("/reserve/restaurantReserveCancel.do")
public class RestaurantReserveCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IReserveRestaurantService service = ReserveRestaurantServiceImpl.getInstance();
		
		int rest_rsv_no = Integer.parseInt(request.getParameter("rest_rsv_no"));
		
		int result = service.reserveRestaurantCancel(rest_rsv_no);
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
