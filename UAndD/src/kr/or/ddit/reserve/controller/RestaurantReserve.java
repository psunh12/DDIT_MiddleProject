package kr.or.ddit.reserve.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.reserve.service.IReserveRestaurantService;
import kr.or.ddit.reserve.service.ReserveRestaurantServiceImpl;
import kr.or.ddit.vo.RestaurantReserveVO;
import kr.or.ddit.vo.RestaurantVO;

@WebServlet("/reserve/restaurantReserve.do")
public class RestaurantReserve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		
		IReserveRestaurantService service = ReserveRestaurantServiceImpl.getInstance();
		
		int rest_no = Integer.parseInt(request.getParameter("rest_no"));
		
		RestaurantVO restaurantVo = service.getRestaurantInfo(rest_no);
		
		request.setAttribute("restaurantVo", restaurantVo);
		
		request.getRequestDispatcher("/view/reserve/restaurantInfoReturn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 전송 데이터 받아서 RestaurantReserveVO객체에 저장
		RestaurantReserveVO restRsvVo = new RestaurantReserveVO();
		
		try {
			BeanUtils.populate(restRsvVo, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		IReserveRestaurantService service = ReserveRestaurantServiceImpl.getInstance();
		
		int result = service.reserveRestaurant(restRsvVo);
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
		
	}

}
