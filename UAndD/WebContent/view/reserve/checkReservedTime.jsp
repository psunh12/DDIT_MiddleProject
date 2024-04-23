<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<String> timeList = (List<String>)request.getAttribute("timeList");

	String json = new Gson().toJson(timeList);
	
	out.print(json);
	out.flush();
%>