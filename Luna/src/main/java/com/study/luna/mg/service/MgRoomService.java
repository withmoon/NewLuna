package com.study.luna.mg.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.study.luna.mg.model.RoomVO;
import com.study.luna.mg.model.uploadfileVO;

public interface MgRoomService {
	  
	//방탭
	public List<RoomVO> RoomList(HttpSession session,int start, int end, RoomVO vo, String searchOption, String keyword) throws Exception;
	
	//방업로드 
	public void mgRoomUpload(RoomVO vo) throws Exception;
	public void fileUpload(String originalfileName, String saveFileName,RoomVO vo,String savePath ) throws Exception,IllegalStateException;

	//상세보기
	public Object RoomRead(int roomnum)throws Exception;
	public List<uploadfileVO> RoomFile(int roomnum)throws Exception;

	//수정하기
	public void mgRoomUpdate(RoomVO vo)throws Exception;
	public void fileUpdate(String originalfileName, String saveFileName, RoomVO vo, String savePath)throws Exception;

	//삭제하기
	public void RoomDelete(int roomnum)throws Exception;
	public void filDelete(int roomnum)throws Exception;

}
 