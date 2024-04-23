package kr.or.ddit.member.dao;
 
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao
{
	private SqlSession session;
	 
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance()
	{
		if(dao==null) dao = new MemberDaoImpl();
		
		return dao;
	}
	// 싱글톤 끝.
	
	@Override
	public int insertMember(MemberVO memVo)
	{
		session = MybatisUtil.getSqlSession();
		int cnt = 0;		// 결과값을 저장하는 변수
		
		try
		{
			cnt = session.insert("member.insertMember", memVo);
			if(cnt > 0) session.commit();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return cnt;
	} // insertMember 끝

	@Override
	public int updateMember(MemberVO memVo)
	{
		int cnt = 0;
		session = MybatisUtil.getSqlSession();
		try {
			cnt = session.update("member.updateMember", memVo);
			if(cnt > 0 ) session.commit();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return cnt;
	} // updateMember 끝

	@Override
	public int deleteMember(MemberVO memVo)
	{
		int cnt = 0;
		session = MybatisUtil.getSqlSession();
		try
		{
			cnt = session.update("member.deleteMember", memVo);
			if(cnt > 0 ) session.commit();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(session != null) session.close();
		}
		return cnt;
	} // deleteMember 끝

	@Override
	public MemberVO getSelectMember(String memId)
	{
		session = MybatisUtil.getSqlSession();
		MemberVO loginMemVo = null;
		
		try
		{
			loginMemVo = session.selectOne("member.getSelectMember", memId);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return loginMemVo;
	} // getSelectMember 끝.

	@Override
	public String selectById(String memId) 
	{
		String res = null;
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("member.selectById", memId);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(session != null) session.close();
		}

		return res;
	} // selectById 끝

	@Override
	public MemberVO getLoginMember(MemberVO memVo)
	{
		MemberVO loginMemberVo = null;
		session = MybatisUtil.getSqlSession();
		
		try
		{
			loginMemberVo = session.selectOne("member.getLoginMember", memVo);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally 
		{
			if(session!=null) session.close();
		}
		
		return loginMemberVo;
	} // getLoginMember 끝

	@Override
	public String getID(String memMail) 
	{
		String res = null;
		try 
		{
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("member.getID", memMail);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(session != null) session.close();
		}

		return res;
	} // getID 끝


	@Override
	public String setPassAddr(String memId) 
	{
		SqlSession session = null;
		String res = null;
		try 
		{
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("member.setPassAddr", memId);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(session != null) session.close();
		}

		return res;
	} // setPassAddr 끝

	@Override
	public int updatePass(MemberVO memVo) 
	{
		 SqlSession session = null;
		int cnt = 0;
		
		try 
		{
			session = MybatisUtil.getSqlSession();
			cnt = session.update("member.updatePass", memVo);
			if(cnt > 0 ) session.commit();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return cnt;
	} // updatePass 끝



}
