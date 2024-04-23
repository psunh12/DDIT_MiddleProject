package kr.or.ddit.reserve.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.reserve.service.IReserveHotelService;
import kr.or.ddit.reserve.service.ReserveHotelServiceImpl;
import kr.or.ddit.vo.HotelReserveVO;
import kr.or.ddit.vo.HotelVO;

@WebServlet("/reserve/hotelReserve.do")
public class HotelReserve extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		
		IReserveHotelService service = ReserveHotelServiceImpl.getInstance();
		
		int hotel_no = Integer.parseInt(request.getParameter("hotel_no"));
		
		HotelVO hotelVo = service.getHotelInfo(hotel_no);
		
		request.setAttribute("hotelVo", hotelVo);
		
		request.getRequestDispatcher("/view/reserve/hotelInfoReturn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 전송 데이터 받아서 HotelReserveVO객체에 저장
		HotelReserveVO hotelRsvVo = new HotelReserveVO();
		
		try 
		{
			BeanUtils.populate(hotelRsvVo, request.getParameterMap());
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		IReserveHotelService service = ReserveHotelServiceImpl.getInstance();
		
		int result = service.reserveHotel(hotelRsvVo);
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
		
	}

}
