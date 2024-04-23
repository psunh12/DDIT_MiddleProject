<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
     <link rel="stylesheet" href="<%=request.getContextPath()%>/css/updateMem.css">
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script>
$(()=>{
	
	// 수정버튼 클릭
	$('#updatebtn').on('click',function()
		{
			// 각 입력란의 값을 가져옴
			var input1 = $('#pass2').val();
			var input2 = $('#name').val();
			var input3 = $('#tel').val();
			var input4 = $('#domain-list').val();
			var input5 = $('#postcode').val();
			var input6 = $('#extraAddress').val();
			var input7 = $('#roadAddress').val();
			var input8 = $('#detailAddress').val();
			
			if (input1.trim() === '' || input2.trim() === '' || input3.trim() === '' || 
				    input4.trim() === '' || input5.trim() === '' || input6.trim() === '' || 
				    input7.trim() === '' || input8.trim() === '') {
				    swal({
				        title: "입력란을 모두 채워주세요.",
				        text: "다시 시도해주세요.",
				        icon: "error"
				    });
		        return false;
		    }
		
			vdata1 = $('#updateform').serialize();
			console.log(vdata1);
			
	
			// 서버로 보내기
			$.ajax
			({
				url : "<%=request.getContextPath()%>/member/updateMember.do",	
				data : vdata1,
				type : 'post',
				dataType : 'json',
				success : function(res)
				{
					swal({
		                title: "정보수정에 성공했습니다!",
		                text: "마이페이지로 돌아갑니다.",
		                icon: "success"
		            }).then(() => {
		            	window.open('<%=request.getContextPath()%>/view/member/memberForm.jsp', '_blank');
		            });
				},
				error : function(xhr)
				{
	            swal({
	                title: "정보수정에 실패했습니다!",
	                text: "다시 확인해주세요.",
	                icon: "error"
	            });
	            return false;
	        }
			});	
		});
	
	// password
	$('#pass2').on('keyup', function() {
	    let pass1 = $("#pass1").val();
	    let pass2 = $(this).val().trim();
	
	    // 비밀번호 재확인 및 유효성 검사
	    if (pass1 !== "" || pass2 !== "") {
	        if (pass1 === pass2) {
	            $("#spanpass").html('일치');
	            $("#spanpass").css('color', 'green');
	
	            // 비밀번호 유효성 검사 (영문자와 숫자 조합으로 6~15글자)
	            let passPattern = /^[a-zA-Z0-9]{6,15}$/;
	            if (!passPattern.test(pass2)) {
	                $("#spanpass").html('비밀번호는 영문자와 숫자 조합으로 6~15글자여야 합니다.');
	                $("#spanpass").css('color', 'red');
	            }
	        } else {
	            $("#spanpass").html('불일치');
	            $("#spanpass").css('color', 'red');
	        }
	    }
	});

	// 이름 형식체크
	$('#name').on('keyup', function()
	{
		namevalue= $(this).val().trim();
		namePattern=/^[가-힇]{2,10}$/;
		
		if(!namePattern.test(namevalue))
		{
			$('#spanname').html('형식오류').css('color','red');
		}else
		{
			$('#spanname').html("");
		}
	});
	
	// 연락처 형식체크	
	$('#tel').on('keyup', function()
	{
		telvalue= $(this).val().trim();
		telPattern=/01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}/;		// 연락처 정규화
		
		if(!telPattern.test(telvalue))
		{
			$('#spantel').html('핸드폰 번호를 확인 해주세요.').css('color','red');
		}else
		{
			$('#spantel').html("");
		}
	});

	// 도메인 입력
	$(document).ready(function()
	{
    	$('#domain-list').change(function()
		{
        	const selectedOption = $(this).val();
        	const domainInput = $('#domain-text');

			if (selectedOption !== "type" && selectedOption !== null)
			{
            	domainInput.val(selectedOption);
            	domainInput.prop('disabled', true);
        	} else
			{
            	domainInput.val('');
            	domainInput.prop('disabled', false);
        	}
    	});
    });
});

// 우편 API
function prod1() {
    	 
 	    var themeobj = {	    	   		
 	    }
	
	//실제 우편번호 API가 시작되는 코드
	new daum.Postcode
	({
	        	
//	 테마 설정값 호출
	theme: themeobj, 
	        	
	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
    	oncomplete: function(data)
		{
		// 요청한 값들을 저장하는 변수
   		// 삭제해도 우편번호API에는 지장X
			var resultHTML = [];

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 나눈다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname))
			{
				extraRoadAddr += data.bname;
            }
            
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y')
			{
				extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== '')
			{
				extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호 검색해서 얻을 수 있는 data('key' , "value")를 <li>에 넣어서
            //	사용시 찾아보기 좋게 정리함
            for(var item in data)
			{
				resultHTML.push('<li><code class="data_key">'+item+'</code>: "'+data[item]+'"</li>');
            }
            
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;	// --> 우편번호 칸
            document.getElementById("roadAddress").value = roadAddr;	// --> 도로명 주소 칸
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== '')
			{
                document.getElementById("extraAddress").value = extraRoadAddr;
            } else 
			{
                document.getElementById("extraAddress").value = '';
            }
       }
    }).open();
}	

</script>
</head>
<body>

<% 
 	MemberVO memVo = (MemberVO)session.getAttribute("loginMember");
%>

<div class="container">
	<div class="header">
		<div><b>회원 수정</b></div>
	</div>
<form id= "updateform">

	<input type ="hidden" name ="mem_id" value="<%=memVo.getMem_id()%>">
	

<div class="form-group" style="margin:10px 0 10px 0;">
	<label for="id">아이디 <%=memVo.getMem_id() %> </label>         
</div>

           <div class="form-group">
               <label for="pwd">비밀번호 </label> 
               <input type="password" class="form-control" id="pass1" name="mem_pass">
           </div>
           
           <div class="form-group">
               <label for="pwd">비밀번호확인</label> 
               <input type="password" class="form-control" id="pass2">
           	<span id="spanpass"></span>
           </div>
           
           <div class="form-group">
               <label for="name">이름</label>
               <input type="text" class="form-control" id="name" name="mem_name">
               <span id="spanname"></span>
           </div>
           
           <div class="form-group">
               <label for="tel">휴대폰번호</label> 
               <input type="text" class="form-control" id="tel" name="mem_tel">
               <span id="spantel"></span>
           </div>

         <div class="form-group">
            <label for="mail">이메일</label>
            
            <table class="email-input-group">
				<tr>
	            <td>
	                <input type="text" class="form-control" id="mail" name="mem_mail">
	            </td>
				<td>
				@
				</td>
				<td>
	                <input type="text" class="form-control" id="domain-text" >
				</td>
				
				<td>
					<select class="box" id="domain-list" name="domain">
						<option value="type">직접입력</option>
						<option value="naver.com">naver.com</option>
	                    <option value="daum.net">daum.net</option>
	                    <option value="gmail.com">gmail.com</option>
	                    <option value="kakao.com">kakao.com</option>
	                    <option value="nate.com">nate.com</option>
                		</select>
				</td>
				
				</tr>
               </table>
        </div>      

       <div class="form-group" style="display: inline-block;">
        	<label for="zip">주소</label>
        	<table>
         	<tr>
         		<td>
					<input type="text" id="postcode" class="form-control" placeholder="우편번호">
         		</td>
         		<td>
					<input type="button" onclick="prod1()" value="우편번호 찾기" class="btn" id="postnum" style="line-height:0.8;">
         		</td>
         	</tr>
       		<tr>
       			<td><input type="text" id="roadAddress" class="form-control" placeholder="도로명주소" name="roadAddress"></td>
       			<td><input type="text" id="extraAddress" class="form-control" placeholder="참고항목" name="extraAddress"></td>
       		</tr>
        	</table>
           <input type="text" id="detailAddress" class="form-control" placeholder="상세주소" name="detailAddress">
	</div>
   <br>
    <div style="display:flex; margin:10px;">
    <input class="btn" type="button" id="updatebtn" value="수정">
    <input class="btn" type="reset" id="reset" value="취소"> 
    <script>
document.getElementById('reset').addEventListener('click', function() {
  // 부모 창의 window 객체를 사용하여 전체 창의 URL 변경
  window.parent.location.href = '<%=request.getContextPath()%>/view/member/memberForm.jsp';
});
</script>
    </div>
    <span id="update"></span> 
</form>
</div>
</body>
</html>