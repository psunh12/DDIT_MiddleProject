package kr.or.ddit.tour.controller;

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


@WebServlet("/tour/tourUpdate.do")
public class TourUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    TourVO vo= new TourVO();
		   try {
				BeanUtils.populate(vo, request.getParameterMap());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			   //service 객체 얻기
			    ITourService service= TourServiceImpl.getInstance();
			    
			   //service 메소드 호출 -결과값 int
			   int cnt= service.updateTour(vo);
			   //request에 저장
			   request.setAttribute("result", cnt);
			   //view페이지로 이동
			   
			   request.getRequestDispatcher("tourview/result.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
