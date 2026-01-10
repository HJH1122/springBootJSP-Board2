package com.hjh.myapp.goods.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hjh.myapp.category.service.CategoryService;
import com.hjh.myapp.category.vo.CategoryVO;
import com.hjh.myapp.goods.service.GoodsService;
import com.hjh.myapp.goods.vo.GoodsImageVO;
import com.hjh.myapp.goods.vo.GoodsOptionVO;
import com.hjh.myapp.goods.vo.GoodsSearchVO;
import com.hjh.myapp.goods.vo.GoodsSizeColorVO;
import com.hjh.myapp.goods.vo.GoodsVO;
import com.hjh.myapp.member.service.MemberService;
import com.hjh.myapp.member.vo.LoginVO;
import com.hjh.myapp.util.file.FileUtil;
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
	
	String path = "/upload/goods";
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	
	
	@GetMapping("/list.do")
	public String list(Model model, @ModelAttribute(name = "searchVO") GoodsSearchVO searchVO, HttpServletRequest request) throws Exception{
		
		log.info("상품 리스트");
		
		PageObject pageObject = PageObject.getInstance(request);
		
		String strPerPageNum = request.getParameter("perPageNum");
		if(strPerPageNum == null || strPerPageNum.equals("")) {
			pageObject.setPerPageNum(6);
		}
		//대분류 가져와서 JSP에 넘기기
		model.addAttribute("bigList", categoryService.list(0));

		model.addAttribute("list", service.list(pageObject, searchVO));
		
		model.addAttribute("pageObject", pageObject);
		return "goods/list";
	}
	
	@GetMapping("/view.do")
	public String view(Model model, Long goods_no, int inc, @ModelAttribute(name = "searchVO") GoodsSearchVO searchVO) throws Exception{
		
		log.info("write vo:");

		
		model.addAttribute("vo", service.view(goods_no, inc));
		model.addAttribute("imageList", service.viewImageList(goods_no));
		model.addAttribute("sizeColorList", service.viewSizeColorList(goods_no));
		model.addAttribute("optionList", service.viewOptionList(goods_no));
		
		
		
		return "goods/view";
	}
	
	@GetMapping("/writeForm.do")
	public String writeForm(Model model) throws Exception{
		
		//대분류 가져와서 JSP에 넘기기
		model.addAttribute("bigList", categoryService.list(0));
		return "goods/writeForm";
	}

	
	@PostMapping("/write.do")
	public String write(GoodsVO vo, MultipartFile imageFile, MultipartFile detailImageFile, ArrayList<MultipartFile> imageFiles, @RequestParam(name = "size_nos", required = false) ArrayList<Long> size_nos, @RequestParam(name = "color_nos", required = false) ArrayList<Long> color_nos, @RequestParam(name = "option_names", required = false) ArrayList<String> option_names, Long perPageNum, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		
		log.info("write vo:" + vo);

		
		//service.write(vo);
		
		rttr.addFlashAttribute("msg","상품이 등록되었습니다.");
		log.info("대표이미지:" + imageFile.getOriginalFilename());
		log.info("상세설명:" + detailImageFile.getOriginalFilename());
		for(MultipartFile file: imageFiles)
			log.info(file.getOriginalFilename());
		log.info("사이즈:"+size_nos);
		log.info("컬러:"+color_nos);
		log.info("옵션:"+option_names);
		//상품 대표이미지
		vo.setImage_name(FileUtil.upload(path, imageFile, request));
		String fileName = detailImageFile.getOriginalFilename();
		//상품 상세이미지
		if(fileName != null && !fileName.equals("")) {
			vo.setDetail_image_name(FileUtil.upload(path, detailImageFile, request));
		}
		List<GoodsImageVO> goodsImageList = null;
		//첨부이미지 - GoodsImageVO
		if(imageFiles != null && imageFiles.size() > 0) {
			for(MultipartFile file: imageFiles) {
				if(goodsImageList == null) {
					goodsImageList = new ArrayList<>();
				}
				fileName = file.getOriginalFilename();
				if(fileName != null && !fileName.equals("")) {
					GoodsImageVO imageVO = new GoodsImageVO();
					imageVO.setImage_name(FileUtil.upload(path, file, request));
					goodsImageList.add(imageVO);
				}
			}
		}
		log.info("vo2:"+vo);
		log.info("goodsImageList2:"+goodsImageList);
		//사이즈&컬러 = 사이즈*컬러 GoodsSizeColorVO
		List<GoodsSizeColorVO> goodsSizeColorList = null;
		if(size_nos != null && size_nos.size() > 0) {
			for(Long sizeNo: size_nos) {
				if(goodsSizeColorList == null) {
					goodsSizeColorList = new ArrayList<>();
				}
				if(color_nos != null && color_nos.size() > 0) {
					for(Long colorNo: color_nos) {
						GoodsSizeColorVO sizeColorVO = new GoodsSizeColorVO();
						sizeColorVO.setSize_no(sizeNo);
						sizeColorVO.setColor_no(colorNo);
						goodsSizeColorList.add(sizeColorVO);
					}
				}else {
					GoodsSizeColorVO sizeColorVO = new GoodsSizeColorVO();
					sizeColorVO.setSize_no(sizeNo);
					goodsSizeColorList.add(sizeColorVO);
				}
				
				
			}
		}
		log.info("goodsSizeColorList2:"+goodsSizeColorList);
		
		//옵션 GoodsOptionVO
		List<GoodsOptionVO> goodsOptionList = null;
		if(option_names != null && option_names.size() > 0) {
			for(String option_name: option_names) {
				if(goodsOptionList == null) {
					goodsOptionList = new ArrayList<>();
				}
				if(option_names != null && !option_names.equals("")) {
					GoodsOptionVO optionVO = new GoodsOptionVO();
					optionVO.setOption_name(option_name);
					goodsOptionList.add(optionVO);
				}
				
			}
		}
		log.info("goodsOptionList2:"+goodsOptionList);
		
		//write에 넘길 데이터
		service.write(vo, goodsImageList, goodsSizeColorList, goodsOptionList);
		
		rttr.addFlashAttribute("msg", "상품 등록되었습니다");
		
		
		return "redirect:list.do?perPageNum=" + perPageNum;
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
