package com.hjh.myapp.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hjh.myapp.member.mapper.MemberMapper;
import com.hjh.myapp.member.vo.LoginVO;

@Service("categoryService")
@Qualifier("categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public LoginVO login(LoginVO vo) throws Exception {
		
		return mapper.login(vo);
	}

}
