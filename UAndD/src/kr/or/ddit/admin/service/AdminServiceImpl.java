package kr.or.ddit.admin.service; 

import kr.or.ddit.admin.dao.AdminDaoImpl;
import kr.or.ddit.admin.dao.IAdminDao;
import kr.or.ddit.vo.AdminVO;

public class AdminServiceImpl implements IAdminService
{
	private static IAdminDao dao = AdminDaoImpl.getInstance();
	
	private static AdminServiceImpl service;
	
	private AdminServiceImpl() 
	{
		dao = AdminDaoImpl.getInstance();
	}
	
	public static IAdminService getInstance()
	{
		if(service==null) service = new AdminServiceImpl();
		return service;
	}	// 싱글톤 끝.

	@Override
	public AdminVO getLoginAdmin(AdminVO adminVo) {
		return dao.getLoginAdmin(adminVo);
	}

	

}
