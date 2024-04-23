<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.vo.CultureVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<CultureVO> culList= (List<CultureVO>)request.getAttribute("culList");
	
	String json = new Gson().toJson(culList);
	
	out.print(json);
	out.flush();
%>