<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page isELIgnored="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한밭 지킴이</title> 
<link rel="icon" href="../images/icon/꿈돌5-1.png" type="image/x-icon">

<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script src="<%=request.getContextPath() %>/js/culture.js"></script> 
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel= "stylesheet"  href="<%=request.getContextPath() %>/css/culture.css">  
<script src="<%=request.getContextPath() %>/js/jquery.serializejson.min.js"></script>


 <script>
   mypath='<%=request.getContextPath()%>';
   currentPage=1;
   var vword="";
   $(document).ready(function() {
	 
		   
		    let initialCategory = getQueryStringValue('cate'); // 링크에서 값을 가져옴
		    vvword=initialCategory;
		    

		    // 가져온 값이 없거나 원하는 값이 없을 경우 기본값으로 설정
		    if (!initialCategory || !['1', '2', '3'].includes(initialCategory)) { //1,2,3이 아니면 전체리스트 보여줌
		     const gthis = $(`.cateBtn[name='resList']`);
			 gthis.addClass('active');
               
			 ListPageServer(currentPage, vvword);
		       
		    }
		    	
		    const gthis = $(`.cateBtn[name='${initialCategory}']`); //카테고리 번호를 가져와 보여줌
		    gthis.addClass('active');

		    ListPageServer(currentPage, vvword);
		    	
		   
		});
</script>

<style>
</style>

</head>
<body>

<jsp:include page="/view/main/top.jsp"/>
<div class="big-buttons">      <!-- 카테고리 선택 버튼 -->
<button class="cateBtn" name="resList" active> 전체보기 </button>
<button class="cateBtn" name="concertList" >공연</button>
<button class="cateBtn" name="fesList"> 축제 </button>
<button class="cateBtn" name="museumList">전시</button>
<br><br>
&nbsp;&nbsp;<img src="<%=request.getContextPath() %>/images/culture/cul_cul.png" style="width:100px; height:100px;">
</div>

    
<div id= "mainview" class='centered-content' >
<div id ="result1"></div>  <!-- 문화 리스트 출력되는 자리 -->
<br><br>
<div id ="pagelist" class='centered-content'></div> <!-- 페이지 버튼이 출력되는 자리 --> 
<div id ="result2"></div>  <!-- offcanvas 폼이 출력되는 자리 -->
 </div> 
</body>
</html>