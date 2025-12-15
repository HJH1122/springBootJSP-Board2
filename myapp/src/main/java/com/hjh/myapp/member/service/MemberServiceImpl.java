package com.hjh.myapp.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hjh.myapp.member.mapper.MemberMapper;
import com.hjh.myapp.member.vo.LoginVO;

@Service("memberService")
@Qualifier("memberServiceImpl")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public LoginVO login(LoginVO vo) throws Exception {
		
		return mapper.login(vo);
	}

}
