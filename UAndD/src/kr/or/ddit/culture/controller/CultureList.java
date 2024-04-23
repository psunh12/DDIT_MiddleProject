package kr.or.ddit.culture.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.culture.service.CultureServiceImpl;
import kr.or.ddit.culture.service.ICultureService;
import kr.or.ddit.vo.CultureVO;
import kr.or.ddit.vo.PageVO;





/**
 * Servlet implementation class CultureList
 */
@WebServlet("/cultureList.do")
public class CultureList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		request.setCharacterEncoding("utf-8");
		//요청시 전송데이터 받기 -page,ctype,cword
		int spage= Integer.parseInt(request.getParameter("page"));//최초 실행시 1
		String stype =  request.getParameter("stype"); //최초실행시 값 없음
		String sword =  request.getParameter("sword"); //최초실행시 값 없음
		
		//service객체 
		ICultureService service= CultureServiceImpl.getInstance();
		
		//메소드 호출 -page정보
		PageVO vo =service.getPageInfo(spage, stype, sword);
		// 리턴값은 start, end, startPage, endPage, totalPage
		//  start, end=> 1페이지 : 1~3 2페이지 :4~6 3페이지 : 7~9 ...
		//startPage, endPage => 1페이지 : 1~2 2페이지 :1~2 3페이지 : 3~4 ...
		
		//해당 페이지에 따라 게시판 글을 3개씩 가져온다.
		 Map <String ,Object > map= new HashMap<String, Object>();
		
		 map.put("start",vo.getStart() );
		 map.put("end",vo.getEnd() );
		 map.put("stype", stype);
		 map.put("sword", sword);
		 
		 
		 List <CultureVO> list= service.selectByPage(map);
		//list결과값을 request에 저장
		 request.setAttribute("list", list); //게시판글 3개가 저장되어있음
		 request.setAttribute("startpage", vo.getStartPage()); //1
		 request.setAttribute("endpage", vo.getEndPage()); //2
		 request.setAttribute("totalpage", vo.getTotalPage());  //7
		
		 //request.getRequestDispatcher("boardview/list.jsp").forward(request, response);
		 request.getRequestDispatcher("cultureview/listPage.jsp").forward(request, response);
		 
		 
	}

}


