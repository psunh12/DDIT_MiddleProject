package kr.or.ddit.vo;

public class RestaurantReserveVO {
	private int rest_rsv_no;			// 식당예약번호
	private String rest_rsv_date;		// 예약날짜
	private String rest_rsv_time;		// 예약시간
	private int rest_rsv_count;		// 인원수
	private int rest_rsv_state;		// 취소여부
	private String mem_id;				// 회원아이디
	private int rest_no;				// 식당번호

	public int getRest_rsv_no() {
		return rest_rsv_no;
	}

	public void setRest_rsv_no(int rest_rsv_no) {
		this.rest_rsv_no = rest_rsv_no;
	}

	public String getRest_rsv_date() {
		return rest_rsv_date;
	}

	public void setRest_rsv_date(String rest_rsv_date) {
		this.rest_rsv_date = rest_rsv_date;
	}

	public String getRest_rsv_time() {
		return rest_rsv_time;
	}

	public void setRest_rsv_time(String rest_rsv_time) {
		this.rest_rsv_time = rest_rsv_time;
	}

	public int getRest_rsv_count() {
		return rest_rsv_count;
	}

	public void setRest_rsv_count(int rest_rsv_count) {
		this.rest_rsv_count = rest_rsv_count;
	}

	public int getRest_rsv_state() {
		return rest_rsv_state;
	}

	public void setRest_rsv_state(int rest_rsv_state) {
		this.rest_rsv_state = rest_rsv_state;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getRest_no() {
		return rest_no;
	}

	public void setRest_no(int rest_no) {
		this.rest_no = rest_no;
	}

}
