package kr.or.ddit.fileupload.service;

import java.util.List;

import kr.or.ddit.fileupload.dao.FileinfoDaoImpl;
import kr.or.ddit.fileupload.dao.IFileinfoDao;
import kr.or.ddit.vo.FileInfoVO;

public class FileinfoServiceImpl implements IFileinfoService {
           private IFileinfoDao dao;
           private static FileinfoServiceImpl service;
           private FileinfoServiceImpl() {
			dao= FileinfoDaoImpl.getInstance();
			}
	       public static FileinfoServiceImpl getInstance() {
	    	   if(service==null)service = new FileinfoServiceImpl();
	    	   return service;
	       }
	@Override
	public int insertFileinfo(FileInfoVO vo) {
		
		return dao.insertFileinfo(vo);
	}



}
