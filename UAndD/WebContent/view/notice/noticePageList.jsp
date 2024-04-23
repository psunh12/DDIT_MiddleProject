<%@ page import="java.util.ArrayList"%>
<%@ page import="kr.or.ddit.vo.NoticeVO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String admin= (String)session.getAttribute("admin");
    List<NoticeVO> noticeList = (List<NoticeVO>) request.getAttribute("noticeList");
    int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
    int totalNotices = (noticeList != null) ? noticeList.size() : 0;
    int noticesPerPage = 10;
    int totalPages = (int) Math.ceil((double) totalNotices / noticesPerPage);
    int startIndex = (currentPage - 1) * noticesPerPage;
    int endIndex = Math.min(startIndex + noticesPerPage - 1, totalNotices - 1);
    List<NoticeVO> currentPageNotices = new ArrayList<>();
    if (noticeList != null) {
        currentPageNotices = noticeList.subList(startIndex, endIndex + 1);
    }
    String path = request.getContextPath();
    String ss=null;
    if(admin!=null){
    	ss=admin;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script type="text/javascript" src="<%= path %>/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript">
    ss= <%=ss%>;
        function updateHitAndRedirect(noticeNo) {
            $.ajax({
                url: '<%= request.getContextPath() %>/notice/hit.do',
                type: 'get',
                data: {"noticeNo": noticeNo},
                success: function (res) {
                    if (res.result === "success") {
                        window.location.href = '<%= request.getContextPath() %>/notice/detail.do?noticeNo=' + noticeNo;
                    } else {
                        alert("조회수 업데이트에 실패했습니다.");
                    }
                },
                error: function (xhr) {
                    alert("오류 상태 : " + xhr.status);
                },
                dataType: 'json'
            });
        }
        
        $(()=>{
        	
        	if (ss==true){
        		$('#noticeInsertBtn').css('display', 'block');
        	}
        })
    </script>
</head>
<body>
<div class="card-body">
    <div class="table-responsive">
        <table class="table " id="dataTable" width="100%" cellspacing="0">
            <tr class="table-light">
                <th>번호</th>
                <th>제목</th>
                <th>작성날짜</th>
                <th>조회수</th>
                <th>첨부</th>
            </tr>
            <% if (totalNotices == 0) { %>
                <tr>
                    <td colspan="5">공지사항이 존재하지 않습니다.</td>
                </tr>
            <% } else {
                for (NoticeVO noticeVO : currentPageNotices) { %>
                    <tr onclick="updateHitAndRedirect(<%=noticeVO.getNoticeNo()%>)" style="cursor:pointer">
                        <td><%=noticeVO.getNoticeNo()%></td>
                        <td><%=noticeVO.getNoticeTitle()%></td>
                        <td><%=noticeVO.getNoticeDate()%></td>
                        <td><%=noticeVO.getNoticeHits()%></td>
                        <td>  </td>
                       <!-- <td><%=noticeVO.getNoticeFile()%></td> --> 
                    </tr>
                <% }
            } %>
            
              <div align="right" style='display:none' id='noticeInsertBtn'>
    <a class="btn btn-primary" href="<%=request.getContextPath() %>/notice/insert.do">게시글쓰기</a>
</div>
        </table>

        <div align="center">
            <ul class="pagination justify-content-center">
                <% if (currentPage > 1) { %>
                    <li class="page-item">
                        <a class="page-link" href="?page=<%=currentPage - 1%>" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                <% } %>
                <% int pageRange = Math.min(5, totalPages); %>
                <% int startPage = Math.max(1, currentPage - 2); %>
                <% int endPage = Math.min(startPage + pageRange - 1, totalPages); %>
                <% for (int i = startPage; i <= endPage; i++) { %>
                    <li class="page-item <%= (i == currentPage) ? "active" : "" %>">
                        <a class="page-link" href="?page=<%=i%>"><%=i%></a>
                    </li>
                <% } %>
                <% if (currentPage < totalPages) { %>
                    <li class="page-item">
                        <a class="page-link" href="?page=<%=currentPage + 1%>" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                <% } %>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
