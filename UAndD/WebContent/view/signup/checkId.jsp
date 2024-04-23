<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 서블릿에서 저장 데이터를 꺼내기
	String result = (String)request.getAttribute("res");

	if(result ==null){
	%>
	{
		"sw" : "사용가능 합니다."
	}
	 
	<%	}else{ %>
	{
		"sw" : "사용 불가능 합니다."
	}
	<%
	}
	%> 