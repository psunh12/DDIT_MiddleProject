package kr.or.ddit.reserve.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.RestaurantReserveVO;
import kr.or.ddit.vo.RestaurantVO;

public interface IReserveRestaurantService {
	
	/**
	 * 식당 번호로 식당의 상세 정보를 검색해 RestaurantVO객체로 반환하는 메서드
	 * 
	 * @param rest_no 검색할 식당 번호
	 * @return 식당의 상세 정보가 담긴 RestaurantVO객체
	 */
	public RestaurantVO getRestaurantInfo(int rest_no);
	
	/**
	 * RestaurantReserveVO객체를 받아 식당 예약 테이블에 정보를 저장을 하는 메서드
	 * 
	 * @param restRsvVo 식당 예약 정보가 담긴 RestaurantReserveVO객체
	 * @return 반환값 성공 시: 1, 실패 시: 0
	 */
	public int reserveRestaurant(RestaurantReserveVO restRsvVo);
	
	/**
	 * 사용자가 선택한 날짜에 예약된 시간 정보를 반환하는 메서드
	 * 
	 * @param selectedTime rest_no 식당 번호, selectedDate 사용자가 선택한 날짜
	 * @return 이미 예약된 시간을 List 객체로 반환
	 */
	public List<String> getRestaurantReservedTime(Map<String, String> selectedDate);
	
	/**
	 * mem_id를 가진 사용자가 예약한 식당 정보를 불러오는 메서드
	 * 
	 * @param mem_id 예약한 정보를 가져올 사용자의 ID
	 * @return 식당 정보와 예약 정보가 담긴 List 객체
	 */
	public List<Map<String, String>> getMemberRestaurantReserve(String mem_id);
	
	/**
	 * mem_id를 가진 사용자가 예약한 식당 중 취소되거나 완료된 식당 정보를 불러오는 메서드
	 * 
	 * @param mem_id 취소되거나 완료된 식당 정보를 가져올 사용자의 ID
	 * @return 취소되거나 완료된 식당 정보가 담긴 List 객체
	 */
	public List<Map<String, String>> getMemberRestaurantReserveCancel(String mem_id);
	
	/**
	 * 식당 예약 번호를 불러와 예약을 취소하는 메서드
	 * 
	 * @param hotel_rsv_no 취소할 식당 예약 번호
	 * @return 반환값 성공 시: 1, 실패 시: 0
	 */
	public int reserveRestaurantCancel(int rest_rsv_no);
	
	/**
	 * 당일 전에 해당하는 식당의 예약을 0으로 변경하는 메서드 
	 * 
	 * @return 반환값 성공 시: 1, 실패 시: 0;
	 */
	public int changeDayReserveState();
	
}
