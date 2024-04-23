package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NoticeVO;

public interface INoticeDao {

	public List<NoticeVO> getAllNotice();
	public NoticeVO getNotice(int no);
	public int deleteNotice(int no);
	public int updateHits(int noticeNo);
	public int updateNotice(NoticeVO noticeVO);
	public int insertNotice(NoticeVO noticeVO);
//	public int getTotalCount(Map<String, Object> map);
	
	
}	