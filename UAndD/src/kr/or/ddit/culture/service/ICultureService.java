package kr.or.ddit.culture.service;


import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.CultureVO;
import kr.or.ddit.vo.PageVO;

public interface ICultureService {
	
	/**
	 *  db의 문화 리스트를 받아서 문화 타입 코드에 따라 리스트를 보여주는 메서드
	 * @param 문화 코드
	 * @return 
	 */
	public List<CultureVO> selectCulture(int num);
	 
	
     /**
	   * 리스트에서 클릭하면 상세 정보를 보여주는 메서드 
	   * @param num 상세 번호
	   * @return  
	   */
	 public CultureVO selectOneCulture(int num);
	
	 /**
	  *  페이지로 나눠서 보여주는 메서드
	  * @param map
	  * @return
	  */
	 public List<CultureVO> selectByPage(Map<String, Object> map);
	
	 /**
	  *  카테고리별 자료를 페이지로 나눠서 보여주는 메서드
	  * @param map
	  * @return
	  */
	 public List<CultureVO> selectByOnePage(Map<String, Object> map);
	 	 
	 /**
	  *  페이지를 계산하는 메서드
	  * @param map
	  * @return
	  */
	 public int getTotalCount(Map<String, Object> map);
	 
	 
	 /**
	  *  문화 DB를 넣는 메서드
	  * @param vo
	  * @return
	  */	 
	 public int insertCulture(CultureVO vo);
	 
	 
	 /**
	  *  문화 DB에서 문화번호를 받아와 삭제하는 메서드
	  * @param int
	  * @return
	  */	 
	 public int deleteCulture(int num);
	 
	 
	 /**
	  *  문화 DB에 값을 수정하는 메서드
	  * @param vo
	  * @return
	  */
	 public int updateCulture(CultureVO vo);
	 
	 
	 /**
	  * page정보 계산 
	  * @param page
	  * @param ctype
	  * @param cword
	  * @return
	  */
	 public PageVO getPageInfo(int page, String ctype, String cword); 
}
