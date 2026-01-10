package com.hjh.myapp.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjh.myapp.category.mapper.CategoryMapper;
import com.hjh.myapp.category.vo.CategoryVO;
import com.hjh.myapp.goods.mapper.GoodsMapper;
import com.hjh.myapp.goods.vo.ColorVO;
import com.hjh.myapp.goods.vo.GoodsImageVO;
import com.hjh.myapp.goods.vo.GoodsOptionVO;
import com.hjh.myapp.goods.vo.GoodsSearchVO;
import com.hjh.myapp.goods.vo.GoodsSizeColorVO;
import com.hjh.myapp.goods.vo.GoodsVO;
import com.hjh.myapp.goods.vo.SizeVO;
import com.hjh.myapp.member.mapper.MemberMapper;
import com.hjh.myapp.member.vo.LoginVO;
import com.hjh.myapp.util.page.PageObject;

@Service("goodsService")
@Qualifier("goodsServiceImpl")
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsMapper mapper;

	@Override
	public List<GoodsVO> list(PageObject pageObject, GoodsSearchVO searchVO) throws Exception {
		
		pageObject.setTotalRow(mapper.getTotalRow(searchVO));
		return mapper.list(pageObject, searchVO);
	}
	
	@Override
	@Transactional
	public GoodsVO view(Long goods_no, int inc) throws Exception {
		
		if(inc ==1) {
			mapper.increase(goods_no);
		}
		
		return mapper.view(goods_no);
	}

	@Override
	@Transactional
	public Integer write(GoodsVO vo, List<GoodsImageVO> goodsImageList, List<GoodsSizeColorVO> goodsSizeColorList, List<GoodsOptionVO> goodsOptionList) throws Exception {
		
		Integer result = null;
		mapper.write(vo);
		//추가이미지
		if(goodsImageList != null && goodsImageList.size() > 0) {
			for(GoodsImageVO imageVO : goodsImageList) {
				imageVO.setGoods_no(vo.getGoods_no());
			}
			mapper.writeImage(goodsImageList);
		}
		//사이즈&컬러
		if(goodsSizeColorList != null && goodsSizeColorList.size() > 0) {
			for(GoodsSizeColorVO sizeColorVO : goodsSizeColorList) {
				sizeColorVO.setGoods_no(vo.getGoods_no());
			}
			mapper.writeSizeColor(goodsSizeColorList);
		}
		//옵션
		if(goodsOptionList != null && goodsOptionList.size() > 0) {
			for(GoodsOptionVO optionVO : goodsOptionList) {
				optionVO.setGoods_no(vo.getGoods_no());
			}
			mapper.writeOption(goodsOptionList);
		}
		//가격
		result = mapper.writePrice(vo);
			
		return result;
	}

	@Override
	public Integer update(GoodsVO vo) throws Exception {
		
		return mapper.update(vo);
	}

	@Override
	public Integer delete(GoodsVO vo) throws Exception {
		
		return mapper.delete(vo);
	}

	@Override
	public List<SizeVO> getSize(Integer cate_code1) throws Exception {
		
		return mapper.getSize(cate_code1);
	}

	@Override
	public List<ColorVO> getColor(Integer cate_code1) throws Exception {
		
		return mapper.getColor(cate_code1);
	}

	@Override
	public List<GoodsImageVO> viewImageList(Long goods_no) {
		
		return mapper.viewImageList(goods_no);
	}

	@Override
	public List<GoodsSizeColorVO> viewSizeColorList(Long goods_no) {
		
		return mapper.viewSizeColorList(goods_no);
	}

	@Override
	public List<GoodsOptionVO> viewOptionList(Long goods_no) {
		
		return mapper.viewOptionList(goods_no);
	}



}
