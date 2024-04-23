<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://kit.fontawesome.com/a08d1164a5.js" crossorigin="anonymous"></script>

<script src="<%=request.getContextPath()%>/js/weather.js"></script>
<link rel ="stylesheet" href="<%=request.getContextPath()%>/css/weather.css">


</head>

<body>
    <div class='weather'>
        <div class='city'></div>
       	<div class='weather_icon'></div>
        <div class='currTemp'></div>
        <div class='nowTime'></div>
    </div>
</body>
</html>
