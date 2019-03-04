package com.study.luna.pub.command;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReportReplyDTO {
	int seq;
	String reply;
	int reportseq;
	String branchname;
	String regdate;
	int replyseq;
}
