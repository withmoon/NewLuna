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

	//글 insert / 파일 insert
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
		System.out.println("파일 이름 맵저장 서비스로직");
		RoomDAO.uploadFile(hm);
	}
  //화면 게시판 읽어오기
	@Override
	public List<RoomVO> RoomList(RoomVO vo) throws Exception {
		System.out.println("roomlist 서비스");
		return  RoomDAO.mgRoomList(vo);
	}
	//상세보기 글/file 읽어오기
	@Override
	public Object RoomRead(int roomnum) throws Exception {
		System.out.println("roomRead 서비스");
		return RoomDAO.mgRoomRead(roomnum);
	}
	@Override//file
	public List<uploadfileVO> RoomFile(int roomnum) throws Exception {
		System.out.println("roomfile 서비스");
		return RoomDAO.mgRoomFile(roomnum);
	}
	//수정하기 글     /   file update 하기
	@Override
	public void mgRoomUpdate(RoomVO vo) throws Exception {
		System.out.println("roomTextupdate 서비스");
		RoomDAO.mgRoomTextupdate(vo); 
	}
	@Override //file update
	public void fileUpdate(String originalfileName, String saveFileName, RoomVO vo, String savePath) throws Exception {
		System.out.println("roomFileupdate 서비스");
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("originalfileName", originalfileName);
		hm.put("saveFileName", saveFileName);
		hm.put("filenum",vo.getFilenum());
		hm.put("roomnum",vo.getRoomnum());
		hm.put("savePath",savePath);
		System.out.println("파일 이름 맵저장 서비스로직");
		RoomDAO.mgRoomFileupdate(hm);
	}
	
	//삭제하기
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
