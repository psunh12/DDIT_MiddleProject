package kr.or.ddit.hotel.dao;

import java.util.List;

import kr.or.ddit.vo.HotelVO;

public interface IHotelDao {

	public List<HotelVO> selectHotel();
	
	
	public List<HotelVO> selectByDong(String dong);
	
	
	public List<HotelVO> selectbyName(String dong);
}
