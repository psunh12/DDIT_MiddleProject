package kr.or.ddit.admin.dao; 

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.AdminVO;

public class AdminDaoImpl implements IAdminDao
{
	private SqlSession session;
	
	private static AdminDaoImpl dao;
	
	private AdminDaoImpl() {}
	
	public static AdminDaoImpl getInstance()
	{
		if(dao==null) dao = new AdminDaoImpl();
		
		return dao;
	}
	// 싱글톤 끝.

	@Override
	public AdminVO getLoginAdmin(AdminVO adminVo) 
	{
		AdminVO adminVO =null;
		session = MybatisUtil.getSqlSession();
		
		try 
		{
			adminVO = session.selectOne("admin.getLoginAdmin", adminVo);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally
		{
			if(session!=null) session.close();
		}
		return adminVO;
	}

	
}
