package com.hjh.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjh.myapp.category.service.CategoryService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ajax")
@Log4j2
public class AjaxController {
	
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	
	@GetMapping("/getMidList.do")
	public String getMidList(Model model, Integer cate_code1) throws Exception{
		
		//중분류 가져와서 JSP에 넘기기
		model.addAttribute("midList", categoryService.list(cate_code1));
		return "goods/midList";
	}
}
