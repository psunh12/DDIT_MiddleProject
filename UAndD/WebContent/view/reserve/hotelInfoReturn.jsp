<%@page import="kr.or.ddit.vo.HotelVO"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 서블릿에서 저장한 데이터 꺼내기
	HotelVO hotelVo = (HotelVO)request.getAttribute("hotelVo");

	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	String hotelJson = gson.toJson(hotelVo);
	
	out.print(hotelJson);
	out.flush();
%>