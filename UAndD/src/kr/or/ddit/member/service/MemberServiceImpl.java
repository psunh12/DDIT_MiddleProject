package kr.or.ddit.member.service;

import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;
 
public class MemberServiceImpl implements IMemberService
{
	
	private static IMemberDao dao = MemberDaoImpl.getInstance();
	
	private static MemberServiceImpl service;
	
	private MemberServiceImpl()
	{ 
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance()
	{
		if(service==null) service = new MemberServiceImpl();
		return service;
	} // 싱글톤 끝.
	
	
	@Override
	public int insertMember(MemberVO memVo)
	{
		return dao.insertMember(memVo);
	}

	@Override
	public int updateMember(MemberVO memVo)
	{
		return dao.updateMember(memVo); 
	}

	@Override
	public int deleteMember(MemberVO memVo)
	{
		return dao.deleteMember(memVo);
	}

	@Override
	public MemberVO getSelectMember(String memId)
	{
		return dao.getSelectMember(memId);
	}

	@Override
	public String selectById(String memId)
	{
		return dao.selectById(memId);
	}

	@Override
	public MemberVO getLoginMember(MemberVO memVo)
	{
		return dao.getLoginMember(memVo);
	}

	@Override
	public String getID(String memMail) 
	{
		return dao.getID(memMail);
	}

	@Override
	public String setPassAddr(String memId) 
	{
		return dao.setPassAddr(memId);
	}

	@Override
	public int updatePass(MemberVO memVo) 
	{
		return dao.updatePass(memVo);
	}





}
