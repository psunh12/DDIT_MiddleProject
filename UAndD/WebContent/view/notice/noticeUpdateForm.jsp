<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//원글내용 가져오기- 서블릿에서 저장한 데이타 꺼내기 
NoticeVO noticeVO = (NoticeVO) request.getAttribute("noticeVO");

//원글내용 꺼내기 
String updatedTitle = noticeVO.getNoticeTitle();
String updatedContent = noticeVO.getNoticeContent(); // 수정 전 내용
Date currentDate = new Date(); // 현재 날짜 및 시간
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 날짜 포맷 지정

String updatedDate = dateFormat.format(currentDate);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/notice/update.do"
		method="post">
		<!-- 수정된 데이터를 처리할 서블릿 경로 지정 -->
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
					<tr bgcolor="#dcdcdc" align="center">
						<th>번호</th>
						<td align="left"><input type="text" name="notice_no" value="<%=noticeVO.getNoticeNo()%>" style="border: none; background-color: #dcdcdc" readonly /></td>
						<td></td>
						<td align="right" style="word-spacing:7px; "><font style="font-weight: bolder">작성날짜</font> <%=noticeVO.getNoticeDate()%> <font style="font-weight: bolder">조회</font>  <%=noticeVO.getNoticeHits()%> </td>
						</tr>
					<tr bgcolor="#dcdcdc">
						<td style="background-color: #ffffff"><font style="font-weight: bolder">제목</td>
						<td colspan="5" style="background-color: #ffffff"><input type="text"
							name="notice_title" value="<%=noticeVO.getNoticeTitle()%>"
							style="border: 0 solid black;"></td>
						
					</tr>
					<th>내용</th>

					<td colspan="5"><textarea id="content" name="notice_content" maxlength="3000"
							style="height: 350px; resize: none; width: 990px; border: 0 solid black;"><%=noticeVO.getNoticeContent()%></textarea></td>

					<tr align="right">
						<td colspan="6">
							<button class="btn btn-primary" type="submit" onclick="complete()">수정 완료</button>
							<button class="btn btn-primary" type="button"
								onclick="location.href='<%=request.getContextPath()%>/notice/list.do'">
								목록</button>
							<button class="btn btn-primary" type="button"
								onclick="if(confirm('정말 삭제하시겠습니까?')) location.href='./delete.do?noticeNo=<%=noticeVO.getNoticeNo()%>'">
								삭제</button>
								
								 <!--                     <tr> --> <!--                         <th>번호</th> -->
							<!--                         <th>제목</th> --> <!--                         <th>내용</th> -->
							<!--                         <th>작성날짜</th> --> <!--                         <th>조회수</th> -->
							<!--                         <th>첨부</th> --> <!--                     </tr> -->
							<!--                     <tr> --> <%--                         <td><%=noticeVO.getNoticeNo()%></td> --%>
							<%--                         <td><input type="text" name="notice_title" value="<%=noticeVO.getNoticeTitle()%>"></td> --%>
							<%--                         <td><textarea name="notice_content"><%=noticeVO.getNoticeContent()%></textarea></td> --%>
							<%--                         <td><%=noticeVO.getNoticeDate()%></td> --%>
							<%--                         <td><%=noticeVO.getNoticeHits()%></td> --%>
							<!--                         <td>-</td> --> <!--                     </tr> -->
							<!--                     <tr align="right"> --> <!--                         <td colspan="6"> -->
							<!--                             <button type="submit">수정 완료</button> -->
							<%--                             <a href="<%=request.getContextPath() %>/notice/list.do">[목록으로]</a> --%>
							<%--                             <a href="./delete.do?noticeNo=<%=noticeVO.getNoticeNo() %>">[게시글 삭제]</a> --%>
							<!--                         </td> --> <!--                     </tr> -->
				</table>
			</div>
		</div>
	</form>
	<script>
	 function complete() {
     	const contentTextArea = document.getElementById("content");
         const content = contentTextArea.value.replace(/\n/g, "<br>");
         contentTextArea.value = content;
         swal("글 작성이 완료되었습니다.");
         document.getElementById("noticeInsertForm").submit(); // 작성완료 버튼 클릭 시 form을 submit할 수 있도록 추가
     }
        window.onload = function() {
            var textarea = document.querySelector("textarea[name='notice_content']");
            textarea.value = textarea.value.replace(/<br>/g, "\n");
        }
    </script>
</body>
</html>