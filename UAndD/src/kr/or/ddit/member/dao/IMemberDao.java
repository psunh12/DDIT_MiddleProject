package kr.or.ddit.member.dao;

import java.util.Map;

import kr.or.ddit.vo.MemberVO;

public interface IMemberDao {
	
	/** 
	 * MemberVO객체를 받아 회원의 정보를 저장하는 메서드
	 * 
	 * @param memVo 회원의 정보가 있는 MemberVO객체
	 * @return 성공 시 반환값: 1, 실패 시 반환값: 0
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * MemberVO객체를 받아 회원의 정보를 수정하는 메서드
	 * 
	 * @param memVo 회원의 정보가 있는 MemberVO객체
	 * @return 성공 시 반환값: 1, 실패 시 반환값: 0
	 */
	public int updateMember(MemberVO memVo);
	 
	/**
	 * 회원의 ID를 받아 회원의 탈퇴 여부를 0으로 변경하는 메서드
	 * (0은 탈퇴한 회원, 1은 기존 회원)
	 * 
	 * @param memId 탈퇴 여부를 변경할 회원의 ID
	 * @return 성공 시 반환값: 1, 실패 시 반환값: 0
	 */
	public int deleteMember(MemberVO memVo);
	   
	
	/**
	 * 회원의 정보를 읽어 MemberVO객체로 반환하는 메서드
	 * 
	 * @param memId 정보를 가져올 회원의 ID
	 * @return 검색한 회원의 MemberVO객체
	 */
	public MemberVO getSelectMember(String memId);
	
	/**
	 * 회원의 ID를 받아 아이디 존재 유무를 확인하는 메서드
	 * 
	 * @param memId 검색할 회원의 ID
	 * @return 해당 ID가 있으면 String 객체,
	 * 			없으면 null반환
	 */
	public String selectById(String memId);

	/**
	 * 회원  ID,PASSWORD가 저장된 MemeberVo객체를 인수값으로 받아서 해당회원을
	 * 검색하여 반환하는 메서드
	 * 
	 * @param memVo 검색할 회원ID,PASS가 저장된 MemberVO객체
	 * @return 검색된 회원정보가 저장된 MemberVO객체
	 */
	public MemberVO getLoginMember(MemberVO memVo);
	
	/**
	 * 회원 mail을 받아 아이디를 가져오는 메서드
	 * 
	 * @param memMail 회원의 id가 저장된 mail
	 * @return 해당 mail이  String 객체,
	 * 			없으면 null반환
	 */
	public String getID(String memMail);
	
	/**
	 * 회원의 ID를 받아 임시 비밀번호를 보낼 메일주소와 회원이름을 확인하는 메서드
	 * 
	 * @param memId 검색할 회원의 ID
	 * @return 해당 ID가 있으면 String 객체,
	 * 			없으면 null반환
	 */
	public String setPassAddr(String memId);
	
	/** 
	 * 회원의 ID를 받아 회원의 패스워드를 임시번호로 수정하는 메서드
	 * 
	 * @param memId 패스워드를바꿀 회원의 ID
	 * @return 성공 시 반환값: 1, 실패 시 반환값: 0
	 */
	public int updatePass(MemberVO memVo);
	


}