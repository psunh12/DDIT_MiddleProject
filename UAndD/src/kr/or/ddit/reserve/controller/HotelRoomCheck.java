package kr.or.ddit.reserve.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reserve.service.IReserveHotelService;
import kr.or.ddit.reserve.service.ReserveHotelServiceImpl;

/**
 * 입력한 날짜에 남은 객실이 있는지 확인하고 예약 완료 후 차감하는 서블릿
 */
@WebServlet("/reserve/hotelRoomCheck.do")
public class HotelRoomCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 객실 확인
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Map<String, String> dateMap = new HashMap<String, String>();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		dateMap.put("startDate", startDate);
		dateMap.put("endDate", endDate);
		
		IReserveHotelService service = ReserveHotelServiceImpl.getInstance();
		
		int usedRoom = service.getHotelRoom(dateMap);
		
		request.setAttribute("usedRoom", usedRoom);
		
		request.getRequestDispatcher("/view/reserve/checkEmptyRoom.jsp").forward(request, response);
		
	}
	
	// 예약 완료 후 차감
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int hotel_no = Integer.parseInt(request.getParameter("hotel_no"));
		
		IReserveHotelService service = ReserveHotelServiceImpl.getInstance();
		
		int result = service.subtractHotelRoom(hotel_no);
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}

}
