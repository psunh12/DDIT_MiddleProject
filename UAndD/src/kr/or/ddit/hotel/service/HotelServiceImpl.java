package kr.or.ddit.hotel.service;



import java.util.List;

import kr.or.ddit.hotel.dao.HotelDaoImpl;
import kr.or.ddit.hotel.dao.IHotelDao;
import kr.or.ddit.vo.HotelVO;

public class HotelServiceImpl implements IHotelSerivce {
	private static IHotelSerivce service;
	IHotelDao dao;
	private HotelServiceImpl() {
		dao= HotelDaoImpl.getInstance();
	}
	public static IHotelSerivce getInstance() {
		if(service==null) service = new HotelServiceImpl();
	    return service;
	} // singleton 끝 
	@Override
	public List<HotelVO> selectHotel() {
		
		return dao.selectHotel();
	}
	@Override
	public List<HotelVO> selectByDong(String dong) {
		
		return dao.selectByDong(dong);
	}
	@Override
	public List<kr.or.ddit.vo.HotelVO> selectbyName(String dong) {
		
		return dao.selectbyName(dong);
	}

}
