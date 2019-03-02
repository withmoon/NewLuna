package com.study.luna.user.qna.dao;

import java.util.List;

import com.study.luna.mg.model.QBoardVO;

public interface GetUserQnAllDAO {
	//사용자 문의 글 가져오기
	List<QBoardVO> getUserQnAll(int start,int end,String id);
}
