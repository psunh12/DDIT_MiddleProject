 <%@page import="kr.or.ddit.vo.BoardVO"%>
<%@page import="kr.or.ddit.vo.NoticeVO"%> 
 <%@ page language="java" contentType="text/html; charset=UTF-8" 
     pageEncoding="UTF-8"%>
      <% 
BoardVO boardVO = (BoardVO) request.getAttribute("boardVO");
    String mem_id = (String)session.getAttribute("mem_id");
    if(mem_id==null){mem_id = "관리자";}
    
 %> 
 <!DOCTYPE html> 
 <html>
 <head> 
 <meta charset="UTF-8"> 
 <title>Insert title here</title> 
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
 </head> 
 <body>
     <div class="container mt-5">
        <h1>게시판 작성</h1>
        <form id="boardInsertForm" action="<%=request.getContextPath() %>/board/insert.do" method="post">
            <div class="mb-3">
                <label for="mem_id">작성자</label>
                <input type="text" name="mem_id" value="<%=mem_id %>" style="border:none" readonly/><br>
                <label for="title" class="form-label">제목:</label>
                <input type="text" id="title" name="brd_title" class="form-control">
            </div>

            <div class="mb-3">
                <label for="content" class="form-label">내용:</label>
                <textarea id="content" name="brd_content" rows="4" class="form-control"></textarea>
            </div>

            <button type="button" class="btn btn-primary" onclick="complete()">작성완료</button>
            <button type="button" class="btn btn-secondary" onclick="history.back(-1);">뒤로가기</button>
        </form>
    </div>

    <script>
        function complete() {
        	const contentTextArea = document.getElementById("content");
            const content = contentTextArea.value.replace(/\n/g, "<br>");
            contentTextArea.value = content;
            swal("글 작성이 완료되었습니다.");
            document.getElementById("boardInsertForm").submit(); 
        }
    </script>
</body>
 </body> 
 </html> 
 