<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<Map<String, String>> hotelRsvList = (List<Map<String, String>>)request.getAttribute("hotelRsvCancelList");

	String json = new Gson().toJson(hotelRsvList);
	
	out.print(json);
	out.flush();
%>