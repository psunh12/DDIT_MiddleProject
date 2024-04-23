/**
 * 회원이 숙소 예약 리스트와 취소 리스트를 볼 때 사용하는 js
 */

// 경로 path 설정
const pathName = "/" + window.location.pathname.split("/")[1];
const origin = window.location.origin;
const path = origin + pathName;

// 숙소 예약 List를 테이블 <tbody>에 넣기
addMemberHotelReserve = function(memId)
{
	mem_id = memId;
	
	$.ajax
	 ({
		 url: `${path}/reserve/hotelMemberReserveList.do`,
		 type: 'POST',
		 data: 
		 {
			 "mem_id" : mem_id
		 },
		 success: function(res)
		 {
			var hotelReserveList = null;
			if (res == null || res == 0)
			{
				hotelReserveList += `
				<tr>
					<td colspan="8" style="color: gray; text-align: center;">예약 목록이 없습니다.</td>
				</tr>
				`;
			} else 
			{				 
				$.each(res, function(i, v)
				{
					hotelReserveList += `
					<tr>
						<td>${v.HOTEL_RSV_NO}</td>
					 	<td>${v.HOTEL_NAME}</td>
					 	<td>${v.HOTEL_RSV_STARTDATE}</td>
					 	<td>${v.HOTEL_RSV_ENDDATE}</td>
					 	<td>${v.HOTEL_RSV_COUNT}</td>
					 	<td>${v.HOTEL_RSV_ROOM}</td>
					 	<td>${v.HOTEL_TOTALAMT}</td>
						<td><input type="button" value="예약 취소" id="${v.HOTEL_RSV_NO}" 
									onclick="hotelReserveCancel(this.id)"></td>
					 </tr>
					 `;
				 })
			 }
		
			$('#addMemberHotelReserve').html(hotelReserveList);
		 },
		 error: function(xhr)
		 {
			 console.log('숙소 예약 리스트 불러오기 오류 ==> ' + xhr);
		 },
		 dataType: 'json'
	 })

}

// 숙소 예약 취소
hotelReserveCancel = function(hotel_rsv_no)
{
	$.ajax
	({
		url: `${path}/reserve/hotelReserveCancel.do`,
		type: 'POST',
		data:
		{
			"hotel_rsv_no" : hotel_rsv_no
		},
		success: function()
		{
			swal
			({
				title: "숙소 예약이 취소되었습니다.", 
				icon: "success"
			}).then(function()
			{
				window.location.reload();
			})
		},
		error: function(xhr)
		{
			console.log('숙소 예약 취소 실패 ==> ' + xhr);
		}
	})
}

// 숙소 예약 취소 List를 테이블 <tbody>에 넣기
addMemberHotelReserveCancel = function(memId)
{
	mem_id = memId;
	
	$.ajax
	 ({
		 url: `${path}/reserve/hotelMemberReserveCancelList.do`,
		 type: 'POST',
		 data: 
		 {
			 "mem_id" : `${mem_id}`
		 },
		 success: function(res)
		 {
			var hotelReserveList = null;
			if (res == null || res == 0)
			{
				hotelReserveList += `
				<tr>
					<td colspan="8" style="color: gray; text-align: center;">취소 및 만료 목록이 없습니다.</td>
				</tr>
				`;
			} else 
			{				 
				console.log(res);
				$.each(res, function(i, v)
				{
					hotelReserveList += `
					<tr>
						<td>${v.HOTEL_RSV_NO}</td>
					 	<td>${v.HOTEL_NAME}</td>
					 	<td>${v.HOTEL_RSV_STARTDATE}</td>
					 	<td>${v.HOTEL_RSV_ENDDATE}</td>
					 	<td>${v.HOTEL_RSV_COUNT}</td>
					 	<td>${v.HOTEL_RSV_ROOM}</td>
					 	<td>${v.HOTEL_TOTALAMT}</td>
						<td><input type="button" value="취소 완료" disabled></td>
					 </tr>
					 `;
				 })
			 }
		
			$('#addMemberHotelReserveCancel').html(hotelReserveList);
		 },
		 error: function(xhr)
		 {
			 console.log('숙소 예약 리스트 불러오기 오류 ==> ' + xhr);
		 },
		 dataType: 'json'
	 })

}