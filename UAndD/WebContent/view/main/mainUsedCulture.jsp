<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.min.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.serializejson.min.js"></script>
<script src="<%=request.getContextPath() %>/js/mainUsedCulture.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mainUsedCulture.css"/>
 
<script type="text/javascript">
$(function()
{
	ListImg();
})
</script>
 
</head>
<body>

<div id="blue-container">
	<div>
		<img alt="폭죽" src="<%= request.getContextPath() %>/images/icon/free-icon-fireworks-3370931.png" style="witdh:100px; height:100px;  margin-left:95px;" >
		<div id="locationCultureText" style="width: 300px;">
			<p style="margin-top:10px;"> 대전의 축제<br>봐볼래유? </p>
		</div>
		<div>
			<div id="locationCultureDiv" style="width: 100px; height:100px;" 
				onclick="location.href='<%=request.getContextPath()%>/cultureboard/cultureMain.jsp'">
				<img alt="화살표" src="<%= request.getContextPath() %>/images/icon/손가락.png">
			</div>
		</div>
	</div>
	<div id="slider">
		<div class="image-box">
			<div id="culture_img">
				<!-- 이미지 삽입 -->
			</div>
		</div>
	</div>
</div>


</body>
</html>