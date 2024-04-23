<%@page import="kr.or.ddit.vo.AdminVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>관리자 로그인</title>
  <link rel="icon" href="../images/icon/꿈돌5-1.png" type="image/x-icon">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel= "stylesheet"  href="<%=request.getContextPath()%>/css/adminLogins.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
</head>
<style type="text/css">
 iframe {
   width: 100%;
   height : 100%;
   border : none;
 }
 #check{
   color : red;
 }
 
.input.password {
   position: relative;
}
.eyes {
  position: absolute;
  left: 250px;
  top: 50%;
  transform: translateY(-50%);
  cursor: pointer;
}
 </style>

</head>

<script type="text/javascript">
	//눈표시 클릭 시 패스워드 보이기 다시클릭하면 가려지기
    $(function()
    {
    	$('#yes').on('click', function () {
            if (!$('#chk').prop('checked')) { // 올바른 ID를 사용하여 체크박스에 액세스
                alert("이용약관에 동의체크를 해주세요.");
            	return false;
            }else{
                window.open('<%= request.getContextPath() %>/view/signup/memberSignup.jsp');
            }
        });
    	
        $('.eyes').on('click', function()
        {
            // 비밀번호 입력란의 타입을 'text' 또는 'password'로 변경
            var passwordInput = $('.input.password #password');
            var currentType = passwordInput.attr('type');
            
            if (currentType === 'password') 
            {
                passwordInput.attr('type', 'text');
                $(this).find('.fa-eye-slash').attr('class', 'fa fa-eye fa-lg');
            } else 
            {
                passwordInput.attr('type', 'password');
                $(this).find('.fa-eye').attr('class', 'fa fa-eye-slash fa-lg');
            }
        });
    });
	

</script>
<body>

	<div class="container">
		<!-- 로고  -->
		<div id="logo" onclick="location.href='<%=request.getContextPath()%>/index.jsp'">
			<img src= "<%=request.getContextPath()%>/images/header/로고3.png" alt="대전관광" style="width:300px;">
		</div>
		
        <!-- 회원서블릿에 저장된 데이터, 로그인오류정보 체크 -->
	<%
    // 세션에 저장한 데이터 가져오기
    //로그인 실패 때는 null값이 나온다 -> null일때 아래 body의 내용이 나오게하기
    AdminVO adVo = (AdminVO)session.getAttribute("loginAdmin");
    //로그인 성공, 실패 여부
    String check = (String)session.getAttribute("check");
	%>
	
		<!-- 관리자 로그인 탭 -->
		<div class="form-container sign-in-container" style="margin-left: -40px;">
		<!-- 로그인 안했거나 로그인  id 비밀번호가 틀렸을때    -->
			<form action="<%=request.getContextPath()%>/admin/adminLogin.do" method="post">
			<br><h1 style="font-size:30px; margin-left: 25px;"><b>관리자 로그인</b></h1><br>
			<%  
			    if(adVo == null)
			    {session.invalidate();
			%>
			<div>
	        	<input type="text" id="adminId" class="form-input" name="adminId" placeholder="아이디">
			</div>
				<div class="input password" >
		    <input type="password" id="password" class="form-input" name="adminPass" placeholder="비밀번호" style="margin-top: 10px;">
		    <div class="eyes">
		        <i class="fa fa-eye-slash fa-lg" style="margin-left: -80px;"></i>
				</div>
				</div>
				
		      	 <!-- 로그인 오류 메시지 -->
		        <% if (check != null && check.equals("false")) 
		        	{ %>
		            <span id="check" style="color: red;">로그인 오류 또는 비관리자입니다</span><br><br>
		        <% } %>
				<button type="submit" style="margin: 10px 0 0 25px; ">로그인</button>
			</form>   
			<!-- 로그인 성공시 -->
				<%
					}else
					{
				%>
				<script>
					window.location.href = '<%=request.getContextPath()%>/index.jsp';
				</script>
				<%
					}  
				%>			
	    <!-- 관리자 로그인 탭 끝 -->
	    </div>
	</div>
</body>
</html>