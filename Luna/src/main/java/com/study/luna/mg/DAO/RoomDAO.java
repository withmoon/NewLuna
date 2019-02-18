package com.study.luna.mg.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.study.luna.mg.model.RoomVO;
import com.study.luna.mg.model.uploadfileVO;

public interface RoomDAO {

	//����Ʈ ���̺���������
	public List<RoomVO> mgRoomList(RoomVO vo);
	
	//insert
	public int uploadFile(HashMap<String, Object> hm)throws Exception;
	public int roomupload(RoomVO vo)throws Exception;

	//�󼼺���
	public RoomVO mgRoomRead(int roomnum)throws Exception;
	public List<uploadfileVO> mgRoomFile(int roomnum);

	//update
	public void mgRoomTextupdate(RoomVO vo);
	public void mgRoomFileupdate(HashMap<String, Object> hm);

	//delete
	public void mgRoomDelete(int roomnum);
	public void mgRoomFileDelete(int roomnum);

}