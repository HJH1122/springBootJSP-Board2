<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>상품등록</title>

<script>
$(function(){
	
	//초기화면에서 중분류 데이터 세팅
	$("#cate_code2").load("/ajax/getMidList.do?cate_code1=" + $("#cate_code1").val());
	
	//대분류 onchange일때 중분류도 바뀌도록
	$("#cate_code1").change(function(){
		$("#cate_code2").load("/ajax/getMidList.do?cate_code1=" + $("#cate_code1").val());
	});
	
});
</script>
</head>

<body>
<div class="container">
	 <h3>상품등록</h3>	
	 <form action="write.do" method="post" enctype="multipart/form-data">
	 	<div class="form-inline">
		 	<div class="form-group">
		 		<label for="title">대분류</label>
				<select class="form-control" name="cate_code1" id="cate_code1" style="margin: 0 10px;">
					<c:forEach items="${bigList}" var="vo">
						<option value="${vo.cate_code1 }">"${vo.cate_name }"</option>
					</c:forEach>
				</select>
		 	</div>
		 	<div class="form-group">
		 		<label for="title">중분류</label>
				<select class="form-control" name="cate_code2" id="cate_code2" style="margin: 0 10px;">
					
				</select>
		 	</div>
	 	</div>
	 	<div class="form-group">
	 		<label for="goods_name">상품명</label>
			<input class="form-control" id="goods_name" name="goods_name" required>	 		
	 	</div>
	 	<div class="form-group">
	 		<label for="company">제조사</label>
			<input class="form-control" id="company" name="company" required>	 		
	 	</div>
	 	<div class="form-group">
	 		<label for="product_date">제조날짜</label>
			<input class="form-control datepicker" id="product_date" name="product_date" required readonly>	 		
	 	</div>
		<div class="form-group">
		    <label for="content">상세 설명</label>
			<input class="form-control" id="content" rows="7" name="content" required>
		</div>
	  <button type="submit" class="btn btn-primary">로그인</button>
	</form>
</div>
</body>
</html>
