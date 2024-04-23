package kr.or.ddit.vo;

public class CultureVO {
	private int cul_no;
	private String cul_img;
	private String cul_name;
	private String cul_perfomer;
	private String cul_place;
	private String cul_date;
	private String cul_host;
	private int cul_state;
	private int cul_tp_cd;
	
	
	
	public int getCul_no() {
		return cul_no;
	}
	public void setCul_no(int cul_no) {
		this.cul_no = cul_no;
	}
	public String getCul_img() {
		return cul_img;
	}
	public void setCul_img(String cul_img) {
		this.cul_img = cul_img;
	}
	public String getCul_name() {
		return cul_name;
	}
	public void setCul_name(String cul_name) {
		this.cul_name = cul_name;
	}
	public String getCul_perfomer() {
		return cul_perfomer;
	}
	public void setCul_perfomer(String cul_perfomer) {
		this.cul_perfomer = cul_perfomer;
	}
	public String getCul_place() {
		return cul_place;
	}
	public void setCul_place(String cul_place) {
		this.cul_place = cul_place;
	}
	public String getCul_date() {
		return cul_date;
	}
	public void setCul_date(String cul_date) {
		this.cul_date = cul_date;
	}
	public String getCul_host() {
		return cul_host;
	}
	public void setCul_host(String cul_host) {
		this.cul_host = cul_host;
	}
	public int getCul_state() {
		return cul_state;
	}
	public void setCul_state(int cul_state) {
		this.cul_state = cul_state;
	}
	public int getCul_tp_cd() {
		return cul_tp_cd;
	}
	public void setCul_tp_cd(int cul_tp_cd) {
		this.cul_tp_cd = cul_tp_cd;
	}
	@Override
	public String toString() {
		return "CultureVO [cul_no=" + cul_no + ", cul_img=" + cul_img + ", cul_name=" + cul_name + ", cul_perfomer="
				+ cul_perfomer + ", cul_place=" + cul_place + ", cul_date=" + cul_date + ", cul_host=" + cul_host
				+ ", cul_state=" + cul_state + ", cul_tp_cd=" + cul_tp_cd + "]";
	}
	
	
	
	
	
}
