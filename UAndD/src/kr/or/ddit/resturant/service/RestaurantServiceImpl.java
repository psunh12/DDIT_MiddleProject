package kr.or.ddit.resturant.service;

import java.util.List;

import kr.or.ddit.hotel.dao.HotelDaoImpl;
import kr.or.ddit.hotel.dao.IHotelDao;
import kr.or.ddit.hotel.service.HotelServiceImpl;
import kr.or.ddit.hotel.service.IHotelSerivce;
import kr.or.ddit.resturant.dao.IRestaurantDao;
import kr.or.ddit.resturant.dao.RestaurantDaoImpl;
import kr.or.ddit.vo.RestaurantVO;

public class RestaurantServiceImpl implements IRestaurantService {
	private static IRestaurantService service;
	IRestaurantDao dao;
	private RestaurantServiceImpl() {
		dao= RestaurantDaoImpl.getInstance();
	}
	public static IRestaurantService getInstance() {
		if(service==null) service = new RestaurantServiceImpl();
	    return service;
	} // singleton 끝 
	
	
	@Override
	public List<RestaurantVO> selectRestaurant() {
		
		return dao.selectRestaurant();
	}
	@Override
	public List<RestaurantVO> selectByDong(String dong) {
		
		return dao.selectByDong(dong);
	}
	@Override
	public List<RestaurantVO> selectByName(String name) {
		
		return dao.selectByName(name);
	}
}
