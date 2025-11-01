package com.hjh.myapp.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private long no;
	String title, content, writer;
	Date writeDate;
	long hit;

}
