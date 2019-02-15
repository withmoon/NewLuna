package com.study.luna.user.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RoomReservLogDTO {
int seq;
String imp_uid;
String merchant_uid;
String branchName;
int roomNum; 
String id;
String reserveTime;
int payAmount;
int varAmount;
int status;
Date paid_at;
}
