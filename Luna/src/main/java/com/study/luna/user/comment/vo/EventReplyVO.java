package com.study.luna.user.comment.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventReplyVO {
	private Integer rno; //댓글 번호
	private Integer seq; //게시글 번호
	private String replytext; //댓글 내용
	private String replyer; //작성자
	private String userName; //댓글 작성자의 이름
	private Date regdate; //댓글 작성일자
	private Date updatedate; //댓글 수정일자
	private String writer; //게시글의 작성자 추가
}
