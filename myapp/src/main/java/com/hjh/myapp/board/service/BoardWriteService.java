package com.hjh.myapp.board.service;

import com.hjh.myapp.Service;
import com.hjh.myapp.board.mapper.BoardMapper;
import com.hjh.myapp.board.vo.BoardVO;

import jakarta.inject.Inject;

@org.springframework.stereotype.Service
public class BoardWriteService implements Service {
	
	private BoardMapper mapper;

	@Inject
	public void setMapper(BoardMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Object service(Object obj) throws Exception {
		
		BoardVO vo = (BoardVO) obj;
		return mapper.write(vo);
	}

}
