<%@page import="kr.or.ddit.vo.CultureVO"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
             
         <%
      //서블릿에서 저장한 데이터 꺼내오기
         List<CultureVO> list= (List<CultureVO>)request.getAttribute("list");
         int sp= (int)request.getAttribute("startpage");
         int ep= (int)request.getAttribute("endpage");
         int tp= (int)request.getAttribute("totalpage");         
         %>
    [
    <%
    for(int i=0; i<list.size(); i++){
    	  CultureVO vo= list.get(i);
    	  if(i>0) out.print(",");
    	%>
    	{
    	  "num" : "<%=vo.getCul_no() %>",
    	  "name" : "<%=vo.getCul_name()%>",
    	  "host" : "<%=vo.getCul_host() %>",
    	  "date" : "<%=vo.getCul_date() %>",
    	  "place" : "<%=vo.getCul_place() %>",    	  
    	  "img" : "<%=vo.getCul_img() %>",
    	  "perfomer" : "<%=vo.getCul_perfomer() %>"
    	}
    	
   <% 	
    } 
    %>
    ]