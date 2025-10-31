package com.hjh.myapp.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjh.myapp.util.page.PageObject;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@GetMapping("/list.do")
	public String list(PageObject pageObject) throws Exception{
		
		log.info("게시판 리스트 처리");
		
		return "board/list";
	}

	@GetMapping("/write.do")
	public String writeForm() throws Exception{
		
		log.info("게시판 글쓰기 폼");
		
		return "board/write";
	}
	
	@PostMapping("/write.do")
	public String write() throws Exception{
		
		log.info("게시판 글쓰기 처리");
		
		return "redirect:list.do";
	}
	
	
	@GetMapping("/view.do")
	public String view(long no) throws Exception{
		
		log.info("게시판 글보기 no:" , no);
		
		return "board/view";
	}
	
	@GetMapping("/update.do")
	public String updateForm(long no) throws Exception{
		
		log.info("게시판 수정 폼 no:" , no);
		
		return "board/update";
	}
	
	@PostMapping("/update.do")
	public String update() throws Exception{
		
		log.info("게시판 수정 처리");
		
		return "redirect:view.do?no=10";
	}
	
	@GetMapping("/delete.do")
	public String delete(long no) throws Exception{
		
		log.info("게시판 글삭제 처리 no:" , no);
		
		return "redirect:list.do";
	}
}
