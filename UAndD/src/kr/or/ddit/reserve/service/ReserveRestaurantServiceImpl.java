package kr.or.ddit.reserve.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.reserve.dao.IReserveRestaurantDao;
import kr.or.ddit.reserve.dao.ReserveRestaurantDaoImpl;
import kr.or.ddit.vo.RestaurantReserveVO;
import kr.or.ddit.vo.RestaurantVO;

public class ReserveRestaurantServiceImpl implements IReserveRestaurantService
{
	
	private static IReserveRestaurantDao dao = ReserveRestaurantDaoImpl.getInstance();
	
	private static IReserveRestaurantService service = null;
	
	private ReserveRestaurantServiceImpl() {}
	
	public static IReserveRestaurantService getInstance() 
	{
		if ( service == null ) 
		{
			service = new ReserveRestaurantServiceImpl();
		}
		
		return service;
	}


	@Override
	public RestaurantVO getRestaurantInfo(int rest_no) 
	{
		return dao.getRestaurantInfo(rest_no);
	}

	@Override
	public int reserveRestaurant(RestaurantReserveVO restRsvVo) 
	{
		return dao.reserveRestaurant(restRsvVo);
	}

	@Override
	public List<String> getRestaurantReservedTime(Map<String, String> selectedDate) 
	{
		return dao.getRestaurantReservedTime(selectedDate);
	}

	@Override
	public List<Map<String, String>> getMemberRestaurantReserve(String mem_id) 
	{
		return dao.getMemberRestaurantReserve(mem_id);
	}

	@Override
	public List<Map<String, String>> getMemberRestaurantReserveCancel(String mem_id) 
	{
		return dao.getMemberRestaurantReserveCancel(mem_id);
	}

	@Override
	public int reserveRestaurantCancel(int rest_rsv_no) 
	{
		return dao.reserveRestaurantCancel(rest_rsv_no);
	}

	@Override
	public int changeDayReserveState() {
		return dao.changeDayReserveState();
	}
	
}
