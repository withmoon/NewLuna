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

	@Override //�� ���� ���̺� �о����
	public List<RoomVO> mgRoomList(RoomVO vo) {
		System.out.println("roomList select");
		return SqlSession.selectList("mgRoomDAO.RoomList",vo);
	}
	@Override //�� text db
	public int roomupload(RoomVO vo) {
		System.out.println("roomtext DB ����");
		return SqlSession.insert("mgRoomDAO.RoomText",vo);
	}
	@Override  //�� file db
	public int uploadFile(HashMap<String, Object> hm) throws Exception {
		System.out.println("roomfile DB ����");
		return SqlSession.insert("mgRoomDAO.RoomFile",hm); 
	}
	//�� �󼼺��� text
	@Override
	public RoomVO mgRoomRead(int roomnum) throws Exception {
		System.out.println("roomList �󼼺��� DAO");
		return SqlSession.selectOne("mgRoomDAO.RoomSelect",roomnum);
	}
	//�� �󼼺��� file
	@Override
	public List<uploadfileVO> mgRoomFile(int roomnum) {
		System.out.println("roomfile �󼼺��� DAO");
		return SqlSession.selectList("mgRoomDAO.RoomFileSelect",roomnum);
	}
	
	//������Ʈ �����ϱ�
	@Override
	public void mgRoomTextupdate(RoomVO vo) {
		System.out.println("roomtext  update DAO");
		SqlSession.update("mgRoomDAO.RoomTextInsert",vo);
	}
	@Override //���ϼ���
	public void mgRoomFileupdate(HashMap<String, Object> hm) {
		System.out.println("roomfile update DAO");
		SqlSession.update("mgRoomDAO.RoomFileInsert",hm);
	}
	
	//�����ϱ�
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
