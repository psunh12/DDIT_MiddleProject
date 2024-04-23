package kr.or.ddit.vo;

public class BoardVO {
	private int brd_no;
	private String brd_title;
	private String brd_content;
	private int brd_hits;
	private String brd_date;
	private String brd_file;
	private String mem_id;
	public int getBrd_no() {
		return brd_no;
	}
	public void setBrd_no(int brd_no) {
		this.brd_no = brd_no;
	}
	public String getBrd_title() {
		return brd_title;
	}
	public void setBrd_title(String brd_title) {
		this.brd_title = brd_title;
	}
	public String getBrd_content() {
		return brd_content;
	}
	public void setBrd_content(String brd_content) {
		this.brd_content = brd_content;
	}
	public int getBrd_hits() {
		return brd_hits;
	}
	public void setBrd_hits(int brd_hits) {
		this.brd_hits = brd_hits;
	}
	public String getBrd_date() {
		return brd_date;
	}
	public void setBrd_date(String brd_date) {
		this.brd_date = brd_date;
	}
	public String getBrd_file() {
		return brd_file;
	}
	public void setBrd_file(String brd_file) {
		this.brd_file = brd_file;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "BoardVO [brd_no=" + brd_no + ", brd_title=" + brd_title + ", brd_content=" + brd_content + ", brd_hits="
				+ brd_hits + ", brd_date=" + brd_date + ", brd_file=" + brd_file + ", mem_id=" + mem_id + "]";
	}
	public BoardVO(int brd_no, String brd_title, String brd_content) {
		super();
		this.brd_no = brd_no;
		this.brd_title = brd_title;
		this.brd_content = brd_content;
	}
	
	public BoardVO(int brd_no, String brd_title, String brd_content, int brd_hits, String brd_date, String brd_file,
			String mem_id) {
		super();
		this.brd_no = brd_no;
		this.brd_title = brd_title;
		this.brd_content = brd_content;
		this.brd_hits = brd_hits;
		this.brd_date = brd_date;
		this.brd_file = brd_file;
		this.mem_id = mem_id;
	}
	
	
	public BoardVO(String mem_id, String title, String content) {
		this.mem_id = mem_id;
		this.brd_title = title;
		this.brd_content = content;
	}
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}
	
	
}
