package com.study.luna.pub.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class ReportDTO {
	//reportDAO
	int seq;
	String seqs;
	int num;
	String title;
	String content;
	String fname;
	MultipartFile ffname;
	String id;
	String regdate;
	int isreply;
	String fpath;
	String searchOption;
	String keyword;
}
