<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>한밭 지킴이</title>
<link rel="icon" href="<%= request.getContextPath() %>/images/icon/꿈돌5-1.png" type="image/x-icon">

<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.min.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.serializejson.min.js"></script>
<script src="<%=request.getContextPath() %>/js/hotel.js"></script>
<script src="<%=request.getContextPath() %>/js/reserveHotel.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- 카카오페이API script -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>

<link rel= "stylesheet"  href="<%=request.getContextPath() %>/css/hotel.css">
<link rel= "stylesheet"  href="<%=request.getContextPath() %>/css/reserve.css">

<!-- 예쁜 Alert창 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<%
   // 세션에 저장한 데이터 가져오기
	MemberVO memVo = (MemberVO)session.getAttribute("loginMember");

	String mem_id = null;
	
	if ( memVo == null ) {
		mem_id = null;
	} else {
		mem_id = memVo.getMem_id();
	}
%>

</head>

<body>
<!-- 상단 메뉴바 -->
<jsp:include page="/view/main/top.jsp"/>

<div id="hotel-main-container">
	<div id ="category-container">
		<div class="big-buttons">
	        <button class="cateBtn" name="tourList" id="tourListBtn">주요관광지</button>
	        <button class="cateBtn" name="resList"> 식당 </button>
	        <button class="cateBtn" name="hotelList">숙박업소</button>
	        <button class="cateBtn" name="list" id="tashuBtn">타슈</button>
	        <!-- 나머지 버튼들도 유사하게 추가할 수 있습니다 -->
        </div>
        <br><br>
        <p style="font-size: 15px;">지역</p>
        <div class="sub-buttons">
	        <button class="cateBtn" name="daeAll" >전체</button>
	        <button class="cateBtn" name="daeYou" >유성구</button>
	        <button class="cateBtn" name="daeSeo" >서구</button>
	        <button class="cateBtn" name="daeJung" >중구</button>
	        <button class="cateBtn" name="daeDong" >동구</button>
	        <button class="cateBtn" name="daeDae" >대덕구</button>
	        <!-- 다른 세부 카테고리 버튼들도 유사하게 추가 -->
				</div>
			<br><br>
		<img src="<%=request.getContextPath() %>/images/tour/tour_hotel.png">  
	</div>   
	<hr>
	<div id="search-container">
		<form id ="boxandbutton" >
	        <input type="text" id="searchbox" name="searchbox" placeholder="이름으로 검색합니다" style="width: 80%;">
	        <input type="button" id="searchBtn" name="searchbutton" value="검색" style="width: 20%;" >
        </form>
        <hr>
        <ul id="placesList"></ul>
        <div id="pagination"></div>
    </div>
        
	<hr>
      <!--   장소 목록 표시를 위한 ul 엘리먼트 
        <ul id="placesList"></ul>
        페이지네이션 표시를 위한 엘리먼트
        <div id="pagination"></div>
    </div> -->
      
    <div id="map-container">
        <div class="map_wrap">
            <!-- 지도를 표시할 div 엘리먼트 -->
            <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
        </div>
    </div>
    


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e849d9640ad67395b31b38844f71b8eb&libraries=services"></script>
	<script>
		data={};
	    mypath='<%=request.getContextPath()%>';  
	    var markers = [];
	    // 지도 객체 생성 및 설정
	    var mapContainer = document.getElementById('map'),
	    mapOption = 
	    {
			center: new kakao.maps.LatLng(36.3519957, 127.39131469),
	        level: 6
		};
	    var map = new kakao.maps.Map(mapContainer, mapOption);
	    // 장소 검색 서비스 객체 생성
	    var ps = new kakao.maps.services.Places();
	    // 인포윈도우 생성
	    var  infowindow = new kakao.maps.InfoWindow
	    ({
	    	zIndex: 1
		});
	    var geocoder = new kakao.maps.services.Geocoder();
	    var pagination;
	    var infowindows = [];
    
    	$(()=>
    	{
        	resetMap();
        	  $.ajax
        	  ({
        			url:`${mypath}/hotel/hotelList.do`,
        			type:'get',
        	 		success: function(res)	// ajax로 가져온 json데이터 res를 for문으로 돌린다
        	 		{   			    		   
        				res.forEach(function(item) // tour_addr값을 주소로하여 마커를 찍는다
        				{ 
        					geocoder.addressSearch(item.hotel_addr, function(result, status) 
        					{
        	 					if (status === kakao.maps.services.Status.OK) 
        	 					{
        							var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        	 						var marker = new kakao.maps.Marker({
        								map: map,
        								position: coords
        							});
        							markers.push(marker);
        							var  infowindow = new kakao.maps.InfoWindow
        							({
        								content: `<div id="infowindow" > 
        											${item.hotel_name}<p>
        										</div>`
        							});
	        						kakao.maps.event.addListener(marker, 'mouseover', function() 
	        						{
	        							infowindow.open(map, marker);
	        						});
	
	        						kakao.maps.event.addListener(marker, 'mouseout', function() 
	        						{
	        							infowindow.close();
	        						}); 
	        						
	        						kakao.maps.event.addListener(marker, 'click', function()
	        						{
	        						     moveToHotelDetail(`${item.hotel_no}`, '<%= mem_id %>');
	        						}); 	        						
		        					// 리스트에 아이템 추가
		        					var listItem = $('<li></li>')
    								.html(`    										
    								<table>
    									<tr>
    										<td rowspan="2">
    											<div id="hotel_img_div">
    												<img src="${path}/images/hotel/${item.hotel_img}"
    													style="width: 100px; height: 100px;
    														border-radius: 70%; margin-right:10px;">
    											</div>
    										</td>
    										<td>${item.hotel_name}</td>
    									</tr>
    									<tr>
    										<td>${item.hotel_addr}</td>
    									</tr>
    								</table>
    								<hr>`);
		
		        					// 클릭 이벤트 추가
		        					listItem.on('click', function() 
		        					{
		        						infowindows.forEach(function(window) 
		        						{
		        							window.close();
		        						});
		        						infowindow.open(map, marker);
		        						infowindows.push(infowindow);
		        						
		        						
		        						moveToHotelDetail(`${item.hotel_no}`, '<%= mem_id %>');
		        						
		        						map.panTo(coords);                     
		        					setTimeout(function() 
		        					{
		        						infowindow.close();
		        					}, 3500);
        						}); 

        						// 리스트를 출력할 요소에 추가
        						$('#placesList').append(listItem);
        					}
        				});
        			});
				},
        		error: function(xhr)
        		{
        			alert(xhr.status);
        		},
        		dataType: 'json'			
        	})
        })
	</script>
	<!-- 숙소의 상세 정보를 출력하는 모달창 시작 -->
	<div class="modal" id="hotelDetailModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
		
				<!-- 모달 헤더 -->
				<div class="modal-header" id="hotelModalHeader">
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- 모달 몸통(내용 출력) -->
				<div class="modal-body" id="hotelModalBody">
					<div id="left-modal-body"></div> 	<!-- 상세 정보 폼 -->
					<div id="right-modal-body"></div> 	<!-- 예약 입력 폼 -->
				</div>

				<!-- 모달 하단(후기 출력) -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div> <!-- 숙소의 상세 정보를 출력하는 모달창 끝 -->
</div>
</body>
</html>