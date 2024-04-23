<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="icon" href="../images/icon/꿈돌5-1.png" type="image/x-icon">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel= "stylesheet"  href="<%=request.getContextPath()%>/css/getPass.css">
</head>
<%	// 서블릿에서 저장 데이터를 꺼내기
	String result = (String)request.getAttribute("memMail");
	String check = (String)request.getAttribute("check");
%>
<body>
<!-- 상단 메뉴바 -->
<jsp:include page="/view/main/top.jsp"/>

<!-- 저장된 메일주소 데이터가 없으면 -->
<%
if(result == null)
{	if("false".equals(check))
	{
%>
   <script>
    swal({title: "비밀번호 찾기 실패!",  text: "다시 입력해주세요", icon: "error"});
    </script>
	<%} %>
	<div class="container">
	<!-- 아이디로 메일주소를 받아서 비번찾기 -->
	<form action="<%=request.getContextPath()%>/member/fogotPass.do" method="post">
	<img src="<%=request.getContextPath()%>/images/login/꿈순이2.png" style="width:150px; height:150px; margin-left:-40px;">
	<br><br><h1>비밀번호 찾기</h1><br>
	<h2>가입시 입력한 아이디를 입력해주세요</h2><br>
	<input type="text" name="memId" placeholder="아이디" style="width:200px; height:20px;"><br>
	<br><button type="submit">확인</button>
	</form>
	</div>
<%
// 저장된 메일주소 데이터가 있으면
}else
{
%>
	<script>
    swal({title: "임시번호 발급 성공!", text: "임시비밀번호가 메일로 발송되었습니다.", icon: "success"
    }).then(function() 
    {
    window.location.href = "<%=request.getContextPath()%>/view/login_out/loginMain.jsp"; 
    });
    </script>
<%
} 
%>
	

</body>
</html>