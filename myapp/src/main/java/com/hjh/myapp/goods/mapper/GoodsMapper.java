package com.hjh.myapp.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
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

@Mapper
public interface GoodsMapper {

	public List<GoodsVO> list(@Param("pageObject") PageObject pageObject, @Param("searchVO") GoodsSearchVO searchVO) throws Exception;
	
	public Integer getTotalRow(@Param("searchVO") GoodsSearchVO searchVO);
	
	public Integer increase(@Param("goods_no") Long goods_no);

	public GoodsVO view(@Param("goods_no") Long goods_no) throws Exception;
	
	//상품 정보 등록
	public Integer write(GoodsVO vo) throws Exception;
	//상품 추가이미지 등록
	public Integer writeImage(List<GoodsImageVO> goodsImageList) throws Exception;
	//상품 사이즈&컬러 등록
	public Integer writeSizeColor(List<GoodsSizeColorVO> goodsSizeColorList) throws Exception;
	//상품 옵션 등록
	public Integer writeOption(List<GoodsOptionVO> goodsOptionList) throws Exception;
	//상품 가격 등록
	public Integer writePrice(GoodsVO vo) throws Exception;

	public Integer update(GoodsVO vo) throws Exception;

	public Integer delete(GoodsVO vo) throws Exception;
	
	public List<SizeVO> getSize(@Param("cate_code1") Integer cate_code1) throws Exception;
	
	public List<ColorVO> getColor(@Param("cate_code1") Integer cate_code1) throws Exception;

	public List<GoodsImageVO> viewImageList(@Param("goods_no") Long goods_no);

	public List<GoodsSizeColorVO> viewSizeColorList(@Param("goods_no") Long goods_no);

	public List<GoodsOptionVO> viewOptionList(@Param("goods_no") Long goods_no);

	
}
