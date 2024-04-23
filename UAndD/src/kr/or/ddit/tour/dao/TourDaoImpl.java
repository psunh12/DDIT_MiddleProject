package kr.or.ddit.tour.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.TourVO;


public class TourDaoImpl implements ITourDao { //싱글톤 시작
	private static ITourDao dao;
	private TourDaoImpl() {}
 	public static ITourDao getInstance() {
 		if(dao==null) dao= new TourDaoImpl();
 		return dao;
	} //싱글톤 끝
 	
 	
	@Override // tour의 리스트를 뽑는 메서드
	public List<TourVO> selectTour() {
		List<TourVO> list= null;
		SqlSession session=MybatisUtil.getSqlSession();
			try {
			 list= session.selectList("tour.selectTour");
			} catch (Exception e) {
			 e.printStackTrace();
			}finally {
				session.commit();
				session.close();
			}		
		return list;
	} //selectTour 끝

	@Override // tour의 상세 정보를 출력하는 메서드
	public TourVO selectOneTour(int num) {
		TourVO vo= null;
		SqlSession session=MybatisUtil.getSqlSession();
			try {
			 vo= session.selectOne("tour.selectOneTour",num);
			} catch (Exception e) {
			 e.printStackTrace();
			}finally {
				session.commit();
				session.close();
			}		
		return vo;
	}// selectOneTour 끝

	@Override // tour에 정보를 저장하는 메서드
	public int insertTour(TourVO vo) {
		int cnt= 0;
		SqlSession session=MybatisUtil.getSqlSession();
			try {
			 cnt= session.insert("tour.insertTour",vo);
			} catch (Exception e) {
			 e.printStackTrace();
			}finally {
				session.commit();
				session.close();
			}		
		return cnt;
	} //insertTour 끝

	@Override //투어 db의 자료를 삭제하는 메서드
	public int deleteTour(int num) {
		int cnt= 0;
		SqlSession session=MybatisUtil.getSqlSession();
			try {
			 cnt= session.delete("tour.deleteTour",num);
			} catch (Exception e) {
			 e.printStackTrace();
			}finally {
				session.commit();
				session.close();
			}		
		return cnt;
	} //deleteTour 끝

	@Override  //db의 값을 수정하는 메서드
	public int updateTour(TourVO vo) {
		int cnt= 0;
		SqlSession session=MybatisUtil.getSqlSession();
			try {
			 cnt= session.update("tour.updateTour",vo);
			} catch (Exception e) {
			 e.printStackTrace();
			}finally {
				session.commit();
				session.close();
			}		
		return cnt;
	} //updateTour 끝'
	
	
	@Override  //동 주소를 검색하는 메서드
	public List<TourVO> selectDongTour(String dong) {	
			List<TourVO> list= null;
			SqlSession session=MybatisUtil.getSqlSession();
				try {
				 list= session.selectList("tour.selectDongTour",dong);
				} catch (Exception e) {
				 e.printStackTrace();
				}finally {
					session.commit();
					session.close();
				}		
			return list;
		} //selectDongTour 끝
	
	@Override  //이름을 받아서 주소 검색 메서드
	public List<TourVO> selectNameTour(String dong) {
		List<TourVO> list= null;
		SqlSession session=MybatisUtil.getSqlSession();
			try {
			 list= session.selectList("tour.selectNameTour",dong);
			} catch (Exception e) {
			 e.printStackTrace();
			}finally {
				session.commit();
				session.close();
			}		
		return list;
	} //selectNameTour 끝


}
