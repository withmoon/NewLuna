package com.study.luna.user.board.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventBoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date startDate;
	private Date endDate;
}
