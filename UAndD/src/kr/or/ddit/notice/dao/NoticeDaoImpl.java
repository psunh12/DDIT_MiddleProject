package kr.or.ddit.notice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.NoticeVO;

public class NoticeDaoImpl implements INoticeDao {

	private static INoticeDao noticeDao;
	
	public NoticeDaoImpl() {};
	
	public static INoticeDao getInstance() {
		if(noticeDao==null) {
			noticeDao = new NoticeDaoImpl();
		}
		return noticeDao;
	}

	@Override
	public List<NoticeVO> getAllNotice() {
		List<NoticeVO> noticeList = new ArrayList<NoticeVO>();
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			noticeList = session.selectList("notice.getAllNotice"); 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return noticeList;
	}
	
	@Override
	public NoticeVO getNotice(int no) {
		NoticeVO noticeVO = new NoticeVO();
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			noticeVO = session.selectOne("notice.getNotice",no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return noticeVO;
	}

	@Override
	public int deleteNotice(int no) {
		int cnt = 0;
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			cnt = session.delete("notice.deleteNotice", no);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateHits(int noticeNo) {
		int cnt = 0;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			cnt = session.update("notice.updateHits", noticeNo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateNotice(NoticeVO noticeVO) {
		int cnt = 0;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			cnt = session.update("notice.updateNotice", noticeVO);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int insertNotice(NoticeVO noticeVO) {
		int cnt = 0;
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			cnt = session.insert("notice.insertNotice", noticeVO);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

//	@Override
//	public int getTotalCount(Map<String, Object> map) {
//		SqlSession session = MybatisUtil.getSqlSession();
//		
//		int res = 0;
//		
//		try {
//			res = session.selectOne("notice.getTotalCount", map);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
//		return res;
//	}
	
	
}	//NoticeDaoImpl 끝
