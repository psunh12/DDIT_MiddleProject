<%@page import="kr.or.ddit.vo.AdminVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>

<%
	String path = request.getContextPath();
%>

<!-- 관리자 예약 일괄 체크 아웃 script -->
<script src="<%= path %>/js/jquery-3.7.1.min.js"></script>
<script src="<%= path %>/js/admin.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 예쁜 Alert창 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/adminForm.css">

<style>
.marginTop {
	margin-top: 150px;
}
</style>

</head>
<body>
<%
   // 세션에 저장한 데이터 가져오기
	AdminVO adVo = (AdminVO)session.getAttribute("loginAdmin");
%>
<!-- 상단 메뉴바 -->
<jsp:include page="/view/main/top.jsp"/>

   <div id="mypage"><h1 class="mypage"><b>관리자페이지</b></h1></div>
    <div class="container">
        <div id="left">
            <!-- 왼쪽에 오는 내정보 -->
            <div class="admin-info" style="width: 340px;">
            <br>
                <div class="image-wrapper">
                <img src="<%=request.getContextPath()%>/images/login/산타꿈돌.jpg" class="round-image" >
                </div>
                <div class="admin-details" style="padding:10px;text-align: left;height: 130px;">
                    <!-- 회원 정보 내용 추가 -->
                    <%
                    	if(adVo != null){
                    %>
                    <p> 관리자 : <%=adVo.getAdmin_name()%></p>  
					<p> 아이디 : <%=adVo.getAdmin_id()%></p>  
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
					<div>
				<!-- 관리자 일괄 체크 아웃 -->
					<input type="button" id="doAllCheckout" value="숙소 체크 아웃" onclick="managerAllCheckout()">
				    </div>
                </div>           
            </div>  
        </div>

        <div id="right">

            <!-- 정보 표시 -->
            <div class="maincolumn">
                <div class="cate">
         		<iframe src="adminInfo.jsp" id ="myIframe" name ="itr">
         		</iframe>
                </div>
            </div>
        </div>
</div>
        
<!-- 하단 메뉴바 삽입 -->
<jsp:include page="/view/main/bottom.jsp"/>

<hr>


</body>
</html>