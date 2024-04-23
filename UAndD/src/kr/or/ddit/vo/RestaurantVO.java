package kr.or.ddit.vo;

public class RestaurantVO {
	private int rest_no;		// 식당번호
	private String rest_name;	// 식당명
	private String rest_addr;	// 주소
	private String rest_tel;	// 전화번호
	private String rest_time;	// 운영시간
	private String rest_img;	// 이미지파일명

	public int getRest_no() {
		return rest_no;
	}

	public void setRest_no(int rest_no) {
		this.rest_no = rest_no;
	}

	public String getRest_name() {
		return rest_name;
	}

	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}

	public String getRest_addr() {
		return rest_addr;
	}

	public void setRest_addr(String rest_addr) {
		this.rest_addr = rest_addr;
	}

	public String getRest_tel() {
		return rest_tel;
	}

	public void setRest_tel(String rest_tel) {
		this.rest_tel = rest_tel;
	}

	public String getRest_time() {
		return rest_time;
	}

	public void setRest_time(String rest_time) {
		this.rest_time = rest_time;
	}

	public String getRest_img() {
		return rest_img;
	}

	public void setRest_img(String rest_img) {
		this.rest_img = rest_img;
	}

}
