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
	public List<GoodsVO> list(PageObject pageObject) throws Exception {
		
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.list(pageObject);
	}
	
	@Override
	@Transactional
	public GoodsVO view(Long no, int inc) throws Exception {
		
		if(inc ==1) {
			mapper.increase(no);
		}
		
		return mapper.view(no);
	}

	@Override
	@Transactional
	public Integer write(GoodsVO vo) throws Exception {
		
		Integer result = mapper.write(vo);
			
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



}
