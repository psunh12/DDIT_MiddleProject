<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
  <title>한밭 지킴이</title> 
<link rel="icon" href="<%= request.getContextPath() %>/images/icon/꿈돌5-1.png" type="image/x-icon">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet"  href="../../css/notice.css">
</head>
<body>
<br>
<!-- 상단 메뉴바 -->
<jsp:include page="/view/main/top.jsp"/>

<div class="container">
    <br>
  <!-- 탭선택 -->
  <ul class="nav nav-pills justify-content-center" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="pill" href="#home">공지게시판</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="pill" href="#menu1">자유게시판</a>
    </li>
  </ul>

  <!-- 공지게시판 -->
  <div  align="center" class="tab-content">
    <div id="home" class="container tab-pane active"><br>
  		<iframe class="mainIframe" name="notice" src="<%=request.getContextPath() %>/notice/list.do"></iframe> 
    </div>
    
  <!-- 자유게시판 -->  
    <div id="menu1" class="container tab-pane fade"><br>
    <!--     	 onload="this.style.height=(this.contentWindow.document.body.scrollHeight+100)+'px';" -->
  		<iframe class="mainIframe" name="board" scrolling="no" src="<%=request.getContextPath() %>/board/list.do"></iframe> 
    </div>
  </div>
  
</div>
<br>
<br>
<br>
<!-- 하단 메뉴바 삽입 -->
<jsp:include page="/view/main/bottom.jsp"/>
</body>
</html>
