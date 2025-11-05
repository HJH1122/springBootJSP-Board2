package com.hjh.myapp.board.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hjh.myapp.Service;
import com.hjh.myapp.board.mapper.BoardMapper;


@org.springframework.stereotype.Service
public class BoardViewService implements Service {
	
	private BoardMapper mapper;

	
	@Autowired
	public void setMapper(BoardMapper mapper) {
		this.mapper = mapper;
	}



	@Override
	public Object service(Object obj) throws Exception {

		
		Object[] objs = (Object[]) obj;
		
		long no = (Long) objs[0];
		int inc = (Integer) objs[1];
		
		if(inc == 1) {
			mapper.increase(no);
		}
		
		return mapper.view(no);
	}

}
