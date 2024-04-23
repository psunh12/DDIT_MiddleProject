<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>한밭 지킴이</title>
<link rel="icon" href="<%= request.getContextPath() %>/images/icon/꿈돌5-1.png" type="image/x-icon">

<link rel= "stylesheet"  href="<%=request.getContextPath()%>/css/login.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/passEye.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<style type="text/css">
 iframe {
   width: 100%;
   height : 100%;
   border : none;
 }
 #check{
   color : red;
 }
 </style>

</head>

<script type="text/javascript">
	//눈표시 클릭 시 패스워드 보이기 다시클릭하면 가려지기
    $(function()
    {
    	$('#yes').on('click', function () {
            if (!$('#chk').prop('checked')) { // 올바른 ID를 사용하여 체크박스에 액세스
            	
            	swal({
			        title: "개인정보 동의가 필요합니다.",
			        text: "이용약관에 동의 체크를 해주세요.",
			        icon: "warning"
			    });
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
	<!-- 로고  -->
	<div id="logo" onclick="location.href='<%=request.getContextPath()%>/index.jsp'">
		<img src= "<%=request.getContextPath()%>/images/header/로고3.png" alt="대전관광" style="width:300px;">
	</div>
	
	<!-- 회원서블릿에 저장된 데이터, 로그인오류정보 체크 -->
	<%
	
    // 세션에 저장한 데이터 가져오기
    //로그인 실패 때는 null값이 나온다 -> null일때 아래 body의 내용이 나오게하기
    MemberVO memVo = (MemberVO)session.getAttribute("loginMember");
    //로그인 성공, 실패 여부
    String check = (String)session.getAttribute("check");
    
	%>
<div class="container" id="container">
  <div class="form-container sign-up-container">
    <form action="#">
      <h1 style="font-size:30px;"><b>이용약관 동의서</b></h1>
	<br>
	<div>
		<jsp:include page="/view/signup/memberAgre.jsp"/>
	</div>
	
	<div class="checkBox check">
	<div>
		<table>
        	<tr>
          		<td><span>개인정보 수집 및 이용약관 동의(필수)</span></td>
          		<td><input type="checkbox" id="chk"></td>
         	</tr>
		</table>
	</div>
</div>
      <button id="yes" style="margin-top:10px;">회원가입</button>
    </form>
  </div>
  
  
  
  <!-- 회원 로그인 탭  -->
  <div class="form-container sign-in-container">
		<form action="<%=request.getContextPath()%>/member/loginMember.do" method="post">
		<br><h1 style="font-size:30px;"><b>로그인</b></h1><br>
		<%
		    if(memVo == null)
		    {session.invalidate();
		%>
		<div>
		<input type="text" id="memId" class="form-input" name="memId" placeholder="아이디">
		</div>
		<div class="input password">
	    <input type="password" id="password" class="form-input" name="pass" placeholder="비밀번호" style="margin: 10px 0 0 -9px; width: 240px;">
	    <div class="eyes">
	        <i class="fa fa-eye-slash fa-lg"></i>
	    </div>
		</div>
		
		<!-- 로그인 오류 메시지 -->
		<% if (check != null && check.equals("false")) { %>
		    <span id="check" style="color: red; margin-top: 10px;">로그인 오류 또는 비회원입니다</span>
		<% } %>
		
		<button type="submit" style="margin-top: 10px; width: 225px; height: 40px; padding : 0;">로그인</button>
    	<!-- 카카오 로그인 -->
		<a id="kakao-login-btn"></a>
		<div id="result"></div>
        <div class="idpass">
            <a href="<%=request.getContextPath()%>/view/login_out/getId.jsp" style="text-decoration: none;">아이디 찾기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/view/login_out/getPassword.jsp" class="login_forgot" style="text-decoration: none;">비밀번호 찾기 </a>
        </div> 
	  <a href="<%=request.getContextPath()%>/view/login_out/adminLogin.jsp" style="text-decoration: none; color: #22b14c;">관리자세요?
	  </a>			
			</form> 
			
			<!-- 카카오 로그인 스크립트 -->
			<script type="text/javascript">
			  function unlinkApp() 
			  {
			    Kakao.API.request
			    ({
			      url: '/v1/user/unlink',
			      success: function(res) 
			      {
					  alert('success: ' + JSON.stringify(res))
			      },
			      fail: function(err) 
			      {
			          alert('fail: ' + JSON.stringify(err))
			      },
			    })
			  }
			</script>
		
<script type="text/javascript">
    Kakao.init('e849d9640ad67395b31b38844f71b8eb'); // JavaScript 키 입력
    console.log(Kakao.isInitialized());

    Kakao.Auth.createLoginButton({
        container: '#kakao-login-btn',
        success: function (authObj) {
            Kakao.API.request({
                url: '/v2/user/me',
                success: function (result) {
                    $('#result').append(result);
                    id = result.id;
                    connected_at = result.connected_at;
                    kakao_account = result.kakao_account;
                    $('#result').append(kakao_account);
                    resultdiv = "<h2>로그인 성공 !!";
                    resultdiv += '<h4>id: ' + id + '<h4>';
                    resultdiv += '<h4>connected_at: ' + connected_at + '<h4>';
                    name = "";
                    birthday = "";
                    email = "";
                    birthyear = "";
                    phone_number = "";
                    address = "";

                    if (typeof kakao_account != 'undefined') { // 받을 데이터 추가 및 삭제
                        email = kakao_account.email;
                        name = kakao_account.name;
                        birthyear = kakao_account.birthyear;
                        birthday = kakao_account.birthday;
                        phone_number = kakao_account.phone_number;
                        nickname = kakao_account.profile_nickname;
                        address = kakao_account.shipping_address;

                        // 폼 동적으로 생성
                        var form = $('<form action="<%=request.getContextPath()%>/member/loginKakao.do" method="post"></form>');
                        form.append('<input type="hidden" name="id" value="' + id + '">');
                        form.append('<input type="hidden" name="mail" value="' + email + '">');
                        form.append('<input type="hidden" name="name" value="' + name + '">');
                        form.append('<input type="hidden" name="tel" value="' + phone_number + '">');
                        $('body').append(form);

                        // 폼 제출
                        form.submit();
                    }
                },
                fail: function (error) {
                    alert('로그인에 성공했지만 사용자 정보를 요청하지 못했습니다: ' + JSON.stringify(error));
                },
            });
        },
        fail: function (err) {
            alert('로그인 실패: ' + JSON.stringify(err));
        },
    });
</script> 
			
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
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
		<img src="<%=request.getContextPath()%>/images/icon/여행객.png" style="width:90px; height:90px;">
        <br><h1><b>대전 여행러라면! <br>로그인하러 GO! GO!</b></h1>
        <p>유잼 대전으로 떠나요!</p>
        <button class="ghost" id="signIn">로그인</button>
      </div>
      <div class="overlay-panel overlay-right">
		<img src="<%=request.getContextPath()%>/images/icon/자전거.png" style="width:100px; height:100px;">
        <br><h1><b>타슈타고 여행가유~</b></h1>
        <p>우리 튀김소보루 사러가요!</p>
        <button class="ghost" id="signUp">회원가입</button>
      </div>
    </div>
  </div>
</div>
</body>
<script src="<%=request.getContextPath()%>/js/logins.js"></script>
</html>