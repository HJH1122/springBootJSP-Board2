package com.hjh.myapp.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hjh.myapp.member.service.MemberService;
import com.hjh.myapp.member.vo.LoginVO;


@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	@Qualifier("memberService")
	private MemberService service;
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	
	
	@GetMapping("/loginForm.do")
	public String loginForm() throws Exception{
		
		log.info("로그인 폼");
		
		return "member/loginForm";
	}
	
	@PostMapping("/login.do")
	public String login(LoginVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		
		log.info("로그인 vo:");

		LoginVO loginVO = service.login(vo);
		
		if(loginVO == null) {
			rttr.addFlashAttribute("msg","로그인을 다시 하세요.");
			return "redirect:/member/loginForm.do";
		}
		
		session.setAttribute("login", loginVO);
		rttr.addFlashAttribute("msg","로그인 되었습니다.");
		
		return "redirect:/";
	}
	
	
}
