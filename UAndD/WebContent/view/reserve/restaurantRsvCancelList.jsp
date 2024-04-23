<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<Map<String, String>> restaurantRsvCancelList = (List<Map<String, String>>)request.getAttribute("restaurantRsvCancelList");

	String json = new Gson().toJson(restaurantRsvCancelList);
	
	out.print(json);
	out.flush();
%>