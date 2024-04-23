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

@WebServlet("/reserve/hotelMemberReserveList.do")
public class HotelMemberReserveList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IReserveHotelService service = ReserveHotelServiceImpl.getInstance();
		
		String mem_id = request.getParameter("mem_id");
		
		List<Map<String, String>> hotelRsvList = service.getMemberHotelReserve(mem_id);
		System.out.println(hotelRsvList);
		
		request.setAttribute("hotelRsvList", hotelRsvList);
		
		request.getRequestDispatcher("/view/reserve/hotelReserveList.jsp").forward(request, response);
	}

}
