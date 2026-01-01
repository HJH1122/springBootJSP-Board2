package com.hjh.myapp.goods.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hjh.myapp.category.service.CategoryService;
import com.hjh.myapp.category.vo.CategoryVO;
import com.hjh.myapp.goods.service.GoodsService;
import com.hjh.myapp.goods.vo.GoodsVO;
import com.hjh.myapp.member.service.MemberService;
import com.hjh.myapp.member.vo.LoginVO;
import com.hjh.myapp.util.page.PageObject;


@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	@Qualifier("goodsService")
	private GoodsService service;
	
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	
	
	@GetMapping("/list.do")
	public String list(Model model, HttpServletRequest request) throws Exception{
		
		log.info("상품 리스트");
		
		PageObject pageObject = PageObject.getInstance(request);
		

		model.addAttribute("list", service.list(pageObject));
		
		model.addAttribute("pageObject", pageObject);
		return "goods/list";
	}
	
	@GetMapping("/view.do")
	public String view(Model model, Long no, int inc) throws Exception{
		
		log.info("write vo:");

		
		model.addAttribute("vo", service.view(no, inc));
		
		
		return "goods/view";
	}
	
	@GetMapping("/writeForm.do")
	public String writeForm(Model model) throws Exception{
		
		//대분류 가져와서 JSP에 넘기기
		model.addAttribute("bigList", categoryService.list(0));
		return "goods/writeForm";
	}

	
	@PostMapping("/write.do")
	public String write(GoodsVO vo, RedirectAttributes rttr) throws Exception{
		
		log.info("write vo:");

		
		service.write(vo);
		
		rttr.addFlashAttribute("msg","상품이 등록되었습니다.");
		
		return "redirect:list.do?cate_code1=" + vo.getCate_code1();
	}
	
	@PostMapping("/update.do")
	public String update(GoodsVO vo, RedirectAttributes rttr) throws Exception{
		
		log.info("상품 수정 :");

		if(service.update(vo) == 1){
			
			rttr.addFlashAttribute("msg","상품이 수정되었습니다.");
		}
		else {
			rttr.addFlashAttribute("msg","상품이 수정되지 않았습니다.");
		}
		
		return "redirect:view.do";
	}
	
	@PostMapping("/delete.do")
	public String delete(GoodsVO vo, RedirectAttributes rttr) throws Exception{
		
		log.info("상품 삭제 :");

		if(service.delete(vo) >= 1){
			
			rttr.addFlashAttribute("msg","상품이 삭제되었습니다.");
			
			return "redirect:list.do";
		}
		else {
			rttr.addFlashAttribute("msg","상품이 삭제되지 않았습니다.");
			
			return "redirect:view.do";
		}
		
		
	}
	
	
}
