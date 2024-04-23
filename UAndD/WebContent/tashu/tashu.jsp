<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#tashuBtn01").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/tashu/tashuTest.do",
			type : "get",
			
	        success : function(res){
	        	console.log("res", res);
	        },
	        error : function(xhr){
	        	console.log("error", xhr);
	        },
	        dataType : "json"
		});
	});
	
});

</script>
</head>
<body>
<input type="button" id="tashuBtn01" value="타슈정보">
</body>
</html>