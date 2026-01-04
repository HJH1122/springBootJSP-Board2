package com.hjh.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjh.myapp.category.service.CategoryService;
import com.hjh.myapp.goods.service.GoodsService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ajax")
@Log4j2
public class AjaxController {
	
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	
	@Autowired
	@Qualifier("goodsService")
	private GoodsService goodsService;
	
	@GetMapping("/getMidList.do")
	public String getMidList(Model model, Integer cate_code1) throws Exception{
		
		//중분류 가져와서 JSP에 넘기기
		model.addAttribute("midList", categoryService.list(cate_code1));
		return "goods/midList";
	}
	@GetMapping("/getSize.do")
	public String getSize(Model model, Integer cate_code1) throws Exception{
		
		//사이즈 가져와서 JSP에 넘기기
		model.addAttribute("sizeList", goodsService.getSize(cate_code1));
		return "goods/sizeList";
	}
	@GetMapping("/getColor.do")
	public String getColor(Model model, Integer cate_code1) throws Exception{
		
		//컬러 가져와서 JSP에 넘기기
		model.addAttribute("colorList", goodsService.getColor(cate_code1));
		return "goods/colorList";
	}

}
