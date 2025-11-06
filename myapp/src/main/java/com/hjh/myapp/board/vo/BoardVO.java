package com.hjh.myapp.board.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVO {
	
	private long no;
	private String title, content, writer;
	Date writeDate;
	long hit;
	private MultipartFile imageFile;
	private String fileName;
	private String deleteName;
	

}
