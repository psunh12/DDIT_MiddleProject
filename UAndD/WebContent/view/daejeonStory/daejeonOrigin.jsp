<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	String path = request.getContextPath();
%>
<title>한밭 지킴이</title>
<link rel="icon" href="<%= path %>/images/icon/꿈돌5-1.png" type="image/x-icon">  

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
    <div class="scroll_on type_left">
    	<h2>대전의 유래</h2>
    	<br>
    	<img src="<%= path %>/images/upSlide/daejeon1.jpg">
    </div>
    
    <div class="scroll_on type_right flexSide">
    	<div style="width: 14%"></div>
    	<div style="width: 500px; margin-right: 10px;">
    		<p>1914년 <br> 대전군(大田郡)이 형성된 당시</p>
    		<br>
    		<span>
    		12개 면의 각 지도는 대전이란 도시의 탄생을 알리는<br>
    		출생기록부와 같다.<br>
    		공주와 회덕, 진잠의 일부로 존재하던 조선시대 고지도에는<br>
    		대전의 옛 모습이 고스란히 드러난다.
    		</span>
    	</div>
    	<div>
    		<figure>
	    		<img alt="대전 사진2" src="<%= path %>/images/upSlide/daejeon2.png">
    			<figcaption style="margin-top:10px;">대전역 앞 중앙로(1930년대)</figcaption>		
    		</figure>
    	</div>
    </div>
    
    <div class="scroll_on type_top flexSide">
    	<div style="width: 14%"></div>
    	<div style="width: 500px; margin-right: 10px;">
		    <p>1905년 대전역이 세워지자</p>
		    <br>
		    <span>
			그 주변으로 사람과 물자가 모여 이른바 ‘시가지’가 <br>
			형성되었으며 회덕에 있던 군청도 1910년  <br>
			대전역 부근으로 옮겨왔다. <br>
			1914년 대전군(大田郡) 신설과 함께 대전역 주변의  <br>
			시가지 약 1.26㎢가 ‘대전면’으로 설정되었다.  <br>
			1933년 발간된 <충남산업지(忠南産業誌)>는 대전을  <br>
			“적막한 한 촌에 지나지 않았으나 경부선의 한 역이  <br>
			설치되면서 이때부터 여기를 ‘대전’이라고  <br>
			부르게 되었다”고 적었다.  <br>
			대전에 역이 생긴 것이 아니라 역이 세워지면서  <br>
			대전이라고 불리게 되었다는 기록이다. <br>
			</span>
		</div>
		<div>
    		<figure>
	 	   		<img alt="대전 사진3" src="<%= path %>/images/upSlide/daejeon3.png">
    			<figcaption style="margin-top:10px;">대전역 앞 중앙로(1970년대)</figcaption>		
    		</figure>
    	</div>
    </div>
	
    <div class="scroll_on type_bottom flexSide">
    	<div style="width: 14%"></div>
    	<div style="width: 500px; margin-right: 10px;">
    		<span>
    		 <br> <br> <br>
    		대전면은 1931년 ‘대전읍(邑)’으로 개편되었다가  <br>
    		1935년 ‘대전부(府)’로 승격되면서  <br>
			명실상부한 ‘도시’로서의 위상을 갖게 된 것이다. <br>
			</span>
		</div>
		<div>
    		<figure>
	 	   		<img alt="대전 사진4" src="<%= path %>/images/upSlide/daejeon4.png">
    			<figcaption style="margin-top:10px;">대전역 앞 중앙로(현재)</figcaption>		
    		</figure>
    	</div>
	</div>
	
	<div style="height: 100px">
	</div>
</div>

<div class="moveTopBtn">
	<img alt="상단 이동 버튼" src="<%= path %>/images/icon/scrollToTop.png">
</div>

<!-- 하단 메뉴바 삽입 -->
<jsp:include page="/view/main/bottom.jsp"/>

</body>
</html>