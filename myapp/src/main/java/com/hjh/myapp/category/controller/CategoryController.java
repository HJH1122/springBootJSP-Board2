package com.hjh.myapp.category.controller;

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
import com.hjh.myapp.member.service.MemberService;
import com.hjh.myapp.member.vo.LoginVO;


@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	@Qualifier("categoryService")
	private CategoryService service;
	
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	
	
	@GetMapping("/list.do")
	public String list(@RequestParam(defaultValue = "0") Integer cate_code1, Model model) throws Exception{
		
		log.info("카테고리 리스트");
		
		List<CategoryVO> bigList = service.list(0);
		
		if(cate_code1 == 0 && (bigList != null && bigList.size() != 0)) {
			cate_code1 = bigList.get(0).getCate_code1();
		}
		
		List<CategoryVO> midList = service.list(cate_code1);
		
		model.addAttribute("bigList", bigList);
		model.addAttribute("midList", midList);
		
		model.addAttribute("cate_code1", cate_code1);
		return "category/list";
	}
	
	@PostMapping("/write.do")
	public String write(CategoryVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		
		log.info("write vo:");

		
		service.write(vo);
		
		rttr.addFlashAttribute("msg","카테고리 등록되었습니다.");
		
		return "redirect:list.do?cate_code1=" + vo.getCate_code1();
	}
	
	@PostMapping("/update.do")
	public String update(CategoryVO vo, RedirectAttributes rttr) throws Exception{
		
		log.info("카테고리 수정 :");

		if(service.update(vo) == 1){
			
			rttr.addFlashAttribute("msg","카테고리가 수정되었습니다.");
		}
		else {
			rttr.addFlashAttribute("msg","카테고리가 수정되지 않았습니다.");
		}
		
		return "redirect:list.do?cate_code1=" + vo.getCate_code1();
	}
	
	@PostMapping("/delete.do")
	public String delete(CategoryVO vo, RedirectAttributes rttr) throws Exception{
		
		log.info("카테고리 삭제 :");

		if(service.delete(vo) >= 1){
			
			rttr.addFlashAttribute("msg","카테고리가 삭제되었습니다.");
		}
		else {
			rttr.addFlashAttribute("msg","카테고리가 삭제되지 않았습니다.");
		}
		return "redirect:list.do" + ((vo.getCate_code2() > 0) ? ("?cate_code1=" + vo.getCate_code1()) : "");
		
	}
	
	
}
