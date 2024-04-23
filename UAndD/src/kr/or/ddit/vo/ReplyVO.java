package kr.or.ddit.vo;

public class ReplyVO {
	
	private int rpl_no;
	private String rpl_content;
	private String rpl_date;
	private String mem_id;
	private int brd_no;
	public int getRpl_no() {
		return rpl_no;
	}
	public void setRpl_no(int rpl_no) {
		this.rpl_no = rpl_no;
	}
	public String getRpl_content() {
		return rpl_content;
	}
	public void setRpl_content(String rpl_content) {
		this.rpl_content = rpl_content;
	}
	public String getRpl_date() {
		return rpl_date;
	}
	public void setRpl_date(String rpl_date) {
		this.rpl_date = rpl_date;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getBrd_no() {
		return brd_no;
	}
	public void setBrd_no(int brd_no) {
		this.brd_no = brd_no;
	}
	@Override
	public String toString() {
		return "ReplyVO [rpl_no=" + rpl_no + ", rpl_content=" + rpl_content + ", rpl_date=" + rpl_date + ", mem_id="
				+ mem_id + ", brd_no=" + brd_no + "]";
	}
	
	
}
