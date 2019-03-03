package com.study.luna.pub.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class ReportDTO {
	int seq;
	String title;
	String content;
	String orginfname;
	String fname;
	MultipartFile ffname;
	String id;
	
	
}
