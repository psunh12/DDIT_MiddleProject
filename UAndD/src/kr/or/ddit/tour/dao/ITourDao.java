package kr.or.ddit.tour.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.TourVO;

public interface ITourDao {

    /**
     * DB에서 데이터를 가져와 지도에 마커를 찍는 메소드
     * @param map 
     * @return tour자료가있는 List
     */
public List<TourVO> selectTour();
  
   /**
    * 관광지 하나의 상세자료를 보여주는 메서드
    *
    * @return TourVO객체
    */
public TourVO selectOneTour(int num);

  /**
   * 관광지 자료를 삽입하는 메서드
   * @param vo 자료들이 들어갈 vo객체
   * @return 성공시 1, 실패시 0
   */
public int insertTour(TourVO vo);

  /**
   * 관광지 자료를 삭제하는 메서드
   * @param num tour_num값으로 db를 찾음
   * @return 성공시 1, 실패시 0
   */  
public int deleteTour(int num);

  /**
   * 관광지 자료를 수정하는 메서드
   * @param 업데이트 할 vo객체
   * @return 성공시 1, 실패시 0
   */  		
public int updateTour(TourVO vo);


  /**
   * 동으로 관광지를 검색하는 메서드
   * @param  문자열 주소
   * @return 검색한 것들의 리스트
   */  		
public List<TourVO> selectDongTour(String dong);


/**
 * 이름으로 관광지를 검색하는 메서드
 * @param  문자열 이름
 * @return 검색한 것들의 리스트
 */  		
public List<TourVO> selectNameTour(String dong);
}
