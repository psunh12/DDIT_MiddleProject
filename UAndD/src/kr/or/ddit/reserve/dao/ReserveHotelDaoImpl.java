package kr.or.ddit.reserve.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.HotelReserveVO;
import kr.or.ddit.vo.HotelVO;

public class ReserveHotelDaoImpl implements IReserveHotelDao
{
	private static IReserveHotelDao dao;
	
	private ReserveHotelDaoImpl() {}
	
	public static IReserveHotelDao getInstance() 
	{
		if ( dao == null ) 
		{
			dao = new ReserveHotelDaoImpl();
		}
		
		return dao;
	}

	@Override
	public int reserveHotel(HotelReserveVO hotelRsvVo) 
	{
		int res = 0; // 결과값을 저장하는 변수
		SqlSession session = null;
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			res = session.insert("hotelRsvVo.reserveHotel", hotelRsvVo);
			
			session.commit();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			if ( session != null ) 
			{
				session.close();
			}
		}
		
		return res;
	}

	@Override
	public HotelVO getHotelInfo(int hotel_no) 
	{
		HotelVO hotelVo = null;
		SqlSession session = null;
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			hotelVo = session.selectOne("hotelVo.getHotelInfo", hotel_no);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			if ( session != null ) 
			{
				session.close();
			}
		}
		
		return hotelVo;
	}

	@Override
	public int subtractHotelRoom(int hotel_no) 
	{
		SqlSession session = null;
		int res = 0; // 결과값을 저장할 변수
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			res = session.update("hotelVo.subtractHotelRoom", hotel_no);
			
			session.commit();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			if ( session != null )
			{
				session.close();
			}
		}
		
		return res;
	}

	@Override
	public int getHotelRoom(Map<String, String> date) 
	{
		SqlSession session = null;
		int res = 0;	// 결과값을 저장할 변수
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			res = session.selectOne("hotelVo.getHotelRoom", date);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			if ( session != null )
			{
				session.close();
			}
		}
		
		return res;
	}

	@Override
	public int doManagerAllCheckout() 
	{
		int res = 0;	// 결과값이 저장될 변수
		SqlSession session = null;
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			res = session.update("hotelRsvVo.doManagerAllCheckout");
			
			session.commit();
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			if (session != null)
			{
				session.close();
			}
		}
		
		return res;
	}

	@Override
	public List<Map<String, String>> getMemberHotelReserve(String mem_id) {
		List<Map<String, String>> memberRsvList = new ArrayList<Map<String,String>>();
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			memberRsvList = session.selectList("hotelRsvVo.getMemberHotelReserve", mem_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally 
		{
			if (session != null)
			{
				session.close();
			}
		}
		
		return memberRsvList;
	}

	@Override
	public List<Map<String, String>> getMemberHotelReserveCancel(String mem_id) 
	{
		List<Map<String, String>> memberRsvCancelList = new ArrayList<Map<String,String>>();
		SqlSession session = null;
		
		try
		{
			session = MybatisUtil.getSqlSession();
			
			memberRsvCancelList = session.selectList("hotelRsvVo.getMemberHotelReserveCancel", mem_id);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			if (session != null)
			{
				session.close();
			}
		}
		
		return memberRsvCancelList;
	}

	@Override
	public int reserveHotelCancel(String hotel_rsv_no) 
	{
		SqlSession session = null;
		int res = 0;	// 결과값을 저장할 변수
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			res = session.update("hotelRsvVo.reserveHotelCancel", hotel_rsv_no);
			
			session.commit();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			if (session != null)
			{
				session.close();
			}
		}
		
		return res;
	}

}
