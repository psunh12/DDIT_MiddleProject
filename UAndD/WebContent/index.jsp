<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>한밭 지킴이</title>
<link rel="icon" href="./images/icon/꿈돌5-1.png" type="image/x-icon">  
<% 
	String path = request.getContextPath();	// 상위 경로를 변수로 선언
%>

<!-- 메인 이미지 슬라이드 css -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<link rel="stylesheet" href="<%= path %>/css/banner.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- 공통 js -->
<script type="text/javascript" src="<%= path %>/js/common.js"></script>
<!-- 공통 css -->
<link rel="stylesheet" href="<%= path %>/css/common.css">

</head>
<body>


<!-- 상단 메뉴바 -->
<jsp:include page="/view/main/top.jsp"/>

<!-- 메인 이미지 슬라이드 css 시작 -->
<div class="carousel-container">
	<div class="fix-text"><!-- 이미지 위에 올라가는 고정 텍스트  -->
		<h3>DAEJEON<br>TRIP ROAD</h3>
		<p>대전에서 뭐하지?<br> 한밭지킴이에서 계획짜자!</p>
	</div>

	<!-- 배너를 캐러셀Carousel -반응형슬라이드로 만들어줌- 설정. -->
	<div id="banner" class="carousel slide" data-bs-ride="carousel">

		<!-- 배너 중앙 아래 / 슬라이드가 지나갈때마다 같이 지나가는 버튼 생성-->
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#banner" data-bs-slide-to="0" class="active"></button>
			<button type="button" data-bs-target="#banner" data-bs-slide-to="1"></button>
			<button type="button" data-bs-target="#banner" data-bs-slide-to="2"></button>
			<button type="button" data-bs-target="#banner" data-bs-slide-to="3"></button>
			<button type="button" data-bs-target="#banner" data-bs-slide-to="4"></button>
		</div>
		
		<!-- 캐러셀(슬라이드) 이미지삽입 -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="<%= path %>/images/banner/특별상-윤환-대동하늘공원의-.jpg" 
					alt="대동하늘공원" class="d-block" style="width:100%">
    		</div>
    
			<div class="carousel-item">
				<img src="<%= path %>/images/banner/5-가작-김미영-한밭수목원의.jpg" 
					alt="한밭수목원" class="d-block" style="width:100%">
			</div>
    
			<div class="carousel-item">
				<img src="<%= path %>/images/banner/5-가작-이영춘-반영-1.jpg" 
					alt="한밭수목원" class="d-block" style="width:100%">
			</div>
    
			<div class="carousel-item">
				<img src="<%= path %>/images/banner/2-은상-성순용-역사탐방.jpg" 
					alt="역사탐방" class="d-block" style="width:100%">
			</div>
    
			<div class="carousel-item">
				<img src="<%= path %>/images/banner/3-특별상-노희완-장태산에서.jpg" 
					alt="장태산" class="d-block" style="width:100%">
			</div>
		</div>
  
		<!-- 캐러셀 왼쪽 오른쪽 슬라이드기능 버튼 생성 -->
		<button class="carousel-control-prev" type="button" data-bs-target="#banner" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" type="button" data-bs-target="#banner" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
	</div>
</div><!-- 메인 이미지 슬라이드 css 끝 -->

<!-- 날씨 API --> 
<jsp:include page="/view/weather/weather.jsp"/>

<!-- 배너2 -->
<img src="<%= path %>/images/banner/배너2.png" style="margin:100px 0 100px 350px">


<!-- 축제 관련 내용 jsp -->
<jsp:include page="/view/main/mainUsedCulture.jsp"/>

<!-- 공연 관련 내용 jsp -->

<br>
<br>
<br>
<br>

<!-- 동영상 자동 재생(height 자동 조절 안 됨 - 수정해보다가 안 되면 발표 화면에 맞춰서 고정값 넣기) -->
<div class="container" id="videoArea">
	<iframe class="videoArea" src="https://www.youtube.com/embed/Vh6UyH1TAEY?si=-enLIog4Wzto0soU&amp;controls=0&mute=1&autoplay=1&playlist=Vh6UyH1TAEY&loop=1" 
			title="YouTube video player" frameborder="0" width="100%" height="650px"
			allow="accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen ></iframe>
</div>

<div class="moveTopBtn">
	<img alt="상단 이동 버튼" src="<%= path %>/images/icon/scrollToTop.png">
</div>

<!-- 하단 메뉴바 삽입 -->
<jsp:include page="/view/main/bottom.jsp"/>

</body>
</html>