package kr.or.ddit.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.HotelVO;

public class HotelDaoImpl implements IHotelDao {
	private static  IHotelDao dao;
    private HotelDaoImpl() {}     
	public static IHotelDao getInstance() {
		if(dao==null) dao= new HotelDaoImpl();
		return dao;
	    }  //singleton 패턴	
	@Override
	public List<HotelVO> selectHotel() {
		List<HotelVO> list= null;
		SqlSession session= MybatisUtil.getSqlSession();
			try {
				list=session.selectList("hotelVo.selectHotel");
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					session.commit();
					session.close();
				}
					return list;
	}//selectCulture 끝
	@Override
	public List<HotelVO> selectByDong(String dong) {
		List<HotelVO> list= null;
		SqlSession session= MybatisUtil.getSqlSession();
			try {
				list=session.selectList("hotelVo.selectByDong",dong);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					session.commit();
					session.close();
				}
					return list;
	}
	@Override
	public List<HotelVO> selectbyName(String dong) {
		List<HotelVO> list= null;
		SqlSession session= MybatisUtil.getSqlSession();
			try {
				list=session.selectList("hotelVo.selectByName",dong);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					session.commit();
					session.close();
				}
					return list;
	}

}
