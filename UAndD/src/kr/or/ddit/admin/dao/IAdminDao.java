package kr.or.ddit.admin.dao; 

import kr.or.ddit.vo.AdminVO;
import kr.or.ddit.vo.MemberVO;

public interface IAdminDao {
	/**
	 * 관리자  ID,PASSWORD가 저장된 AdminVo객체를 인수값으로 받아서 해당관리자를
	 * 검색하여 반환하는 메서드
	 * 
	 * @param adminVo 검색할 관리자ID,PASS가 저장된 AdminVO객체
	 * @return 검색된 관리자정보가 저장된 AdminVO객체
	 */
	public AdminVO getLoginAdmin(AdminVO adminVo);
}
