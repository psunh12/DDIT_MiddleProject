/**
 * 
 */

// 경로 path 설정
const pathName = "/" + window.location.pathname.split("/")[1];
const origin = window.location.origin;
const path = origin + pathName;

// 식당 예약 List를 테이블 <tbody>에 넣기
addMemberRestaurantReserve = function(memId)
{
	mem_id = memId;
	
	$.ajax
	 ({
		 url: `${path}/reserve/restaurantMemberReserveList.do`,
		 type: 'POST',
		 data: 
		 {
			 "mem_id" : mem_id
		 },
		 success: function(res)
		 {
			var restaurantReserveList = null;
			if (res == null || res == 0)
			{
				restaurantReserveList += `
				<tr>
					<td colspan="6" style="color: gray; text-align: center;">예약 목록이 없습니다.</td>
				</tr>
				`;
			} else 
			{				 
				$.each(res, function(i, v)
				{
					restaurantReserveList += `
					<tr>
						<td>${v.REST_RSV_NO}</td>
					 	<td>${v.REST_NAME}</td>
					 	<td>${v.REST_RSV_DATE}</td>
					 	<td>${v.REST_RSV_TIME}</td>
					 	<td>${v.REST_RSV_COUNT}</td>
						<td><input type="button" value="예약 취소" id="${v.REST_RSV_NO}" 
									onclick="restaurantReserveCancel(this.id)"></td>
					 </tr>
					 `;
				 })
			 }
		
			$('#addMemberRestaurantReserve').html(restaurantReserveList);
		 },
		 error: function(xhr)
		 {
			 console.log('숙소 예약 리스트 불러오기 오류 ==> ' + xhr);
		 },
		 dataType: 'json'
	 })

}

// 식당 예약 취소
restaurantReserveCancel = function(rest_rsv_no)
{
	$.ajax
	({
		url: `${path}/reserve/restaurantReserveCancel.do`,
		type: 'POST',
		data:
		{
			"rest_rsv_no" : rest_rsv_no
		},
		success: function()
		{
			swal({
				title: "식당 예약이 취소되었습니다.",
				icon: "success"
			}).then(function()
			{
				window.location.reload();
			})
		},
		error: function(xhr)
		{
			console.log('식당 예약 취소 실패 ==> ' + xhr);
		}
	})
}

// 식당 날짜가 지나면(당일 전) 예약이 지난 것으로 되는 것
changeDateReserveState = function()
{
	$.ajax
	({
		url: `${path}/reserve/restaurantMemberReserveList.do`,
		type: 'GET',
		success: function() 
		{
			console.log('당일 이전 예약 상태 0으로 변경');
		},
		error: function(xhr)
		{
			console.log('식당 날짜가 지나면 예약이 0으로 되는 것 실패 ==> ' + xhr);
		}
	})
}

// 식당 예약 취소 List를 테이블 <tbody>에 넣기
addMemberRestaurantReserveCancel = function(memId)
{
	mem_id = memId;
	
	$.ajax
	 ({
		 url: `${path}/reserve/restaurantMemberReserveCancelList.do`,
		 type: 'POST',
		 data: 
		 {
			 "mem_id" : mem_id
		 },
		 success: function(res)
		 {
			var restaurantReserveCancelList = null;
			if (res == null || res == 0)
			{
				restaurantReserveCancelList += `
				<tr>
					<td colspan="6" style="color: gray; text-align: center;">취소 및 만료 목록이 없습니다.</td>
				</tr>
				`;
			} else 
			{				 
				$.each(res, function(i, v)
				{
					restaurantReserveCancelList += `
					<tr>
						<td>${v.REST_RSV_NO}</td>
					 	<td>${v.REST_NAME}</td>
					 	<td>${v.REST_RSV_DATE}</td>
					 	<td>${v.REST_RSV_TIME}</td>
					 	<td>${v.REST_RSV_COUNT}</td>
						<td><input type="button" value="취소 완료" disabled></td>
					 </tr>
					 `;
				 })
			 }
		
			$('#addMemberRestaurantReserveCancel').html(restaurantReserveCancelList);
		 },
		 error: function(xhr)
		 {
			 console.log('숙소 예약 리스트 불러오기 오류 ==> ' + xhr);
		 },
		 dataType: 'json'
	 })

}