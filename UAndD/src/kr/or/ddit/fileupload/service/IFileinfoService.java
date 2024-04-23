package kr.or.ddit.fileupload.service;

import java.util.List;

import kr.or.ddit.vo.FileInfoVO;

public interface IFileinfoService {

    /**
     * fileInfoVO객체에 저장된 데이터를 DB에 insert하는 메서드
     * @param filevo db에 저장할 자료가 저장된 FileInfoVO객체
     * @return  작업성공: 1 ,실패 :0
     */
    public int insertFileinfo (FileInfoVO vo);
    	     
   

	
}
