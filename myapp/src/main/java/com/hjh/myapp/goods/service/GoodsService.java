package com.hjh.myapp.goods.service;

import java.util.List;

import com.hjh.myapp.category.vo.CategoryVO;
import com.hjh.myapp.goods.vo.GoodsVO;
import com.hjh.myapp.util.page.PageObject;


@org.springframework.stereotype.Service
public interface GoodsService {

	public List<GoodsVO> list(PageObject pageObject) throws Exception;

	public GoodsVO view(Long no, int inc) throws Exception;
	
	public Integer write(GoodsVO vo) throws Exception;

	public Integer update(GoodsVO vo) throws Exception;

	public Integer delete(GoodsVO vo) throws Exception;

	public List<CategoryVO> getCategory(Integer cate_code1) throws Exception;
}
