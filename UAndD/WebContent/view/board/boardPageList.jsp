<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String check = (String)session.getAttribute("check");
    List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList");
    int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
    int totalBoards = (boardList != null) ? boardList.size() : 0;
    int boardsPerPage = 10;
    int totalPages = (int) Math.ceil((double) totalBoards / boardsPerPage);
    int startIndex = (currentPage - 1) * boardsPerPage;
    int endIndex = Math.min(startIndex + boardsPerPage - 1, totalBoards - 1);
    List<BoardVO> currentPageBoards = new ArrayList<>();
    if (boardList != null) {
        currentPageBoards = boardList.subList(startIndex, endIndex + 1);
    }
    String path = request.getContextPath();
    String ss = null;
    if(check!=null){
    	ss=check;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script type="text/javascript" src="<%= path %>/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript">
    ss=<%=ss%>;
        function updateHitAndRedirect(brd_no) {
            $.ajax({
                url: '<%= request.getContextPath() %>/board/hit.do',
                type: 'get',
                data: {"brd_no": brd_no},
                success: function (res) {
                    if (res.result === "success") {
                        window.location.href = '<%= request.getContextPath() %>/board/detail.do?brd_no=' + brd_no;
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
        	if(ss==true){
        		$('#boardInsertBtn').css('display','block');
        	}
        })
    </script>
</head>
<body>
<div class="card-body">
    <div class="table-responsive">
        <table class="table" id="dataTable" width="100%" cellspacing="0">
            <tr class="table-light" align="center" >
                <th>No</th>
                <th >제목</th>
                <th >작성날짜</th>
                <th >조회수</th>
                <th >작성자</th>
            </tr>
            <% if (totalBoards == 0) { %>
                <tr>
                    <td colspan="5">게시글이 존재하지 않습니다.</td>
                </tr>
            <% } else {
                for (BoardVO boardVO : currentPageBoards) { %>
                    <tr onclick="updateHitAndRedirect(<%=boardVO.getBrd_no()%>)" style="cursor:pointer" align="center">
                        <td ><%=boardVO.getBrd_no()%></td>
                        <td ><%=boardVO.getBrd_title()%></td>
                        <td ><%=boardVO.getBrd_date()%></td>
                        <td ><%=boardVO.getBrd_hits()%></td>
                        <td ><%=boardVO.getMem_id()%></td>
                       
                    </tr>
                <% }
            } %>
            	<div align="right" style='display:none' id='boardInsertBtn'>
                <a class="btn btn-primary" href="<%=request.getContextPath() %>/board/insert.do">게시글쓰기</a>
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
