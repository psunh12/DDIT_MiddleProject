<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>아이디 찾기</title>
<link rel="icon" href="../images/icon/꿈돌5-1.png" type="image/x-icon">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel= "stylesheet"  href="<%=request.getContextPath()%>/css/getIds.css">
</head>
<%	// 서블릿에서 저장 데이터를 꺼내기
	String code = (String)request.getAttribute("code");
	String result = (String)request.getAttribute("id");
	String check = (String)request.getAttribute("check");
%>
<body>
<!-- 상단 메뉴바 -->
<jsp:include page="/view/main/top.jsp"/>

<!-- 저장된 아이디 데이터가 없으면 -->
<%
if(result ==null)
	/* db에서도 못찾았다면 오류알림창나오게하기 */
{	if("false".equals(check))
	{
%>
   <script>
    swal({title: "아이디 찾기 실패!",  text: "다시 입력해주세요", icon: "error"});
    </script>
	<%} %>
	<!-- 메일주소로 아이디 찾기 -->
	<div class="container">
	<form action="<%=request.getContextPath()%>/member/fogotId.do" method="post">
	<img src="<%=request.getContextPath()%>/images/login/꿈돌2.png" style="width:170px; height:170px;">
	<br><br><h1>아이디 찾기</h1><br>
	<h2>가입시 입력한 메일주소를 입력해주세요</h2><br>
	<input type="text" name="memMail" placeholder="메일주소" style="width: 300px;"><br>
	<br><button type="submit">확인</button>
	</form>
	</div>
	
<%
// 아이디 데이터가 있으면
}else
{
%>
	<!-- 아이디 알려주고 로그인하러가는 버튼 -->
	<script>
    swal({title: "아이디 찾기 성공!",  text: "아이디는 '<%=request.getAttribute("id")%>'입니다", icon: "success"
    }).then(function() 
    {
    window.location.href = "<%=request.getContextPath()%>/view/login_out/loginMain.jsp"; 
    });
    </script>
<%
} 
%>

<!-- 하단 메뉴바 삽입 -->
<jsp:include page="/view/main/bottom.jsp"/>
</body>
</html>