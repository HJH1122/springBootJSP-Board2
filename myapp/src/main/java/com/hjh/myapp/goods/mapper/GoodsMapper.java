package com.hjh.myapp.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hjh.myapp.category.vo.CategoryVO;
import com.hjh.myapp.goods.vo.ColorVO;
import com.hjh.myapp.goods.vo.GoodsVO;
import com.hjh.myapp.goods.vo.SizeVO;
import com.hjh.myapp.util.page.PageObject;

@Mapper
public interface GoodsMapper {

	public List<GoodsVO> list(PageObject pageObject) throws Exception;
	
	public Integer getTotalRow(PageObject pageObject);
	
	public Integer increase(Long no);

	public GoodsVO view(Long no) throws Exception;
	
	public Integer write(GoodsVO vo) throws Exception;

	public Integer update(GoodsVO vo) throws Exception;

	public Integer delete(GoodsVO vo) throws Exception;
	
	public List<SizeVO> getSize(@Param("cate_code1") Integer cate_code1) throws Exception;
	
	public List<ColorVO> getColor(@Param("cate_code1") Integer cate_code1) throws Exception;

	
}
