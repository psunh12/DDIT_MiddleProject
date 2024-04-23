package kr.or.ddit.resturant.dao;

import java.util.List;


import kr.or.ddit.vo.RestaurantVO;

public interface IRestaurantDao {
	
         
    public List<RestaurantVO> selectRestaurant(); 
	
	
	public List<RestaurantVO> selectByDong(String dong);
	
	
	public List<RestaurantVO> selectByName(String name);
	 
}
