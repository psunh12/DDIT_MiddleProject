/**
 * 
 */

// 경로 path 설정
const pathName = "/" + window.location.pathname.split("/")[1];
const origin = window.location.origin;
const path = origin + pathName;

ListImg = function()
{
	$.ajax	// ajax로 DB에 있는 데이터를 가져옴
	({                    
		url : `${path}/culture/mainUsedCulture.do`,
		type: "post",
		dataType: "json",
		success :function (res)
		{
			code="";
			$.each(res,function(i,v)
			{
				code+=
               `<img src="${path}/images/culture/${v.cul_img}" id="${v.cul_no}"
					style="width:300px; height: 500px;">`;
			})  
			$('#culture_img').html(code);
		},
		error : function (xhr)
		{
			alert("오류상태 : "+xhr.status);			 
		}		 
	}) 
}
