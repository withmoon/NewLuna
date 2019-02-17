package com.study.luna.mg.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.mg.DAO.RoomDAO;
import com.study.luna.mg.model.RoomVO;
import com.study.luna.mg.model.uploadfileVO;

@Service
public class MgRoomServiceImpl implements MgRoomService {

	@Autowired
	public RoomDAO RoomDAO;

	//�� insert / ���� insert
	@Override
	public void mgRoomUpload(RoomVO vo) throws Exception {
		RoomDAO.roomupload(vo);
	}	
	@Override
	public void fileUpload(String originalfileName, String saveFileName,RoomVO vo, String savePath) throws Exception, IllegalStateException {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("originalfileName", originalfileName);
		hm.put("saveFileName", saveFileName);
		hm.put("filenum",vo.getFilenum());
		hm.put("roomnum",vo.getRoomnum());
		hm.put("savePath",savePath);
		System.out.println("���� �̸� ������ ���񽺷���");
		RoomDAO.uploadFile(hm);
	}
  //ȭ�� �Խ��� �о����
	@Override
	public List<RoomVO> RoomList(RoomVO vo) throws Exception {
		System.out.println("roomlist ����");
		return  RoomDAO.mgRoomList(vo);
	}
	//�󼼺��� ��/file �о����
	@Override
	public Object RoomRead(int roomnum) throws Exception {
		System.out.println("roomRead ����");
		return RoomDAO.mgRoomRead(roomnum);
	}
	@Override//file
	public List<uploadfileVO> RoomFile(int roomnum) throws Exception {
		System.out.println("roomfile ����");
		return RoomDAO.mgRoomFile(roomnum);
	}
	//�����ϱ� ��     /   file update �ϱ�
	@Override
	public void mgRoomUpdate(RoomVO vo) throws Exception {
		System.out.println("roomTextupdate ����");
		RoomDAO.mgRoomTextupdate(vo); 
	}
	@Override //file update
	public void fileUpdate(String originalfileName, String saveFileName, RoomVO vo, String savePath) throws Exception {
		System.out.println("roomFileupdate ����");
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("originalfileName", originalfileName);
		hm.put("saveFileName", saveFileName);
		hm.put("filenum",vo.getFilenum());
		hm.put("roomnum",vo.getRoomnum());
		hm.put("savePath",savePath);
		System.out.println("���� �̸� ������ ���񽺷���");
		RoomDAO.mgRoomFileupdate(hm);
	}
	
	//�����ϱ�
	@Override
	public void RoomDelete(int roomnum) throws Exception {
		RoomDAO.mgRoomDelete(roomnum);
	}
	@Override
	public void filDelete(int roomnum) throws Exception {
		// TODO Auto-generated method stub
		RoomDAO.mgRoomFileDelete(roomnum);
	}



}
