package kr.or.ddit.vo;

public class HotelVO {
	private int hotel_no;			// 숙소번호
	private String hotel_name;		// 숙소명
	private String hotel_addr;		// 주소
	private String hotel_tel;		// 전화번호
	private String hotel_time;		// 운영시간
	private int hotel_room_count;	// 객실수
	private String hotel_img;		// 이미지파일명
	private int hotel_amount;		// 금액

	public int getHotel_amount() {
		return hotel_amount;
	}

	public void setHotel_amount(int hotel_amount) {
		this.hotel_amount = hotel_amount;
	}

	public int getHotel_no() {
		return hotel_no;
	}

	public void setHotel_no(int hotel_no) {
		this.hotel_no = hotel_no;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_addr() {
		return hotel_addr;
	}

	public void setHotel_addr(String hotel_addr) {
		this.hotel_addr = hotel_addr;
	}

	public String getHotel_tel() {
		return hotel_tel;
	}

	public void setHotel_tel(String hotel_tel) {
		this.hotel_tel = hotel_tel;
	}

	public String getHotel_time() {
		return hotel_time;
	}

	public void setHotel_time(String hotel_time) {
		this.hotel_time = hotel_time;
	}

	public int getHotel_room_count() {
		return hotel_room_count;
	}
	
	public void setHotel_room_count(int hotel_room_count) {
		this.hotel_room_count = hotel_room_count;
	}
	
	public String getHotel_img() {
		return hotel_img;
	}

	public void setHotel_img(String hotel_img) {
		this.hotel_img = hotel_img;
	}

}
