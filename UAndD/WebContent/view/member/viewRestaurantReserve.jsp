<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한밭 지킴이</title>
<%
	String path = request.getContextPath();

	// 세션에 저장한 데이터 가져오기
	MemberVO memVo = (MemberVO)session.getAttribute("loginMember");
	
	String mem_id = null;
	
	if ( memVo == null ) {
		mem_id = null;
	} else {
		mem_id = memVo.getMem_id();
	}

%>
<script src="<%= path %>/js/jquery-3.7.1.min.js"></script>
<script src="<%= path %>/js/viewRestaurantReserve.js?version=1"></script>

<link rel="stylesheet" href="<%= path %>/css/reserve.css">

<!-- 예쁜 Alert창 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script>
$(function() 
{
	
	// 식당 날짜가 지나면 예약이 지난 것으로 되는 것
	// changeDateReserveState();
		
	// 식당 예약 List를 테이블 <tbody>에 넣기
	addMemberRestaurantReserve('<%= mem_id %>');
		
	// 식당 예약 취소 List를 테이블 <tbody>에 넣기
	addMemberRestaurantReserveCancel('<%= mem_id %>');
	
})
</script>

</head>
<body>
<!-- 식당 예약 목록 띄울 div (식당 예약 창에 띄움)-->
<div id="memberRestaurantReserveList">
	<table class="reserveTable">
		<thead>
			<tr>
				<th>식당예약번호</th>
				<th>식당명</th>
				<th>예약날짜</th>
				<th>예약시간</th>
				<th>인원수</th>
				<th></th>
			</tr>
		</thead>
		<tbody id="addMemberRestaurantReserve"></tbody>
	</table>
</div>

<div class="spaceDiv"></div>

<!-- 식당 예약 취소 목록 띄울 div (식당 예약 창에 띄움)-->
<div id="memberRestaurantCancelReserveList">
	<table class="reserveTable">
		<thead>
			<tr>
				<th>식당예약번호</th>
				<th>식당명</th>
				<th>예약날짜</th>
				<th>예약시간</th>
				<th>인원수</th>
				<th></th>
			</tr>
		</thead>
		<tbody id="addMemberRestaurantReserveCancel"></tbody>
	</table>
</div>
</body>
</html>