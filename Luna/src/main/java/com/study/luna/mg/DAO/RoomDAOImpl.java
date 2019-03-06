package com.study.luna.mg.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	public List<RoomVO> mgRoomList(HttpSession session,int start,int end,RoomVO vo,String searchOption, String keyword) {
		System.out.println("roomList select");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName", session.getAttribute("branchName"));
		//#start #end 에 입력될 값
		map.put("start",start);
		map.put("end", end);
		return SqlSession.selectList("mgRoomDAO.RoomList",map);
	}
	
	@Override //방 리스트갯수 
	public int countArticle(String searchOption, String keyword, HttpSession session) {
		System.out.println("roomList select");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName",session.getAttribute("branchName"));
		return SqlSession.selectOne("mgRoomDAO.countArticle",map);
	}
	@Override //룸 text db
	public int roomupload(RoomVO vo) {
		System.out.println("roomtext DB 수행");
		return SqlSession.insert("mgRoomDAO.RoomText",vo);
	}
	@Override  //룸 file db
	public int uploadFile(HashMap<String, Object> hm) throws Exception {
		System.out.println("roomfile DB 수행");
		return SqlSession.insert("mgRoomDAO.RoomFile",hm); 
	}
	//룸 상세보기 text
	@Override
	public RoomVO mgRoomRead(int roomnum) throws Exception {
		System.out.println("roomList text DAO");
		return SqlSession.selectOne("mgRoomDAO.RoomSelect",roomnum);
	}
	//룸 상세보기 file
	@Override
	public List<uploadfileVO> mgRoomFile(int roomnum) {
		System.out.println("roomfile text DAO");
		return SqlSession.selectList("mgRoomDAO.RoomFileSelect",roomnum);
	}
	
	//업데이트 수정하기
	@Override
	public void mgRoomTextupdate(RoomVO vo) {
		System.out.println("roomtext update DAO");
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
