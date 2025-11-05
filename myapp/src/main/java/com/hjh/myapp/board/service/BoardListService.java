package com.hjh.myapp.board.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.hjh.myapp.Service;
import com.hjh.myapp.board.controller.BoardController;
import com.hjh.myapp.board.mapper.BoardMapper;
import com.hjh.myapp.util.page.PageObject;


@org.springframework.stereotype.Service
public class BoardListService implements Service{
	
	private static final Logger log = LoggerFactory.getLogger(BoardListService.class);
	
	private BoardMapper mapper;
	
	@Autowired
	public void setMapper(BoardMapper mapper) {
		this.mapper = mapper;
	}


	@Override
	public Object service(Object obj) throws Exception {
		
		PageObject pageObject = (PageObject) obj;	
		
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		
		log.info("pageObject: " + pageObject);
		
		return mapper.list(pageObject);
	}

}
