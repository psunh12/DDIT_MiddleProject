package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.ReplyVO;

public interface IBoardService {

	public List<BoardVO> getAllBoard();
	public BoardVO getBoard(int no);
	public int deleteBoard(int no);
	public int updateHits(int no);
	public int updateBoard(BoardVO boardVO);
	public int insertBoard(BoardVO boardVO);
//	public PageVO getPageInfo(int spage, String stype, String sword);
//	public int getTotalCount(Map<String, Object> map);
//	public List<NoticeVO> selectByPage(Map<String, Object> map);
	public List<ReplyVO> selectReply(int num);
	public int deleteReply(int num);
	public int updateReply(ReplyVO vo);
	public int insertReply(ReplyVO vo);
	
}	//INoticeService 끝
