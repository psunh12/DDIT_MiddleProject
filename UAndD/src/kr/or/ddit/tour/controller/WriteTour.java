package kr.or.ddit.tour.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import kr.or.ddit.tour.service.ITourService;
import kr.or.ddit.tour.service.TourServiceImpl;
import kr.or.ddit.vo.TourVO;


@WebServlet("/tour/writeTour.do")
public class WriteTour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //request
		
		  request.setCharacterEncoding("utf-8");
		  response.setCharacterEncoding("utf-8");
		  response.setContentType("text/html; charset=utf-8");
		  //전송데이터받기 writer, subject, mail, content,password
		  //vo에 저장
		  TourVO vo= new TourVO();
		   
		   try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
		   
		// 서비스객체
		   ITourService service= TourServiceImpl.getInstance();
		// 서비스메소드 호출 -결과값 받기 -int
		  int res= service.insertTour(vo);
		// request에 저장   		
	      request.setAttribute("result", res);
	    // view로 이동
		  request.getRequestDispatcher("tourview/result.jsp").forward(request, response);
			 
	}

}
