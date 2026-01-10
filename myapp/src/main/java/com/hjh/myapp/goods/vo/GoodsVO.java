package com.hjh.myapp.goods.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Value;

@Data
public class GoodsVO {
	
	private Long goods_no;
	private Integer cate_code1;
	private Integer cate_code2;
	private String cate_name;
	private String goods_name;
	private String detail_image_name;
	private String content;
	private String company;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date product_date;
	private String image_name;
	private Long hit;
	private Integer price;
	private Integer sale_price;
	private Integer discount;
	private Integer discount_rate;
	private Integer delivery_charge;
	private Integer saved_rate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sale_startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sale_endDate;
	
	
}
