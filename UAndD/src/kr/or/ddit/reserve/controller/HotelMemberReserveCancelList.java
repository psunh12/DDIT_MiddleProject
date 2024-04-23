package kr.or.ddit.reserve.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reserve.service.IReserveHotelService;
import kr.or.ddit.reserve.service.ReserveHotelServiceImpl;

@WebServlet("/reserve/hotelMemberReserveCancelList.do")
public class HotelMemberReserveCancelList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IReserveHotelService service = ReserveHotelServiceImpl.getInstance();
		
		String mem_id = request.getParameter("mem_id");
		
		List<Map<String, String>> hotelRsvCancelList = service.getMemberHotelReserveCancel(mem_id);
		
		request.setAttribute("hotelRsvCancelList", hotelRsvCancelList);
		
		request.getRequestDispatcher("/view/reserve/hotelRsvCancelList.jsp").forward(request, response);
	}

}
