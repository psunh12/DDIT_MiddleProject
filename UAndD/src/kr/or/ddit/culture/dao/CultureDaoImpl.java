package kr.or.ddit.culture.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.CultureVO;

public class CultureDaoImpl implements ICultureDao {
	private static  ICultureDao dao;
    private CultureDaoImpl() {}     
	public static ICultureDao getInstance() {
		if(dao==null) dao= new CultureDaoImpl();
		return dao;
	    }  //singleton 패턴	
		
			
			@Override
	       public CultureVO selectOneCulture(int num) { //메서드 시작
				CultureVO vo= null;
				SqlSession session= MybatisUtil.getSqlSession();
					try {
						vo=session.selectOne("culture.selectOneCulture",num);
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							session.commit();
							session.close();
						}
							return vo;
			} //selectOneCulture 메서드 끝 
			
			@Override
			public List<CultureVO> selectCulture(int num) {
				List<CultureVO> list= null;
				SqlSession session= MybatisUtil.getSqlSession();
					try {
						list=session.selectList("culture.selectCulture",num);
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							session.commit();
							session.close();
						}
							return list;
			}//selectCulture 끝
			
			
			
			
			@Override
			public List<CultureVO> selectByPage(Map<String, Object> map) {
				List<CultureVO> list= null;
				SqlSession session= MybatisUtil.getSqlSession();
					try {
						list=session.selectList("culture.selectByPage",map);
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							session.commit();
							session.close();
						}
							return list;
			}//selectByPage 끝
			
			
			
			@Override
			public int insertCulture(CultureVO vo) {
				int cnt= 0;
				SqlSession session= MybatisUtil.getSqlSession();
					try {
						cnt=session.insert("culture.insertCulture",vo);
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							session.commit();
							session.close();
						}
							return cnt;				
			} //insertCulture 끝
			
			
			@Override
			public int getTotalCount(Map<String, Object> map) {
				int cnt= 0;
				SqlSession session= MybatisUtil.getSqlSession();
					try {
						cnt=session.selectOne("culture.getTotalCount",map);
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							session.commit();
							session.close();
						}
							return cnt;				
			} //getTotalCount 끝
			
			@Override
			public int deleteCulture(int num) {
				int cnt= 0;
				SqlSession session= MybatisUtil.getSqlSession();
					try {
						cnt=session.delete("culture.deleteCulture",num);
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							session.commit();
							session.close();
						}
							return cnt;				
			} //deleteCulture 끝
			
			
	        @Override
	        public int updateCulture(CultureVO vo) {
				int cnt= 0;
				SqlSession session= MybatisUtil.getSqlSession();
					try {
						cnt=session.update("culture.updateCulture",vo);
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							session.commit();
							session.close();
						}
							return cnt;				
			} //deleteCulture 끝	        	
			@Override
			public List<CultureVO> selectByOnePage(Map<String, Object> map) {
				List<CultureVO> list= null;
				SqlSession session= MybatisUtil.getSqlSession();
					try {
						list=session.selectList("culture.selectByOnePage",map);
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							session.commit();
							session.close();
						}
							return list;
			}//selectByPage 끝
		
	}//class 끝

	
	
