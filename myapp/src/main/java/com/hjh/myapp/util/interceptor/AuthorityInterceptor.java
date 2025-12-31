package com.hjh.myapp.util.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.hjh.myapp.member.controller.MemberController;
import com.hjh.myapp.member.vo.LoginVO;


public class AuthorityInterceptor implements HandlerInterceptor {
	
	private static final Logger log = LoggerFactory.getLogger(AuthorityInterceptor.class);
	
	private Map<String, Integer> authMap = new HashMap<>();
	
	{
//		authMap.put("/goods/writeForm.do", 9);
//		authMap.put("/goods/write.do", 9);
//		authMap.put("/goods/updateForm.do", 9);
//		authMap.put("/goods/update.do", 9);
//		authMap.put("/goods/delete.do", 9);
//		authMap.put("/goods/changeImage.do", 9);
//		authMap.put("/goods/addSize.do", 9);
//		authMap.put("/goods/addColor.do", 9);
//		authMap.put("/goods/changePrice.do", 9);
		
		authMap.put("/member/logout.do", 1);
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
	    if (!(handler instanceof HandlerMethod)) {
	        return true;
	    }
	    
	    String uri = request.getRequestURI();
	    Integer pageGradeNo = authMap.get(uri);
	    
	    if(pageGradeNo != null) {
	    	HttpSession session = request.getSession();
	    	LoginVO vo = (LoginVO) session.getAttribute("login");
	    	
	    	if(vo == null) {
	    		
	    		request.getRequestDispatcher("/WEB-INF/views/error/loginError.jsp").forward(request, response);
	    		
	    		return false;
	    	}
	    }
	    
		log.info("인터셉터..........");
		
		return true;

	} 
		
	

}
