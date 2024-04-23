<%@page import="kr.or.ddit.vo.AdminVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/memberInfo.css">
<%
   // 세션에 저장한 데이터 가져오기
	AdminVO adVo = (AdminVO)session.getAttribute("loginAdmin");
%>
</head>
<body>
<div id ="container">
<h1>관리자 정보</h1>
	<div id="mapper" >
	<%
		if(adVo != null){
	%>
		<p> 이름    : <%=adVo.getAdmin_name()%></p>  
		<p> 아이디 : <%=adVo.getAdmin_id()%></p>
		<p> 이메일 : <%=adVo.getAdmin_mail()%></p>
		
	<%
		}else{
			
	%>
		<p></p>
	<%
		}
	%>	
	</div>
	<span><img src="<%=request.getContextPath()%>/images/login/스판그림.png"></span>
</div>

</body>
</html>