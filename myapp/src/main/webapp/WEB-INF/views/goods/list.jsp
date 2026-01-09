<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>상품 리스트</title>
<style type="text/css">
	.dataRow:hover{
		opacity: 70%;
		cursor: pointer;
	}
	.imageDiv{
		background: black;
		
	}
	.title{
		text-overflow: ellipsis;
		overflow: hidden;
		display: -webkit-box;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 2;
	}
	
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript">
$(function(){
	
	let titleHeights = [];
	$(".title").each(function(idx, title){
		titleHeights.push($(title).height());
	});
	
	let maxTitleHeight = Math.max.apply(null, titleHeights);
	
	$(".title").height(maxTitleHeight);
	
	let imgWidth = $(".imageDiv:first").width();
	let imgHeight = $(".imageDiv:first").height();
	let height = imgWidth / 5 * 4;
	
	$(".imageDiv").height(height);
	$(".imageDiv > img").each(function(idx, image){
		if($(image).height() > height){
			let image_width = $(image).width();
			let image_height = $(image).height();
			let width = height / image_height * image_width;
			
			$(image).height(height);
			$(image).width(width);
		}
	});
	
	$(".dataRow").click(function(){
		let no = $(this).find(".no").text();
		location="view.do?no="+ no + "&${pageObject.pageQuery}";
	});
	
	//대분류 onchange일때 중분류도 바뀌도록
	$("#cate_code1").change(function(){
		$("#cate_code2").load("/ajax/getMidList.do?cate_code1=" + $("#cate_code1").val() + "&mode=1");
	});
	
	
	$("#perPageNum").change(function(){
		$("#searchForm").submit();
	});
	
	//검색버튼
	$("#searchBtn").click(function(){
		
		//검색내용이 없으면 검색안함
		if($("#cate_code1").val() == 0 && $("#goods_name").val().trim() == "" && $("#min").val() == 0 && $("#min").val() == ""  && $("#max").val() == 0 && $("#max").val() == "" ){
			return false;
		}
		
		//return false;
	});
	
	$("#cate_code1").val("${searchVO.cate_code1}");
	$("#cate_code2").val("${searchVO.cate_code2}");
	$("#goods_name").val("${searchVO.goods_name}");
	$("#min").val("${searchVO.min}");
	$("#max").val("${searchVO.max}");
	
});

</script>
</head>

<body>
<div class="container">
	 <form action="list.do" id="searchForm">
	 	<input name="page" value="1" type="hidden">
	 	<input name="perPageNum" value="${pageObject.perPageNum }" type="hidden">
			<div class="row">
			  <div class="col-md-12 form-inline">
			 	<div class="form-group">
			 		<label for="title">대분류</label>
					<select class="form-control" name="cate_code1" id="cate_code1" style="margin: 0 10px;">
						<option value="0">선택</option>
						<c:forEach items="${bigList}" var="vo">
							<option value="${vo.cate_code1 }">"${vo.cate_name }"</option>
						</c:forEach>
					</select>
			 	</div>
			 	<div class="form-group">
			 		<label for="title">중분류</label>
					<select class="form-control" name="cate_code2" id="cate_code2" style="margin: 0 10px;">
						<option value="0">선택</option>
					</select>
			 	</div>
			 	<div class="form-group">
			 		<label for="goods_name">상품명</label>
					<input class="form-control" id="goods_name" name="goods_name">	 		
			 	</div>
			 	<div class="form-group">
			 		<label for="min">최소가격</label>
					<input class="form-control" id="min" name="min" type="number" min="0">	 		
			 	</div>
			 	<div class="form-group">
			 		<label for="max">최대가격</label>
					<input class="form-control" id="max" name="max" type="number" min="0">	 		
			 	</div>
			 	<button id="searchBtn" class="btn btn-primary">검색</button>
			 </div>
			 </div>
			 <div class="row">
			 <div class="col-md-12">
			 	<div style="width: 200px;" class="float-right">
			 		<div class="input-group mb-3">
			 			<div class="input-group-prepend">
			 				<span class="input-proup-text">Rows/Page</span>
			 			</div>
			 			<select id="perPageNum" name="perPageNum" class="form-control">
			 				<option>6</option>
			 				<option>9</option>
			 				<option>12</option>
			 				<option>15</option>
			 			</select>
			 		</div>
			 	</div>
			 </div>
			</div>
	</form>
	<c:if test="${empty list }">
		<div class="jumbotron">
			<h4>데이터가 존재하지 않습니다.</h4>
		</div>
	</c:if>
	
	<c:if test="${!empty list }">
		 <div class="row">
		 <c:forEach items="${list }" var="vo" varStatus="vs">
		 	<c:if test="${(vs.index % 3 == 0) && (vs.index != 0) }">
			  		${"</div>"}
			  		${"<div class='row'>"}
			</c:if>
			  <div class="col-md-4 dataRow">
			    <div class="card" style="width:100%">
			    	<div class="imageDiv text-center align-content-center">
			        	<img class="card-img-top" src="${vo.image_name }" alt="image">
			    	
			    	</div>
			        <div class="card-body">
			          <strong class="card-title">
			          	<span class="float-right">${vo.hit }</span>
			          	${vo.goods_name }
			          </strong>
			          <p class="card-text title">
			          	<div>
			          		상품번호 : <span class="goods_no">${vo.goods_no }</span>
			          	</div>
			          	<div>
			          		정가 : <fmt:formatNumber value="${vo.price }" />원
			          	</div>
			          	<div>
			          		판매가 : <fmt:formatNumber value="${vo.sale_price }" />원
			          	</div>
			          	<div>
			          		적립금 : ${vo.saved_rate}%
			          	</div>
			          </p>
			        </div>
			    
			    </div>
			  </div>
			  
		  </c:forEach>
		  </div>
		  <div>
		  	<pageNav:pageNav listURI="list.do" pageObject="${pageObject }"/>
		  </div>
	</c:if>
    <%-- <c:if test="${!empty login && login.gradeNo == 9 }"> --%>
		<a href="writeForm.do?perPageNum=${pageObject.perPageNum }" class="btn btn-primary">등록</a>
	<%-- </c:if> --%>
</div>
</body>
</html>
