<%@page import="kr.or.ddit.vo.AdminVO"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<% 
	String path = request.getContextPath();	// 상위 경로를 변수로 선언
%>

<%
   // 세션에 저장한 데이터 가져오기
	MemberVO memVo = (MemberVO)session.getAttribute("loginMember");
	AdminVO adVo = (AdminVO)session.getAttribute("loginAdmin");
%>

<!-- 메인 상단 메뉴바 js  -->
<script src="<%= path %>/js/jquery-3.7.1.min.js"></script>
<script src="<%= path %>/js/header.js"></script>

<!-- header scroll script -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- header css -->
<link rel= "stylesheet"  href="<%= path %>/css/header.css">
<link rel= "stylesheet"  href="<%= path %>/css/common.css">

</head>
<body>
<!-- 기존 header -->
<!--  메인 상단 메뉴바(헤더) 시작   -->
<div id ="header">
	<h1 class="logo">
	<!--  로고 자리입니다   -->
		<div id="logo" onclick="location.href='<%=request.getContextPath()%>/index.jsp'">
			<img src= "<%=path %>/images/header/로고3.png" alt="대전관광" style="width:200px;">
		</div>
	</h1>
		
	<ul id="gnb">
		<li class="dept1">
			<a href="<%=path %>/view/daejeonStory/daejeonOrigin.jsp" role="button">대전알리미</a>
			<ul class="inner_menu">
				<li class="dept2">
					<a href="<%=path %>/view/daejeonStory/daejeonOrigin.jsp">대전이야기</a>
				</li>
				<li class="dept2">
					<a href="<%=path %>/view/daejeonStory/daejeonCommentator.jsp">여행도우미</a>
				</li>
			</ul>
		</li>
		<li class="dept1">
			<a href="<%=request.getContextPath()%>/tour/tourboard/tourMain.jsp">관광명소</a> 
			<ul class="inner_menu">
				<li class="dept2">
					<a href="<%=request.getContextPath()%>/tour/tourboard/tourMain.jsp">주요 관광지</a>
				</li>
				<li class="dept2">
					<a href="<%=request.getContextPath()%>/view/restaurant/resboard/resMain.jsp">식당</a>
				</li>
				<li class="dept2">
					<a href="<%=request.getContextPath()%>/hotel/hotelboard/hotelMain.jsp">숙박업소</a>
				</li>
			</ul>
		</li>
		<li class="dept1">
			<a href="<%=request.getContextPath()%>/cultureboard/cultureMain.jsp">문화의거리</a>
			<ul class="inner_menu">
				<li class="dept2">
					<a href="<%=request.getContextPath()%>/cultureboard/cultureMain.jsp?cate=1">축제</a>
				</li>
				<li class="dept2">
					<a href="<%=request.getContextPath()%>/cultureboard/cultureMain.jsp?cate=2"">전시</a>
				</li>
				<li class="dept2">
					<a href="<%=request.getContextPath()%>/cultureboard/cultureMain.jsp?cate=3">공연</a>
				</li>
			</ul>
		</li>
		<li class="dept1">
			<a href="<%=request.getContextPath()%>/view/notice/mainnotice.jsp">게시판</a>
			<ul class="inner_menu">
				<li class="dept2">
					<a href="<%=request.getContextPath()%>/view/notice/mainnotice.jsp">공지게시판</a>
					</li>
					<li class="dept2">
					<a href="<%=request.getContextPath()%>/view/notice/mainboard.jsp">자유게시판</a>
				</li>
			</ul>
		</li>
		<!-- 관리자로 로그인시 관리자페이지로 이동합니다-->
		<li class="dept1">
		<%
		if(memVo==null && adVo!=null)
		{
		%>
			<a href="<%=request.getContextPath()%>/view/admin/adminForm.jsp">관리자페이지</a>
		<%
		} else
		{
		%>
			<a href="<%=request.getContextPath()%>/view/member/memberForm.jsp">마이페이지</a>
			
		<%
		}
		%>
		</li>
	</ul>
	<div id="rightHeader">
		<!--   로그인 폼입니다    -->
		<%
		if(memVo == null && adVo == null)
		{
		%>
			<div id="loginForm">
				<form class="login-form" action="#">
					<input type="button" value="로그인"  onclick="location.href='<%= request.getContextPath() %>/view/login_out/loginMain.jsp'">
					<input type="button" value="회원가입"  onclick="location.href='<%= request.getContextPath() %>/view/signup/memberSignup.jsp'">
				</form>
			</div>	<!-- id가 loginForm인 div 끝 -->
		<%
		} else
		{	
		%>
		<!-- 로그인 완료 폼 -->
			<div id ="loggedForm">
			<%
			if(adVo != null)
			{
			%>
				<form class="logged-form" action="#">
					<h4 class="hi"><%= adVo.getAdmin_name()%>관리자님 반갑습니다!</h4>
					<input class="logoutbtn" type="button" value="로그아웃"  onclick="location.href='<%=request.getContextPath()%>/member/logoutMember.do'"> 
				</form>
			<%
			} else if(memVo != null)
			{
			%>
				<form class="logged-form" action="#">
					<h4 class="hi"><%= memVo.getMem_name()%>님 반갑습니다!</h4>
					<input class="logoutbtn" type="button" value="로그아웃"  onclick="location.href='<%=request.getContextPath()%>/member/logoutMember.do'"> 
				</form>
			<%
			}
			%>
			</div>
		<%
		}
		%>	

		<!-- 하단 펼쳐지는 부분 -->
		<div class="hd_bg"></div>		
	</div>
</div>
<!--//header-->
<!--  메인 상단 메뉴바(헤더)의 끝  -->
</body>
</html>