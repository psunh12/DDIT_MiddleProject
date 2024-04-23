package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.ReplyVO;

public interface IBoardDao {

	public List<BoardVO> getAllBoard();
	public BoardVO getBoard(int no);
	public int deleteBoard(int no);
	public int updateHits(int no);
	public int updateBoard(BoardVO boardVO);
	public int insertBoard(BoardVO boardVO);
//	public int getTotalCount(Map<String, Object> map);
	public List<ReplyVO> selectReply(int num);
	public int deleteReply(int num);
	public int updateReply(ReplyVO vo);
	public int insertReply(ReplyVO vo);
	
}	