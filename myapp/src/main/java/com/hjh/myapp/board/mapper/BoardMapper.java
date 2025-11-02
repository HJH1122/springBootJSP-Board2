package com.hjh.myapp.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hjh.myapp.board.vo.BoardVO;
import com.hjh.myapp.util.page.PageObject;

@Mapper
public interface BoardMapper {
	
	public List<BoardVO> list(PageObject pageObject) throws Exception;
	
	public long getTotalRow(PageObject pageObject) throws Exception;
	
	public int increase(long no) throws Exception;
	
	public BoardVO view(long no) throws Exception;

}
