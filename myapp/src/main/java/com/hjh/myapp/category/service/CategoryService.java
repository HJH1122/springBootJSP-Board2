package com.hjh.myapp.category.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.hjh.myapp.Service;
import com.hjh.myapp.board.controller.BoardController;
import com.hjh.myapp.board.mapper.BoardMapper;
import com.hjh.myapp.member.vo.LoginVO;
import com.hjh.myapp.util.page.PageObject;


@org.springframework.stereotype.Service
public interface CategoryService {


	public LoginVO login(LoginVO vo) throws Exception;
}
