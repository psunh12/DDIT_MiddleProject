/**
 * 숙소 예약 js
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

// 숙소 상세보기 모달창 설정
moveToHotelDetail = function(hotel_no, memId)
{
	mem_id = memId;
	
	$.ajax
	({
		url: `${path}/reserve/hotelReserve.do`,
		type: 'GET',
		data: 
		{
			"hotel_no" : hotel_no
		},
		success: function(res)
		{
			$('#hotelDetailModal').modal('show');
				
			hotelInfo = res;	// 카카오페이 API에 판매자 정보를 보내기 위해 전역 변수에 저장
			
			// 숙박 업체의 상세 정보를 띄우는 메소드
			showHotelDetailInfo(res);
			
			// 숙박 예약폼을 띄우는 메소드
			openHotelReserveForm();
			
			// 남은 객실 체크
			// checkRoom(`${year}-${month}-${dayZero}`, `${year}-${month}-${dayZero}`);
		},
		error: function(xhr)
		{
			console.log('숙박 업체 모달창 오류: ' + xhr.status);
		},
		dataType: 'json'
	})
}

// 숙박 업체의 상세 정보를 띄우는 메소드
showHotelDetailInfo = function(res) 
{
	let infoCode = `
		<div class="backImgDiv">
			<img id="img2" src="${path}/images/hotel/${res.hotel_img}">
		</div>
		<div class="infoDiv">
			<h4 class="modal-title fix-text">${res.hotel_name}</h4>
			<table>
				<tr>
					<td>주소</td>
					<td>| ${res.hotel_addr}</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>| ${res.hotel_tel}</td>
				</tr>
				<tr>
					<td>운영시간</td>
					<td>| ${res.hotel_time}</td>
				</tr>
				<tr>
					<td>객실 수</td>
					<td>| ${res.hotel_room_count}</td>
				</tr>
			</table>
		</div>
	
	<div id="kakao"> <!-- 카카오페이API 버튼 -->
		<img src="${path}/images/icon/payment_icon_yellow_medium.png" 
				id="payBtn" onclick="requestPay()">
	</div>
	`;

	$('#right-modal-body').html(infoCode);
}

	
// 모달창 바디에 숙박 예약폼을 띄우는 메소드
openHotelReserveForm = function() 
{
	let peopleMin = 1;	// 인원수 최소값
	let peopleMax = 4;	// 인원수 최대값
	
	let bodyCode = `
	<div>
		<h2 class="modalh1">인원 선택</h2>
		<input type="number" id="rsv_count" name="rsv_count" oninput="changeRoomState()"
				min="${peopleMin}" max="${peopleMax}" value="${peopleMin}">
	</div>
	<div>
		<br><br><h2 class="modalh1" style="line-height:0.5;">숙박 날짜 선택</h2>
		<div id="addDateDiv">
			<div id="dateStartForm" class="dateDiv">
				<br><h5 class="modalh2" style="line-height:0.5;">시작일</h5>
				<input type="date" id="select_start_date" name="hotel_rsv_startdate" 
						min="${year}-${month}-${dayZero}" value="${year}-${month}-${dayZero}">
			</div>
			<div id="dateEndForm" class="dateDiv">
				<br><h5 class="modalh2" style="line-height:0.5;">종료일</h5>
				<input type="date" id="select_end_date" name="hotel_rsv_enddate" value="${year}-${month}-${dayZero}">
			</div>
		</div>
	</div>
	<div>
		<div id="addRoomDiv">
			<br><label for="hotel_rsv_room" class="form-label">
				객실 선택
			</label>
			<div class="form_radio_btn">
				<input type="radio" id="room_two" name="hotel_rsv_room" value="2인실" checked disabled>
				<label for="room_two">2인실</label>
			</div>
			<div class="form_radio_btn">
				<input type="radio" id="room_four" name="hotel_rsv_room" value="4인실" disabled>
				<label for="room_four">4인실</label>
			</div>
		</div>
	</div>
	`;
	
	$('#left-modal-body').html(bodyCode);
}

// 시작일을 입력하면 종료일 달력에 시작일 이전이 선택되지않게하는 이벤트
$(document).on('input', '#select_start_date', function()
{
	let startdate = $('#select_start_date').val();
	$('#select_end_date').attr('min', startdate);
	$('#select_end_date').attr('value', startdate);
})

// 2인 이하면 2인실, 3인 이상이면 4인실
changeRoomState = function() 
{
	let peopleCnt = $('#rsv_count').val();
		
	if(peopleCnt <= 2) 
	{
		$('#room_two').prop('checked', true);
	} else 
	{
		$('#room_four').prop('checked', true);
	}	
}

/*
// 빈 객실 수를 구해 표시하는 이벤트
$(document).on('input', '#select_end_date', function()
{
	let start = $('#select_start_date').val();
	let end = $('#select_end_date').val();
		
	// 예약이 끝나면 객실 수를 되돌려야하는데 어떻게 할 지 생각해보기
	// 관리자페이지에서 일괄 체크아웃
	checkRoom(start, end);
})
*/

// 해당하는 날짜에 남은 객실 수를 확인하는 메서드
checkRoom = function(start, end)
{
	$.ajax
	({
		url: `${path}/reserve/hotelRoomCheck.do`,
		type: 'GET',
		data:
		{
			"startDate" : start,
			"endDate" : end
		},
		success: function(res)
		{
			let emptyRoom = hotelInfo.hotel_room_count - res;
			
			if ( emptyRoom <= 0 ) 
			{
				swal({title: "남은 방이 없습니다.", text: "다른 날짜를 선택해주세요.", icon: "error"})
			}
			
			$('#checkRoomDiv').html(emptyRoom);
		},
		error: function(xhr)
		{
			console.log(xhr)
		}
	})
	
}

// 두 날짜 사이의 일수를 구하는 메서드
getDateDiff = (startDate, endDate) => 
{
  let start = new Date(startDate);
  let end = new Date(endDate);
  
  let diffDate = start.getTime() - end.getTime();
  
  return Math.abs(diffDate / (1000 * 60 * 60 * 24)); // 밀리세컨 * 초 * 분 * 시 = 일
}

// 카카오페이를 요청하는 메서드
requestPay = function() 
{
	if ( mem_id == null || mem_id == "null" ) 
	{
		swal
		({
			title: "로그인이 필요합니다.", text: "로그인 페이지로 이동합니다.", icon: "error"
		}).then(function() 
		{
			window.location.href = `${path}/view/login_out/loginMain.jsp`;
		})
	} else
	{
		var IMP = window.IMP; 
		IMP.init("imp67011510");	// 테스트용 가맹점ID(변경 X)

		/* 
			주문번호 = 같은 값은 사용 불가(결제 할 때마다 새로운 값 필요)
			주문번호 만들 때 "코드" + 현재 시간 등으로 만들기 위한 makemerchantUid
		*/
		var today = new Date();   
		var hours = today.getHours(); // 시
		var minutes = today.getMinutes();  // 분
		var seconds = today.getSeconds();  // 초
		var milliseconds = today.getMilliseconds();
		var makeMerchantUid = hours +  minutes + seconds + milliseconds;
		
		let startDate = $('#select_start_date').val();
		let endDate = $('#select_end_date').val();
		let peopleCnt = $('#rsv_count').val();
		let room = $('input[name=hotel_rsv_room]:checked').val();
		
		let betweenDate = getDateDiff(startDate, endDate);
		if (betweenDate == 0) 
		{
			betweenDate = 1;	// 당일 숙박은 1일과 같은 것으로 처리
		}
		
		let totalAmt = hotelInfo.hotel_amount * peopleCnt * betweenDate;
	
		IMP.request_pay
		({
			pg : 'kakaopay', 							// kcp: 미리 등록한 카드로 결제, kakaopay
			pay_method : 'card',
			merchant_uid: hotelInfo.hotel_no +makeMerchantUid,  	// 주문번호
			name : "[" + hotelInfo.hotel_name + "]" + room + startDate + "~" + endDate,		// 상품명
			amount : totalAmt,							// 가격(결제 금액)
			buyer_name : hotelInfo.hotel_name,
			buyer_tel : hotelInfo.hotel_tel,
			buyer_addr : hotelInfo.hotel_addr,
		}, function (rsp) 
		{
			if (rsp.success) 
			{
	 			// 서버 결제 API 성공시 로직
	 			let reserveInfo = 
	 			{
					"imp_uid" : rsp.imp_uid,
					"startDate" : `${startDate}`,
					"endDate" : `${endDate}`,
					"peopleCnt" : `${peopleCnt}`,
					"room" : `${room}`,
					"mem_id" : `${mem_id}`,
					"hotel_no" : `${hotelInfo.hotel_no}`,
					"hotel_totalamt" : `${totalAmt}`
				} ;
				
				payAfterReserveHotel(reserveInfo);
				
				swal({title: "예약이 완료되었습니다.", text: `${startDate}~${endDate} / ${peopleCnt}명 / ${room}`, icon: "success"});
				$('#hotelDetailModal').modal('hide');
			} else 
			{
				console.log(`결제에 실패하였습니다. 에러 내용: ${rsp.error_msg}`);
			}
		});
	}
}

// 카카오 페이 API를 통해 결제 진행 후 숙소 예약 정보를 저장하는 메서드
payAfterReserveHotel = function(reserveInfo) 
{
	$.ajax
	({
		url: `${path}/reserve/hotelReserve.do`,
		type: 'POST',
		data: 
		{
			"hotel_rsv_no" : reserveInfo.imp_uid,
			"hotel_rsv_startdate" : reserveInfo.startDate,
			"hotel_rsv_enddate" : reserveInfo.endDate,
			"hotel_rsv_count" : reserveInfo.peopleCnt,
			"hotel_rsv_room" : reserveInfo.room,
			"hotel_rsv_state" : "1",
			"mem_id" : reserveInfo.mem_id,
			"hotel_no" : reserveInfo.hotel_no,
			"hotel_totalamt" : reserveInfo.hotel_totalamt
		},
		success: function() 
		{
			// 예약 완료 후 객실 수가 1 차감되도록 작성(-2 되는 문제 발생)
			// 객실 차감 전반적인 수정 필요(해당 날짜에만 객실이 -1되고 총 객실 수는 변함 없도록 DB 수정해야할 듯)
			// 객실 예약 DB에 객실 수를 추가할까? 조금 더 고민해봐야 할 듯
			// subtractHotelRoom(reserveInfo.hotel_no);
		},
		error: function(xhr) 
		{
			console.log(`예약에 실패하였습니다. 에러 내용: ${xhr.status}`);
		},
		dataType: 'json'
	})
}

/*
// 예약 완료 후 객실의 수를 -1하는 메서드 
subtractHotelRoom = function(hotel_no)
{
	console.log("subroom 호출");
	$.ajax
	({
		url: `${path}/reserve/hotelRoomCheck.do`,
		type: 'POST',
		data: 
		{
			"hotel_no" : hotel_no
		},
		success: function()
		{
			console.log(`객실 차감 완료`);
		},
		error: function(xhr)
		{
			console.log(`객실 차감을 실패했습니다. 에러 내용: ${xhr.status}`);
		}
	})
}
*/