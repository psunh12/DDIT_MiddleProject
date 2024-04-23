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

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<script src="<%=request.getContextPath() %>/js/tour.js"></script>

<link rel= "stylesheet"  href="<%=request.getContextPath() %>/css/tour.css">
</head>

<%
  String getAdmin= (String)session.getAttribute("admin");
   String admin=null;
  if(getAdmin!=null) admin=getAdmin;
	  
%>

<body>

<!-- 상단 메뉴바 -->
<jsp:include page="/view/main/top.jsp"/>

<div id="map-main-container">
	<div class="map-main" id ="category-container">
		<div class="big-buttons">
	        <button class="cateBtn" name="tourList" id="tourListBtn">주요관광지</button>
	        <button class="cateBtn" name="resList"> 식당 </button>
	        <button class="cateBtn" name="hotelList">숙박업소</button>
	        <button class="cateBtn" name="list" id="tashuBtn">타슈</button>
        </div>
        <!-- 나머지 버튼들도 유사하게 추가할 수 있습니다 -->
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
        <br><br><br>
        <div id="mapinsert" style="display:none">
        	관리자 메뉴&nbsp;
				<button class="cateBtn"  name="mapinsert" style="border:none;"><div style="margin-top:2px;">명소 추가</div></button>
			</div>
		<img src="<%=request.getContextPath() %>/images/tour/tour_tour2.png">  
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
            vadmin=<%=admin%>;
            console.log(vadmin);   
            data={};
            mypath='<%=request.getContextPath()%>';  
            path='<%=request.getContextPath()%>';  
        var markers = [];
        // 지도 객체 생성 및 설정
        var mapContainer = document.getElementById('map'),
            mapOption = {
                center: new kakao.maps.LatLng(36.3519957, 127.39131469),
                level: 6
            };
        var map = new kakao.maps.Map(mapContainer, mapOption);
        // 장소 검색 서비스 객체 생성
        var ps = new kakao.maps.services.Places();
        // 인포윈도우 생성
        var  infowindow = new kakao.maps.InfoWindow({
            zIndex: 1
        });
        var geocoder = new kakao.maps.services.Geocoder();
        var pagination;
        var infowindows = [];
        var jpgname="";
        $(()=>{    
      
         displayTour();
         
        })

   //관리자 권한이 생겼을때 보여지게 하는 버튼들
	if(vadmin==true){
        $("#mapinsert").css("display","block");
      $(document).on("click", "#mapinsert", function() {    
        $(".adminPlace").css("display","block");   
        })
	}
</script>


  <!-- 글쓰기 The Modal -->
<div class="modal" id="wModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">관광명소 추가</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        
           <form name="wform" id ="wform" action="<%=request.getContextPath()%>/fileUpload.do"
           enctype="multipart/form-data" method="post" >
         
           <label>장소 구분</label>
           <input type ="text" id ="tour_tp_nm" name="tour_tp_nm" class="txt"><br><br>
           <label>명소 이름</label>
           <input type ="text" id ="tour_name" name="tour_name" class="txt"><br><br>
           <label>주 소&nbsp;&nbsp;&nbsp;&nbsp;</label>
           <input type ="text" id ="tour_addr" name="tour_addr" class="txt"><br><br>
           <label>전화번호</label>
           <input type ="text" id ="tour_tel" name="tour_tel" class="txt"><br><br>         
           <label> url&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
           <input type ="text" id ="tour_url" name="tour_url" class="txt">
           <label>이미지</label>
           <input type="file" id="tour_img" class="tour_img" ><input type="button" value="업로드" class="cateBtn" name="uploadimg"><br><br> 
           <br> <br>
           <input type="button" value="확인" name="insertsend" class="cateBtn">
           
         </form> 
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal" style="background-color: #0080ff; border:none;">Close</button>
      </div>

    </div>
  </div>
</div>

	<!-- 글 수정 The Modal -->
<div class="modal" id="uModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">관광명소 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <form name="uform" id ="uform">
         
           <input type ="hidden" id ="utour_no" name="tour_no" class="txt">
           <label>장소 구분</label>           
           <input type ="text" id ="utour_tp_nm" name="tour_tp_nm" class="txt"><br><br>
           <label>명소 이름</label>
           <input type ="text" id ="utour_name" name="tour_name" class="txt"><br><br>
           <label>주 소&nbsp;&nbsp;&nbsp;&nbsp;</label>
           <input type ="text" id ="utour_addr" name="tour_addr" class="txt"><br><br>
           <label>전화번호</label>
           <input type ="text" id ="utour_tel" name="tour_tel" class="txt"><br><br>         
           <label> url&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
           <input type ="text" id ="utour_url" name="tour_url" class="txt">
           <label>이미지</label>
           <input type="file" id="utour_img" class="tour_img" ><input type="button" value="업로드" class="cateBtn" name="uuploadimg"><br><br> 
           <br> <br>
           <input type="button" value="확인" name="updatesend" class="cateBtn">
           
         </form> 
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
</div>

<div id='result2'></div>
</body>
</html>