package com.study.luna.mg.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.study.luna.mg.model.RoomVO;
import com.study.luna.mg.model.uploadfileVO;

public interface RoomDAO {

	//리스트 테이블가져오기 
	public List<RoomVO> mgRoomList(HttpSession session,int start, int end, RoomVO vo,String searchOption, String keyword);
	//리스트 카운트
	public int countArticle(String searchOption, String keyword, HttpSession session);
	//방 카운트
	public int roomcount();
	//방주소
	public String roomLocate(HttpSession session);
	 
	//insert
	public int uploadFile(HashMap<String, Object> hm)throws Exception;
	public int roomupload(RoomVO vo)throws Exception;
 
	//상세보기
	public RoomVO mgRoomRead(int roomnum)throws Exception;
	public List<uploadfileVO> mgRoomFile(int roomnum);

	//update
	public void mgRoomTextupdate(RoomVO vo);
	public void mgRoomFileupdate(HashMap<String, Object> hm);

	//delete
	public void mgRoomDelete(int roomnum);
	public void mgRoomFileDelete(int roomnum);
	
	

	

}
