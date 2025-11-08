package com.hjh.myapp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjh.myapp.Service;
import com.hjh.myapp.board.service.BoardDeleteService;
import com.hjh.myapp.board.service.BoardViewService;
import com.hjh.myapp.board.service.BoardWriteService;
import com.hjh.myapp.board.vo.BoardVO;
import com.hjh.myapp.util.file.FileUtil;
import com.hjh.myapp.util.page.PageObject;


@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardDeleteService boardDeleteService_1;

    private final BoardWriteService boardWriteService_1;

    private final BoardViewService boardViewService_1;
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	private Service boardListService;
	private Service boardViewService;
	private Service boardWriteService;
	private Service boardUpdateService;
	private Service boardDeleteService;

    BoardController(BoardViewService boardViewService_1, BoardWriteService boardWriteService_1, BoardDeleteService boardDeleteService_1) {
        this.boardViewService_1 = boardViewService_1;
        this.boardWriteService_1 = boardWriteService_1;
        this.boardDeleteService_1 = boardDeleteService_1;
    }
	
	@Autowired
	public void setBoardListService(Service boardListService) {
		this.boardListService = boardListService;
	}
	@Autowired
	public void setBoardViewService(Service boardViewService) {
		this.boardViewService = boardViewService;
	}
	@Autowired
	public void setBoardWriteService(Service boardWriteService) {
		this.boardWriteService = boardWriteService;
	}
	@Autowired
	public void setBoardUpdateService(Service boardUpdateService) {
		this.boardUpdateService = boardUpdateService;
	}
	@Autowired
	public void setBoardDeleteService(Service boardDeleteService) {
		this.boardDeleteService = boardDeleteService;
	}

	@GetMapping("/list.do")
	public String list(PageObject pageObject, Model model) throws Exception{
		
		log.info("게시판 리스트 처리");
		
		if(pageObject.getPerPageNum() == 10) pageObject.setPerPageNum(8);
		
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
	public String write(BoardVO vo, HttpSession session, HttpServletRequest request, int perPageNum) throws Exception{
		
		log.info("게시판 글쓰기 처리 vo:"+ vo);
		vo.setFileName(FileUtil.upload("/upload/image", vo.getImageFile(), request));
		boardWriteService.service(vo);
		
		return "redirect:list.do?perPageNum="+perPageNum;
	}
	
	
	@GetMapping("/view.do")
	public String view(long no, Integer inc, Model model) throws Exception{
		
		log.info("게시판 글보기 no:" + no);
		model.addAttribute("vo", boardViewService.service(new Object[]{no, inc}));
		
		return "board/view";
	}
	
	@GetMapping("/update.do")
	public String updateForm(long no, Model model) throws Exception{
		
		log.info("게시판 수정 폼 no:" + no);
		model.addAttribute("vo", boardViewService.service(new Object[]{no, 0}));
		return "board/update";
	}
	
	@PostMapping("/update.do")
	public String update(BoardVO vo) throws Exception{
		
		log.info("게시판 수정 처리 vo="+ vo);
		boardUpdateService.service(vo);
		
		return "redirect:view.do?no="+vo.getNo()+"&inc=0";
	}
	
	@GetMapping("/delete.do")
	public String delete(long no) throws Exception{
		
		log.info("게시판 글삭제 처리 no:" + no);
		boardDeleteService.service(no);
		return "redirect:list.do";
	}
}
