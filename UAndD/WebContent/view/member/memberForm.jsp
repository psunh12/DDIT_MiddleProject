<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">

<title>한밭 지킴이</title>
<link rel="icon" href="<%=request.getContextPath()%>/images/icon/꿈돌5-1.png" type="image/x-icon">  

	<link rel= "stylesheet"  href="<%=request.getContextPath()%>/css/memberForm.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<%
   // 세션에 저장한 데이터 가져오기
   MemberVO memVo = (MemberVO)session.getAttribute("loginMember");
%>
<script>
<%
	if(memVo == null){
%>
	swal({
	    title: "로그인이 필요합니다.",
	    text: "로그인 페이지로 돌아갑니다.",
	    icon: "warning"
	}).then(() => {
		window.location.href = '<%=request.getContextPath()%>/view/login_out/loginMain.jsp';
	});
	
<%
	}
%>
</script>
<script>
	function changeIframe(url, title) {
	document.getElementById('myIframe').src = url;
}
</script>

</head>
<body>
    <!-- 상단 메뉴바 -->
    <jsp:include page="/view/main/top.jsp"/>
  
   <div id="mypage"><h1 class="mypage"><b>마이페이지</b></h1></div>
    <div class="container">
        <div id="left">
            <!-- 왼쪽에 오는 내정보 -->
            <div class="mem-info" style="width: 340px;">
            <br>
<!--                 <div><h2><b>내정보</b></h2></div> -->
                <div class="image-wrapper">
                <img src="<%=request.getContextPath()%>/images/login/루돌푸꿈돌.png" class="round-image" >
                </div>
                <div class="mem-details" style="padding:10px;text-align: left;height: 130px;">
                    <!-- 회원 정보 내용 추가 -->
                    <%
                    	if(memVo != null){
                    %>
                    <p> 이름 : <%=memVo.getMem_name()%></p>  
					<p> 아이디 : <%=memVo.getMem_id()%></p>  
					<%
                    	}else{
					%>
					<script>
						swal({
					    title: "로그인이 필요합니다.",
					    text: "로그인 페이지로 돌아갑니다.",
					    icon: "warning"
					}).then(() => {
						window.location.href = '<%=request.getContextPath()%>/view/login_out/loginMain.jsp';
					});
					</script>
					<%
                    	}
					%>
                </div>
            <div id="mem-info-link" style="padding:10px; height:40px;">
            	<!-- 상단에 오는 카테고리 -->
	            <div class="category-container">
	            	<button class="category-item" type="button" onclick="changeIframe('<%=request.getContextPath()%>/view/member/viewRestaurantReserve.jsp')">식당예약</button>
	            	<button class="category-item" type="button" onclick="changeIframe('<%=request.getContextPath()%>/view/member/viewHotelReserve.jsp')"> 숙소예약</button>
	            </div>
           	
                   <a href="#" onclick="changeIframe('<%=request.getContextPath()%>/member/updateMember.do')">회원수정</a>
                   <a href="#" onclick="changeIframe('<%=request.getContextPath()%>/view/withdraw/memberWithdraw.jsp')">탈퇴하기</a>
                   
            	
            </div>            
            </div>  
        </div>

        <div id="right">

            <!-- 정보 표시 -->
            <div class="maincolumn">
                <div class="cate">
         		<iframe src="memberInfo.jsp" id ="myIframe" name ="itr" target=>
         		</iframe>
                </div>
            </div>
        </div>
    </div>
<div>
<!-- 하단 메뉴바 삽입 -->
<jsp:include page="/view/main/bottom.jsp"/>
</div>
</html>
</body> 