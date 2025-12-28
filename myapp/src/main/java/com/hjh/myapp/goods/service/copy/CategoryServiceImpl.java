package com.hjh.myapp.goods.service.copy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hjh.myapp.category.mapper.CategoryMapper;
import com.hjh.myapp.category.vo.CategoryVO;
import com.hjh.myapp.member.mapper.MemberMapper;
import com.hjh.myapp.member.vo.LoginVO;

@Service("categoryService")
@Qualifier("categoryServiceImpl")
public class CategoryServiceImpl implements GoodsService{
	
	@Autowired
	private CategoryMapper mapper;

	@Override
	public List<CategoryVO> list(Integer cate_code1) throws Exception {
		
		return mapper.list(cate_code1);
	}

	@Override
	public Integer write(CategoryVO vo) throws Exception {
		if(vo.getCate_code1() == 0) {
			return mapper.writeBig(vo);
		}
			
		return  mapper.writeMid(vo);
	}

	@Override
	public Integer update(CategoryVO vo) throws Exception {
		
		return mapper.update(vo);
	}

	@Override
	public Integer delete(CategoryVO vo) throws Exception {
		
		return mapper.delete(vo);
	}



}
