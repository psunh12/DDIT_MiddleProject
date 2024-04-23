/**
 * 공통으로 사용하는 js
 */

// const topBtn = document.querySelector(".moveTopBtn");

// 버튼 클릭 시 맨 위로 이동
$(document).on('click', '.moveTopBtn', function()
{
	window.scrollTo({ top: 0, behavior: "smooth" });  
})