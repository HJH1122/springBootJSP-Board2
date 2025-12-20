package com.hjh.myapp.category.service;

import java.util.List;

import com.hjh.myapp.category.vo.CategoryVO;


@org.springframework.stereotype.Service
public interface CategoryService {

	public List<CategoryVO> list(Integer cate_code1) throws Exception;

	public Integer write(CategoryVO vo) throws Exception;

	public Integer update(CategoryVO vo) throws Exception;

	public Integer delete(CategoryVO vo) throws Exception;

}
