package kr.or.ddit.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.notice.dao.INoticeDao;
import kr.or.ddit.notice.dao.NoticeDaoImpl;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PageVO;

public class NoticeServiceImpl implements INoticeService {

	private INoticeDao noticeDao;
	private static INoticeService noticeService;
	
	public NoticeServiceImpl() {
		noticeDao = new NoticeDaoImpl();
	}
	
	public static INoticeService getInstance() {
		if(noticeService==null) {
			noticeService = new NoticeServiceImpl();
		}
		return noticeService;
	}

	@Override
	public List<NoticeVO> getAllNotice() {
		return noticeDao.getAllNotice();
	}
	
	@Override
	public NoticeVO getNotice(int no) {
		return noticeDao.getNotice(no);
	}

	@Override
	public int deleteNotice(int no) {
		return noticeDao.deleteNotice(no);
	}

	@Override
	public int updateHits(int noticeNo) {
		return noticeDao.updateHits(noticeNo);
	}

	@Override
	public int updateNotice(NoticeVO noticeVO) {
		return noticeDao.updateNotice(noticeVO);
	}

	@Override
	public int insertNotice(NoticeVO noticeVO) {
		return noticeDao.insertNotice(noticeVO);
	}

//	@Override
//	public PageVO getPageInfo(int page, String stype, String sword) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("stype", stype);
//		map.put("sword", sword);
//		
//		int count = this.getTotalCount(map);
//		
//		int plist = PageVO.getPerList();
//		int totalPage = (int) Math.ceil((double)count/plist);
//		
//		if(page>totalPage) page = totalPage;
//		
//		int start = (page -1)*plist +1;
//		int end = start + plist -1;
//		
//		if(end>count) {
//			end = count;
//		}
//		
//		int ppage = PageVO.getPerPage();
//		int startPage = ((page-1)/ppage*ppage)*1;
//		int endPage = startPage + ppage - 1;
//		
//		if (endPage > totalPage) {
//			endPage = totalPage;
//		}
//		
//		PageVO pageVo = new PageVO();
//		pageVo.setStart(start);
//		pageVo.setEnd(end);
//		pageVo.setStartPage(startPage);
//		pageVo.setEndPage(endPage);
//		pageVo.setTotalPage(totalPage);
//		
//		return pageVo;
//	}

//	@Override
//	public int getTotalCount(Map<String, Object> map) {
//		return noticeDao.getTotalCount(map);
//	}

//	@Override
//	public List<NoticeVO> selectByPage(Map<String, Object> map) {
//		return noticeDao.getAllNotice();
//	}


}	//NoticeServiceImpl 끝
