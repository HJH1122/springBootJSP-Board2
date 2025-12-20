package com.hjh.myapp.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hjh.myapp.category.vo.CategoryVO;

@Mapper
public interface CategoryMapper {

	public List<CategoryVO> list(@Param("cate_code1") Integer cate_code1) throws Exception;

	public Integer writeBig(CategoryVO vo) throws Exception;

	public Integer writeMid(CategoryVO vo) throws Exception;

	public Integer update(CategoryVO vo) throws Exception;

	public Integer delete(CategoryVO vo) throws Exception;

}
