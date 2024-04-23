<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 //원글내용 가져오기- 서블릿에서 저장한 데이타 꺼내기 
	BoardVO boardVO = (BoardVO) request.getAttribute("boardVO");
 
 
 //원글내용 꺼내기 
 	String updatedTitle = boardVO.getBrd_title();
 	 String updatedContent = boardVO.getBrd_content(); // 수정 전 내용
     Date currentDate = new Date(); // 현재 날짜 및 시간
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 날짜 포맷 지정
     
     String updatedDate = dateFormat.format(currentDate);
 	/* 
     NoticeVO updatedNoticeVO = new NoticeVO();
     updatedNoticeVO.setNoticeNo(noticeVO.getNoticeNo()); // 이전 공지사항 번호를 설정하여 기존 데이터를 수정할 수 있도록 합니다.
     updatedNoticeVO.setNoticeTitle(updatedTitle);
     updatedNoticeVO.setNoticeContent(updatedContent);
     updatedNoticeVO.setNoticeDate(updatedDate); */
     
  // 새로운 NoticeVO 객체를 요청 속성으로 설정하여 수정 가능한 값보내줌.
    /*  request.setAttribute("updatedNoticeVO", updatedNoticeVO); */
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
 <form action="<%=request.getContextPath() %>/board/update.do" method="post"> <!-- 수정된 데이터를 처리할 서블릿 경로 지정 -->
        <div class="card-body">
            <div class="table-responsive"> 
                <font size="2px" color="red">"제목"과 "내용"만 수정이 가능합니다</font>
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <tr  bgcolor="#dcdcdc" align="center">
                        <th>번호</th>
                        <td align="left"><input type="text" name="brd_no" value="<%=boardVO.getBrd_no()%>" style="border:none; background-color:#dcdcdc " readonly/></td>
                        <td></td>
                        <td align="right" style="word-spacing:7px; "><font style="font-weight: bolder">작성날짜</font>  <%=boardVO.getBrd_date()%> <font style="font-weight: bolder">조회</font>  <%=boardVO.getBrd_hits()%></td>
                    </tr>
                    <tr  bgcolor="#dcdcdc">
                        <td style="background-color: #ffffff"><font style="font-weight: bolder">제목</font></td>
                        <td style="background-color: #ffffff" colspan="5"><input type="text"  name="brd_title"  value="<%=boardVO.getBrd_title()%>" style="border:0 solid black;width:1000px;"></td>
                       
                    </tr>
                        <th>내용</th>
                   
                        <td colspan="5"><textarea id="content" name="brd_content" maxlength="3000" style="height:350px; resize:none; width:990px; border:0 solid black;"><%=boardVO.getBrd_content()%></textarea></td>
                
                    <tr align="right">
                        <td colspan="6">
                            <button class="btn btn-primary" type="submit" onclick="complete()">수정 완료</button>
                            <button  class="btn btn-primary" type="button" onclick="location.href='<%=request.getContextPath() %>/board/list.do'"> 목록 </button>
                            <button  class="btn btn-primary" type="button" onclick="if(confirm('정말 삭제하시겠습니까?')) location.href='./delete.do?brd_no=<%=boardVO.getBrd_no() %>'"> 삭제 </button>
                        </td>
                    </tr>
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
         document.getElementById("boardInsertForm").submit(); // 작성완료 버튼 클릭 시 form을 submit할 수 있도록 추가
     }
        window.onload = function() {
            var textarea = document.querySelector("textarea[name='brd_content']");
            textarea.value = textarea.value.replace(/<br>/g, "\n");
        }
    </script>
</body>
</html>