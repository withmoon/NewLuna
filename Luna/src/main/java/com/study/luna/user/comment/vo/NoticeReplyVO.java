package com.study.luna.user.comment.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeReplyVO {
	private int rno; //댓글 번호
	private int num; //게시글 번호
	private String replyer; //작성자
	private String replytext; //작성글
	private Date regdate; //날짜
}
