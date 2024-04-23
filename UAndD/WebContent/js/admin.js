/**
 * 관리자 페이지 일괄 체크 아웃
 */

// 오늘 이전의 날짜는 입력 불가하게 설정하기위해 오늘 날짜를 변수로 설정
const date = new Date();
const year = date.getFullYear()
const month = date.getMonth() + 1;
const day= String(date.getDate());

// 일자가 한 자리 수인 경우 앞에 0을 붙여 두자리 숫자로 만들어준다. ex) 2023-12-09
const dayZero = day.padStart(2, "0");

// 경로 path 설정
const pathName = "/" + window.location.pathname.split("/")[1];
const origin = window.location.origin;
const path = origin + pathName;

 managerAllCheckout = function()
 {
	 $.ajax
	 ({
		url: `${path}/reserve/hotelCheckout.do`,
		type: 'GET',
		success: function()
		{
			swal({title: "일괄 체크 아웃 완료", text: `${year}-${month}-${dayZero}`, icon: "success"});
		},
		error: function(xhr)
		{
			console.log('체크아웃 오류: ' + xhr);
		}
	 })
 }