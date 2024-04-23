package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService {

	private IBoardDao boardDao;
	private static IBoardService boardService;
	
	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}
	
	public static IBoardService getInstance() {
		if(boardService==null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return boardDao.getAllBoard();
	}
	
	@Override
	public BoardVO getBoard(int no) {
		return boardDao.getBoard(no);
	}

	@Override
	public int deleteBoard(int no) {
		return boardDao.deleteBoard(no);
	}

	@Override
	public int updateHits(int no) {
		return boardDao.updateHits(no);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return boardDao.updateBoard(boardVO);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return boardDao.insertBoard(boardVO);
	}

	@Override
	public List<ReplyVO> selectReply(int num) {	
		return boardDao.selectReply(num);
	}

	@Override
	public int deleteReply(int num) {
		return boardDao.deleteReply(num);
	}

	@Override
	public int updateReply(ReplyVO vo) {
        return boardDao.updateReply(vo);
	}

	@Override
	public int insertReply(ReplyVO vo) {
        return boardDao.insertReply(vo);
	}

	

}	//BoardServiceImpl 끝
