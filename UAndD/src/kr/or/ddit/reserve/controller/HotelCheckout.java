package kr.or.ddit.reserve.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reserve.service.IReserveHotelService;
import kr.or.ddit.reserve.service.ReserveHotelServiceImpl;

@WebServlet("/reserve/hotelCheckout.do")
public class HotelCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IReserveHotelService service = ReserveHotelServiceImpl.getInstance();
		
		int result = service.doManagerAllCheckout();
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
