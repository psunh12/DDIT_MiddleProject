/**
 * 
 */
//조회수 증가 
UpdateHitServer  = function(){
	
	$.ajax({
		
		url : `${mypath}/notice/hit.do`,
		type : 'get',
		data : {"num" : vidx},
		success : function(res){
			
			//성공 했다면 
			if(res.flag== "성공"){
				
				//조회수의 위치값 검색 
				vhit = $(gthis).parents('.card').find('.hit');
				
				//그위치에서 현재 값을 가져온다   + 1
				hitvalue =   parseInt($(vhit).text().trim()) + 1;
				
				// 화면의 조회수 값을 변경 
				$(vhit).text(hitvalue);
			}
		},
		error : function(xhr){
			alert("오류 상태 : " + xhr.status)
		},
		dataType : 'json'
	})
	
	
	
}




function writeReply(){
	   $.ajax({
		  url:`${mypath}/reply/replyWrite.do`,
          data: reply,
          type:'post',
          success :function(res){
	          if(res.flag=="성공"){
		 alert("댓글쓰기 성공!!");
	       ReplyListServer();
           
	
	}else{
		 alert("댓글쓰기 실패!!");
	}
         },
         error: function(xhr){
	      alert(xhr.status);
         },
         dataType :'json'
	})

}

function deleteReply(vidx){
	   $.ajax({
		  url:`${mypath}/reply/replyDelete.do`,
          data: {"bonum":vidx},
          type:'post',
          success :function(res){
	          if(res.flag=="성공"){
	   
		 alert("삭제 성공!!");
	     $(this).parents('.card').find('.reply-body').empty();
          
	        
	}else{
		 alert("삭제 실패!!");
	}
         },
         error: function(xhr){
	      alert(xhr.status);
         },
         dataType :'json'
	})


	
}

ReplyUpdateServer =function(){
	  $.ajax({
		url : `${mypath}/reply/replyUpdate.do`,
		type : 'post',
		data : reply,  //renum ,cont 들어있습니다
		success :function(res){
			alert(res.flag);
	         
		   //화면을 수정
         if(res.flag=="성공"){
	
	        
				}         
            
		},
		error : function(xhr){
		   alert(xhr.status);	
		},
		dataType: 'json'
	})
	
	
	
	
	
}




 