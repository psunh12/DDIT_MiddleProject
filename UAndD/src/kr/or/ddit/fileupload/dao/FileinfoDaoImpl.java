package kr.or.ddit.fileupload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.FileInfoVO;


public class FileinfoDaoImpl implements IFileinfoDao{
         private static FileinfoDaoImpl dao;
         private FileinfoDaoImpl() {}
	     public static FileinfoDaoImpl getInstance() {
	    	if(dao==null) dao= new FileinfoDaoImpl();
	    	return dao;
	     }
	
	@Override
	public int insertFileinfo(FileInfoVO vo) {
		   int cnt=0;
		   SqlSession sess=null;
		   try {
			 sess=MybatisUtil.getSqlSession();
			 cnt=sess.insert("fileinfo.insertFileinfo",vo);
			 if (cnt>0)  sess.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sess!=null)sess.close();
		}
		return cnt;
	}


}
