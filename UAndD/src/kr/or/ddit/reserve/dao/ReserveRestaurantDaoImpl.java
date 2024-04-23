package kr.or.ddit.reserve.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.RestaurantReserveVO;
import kr.or.ddit.vo.RestaurantVO;

public class ReserveRestaurantDaoImpl implements IReserveRestaurantDao
{

	private static IReserveRestaurantDao dao;
	
	private ReserveRestaurantDaoImpl() {}
	
	public static IReserveRestaurantDao getInstance() 
	{
		if ( dao == null ) 
		{
			dao = new ReserveRestaurantDaoImpl();
		}
		
		return dao;
	}
	
	@Override
	public RestaurantVO getRestaurantInfo(int rest_no) 
	{
		RestaurantVO restaurantVo = null;
		SqlSession session = null;
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			restaurantVo = session.selectOne("restaurantVo.getRestaurantInfo", rest_no);
			
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
		
		return restaurantVo;
	}

	@Override
	public int reserveRestaurant(RestaurantReserveVO restRsvVo) 
	{
		int res = 0; // 결과값이 저장될 변수
		SqlSession session = null;
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			res = session.insert("restRsvVo.reserveRestaurant", restRsvVo);
			
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
	public List<String> getRestaurantReservedTime(Map<String, String> selectedDate) 
	{
		List<String> reservedTimeList = new ArrayList<String>();
		SqlSession session = null;
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			reservedTimeList = session.selectList("restRsvVo.getReservedTime", selectedDate);
			
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
		
		return reservedTimeList;
	}

	@Override
	public List<Map<String, String>> getMemberRestaurantReserve(String mem_id) 
	{
		List<Map<String, String>> memberRsvList = new ArrayList<Map<String,String>>();
		SqlSession session = null;
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			memberRsvList = session.selectList("restRsvVo.getMemberRestaurantReserve", mem_id);
			
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
		
		return memberRsvList;
	}

	@Override
	public List<Map<String, String>> getMemberRestaurantReserveCancel(String mem_id) 
	{
		List<Map<String, String>> memberRsvCancelList = new ArrayList<Map<String,String>>();
		SqlSession session = null;
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			memberRsvCancelList = session.selectList("restRsvVo.getMemberRestaurantReserveCancel", mem_id);
			
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
	public int reserveRestaurantCancel(int rest_rsv_no) 
	{
		SqlSession session = null;
		int res = 0;	// 결과값을 저장할 변수
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			res = session.update("restRsvVo.reserveRestaurantCancel", rest_rsv_no);
			
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
	public int changeDayReserveState() {
		SqlSession session = null;
		int res = 0;	// 결과값을 저장할 변수
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			
			res = session.update("restRsvVo.changeDayReserveState");
			
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
