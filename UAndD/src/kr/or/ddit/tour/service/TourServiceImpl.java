package kr.or.ddit.tour.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.tour.dao.ITourDao;
import kr.or.ddit.tour.dao.TourDaoImpl;
import kr.or.ddit.vo.TourVO;

public class TourServiceImpl implements ITourService {
	private static ITourService service;  //싱글톤 시작
	private ITourDao dao;
	private TourServiceImpl() {
		dao= TourDaoImpl.getInstance();
	}
	public static ITourService getInstance() {
	    if(service == null) {
	       service = new TourServiceImpl(); 
	    }
	    return service;
	} //싱글톤 끝
	
	
	@Override
	public List<TourVO> selectTour() {
		
		return dao.selectTour();
	}

	@Override
	public TourVO selectOneTour(int num) {
		
		return dao.selectOneTour(num);
	}

	@Override
	public int insertTour(TourVO vo) {
		
		return dao.insertTour(vo);
	}

	@Override
	public int deleteTour(int num) {
		
		return dao.deleteTour(num);
	}

	@Override
	public int updateTour(TourVO vo) {
		
		return dao.updateTour(vo);
	}
	@Override
	public List<TourVO> selectDongTour(String dong) {
		
		return dao.selectDongTour(dong);
	}
	@Override
	public List<TourVO> selectNameTour(String dong) {
		
		return dao.selectNameTour(dong);
	}

	
	
}
