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
	
	//제조일 입력할때 현재날짜 이전만 가능
	$("#product_date").datepicker("option",{"maxDate" : new Date()});
	//판매시작일과 판매종료일은 현재날짜 이후만 가능
	$("#sale_startDate, #sale_endDate").datepicker("option",{"minDate" : new Date()});
	
	//대분류 onchange일때 중분류도 바뀌도록
	$("#cate_code1").change(function(){
		$("#cate_code2").load("/ajax/getMidList.do?cate_code1=" + $("#cate_code1").val());
	});
	
	$("#sale_startDate").change(function(){
		$("#sale_endDate").datepicker("option", "minDate", $(this).val());
	});
	$("#sale_endDate").change(function(){
		$("#sale_startDate").datepicker("option", "maxDate", $(this).val());
	});
	
	let appendImageTag = "";
	appendImageTag +=	`<div class="input-group" id="imageFilesDiv">`;
	appendImageTag +=		`<input class="form-control imageFiles" type="file" name="imageFiles">`;
	appendImageTag +=				`<div class="input-group-btn">`;
	appendImageTag +=				`<button type="button" class="btn btn-danger removeImageBtn">`;
	appendImageTag +=	        		 `<i>X</i>`;
	appendImageTag +=	    		`</button>`;
	appendImageTag +=		`</div>`;
	appendImageTag +=	`</div>`;
	
	let imageCnt = 1;
	
	//첨부이미지 추가
	$("#addImageBtn").click(function(){
		if(imageCnt >= 5){
			alert("첨부이미지는 최대 5개 까지만 가능합니다.");
			return false;
		}
		$("#imageFieldSet").append(appendImageTag);
		imageCnt ++;		
	});
	
	//첨부이미지 제거
	$("#imageFieldSet").on("click",".removeImageBtn", function(){
		$(this).closest(".input-group").remove();
		imageCnt --;
	});
	
});
</script>

</head>

<body>
<div class="container">
	 <h3>상품등록</h3>	
	 <form action="write.do" method="post" enctype="multipart/form-data">
	 	<fieldset class="border p-4">
			<legend class="w-auto px-2"><b style="font-size: 14pt;">[상품 기본정보 입력]</b></legend>	
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
			    <label for="detail_image_name">상세설명 이미지</label>
				<input class="form-control" id="detail_image_name" name="detail_image_name" type="file">
			</div>
			<div class="form-group">
			    <label for="content">상세설명</label>
				<input class="form-control" id="content" rows="7" name="content">
			</div>
			<div class="form-group">
			    <label for="image_name">대표 이미지</label>
				<input class="form-control" id="image_name" name="image_name" type="file">
			</div>
			
		</fieldset>	
		<fieldset class="border p-4">
			<legend class="w-auto px-2"><b style="font-size: 14pt;">[상품 가격정보 입력]</b></legend>
			<div class="form-group">
		 		<label for="price">정가</label>
				<input class="form-control" id="price" name="price" required>	 		
		 	</div>
		 	<div class="form-group">
		 		<label for="price">정가</label>
				<input class="form-control" id="price" name="price" required>	 		
		 	</div>
		 	<div class="form-group">
		 		<label for="discount">할인가</label>
				<input class="form-control" id="discount" name="discount">	 		
		 	</div>
		 	<div class="form-group">
		 		<label for="discount_rate">할인율</label>
				<input class="form-control" id="discount_rate" name="discount_rate">	 		
		 	</div>
		 	<div class="form-group">
		 		<label for="delivery_charge">배송료</label>
				<input class="form-control" id="delivery_charge" name="delivery_charge" required value="0">	 		
		 	</div>
		 	<div class="form-group">
		 		<label for="saved_rate">적립율</label>
				<input class="form-control" id="saved_rate" name="saved_rate" value="0">	 		
		 	</div>
		 	<div class="form-group">
		 		<label for="sale_startDate">판매 시작일</label>
				<input class="form-control datepicker" id="sale_startDate" name="sale_startDate" required readonly>	 		
		 	</div>
		 	<div class="form-group">
		 		<label for="sale_endDate">판매 종료일</label>
				<input class="form-control datepicker" id="sale_endDate" name="sale_endDate" required readonly>	 		
		 	</div>
	 	</fieldset>
	 	<fieldset class="border p-4">
			<legend class="w-auto px-2"><b style="font-size: 14pt;">[상품 옵션 입력]</b></legend>
			
			
		</fieldset>	
		<fieldset class="border p-4" id="imageFieldSet">
			<legend class="w-auto px-2">
				<b style="font-size: 14pt;">[상품 첨부이미지 입력]</b>
				<button type="button" id="addImageBtn" class="btn btn-primary btn-sm">add Image</button>
			</legend>
			<div class="input-group">
				<input class="form-control imageFiles" type="file" name="imageFiles">
				
			</div>
		</fieldset>	
	  <button type="submit" class="btn btn-primary">등록</button>
	  <button type="reset" class="btn btn-warning">새로입력</button>
	  <button type="button" class="cancelBtn btn btn-success">취소</button>
	</form>
</div>
</body>
</html>
