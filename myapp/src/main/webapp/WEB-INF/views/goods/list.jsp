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
	
	$("#perPageNum").change(function(){
		$("#searchForm").submit();
	});
	
	$("#key").val("${(empty pageObject.key)? 't' : pageObject.key}");
	$("#perPageNum").val("${(empty pageObject.perPageNum)? '10' : pageObject.perPageNum}");
	
});

</script>
</head>

<body>
<div class="container">
	 <form action="list.do" id="searchForm">
	 	<input name="page" value="1" type="hidden">
			<div class="row">
			  <div class="col-md-8">
			 	<div class="input-group mb-3">
			 		<div class="input-group-prepend">
				 		<select class="form-control" name="key" id="key">
				 			<option value="t">제목</option>
				 			<option value="c">내용</option>
				 			<option value="tc">제목/내용</option>
				 			<option value="f">파일명</option>
				 		</select>
				 	</div>
				 	<input type="text" class="form-control" placeholder="검색" id="word" name="word" value="${pageObejct.word }">
				 	<div class="input-group-append">
				 		<button class="btn btn-outline-primary">
				 			<i class="fa fa-search"></i>
				 		</button>
				 	</div>
			 	</div>
			 </div>
			
			 
			 <div class="col-md-4">
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
			          		적립금 : "${vo.saved_rate}%"
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
