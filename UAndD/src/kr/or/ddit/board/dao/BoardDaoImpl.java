package kr.or.ddit.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.ReplyVO;

public class BoardDaoImpl implements IBoardDao {

	private static IBoardDao boardDao;
	
	public BoardDaoImpl() {};
	
	public static IBoardDao getInstance() {
		if(boardDao==null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			boardList = session.selectList("board.getAllBoard"); 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return boardList;
	}
	
	@Override
	public BoardVO getBoard(int no) {
		BoardVO boardVO = new BoardVO();
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			boardVO = session.selectOne("board.getBoard",no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return boardVO;
	}

	@Override
	public int deleteBoard(int no) {
		int cnt = 0;
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			cnt = session.delete("board.deleteBoard", no);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateHits(int no) {
		int cnt = 0;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			cnt = session.update("board.updateHits", no);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		int cnt = 0;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			cnt = session.update("board.updateBoard", boardVO);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		int cnt = 0;
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			cnt = session.insert("board.insertBoard", boardVO);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<ReplyVO> selectReply(int num) {
		 List<ReplyVO> list=null;
	     SqlSession sess= MybatisUtil.getSqlSession();
	     try {
			 list= sess.selectList("board.selectReply",num);
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			sess.commit();
			sess.close();
		}
		return list;
	}

	@Override
	public int deleteReply(int num) {
		 int cnt=0;
	     SqlSession sess= MybatisUtil.getSqlSession();
	     try {
			 cnt= sess.delete("board.deleteReply",num);
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			sess.commit();
			sess.close();
		}
		return cnt;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		 int cnt=0;
	     SqlSession sess= MybatisUtil.getSqlSession();
	     try {
			cnt= sess.update("board.updateReply",vo);
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			sess.commit();
			sess.close();
		}
		return cnt;
		
	}

	@Override
	public int insertReply(ReplyVO vo) {
		 int cnt=0;
	     SqlSession sess= MybatisUtil.getSqlSession();
	     try {
			 cnt= sess.insert("board.insertReply",vo);
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			sess.commit();
			sess.close();
		}
		return cnt;
	}

	
	
}	//BoardDaoImpl 끝
