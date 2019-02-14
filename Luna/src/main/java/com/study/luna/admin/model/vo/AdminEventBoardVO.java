package com.study.luna.admin.model.vo;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminEventBoardVO {
   private int seq;
   private String title;
   private String writer;
   private String content;
   private Date startdate;
   private Date enddate;
   private String image;
   private String files;
	
	@Override
	public String toString() {
		return "AdminEventBoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", startdate=" + startdate + ", enddate=" + enddate + ", image=" + image + ", files=" + files + "]";
	}
	
}
