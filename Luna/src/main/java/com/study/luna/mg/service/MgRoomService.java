package com.study.luna.mg.service;

import java.util.List;

import com.study.luna.mg.model.RoomVO;
import com.study.luna.mg.model.uploadfileVO;

public interface MgRoomService {
	
	//����
		public List<RoomVO> RoomList(RoomVO vo, String searchOption, String keyword) throws Exception;
	
	//����ε�
	public void mgRoomUpload(RoomVO vo) throws Exception;
	public void fileUpload(String originalfileName, String saveFileName,RoomVO vo,String savePath ) throws Exception,IllegalStateException;

	//�󼼺���
	public Object RoomRead(int roomnum)throws Exception;
	public List<uploadfileVO> RoomFile(int roomnum)throws Exception;

	//�����ϱ�
	public void mgRoomUpdate(RoomVO vo)throws Exception;
	public void fileUpdate(String originalfileName, String saveFileName, RoomVO vo, String savePath)throws Exception;

	//�����ϱ�
	public void RoomDelete(int roomnum)throws Exception;
	public void filDelete(int roomnum)throws Exception;

}
 