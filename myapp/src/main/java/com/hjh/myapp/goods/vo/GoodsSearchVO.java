package com.hjh.myapp.goods.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;


import lombok.Data;

@Data
public class GoodsSearchVO {
	
	private Integer cate_code1;
	private Integer cate_code2;
	private String goods_name;
	private Integer min;
	private Integer max;
	
	public String getQuery() throws Exception {
		return "cate_code1=" + toStr(cate_code1) + "&cate_code2=" + toStr(cate_code2) + "&goods_name=" + URLEncoder.encode(toStr(goods_name), "utf-8") + "&min=" + toStr(min) + "&max=" + toStr(max);
	}
	
	private String toStr(Object obj) throws Exception {
		return (obj == null)? "" : obj.toString();
	}
	
	//검색 데이터가 존재하는지 확인
	public Boolean isExist() {
		if(cate_code1 != null && cate_code1 != 0) return true;
		if (goods_name != null && !goods_name.isEmpty()) return true;
		if(!(min == null || min == 0)) return true;
		if(!(max == null || max == 0)) return true;
		return false;
	}
}
