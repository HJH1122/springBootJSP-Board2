<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<h1>상세 보기</h1>
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-..." crossorigin="anonymous" referrerpolicy="no-referrer" />
	
	<style type="text/css">
	
		#smallImageDiv img {
			width: 80px;
			height: 80px;
			margin: 3px;
		}
		
		#smallImageDiv img:hover {
			opacity: 70%;
			cursor: pointer;
		}
		
		#goodsDetailDiv div {
			padding: 5px;
			border-bottom: 1px solid #ccc;
		}
	</style>
	
	<script type="text/javascript">
		$(function(){
			//수정버튼
			$("#updateBtn").click(function(){
				location = "updateForm.do?no=${vo.goods_no}";
			});
			//삭제버튼
			$("#deleteBtn").click(function(){
				$("#pw").val("");
			});
			//리스트버튼
			$("#listBtn").click(function(){
				location = "list.do?page=${param.page}&perPageNum=${param.perPageNum}"
			});
			//이미지 보기 버튼(smallImageDiv => bigImageDiv)
			$("#smallImageDiv img").click(function(){
				$("#bigImageDiv img").attr("src", $(this).attr("src"));
			});
			
		});
		
		
	</script>
</head>
<body>
<div class="container">
	<div class="card">
		<div class="card-headr">상품 상세보기</div>
		<div class="card-body">
			<div class="row">
				<div class="col-md-6">
					<div id="smallImageDiv">
						<img src="${vo.image_name }" class="img-thumnail">
						<c:if test="${!empty imageList }">
							<c:forEach items="${itemList }" var="imageVO">
								<img src="${imageVO.image_name }" class="img-thumnail">
							</c:forEach>
						</c:if>
					</div>
					<div id="bigImageDiv" class="img-thumnail">
						<img src="${vo.image_name }" style="width: 100%;">
					</div>
				</div>
				<div class="col-md-6" id="goodsDetailDiv">
					<div>
						<i class="fa fa-check"></i>
						분류 : ${vo.goods_name }
					</div>
					<div>
						<i class="fa fa-check"></i>
						상품번호 : ${vo.goods_no }
					</div>
					<div>
						<i class="fa fa-check"></i>
						상품명 : ${vo.goods_name }
					</div>
					<div>
						<i class="fa fa-check"></i>
						제조사 : ${vo.company }
					</div>
					<div>
						<i class="fa fa-check"></i>
						제조년월 : 
						<fmt:formatDate value="${vo.product_date }" pattern="yyyy-MM-dd"/>
						
					</div>
					<div>
						<i class="fa fa-check"></i>
						정가 : 
						<fmt:formatNumber value="${vo.price }" />원
						
					</div>
					<div>
						<i class="fa fa-check"></i>
						할인가 : 
						<fmt:formatNumber value="${(empty vo.discount)? 0 : vo.discount }" />원
						
					</div>
					<div>
						<i class="fa fa-check"></i>
						할인율 : ${(empty vo.discount_rate)? 0 : vo.discount_rate } %
					</div>
					<div style="color: red;">
						<i class="fa fa-check"></i>
						판매가 : 
						<fmt:formatNumber value="${vo.sale_price }" />원
						
					</div>
					<div>
						<i class="fa fa-check"></i>
						적립금 : 
						<fmt:formatNumber value="${(empty vo.saved_rate)? 0 : (vo.price * (vo.saved_rate / 100))}" />원
						
						</div>
					<div>
						<i class="fa fa-check"></i>
						배송비 : 
						<fmt:formatNumber value="${vo.delivery_charge }" />원
						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form action="/cart/write.do" method="post">
						<c:if test="${!empty sizeColorList }">
							
						</c:if>
						<c:if test="${!empty optionList }">
							
						</c:if>
						<c:if test="${empty sizeColorList and empty optionList}">
							
						</c:if>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
				</div>
			</div>
		</div>
		<div class="card-footer">
			<button class="btn btn-primary" id="updateBtn">수정</button>
			<button class="btn btn-danger" id="deleteBtn" data-toggle="modal" data-target="#deleteModal">삭제</button>
			<button class="btn btn-warning" id="listBtn">리스트</button>
		</div>
	</div>
</div>

<!-- The Modal -->
<div class="modal" id="categoryModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">비밀번호 입력 모달</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

		<form method="post" id="modalForm">
		<input name="no" value="${vo.goods_no }" type="hidden">
	      <!-- Modal body -->
	      <div class="modal-body">
	        <input type="password" name="pw" class="form-control" id="pw">
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	      	<button class="btn btn-danger">삭제</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
	      </div>
      
      	</form>

    </div>
  </div>
</div>

</body>
</html>
