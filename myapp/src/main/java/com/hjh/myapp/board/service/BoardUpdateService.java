package com.hjh.myapp.board.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hjh.myapp.Service;
import com.hjh.myapp.board.mapper.BoardMapper;
import com.hjh.myapp.board.vo.BoardVO;


@org.springframework.stereotype.Service
public class BoardUpdateService implements Service {
	
	private BoardMapper mapper;

	@Autowired
	public void setMapper(BoardMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Object service(Object obj) throws Exception {
		BoardVO vo = (BoardVO) obj;
		return mapper.update(vo);
	}

}
