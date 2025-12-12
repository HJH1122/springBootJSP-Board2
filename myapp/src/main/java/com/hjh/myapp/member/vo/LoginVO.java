package com.hjh.myapp.member.vo;

import lombok.Data;

@Data
public class LoginVO {
	
	private String id;
	private String pw;
	private String name;
	private String photo;
	private Long newMsgCnt;
	private Integer gradeNo;
	
	//grade테이블
	private String gradeName; 

}
