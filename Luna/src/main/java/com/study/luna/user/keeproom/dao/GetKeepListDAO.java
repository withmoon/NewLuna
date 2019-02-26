package com.study.luna.user.keeproom.dao;

import java.util.List;

import com.study.luna.user.dto.RoomInfoDTO;

public interface GetKeepListDAO {
	List<RoomInfoDTO> getKeeplist(int start, int end,String id);
}
