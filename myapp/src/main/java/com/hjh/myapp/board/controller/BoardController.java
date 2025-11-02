package com.hjh.myapp.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjh.myapp.Service;
import com.hjh.myapp.board.service.BoardViewService;
import com.hjh.myapp.board.vo.BoardVO;
import com.hjh.myapp.util.page.PageObject;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardViewService boardViewService_1;
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	private Service boardListService;
	private Service boardViewService;

    BoardController(BoardViewService boardViewService_1) {
        this.boardViewService_1 = boardViewService_1;
    }
	
	@Autowired
	public void setBoardListService(Service boardListService) {
		this.boardListService = boardListService;
	}
	@Autowired
	public void setBoardViewService(Service boardViewService) {
		this.boardViewService = boardViewService;
	}

	@GetMapping("/list.do")
	public String list(PageObject pageObject, Model model) throws Exception{
		
		log.info("게시판 리스트 처리");
		
		model.addAttribute("list", boardListService.service(pageObject));
		model.addAttribute("pageObject", pageObject);
		
		return "board/list";
	}

	@GetMapping("/write.do")
	public String writeForm() throws Exception{
		
		log.info("게시판 글쓰기 폼");
		
		return "board/write";
	}
	
	@PostMapping("/write.do")
	public String write(BoardVO vo) throws Exception{
		
		log.info("게시판 글쓰기 처리 vo:"+ vo);
		
		return "redirect:list.do";
	}
	
	
	@GetMapping("/view.do")
	public String view(long no, int inc, Model model) throws Exception{
		
		log.info("게시판 글보기 no:" + no);
		model.addAttribute("vo", boardViewService.service(new Object[]{no, inc}));
		
		return "board/view";
	}
	
	@GetMapping("/update.do")
	public String updateForm(long no) throws Exception{
		
		log.info("게시판 수정 폼 no:" + no);
		
		return "board/update";
	}
	
	@PostMapping("/update.do")
	public String update(BoardVO vo) throws Exception{
		
		log.info("게시판 수정 처리 vo="+ vo);
		
		return "redirect:view.do?no=10";
	}
	
	@GetMapping("/delete.do")
	public String delete(long no) throws Exception{
		
		log.info("게시판 글삭제 처리 no:" + no);
		
		return "redirect:list.do";
	}
}
