<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<Map<String, String>> restRsvList = (List<Map<String, String>>)request.getAttribute("restRsvList");

	String json = new Gson().toJson(restRsvList);
	
	out.print(json);
	out.flush();
%>