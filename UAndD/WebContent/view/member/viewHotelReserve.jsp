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
<script src="<%= path %>/js/viewHotelReserve.js"></script>

<link rel="stylesheet" href="<%= path %>/css/reserve.css">

<!-- 예쁜 Alert창 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script>
$(function() {

	// 숙소 예약 List를 테이블 <tbody>에 넣기
	addMemberHotelReserve('<%= mem_id %>');
		
	// 숙소 예약 취소 List를 테이블 <tbody>에 넣기
	addMemberHotelReserveCancel('<%= mem_id %>');

})
</script>

</head>
<body>
<!-- 숙소 예약 목록 띄울 div-->
<div id="memberHotelReserveList">
	<table class="reserveTable">
		<thead>
			<tr>
				<th>예약번호</th>
				<th>숙소명</th>
				<th>예약시작일</th>
				<th>예약종료일</th>
				<th>인원수</th>
				<th>객실정보</th>
				<th>결제금액</th>
				<th></th>
	 		</tr>
	 	<thead>
	 	<tbody id="addMemberHotelReserve"></tbody>
	</table>
</div>

<div class="spaceDiv"></div>

<!-- 숙소 예약 취소 및 완료 목록을 띄울 div -->
<div id="memberHotelCancelList">
	<table class="reserveTable">
		<thead>
		 	<tr>
		 		<th>예약번호</th>
		 		<th>숙소명</th>
		 		<th>예약시작일</th>
		 		<th>예약종료일</th>
		 		<th>인원수</th>
		 		<th>객실정보</th>
		 		<th>결제금액</th>
		 		<th></th>
		 	</tr>
	 	</thead>
	 	<tbody id="addMemberHotelReserveCancel"></tbody>
	</table>
</div>
</body>
</html>