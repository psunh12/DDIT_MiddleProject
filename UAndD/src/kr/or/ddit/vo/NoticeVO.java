package kr.or.ddit.vo;

public class NoticeVO {
	private int notice_no;
	private String notice_title;
	private String notice_content;
	private int notice_hits;
	private String notice_date;
	private String notice_file;
	
	public NoticeVO() {
		
	}
	public NoticeVO(String notice_title, String notice_content) {
		super();
		this.notice_title = notice_title;
		this.notice_content = notice_content;
	}
	
	public NoticeVO(int noticeNo, String noticeTitle, String noticeContent) {  
		super();
		this.notice_no = noticeNo;
		this.notice_title = noticeTitle;
		this.notice_content = noticeContent;
		
	}


	public int getNoticeNo() {
		return notice_no;
	}

	public void setNoticeNo(int noticeNo) {
		this.notice_no = noticeNo;
	}

	public String getNoticeTitle() {
		return notice_title;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.notice_title = noticeTitle;
	}

	public String getNoticeContent() {
		return notice_content;
	}

	public void setNoticeContent(String noticeContent) {
		this.notice_content = noticeContent;
	}

	public int getNoticeHits() {
		return notice_hits;
	}

	public void setNoticeHits(int noticeHits) {
		this.notice_hits = noticeHits;
	}

	public String getNoticeDate() {
		return notice_date;
	}

	public void setNoticeDate(String noticeDate) {
		this.notice_date = noticeDate;
	}

	public String getNoticeFile() {
		return notice_file;
	}

	public void setNoticeFile(String noticeFile) {
		this.notice_file = noticeFile;
	}

	
	
}	//NoticeVO 끝
