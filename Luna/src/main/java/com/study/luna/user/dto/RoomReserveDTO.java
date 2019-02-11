package com.study.luna.user.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RoomReserveDTO {
	int roomNum;
    String reservstate;
    Date regdate;
}
