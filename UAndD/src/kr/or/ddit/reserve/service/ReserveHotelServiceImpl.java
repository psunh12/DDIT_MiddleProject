package kr.or.ddit.reserve.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.reserve.dao.IReserveHotelDao;
import kr.or.ddit.reserve.dao.ReserveHotelDaoImpl;
import kr.or.ddit.vo.HotelReserveVO;
import kr.or.ddit.vo.HotelVO;

public class ReserveHotelServiceImpl implements IReserveHotelService 
{
	
	private static IReserveHotelDao dao = ReserveHotelDaoImpl.getInstance();
	
	private static IReserveHotelService service = null;
	
	private ReserveHotelServiceImpl() {}
	
	public static IReserveHotelService getInstance() 
	{
		if ( service == null ) 
		{
			service = new ReserveHotelServiceImpl();
		}
		
		return service;
	}

	@Override
	public int reserveHotel(HotelReserveVO hotelRsvVo) {
		return dao.reserveHotel(hotelRsvVo);
	}

	@Override
	public HotelVO getHotelInfo(int hotel_no) {
		return dao.getHotelInfo(hotel_no);
	}

	@Override
	public int subtractHotelRoom(int hotel_no) {
		return dao.subtractHotelRoom(hotel_no);
	}

	@Override
	public int getHotelRoom(Map<String, String> date) {
		return dao.getHotelRoom(date);
	}

	@Override
	public int doManagerAllCheckout() {
		return dao.doManagerAllCheckout();
	}

	@Override
	public List<Map<String, String>> getMemberHotelReserve(String mem_id) {
		return dao.getMemberHotelReserve(mem_id);
	}

	@Override
	public List<Map<String, String>> getMemberHotelReserveCancel(String mem_id) {
		return dao.getMemberHotelReserveCancel(mem_id);
	}

	@Override
	public int reserveHotelCancel(String hotel_rsv_no) {
		return dao.reserveHotelCancel(hotel_rsv_no);
	}

}
