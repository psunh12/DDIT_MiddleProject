package kr.or.ddit.hotel.service;

import java.util.List;

import kr.or.ddit.vo.HotelVO;

public interface IHotelSerivce {
     
	public List<HotelVO> selectHotel();
	  
	public List<HotelVO> selectByDong(String dong);
	
	public List<HotelVO> selectbyName(String dong);
	
}
