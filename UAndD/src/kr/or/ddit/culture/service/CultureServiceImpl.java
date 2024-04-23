package kr.or.ddit.culture.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.culture.dao.CultureDaoImpl;
import kr.or.ddit.culture.dao.ICultureDao;
import kr.or.ddit.vo.CultureVO;
import kr.or.ddit.vo.PageVO;

public class CultureServiceImpl implements ICultureService {
	private static ICultureService service;
	ICultureDao dao;
	private CultureServiceImpl() {
		dao= CultureDaoImpl.getInstance();	
	}
	public static ICultureService getInstance() {
		if(service==null) service = new CultureServiceImpl();
	    return service;
	} // singleton 끝 
	
	@Override
	public List<CultureVO> selectCulture(int num) {
		
		return dao.selectCulture(num) ;
	}

	@Override
	public CultureVO selectOneCulture(int num) {
		
		return dao.selectOneCulture(num);
	}

	@Override
	public List<CultureVO> selectByPage(Map<String, Object> map) {
		
		return dao.selectByPage(map);
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		
		return dao.getTotalCount(map);
	}

	@Override
	public int insertCulture(CultureVO vo) {
		
		return dao.insertCulture(vo);
	}

	@Override
	public int deleteCulture(int num) {
		
		return dao.deleteCulture(num);
	}

	@Override
	public int updateCulture(CultureVO vo) {
		
		return dao.updateCulture(vo);
	}
	@Override
	public PageVO getPageInfo(int page, String stype, String sword) {
		
			Map<String, Object> map =new HashMap<String, Object>();
			//전체 글 갯수 구하기 
			map.put("stype",stype);
			map.put("sword",sword);
			
			int count= this.getTotalCount(map);
			
			int plist= PageVO.getPerList();
			
			int totalPage= (int)Math.ceil( (double)count/plist);
			
			if(page >totalPage) page= totalPage;
			
			
			 //start,end 구하기
			 int start= (page-1)*plist +1;
			 int end= start+plist-1 ;
			 if(end>count) end=count;
			 
			 //startPage, endPage
			 int ppage=PageVO.getPerPage();
			 int startPage= ((page-1)/ppage *ppage)+1;
			 int endPage= startPage +ppage-1;
			 if(endPage>totalPage) endPage=totalPage;
			 
			 PageVO pvo=new PageVO();
			 pvo.setStart(start);
			 pvo.setEnd(end);
			 pvo.setStartPage(startPage);
			 pvo.setEndPage(endPage);
			 pvo.setTotalPage(totalPage);
			 
			return pvo;
	}
	@Override
	public List<CultureVO> selectByOnePage(Map<String, Object> map) {
		
		return dao.selectByOnePage(map);
	}
}
