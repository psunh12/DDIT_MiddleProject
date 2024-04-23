package kr.or.ddit.culture.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.culture.service.CultureServiceImpl;
import kr.or.ddit.culture.service.ICultureService;
import kr.or.ddit.vo.CultureVO;


@WebServlet("/selectOneCulture.do")
public class SelectOneCulture extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");
		   response.setContentType("application/json; charset=utf-8 ");
		   CultureVO vo= null;
		   int culNo= Integer.parseInt(request.getParameter("culNo"));
		   ICultureService service= CultureServiceImpl.getInstance();
		   Gson gson =new Gson();
		   vo= service.selectOneCulture(culNo);
		   String res= gson.toJson(vo); 
		   PrintWriter out = response.getWriter();
		   out.write(res);
		   out.flush();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
