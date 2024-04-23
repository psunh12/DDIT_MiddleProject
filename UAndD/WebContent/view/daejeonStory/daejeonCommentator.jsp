<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한밭 지킴이</title>
<%
	String path = request.getContextPath();
%>
<script src="<%= path %>/js/jquery-3.7.1.min.js"></script>
<script src="<%= path %>/js/slideText.js"></script>
<link rel="stylesheet" href="<%= path %>/css/slideText.css">

<!-- 공통 js -->
<script type="text/javascript" src="<%= path %>/js/common.js"></script>
<!-- 공통 css -->
<link rel="stylesheet" href="<%= path %>/css/common.css">

</head>
<body>

<!-- 상단 메뉴바 -->
<jsp:include page="/view/main/top.jsp"/>

<div class="container scroll_wrap">
	<div class="scroll_on type_top">
		<h4>문화관광해설사란?</h4>
		<br>
		<br>
		<br>
		<img src="<%= path %>/images/upSlide/daejeonTour1.jpg"
			style="width: 800px; height: 500px; border-radius: 0px 70px;">
	</div>
	<div class="scroll_on type_right flexSide">
		<div id="textSmall" style="width: 1300px;">
			<p style="text-align:center;">
				우리 지역을 방문한 관광객들에게  관광지에 대한 <br>
				이해와 체험 기회를 제공하기 위하여 <br>
				역사, 문화, 자연 등 관광자원 전반에 대한  <br>
				전문적인 해설을 도와주는 사람을 말합니다. <br>
			</p>
		</div>
	</div>
<br><br>
	<div class="scroll_on type_top" >
		<h4>배치현황</h4>
	</div>
	<div class="scroll_on type_top flexSide" id="placeDiv">
        <table border="1" style="text-align:center;">
			<thead>
				<tr>
					<th style="text-align:center;">권역명</th>
					<th style="text-align:center;">배치장소</th>
					<th style="text-align:center;">비고</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>뿌리공원</td>
					<td>족보박물관 옆 관광안내소</td>
					<td></td>
				</tr>
				<tr>
					<td>시티투어</td>
					<td>탑승해설</td>
					<td>시티투어 홈페이지 참고</td>
				</tr>
				<tr>
					<td>원도심 동행투어</td>
					<td>트래블라운지 2층</td>
					<td>도보해설 (트래블라운지 출발)</td>
				</tr>
                <tr>
                    <td>단재 신채호 선생 생가지 및 홍보관</td>
                    <td>단재 신채호 홍보관 내부</td>
                    <td></td>
                </tr>
                <tr>
                    <td>동춘당</td>
                    <td>동춘당 공원관리사무소</td>
                    <td></td>
                </tr>
                <tr>
                    <td>무형문화재전수회관</td>
                    <td>무형문화재전수회관 1층</td>
                    <td></td>
                </tr>
                <tr>
                    <td>숭현서원</td>
                    <td>숭현서원 내부</td>
                    <td></td>
                </tr>
                <tr>
                    <td>우암사적공원</td>
                    <td>우암사적공원 내 유물관</td>
                    <td></td>
                </tr>
                <tr>
                    <td>전통나래관</td>
                    <td>전통나래관 1층</td>
                    <td></td>
                </tr>
                <tr>
                    <td>진잠향교</td>
                    <td>진잠향교 내부</td>
                    <td></td>
                </tr>
                <tr>
                    <td>테미오래</td>
                    <td>옛 충남도지사 공관 내부 </td>
                    <td></td>
				</tr>
	        </tbody>
	    </table>
	</div>
	
	<div class="scroll_on type_top">
		<h4>활동현황</h4>
	</div>
	
	<div class="scroll_on type_right flexSide">
		<div class="flexSide" id="daejeonImg" style="background-image: url('<%= path %>/images/upSlide/daejeonTour2.jpg'); border-radius: 20px">
			<div class="stateDiv" style="text-align:center;">
				<strong id="st1" style="margin-left:-10px;">활동기간</strong>
				<br><br><br>
	            <ul class="ul1" style="margin-left:-40px;">
	                <li>연중무휴 원칙<br>
	                (신정ㆍ설ㆍ추석 명절 휴무)</li>
	                <li>1일 7시간<br>
	                (10:00~17:00)근무 <br>
	                (단재 신채호 생가지는 16:00까지)
	                </li>
	                <li>동절기 2개월간(1, 12월)은 <br>
	                실내 근무가 가능한 관광지만 활동</li>
	            </ul>
			</div>
			<div class="stateDiv" style="text-align:center;">
				<strong id="st2" style="margin-left:-10px;">근무방법</strong>
				<br><br><br>
				<ul class="ul1" style="margin-left:-40px;">
	                <li>권역별 1~3명 상시배치 근무원칙</li>
	                <li>해설시간 : 1일 3회 <br>
	              	  오전 10시, 오후 2시, 오후 4시</li>
	                <li>배치장소, 관광객 수요 등에 <br>
	               	 따라 탄력적 조정 배치<br>
                                        ※ 단체관광객(10명 이상) 예약 <br>
                                        신청 시 현장 동행 해설
                	</li>
           	 	</ul>
			</div>
		</div>
	</div>

	<div class="scroll_on type_top">
		<h4>예약안내</h4>
	</div>
	
	<div class="scroll_on type_top flexSide" style="text-align:center;">
		<div class="stateDiv rsvDiv" id="leftDiv">
			<br><br>
			<strong id="st3">해설신청방법 및 안내전화</strong>
			<br><br>
            <ul class="grn" style="text-align:center; margin-left:-30px;">
                <li>
                    <strong>대전광역시 관광마케팅과</strong><br>
                    042)270-3981
                </li>
                <li>
                    <strong>대전광역시관광협회</strong>
                    042) 226-8410
                </li>
				<li>
                    <strong>문화관광해설사 통합예약 사이트</strong><br>
                    https://www.kctg.or.kr
                </li>
            </ul>
		</div>
		<div class="stateDiv rsvDiv" style="text-align:center;">
			<br><br>
			<strong id="st4">기타 관광안내</strong>
			<br><br>
            <ul class="grn" style="text-align:center; margin-left:-30px;">
                <li>대전종합관광안내소 : 042) 861-1330</li>
                <li>트래블라운지 : 042) 221-1905</li>
                <li>서대전역 관광안내소 : 042) 523-1338</li>
                <li>대전복합터미널 관광안내소 : 042) 633-1355</li>
            </ul>
		</div>
	</div>

	<div class="scroll_on type_top hrefBtn">
		<button onclick="window.open('https://www.kctg.or.kr/index.do')">문화관광해설 신청하기</button>
	</div>
</div>

<div class="moveTopBtn">
	<img alt="상단 이동 버튼" src="<%= path %>/images/icon/scrollToTop.png">
</div>

<!-- 하단 메뉴바 삽입 -->
<jsp:include page="/view/main/bottom.jsp"/>

</body>
</html>