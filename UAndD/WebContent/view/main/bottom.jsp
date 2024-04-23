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
<script type="text/javascript" src="<%= path %>/js/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="<%= path %>/css/bottom.css">

<!-- 드롭다운 위로 출력 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<footer class="container-bottom">
    <div class="ftTop">
        <div id="djList">
      		<a href="http://www.daejeoncitytour.co.kr/kor/main/" target="_blank">대전시티투어</a>
      		<a href="http://www.dc500.org/" target="_blank">대청호오백리길</a>
      		<a href="https://www.daejeon.go.kr/his/board/musBoardDataList.do?bbsCode=hisrelic&menuSeq=667" target="_blank">대전의 문화재</a>
      		<a href="https://www.daejeon.go.kr/fod/index.do" target="_blank">대전의 맛</a>
      		<a href="http://traffic.daejeon.go.kr/" target="_blank">대전의 교통정보</a>
      		<a href="http://www.djto.kr/kor/index.do" target="_blank">대전관광공사</a>
        </div>
        <div id="siteList">
            <a href="https://www.daejeon.go.kr/index.do" target="_blank" >
				<img src="<%=path %>/images/header/Emblem_of_Daejeon.png" alt="Emblem_of_Daejeon.png">
			</a>
            <a href="https://www.instagram.com/daejeontourism/" target="_blank" >
				<img src="<%=path %>/images/header/인스타그램_아이콘.png" alt="인스타그램_아이콘.png">
			</a>
            <a href="https://www.youtube.com/channel/UCzRPq736TUcnIIDdfapXXZw" target="_blank" >
				<img src="<%=path %>/images/header/11.png" alt="11.png">
			</a>
            <a href="https://blog.naver.com/daejeontour" target="_blank" >
				<img src="<%=path %>/images/header/블로그1.png" alt="블로그1.png">
			</a>
        </div>
    </div>
    <div class="ftMid">
    	<div id="tourCall">
      		관광안내 전화번호 1330 <span>이용가능시간: 평일 09:00 ~ 18:00</span>
    	</div>
        <div id="callCenter">
        	<span>
            (35242) 대전광역시 서구 둔산로 100 / 콜센터 (042) 120
        	</span>
        </div>
    </div>
    <div class="ftBttm">
        <span>
            Copyright 2023 © DAEDEOK WARRIORS. All rights reserved
        </span>
    </div>
</footer>

</body>
</html>