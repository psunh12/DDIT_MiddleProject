package kr.or.ddit.resturant.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.RestaurantVO;

public class RestaurantDaoImpl implements IRestaurantDao{	
	private static IRestaurantDao dao;
    private RestaurantDaoImpl() {}     
	public static IRestaurantDao getInstance() {
		if(dao==null) dao= new RestaurantDaoImpl();
		return dao;
	    }  //singleton 패턴	
	
	@Override
	public List<RestaurantVO> selectRestaurant() {
		List<RestaurantVO> list= null;
		SqlSession session= MybatisUtil.getSqlSession();
			try {
				list=session.selectList("restaurantVo.selectRestaurant");
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					session.commit();
					session.close();
				}
					return list;
	}//selectRes 끝
	

	@Override
	public List<RestaurantVO> selectByDong(String dong) {
		List<RestaurantVO> list= null;
		SqlSession session= MybatisUtil.getSqlSession();
			try {
				list=session.selectList("restaurantVo.selectByDong",dong);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					session.commit();
					session.close();
				}
					return list;
	}//selectbyDong 끝

	@Override
	public List<RestaurantVO> selectByName(String name) {
		List<RestaurantVO> list= null;
		SqlSession session= MybatisUtil.getSqlSession();
			try {
				list=session.selectList("restaurantVo.selectByName",name);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					session.commit();
					session.close();
				}
					return list;
	}//selectbyName 끝

}
