package com.hjh.myapp.goods.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hjh.myapp.category.vo.CategoryVO;
import com.hjh.myapp.goods.vo.ColorVO;
import com.hjh.myapp.goods.vo.GoodsImageVO;
import com.hjh.myapp.goods.vo.GoodsOptionVO;
import com.hjh.myapp.goods.vo.GoodsSearchVO;
import com.hjh.myapp.goods.vo.GoodsSizeColorVO;
import com.hjh.myapp.goods.vo.GoodsVO;
import com.hjh.myapp.goods.vo.SizeVO;
import com.hjh.myapp.util.page.PageObject;


@org.springframework.stereotype.Service
public interface GoodsService {

	public List<GoodsVO> list(PageObject pageObject, GoodsSearchVO searchVO) throws Exception;

	public GoodsVO view(Long no, int inc) throws Exception;
	
	public Integer write(GoodsVO vo, List<GoodsImageVO> goodsImageList, List<GoodsSizeColorVO> goodsSizeColorList, List<GoodsOptionVO> goodsOptionList) throws Exception;

	public Integer update(GoodsVO vo) throws Exception;

	public Integer delete(GoodsVO vo) throws Exception;

	public List<SizeVO> getSize(Integer cate_code1) throws Exception;
	
	public List<ColorVO> getColor(Integer cate_code1) throws Exception;
}
