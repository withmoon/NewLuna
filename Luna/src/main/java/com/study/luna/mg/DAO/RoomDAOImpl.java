package com.study.luna.mg.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.mg.model.RoomVO;
import com.study.luna.mg.model.uploadfileVO;

@Repository
public class RoomDAOImpl implements RoomDAO {

	@Autowired
	private SqlSession SqlSession;

	@Override //방 생성 테이블 읽어오기
	public List<RoomVO> mgRoomList(RoomVO vo) {
		System.out.println("roomList select");
		return SqlSession.selectList("mgRoomDAO.RoomList",vo);
	}
	@Override //룸 text db
	public int roomupload(RoomVO vo) {
		System.out.println("roomtext DB 저장");
		return SqlSession.insert("mgRoomDAO.RoomText",vo);
	}
	@Override  //룸 file db
	public int uploadFile(HashMap<String, Object> hm) throws Exception {
		System.out.println("roomfile DB 저장");
		return SqlSession.insert("mgRoomDAO.RoomFile",hm); 
	}
	//룸 상세보기 text
	@Override
	public RoomVO mgRoomRead(int roomnum) throws Exception {
		System.out.println("roomList 상세보기 DAO");
		return SqlSession.selectOne("mgRoomDAO.RoomSelect",roomnum);
	}
	//룸 상세보기 file
	@Override
	public List<uploadfileVO> mgRoomFile(int roomnum) {
		System.out.println("roomfile 상세보기 DAO");
		return SqlSession.selectList("mgRoomDAO.RoomFileSelect",roomnum);
	}
	
	//업데이트 수정하기
	@Override
	public void mgRoomTextupdate(RoomVO vo) {
		System.out.println("roomtext  update DAO");
		SqlSession.update("mgRoomDAO.RoomTextInsert",vo);
	}
	@Override //파일수정
	public void mgRoomFileupdate(HashMap<String, Object> hm) {
		System.out.println("roomfile update DAO");
		SqlSession.update("mgRoomDAO.RoomFileInsert",hm);
	}
	
	//삭제하기
	@Override
	public void mgRoomDelete(int roomnum) {
		// TODO Auto-generated method stub
		System.out.println("room deleteDAO");
		SqlSession.delete("mgRoomDAO.RoomDelete",roomnum);
	}
	@Override
	public void mgRoomFileDelete(int roomnum) {
		// TODO Auto-generated method stub
		System.out.println("roomfile delete DAO");
		SqlSession.delete("mgRoomDAO.RoomFileDelete",roomnum);
	}


 
}
