package com.hjh.myapp.board.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hjh.myapp.Service;
import com.hjh.myapp.board.mapper.BoardMapper;


@org.springframework.stereotype.Service
public class BoardDeleteService implements Service {
	
	private BoardMapper mapper;
	
	@Autowired
	public void setMapper(BoardMapper mapper) {
		this.mapper = mapper;
	}


	@Override
	public Object service(Object obj) throws Exception {
		long no = (long) obj;
		
		return mapper.delete(no);
	}

}
