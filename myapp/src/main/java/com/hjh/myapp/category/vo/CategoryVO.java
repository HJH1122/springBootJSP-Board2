package com.hjh.myapp.category.vo;

import lombok.Data;

@Data
public class CategoryVO {
	
	private String id;
	private String pw;
	private String name;
	private String photo;
	private Long newMsgCnt;
	private Integer gradeNo;
	
	//grade테이블
	private String gradeName; 

}
