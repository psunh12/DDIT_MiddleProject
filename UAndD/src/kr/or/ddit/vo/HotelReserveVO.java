package kr.or.ddit.vo;

public class HotelReserveVO {
	private String hotel_rsv_no;			// 숙소예약번호
	private String hotel_rsv_startdate;		// 예약시작일
	private String hotel_rsv_enddate;		// 예약종료일
	private int hotel_rsv_count;			// 인원수
	private String hotel_rsv_room;			// 객실정보
	private int hotel_rsv_state;			// 취소여부
	private String mem_id;					// 회원아이디
	private int hotel_no;					// 숙소번호
	private int hotel_totalamt;				// 결제금액

	public int getHotel_totalamt() {
		return hotel_totalamt;
	}

	public void setHotel_totalamt(int hotel_totalamt) {
		this.hotel_totalamt = hotel_totalamt;
	}

	public String getHotel_rsv_no() {
		return hotel_rsv_no;
	}

	public void setHotel_rsv_no(String hotel_rsv_no) {
		this.hotel_rsv_no = hotel_rsv_no;
	}

	public String getHotel_rsv_startdate() {
		return hotel_rsv_startdate;
	}

	public void setHotel_rsv_startdate(String hotel_rsv_startdate) {
		this.hotel_rsv_startdate = hotel_rsv_startdate;
	}

	public String getHotel_rsv_enddate() {
		return hotel_rsv_enddate;
	}

	public void setHotel_rsv_enddate(String hotel_rsv_enddate) {
		this.hotel_rsv_enddate = hotel_rsv_enddate;
	}

	public int getHotel_rsv_count() {
		return hotel_rsv_count;
	}

	public void setHotel_rsv_count(int hotel_rsv_count) {
		this.hotel_rsv_count = hotel_rsv_count;
	}

	public String getHotel_rsv_room() {
		return hotel_rsv_room;
	}

	public void setHotel_rsv_room(String hotel_rsv_room) {
		this.hotel_rsv_room = hotel_rsv_room;
	}

	public int getHotel_rsv_state() {
		return hotel_rsv_state;
	}

	public void setHotel_rsv_state(int hotel_rsv_state) {
		this.hotel_rsv_state = hotel_rsv_state;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getHotel_no() {
		return hotel_no;
	}

	public void setHotel_no(int hotel_no) {
		this.hotel_no = hotel_no;
	}

}
