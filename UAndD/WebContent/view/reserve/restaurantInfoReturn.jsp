<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.vo.RestaurantVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 서블릿에서 저장한 데이터 꺼내기
	RestaurantVO hotelVo = (RestaurantVO)request.getAttribute("restaurantVo");

	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	String hotelJson = gson.toJson(hotelVo);
	
	out.print(hotelJson);
	out.flush();
%>