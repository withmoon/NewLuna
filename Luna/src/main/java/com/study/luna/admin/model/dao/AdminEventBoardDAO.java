package com.study.luna.admin.model.dao;

import java.util.List;

import com.study.luna.admin.model.vo.AdminEventBoardVO;


public interface AdminEventBoardDAO {

    public void insert(AdminEventBoardVO adminEventBoardVO) throws Exception;//�ֱ�
    
    
   public List<AdminEventBoardVO> listAlls() throws Exception;//����Ʈ�ҷ�����
    
    //�󼼺���
    //����
    //����
}