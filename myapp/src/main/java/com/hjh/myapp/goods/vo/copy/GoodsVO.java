package com.hjh.myapp.goods.vo.copy;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsVO {
	
	private Long goods_no;
	private Integer cate_code1;
	private Integer cate_code2;
	private String goods_name;
	private String detail_image_name;
	private String content;
	private String company;
	private Date product_date;
	private String image_name;
	private Long hit;
	private Long price;
	private Long discount;
	private Integer discount_rate;
	private Long delivery_charge;
	private Integer save_rate;
	private Date sale_startDate;
	private Date sale_endDate;
}
