<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<h1>카테고리 관리</h1>
	
	<!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap JS (옵션: 툴팁, 모달 등을 위한 JS) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script type="text/javascript">
		
		$(function(){
			$(".bigCateData").click(function(){

				let cate_code1 = $(this).data("cate_code1");
				if(!$(this).hasClass("active")){
					location = "list.do?cate_code1=" + cate_code1;
				}
			});
			
			$(".cate_edit").click(function(){
				alert("수정");
				return false;
			});
			
			$("#bigWriteBtn").click(function(){
				
				$("#categoryModal").find(".modal-title").text("대분류 등록");
				$("#modalCate_code1").val(0);
				$("#modalCate_code2").val(0);
				
				$("#modalForm").attr("action", "write.do");
				
				$("#categoryModal").modal("show");
				return false;
			});
			
		});
		
	</script>

</head>

<body>
<div class="container">
	<div class="card">
		<div class="card-header">카테고리 관리</div>
		<div class="card-body">
			<p>
				대분류 탭을 수정하거나 삭제하려면 수정버튼을 클릭하십시요.
			</p>
			<!-- Nav tabs -->
			  <ul class="nav nav-tabs">
			  <c:forEach items="${bigList }" var="vo">
			    <li class="nav-item">
			      <a class="nav-link bigCateData ${(vo.cate_code1 == param.cate_code1) ? 'active' : ''}" data-toggle="tab" href="#mid_category" data-cate_code1="${vo.cate_code1 }">
			      	<span class="cate_name">${vo.cate_name }</span> 
			      <i class="fa fa-edit cate_edit"></i>
			      </a>
			    </li>
			  </c:forEach>
			  	<li class="nav-item">
			      <a class="nav-link " data-toggle="tab" href="#mid_category" id="bigWriteBtn" data-cate_code1="${vo.cate_code1 }">
			      	<i class="fa fa-plus"></i>
			      </a>
			    </li>
			  
			  </ul>
			
			  <!-- Tab panes -->
			  <div class="tab-content">
			    <div id="mid_category" class="container tab-pane active"><br>
			      <h3>
			      	카테고리 - 중분류
			      	<button class="btn btn-primary btn-sm">add</button>
			      </h3>
			      <ul>
			      	<c:forEach items="${midList }" var="vo">
				      	<li class="list-group-item">
				      		${vo.cate_name }
				      		<span class="pull-right">
				      			<button class="btn btn-success btn-sm">수정</button>
				      			<button class="btn btn-danger btn-sm">삭제</button>
				      		</span>
				      	</li>
			      	</c:forEach>
			      </ul>
			    </div>
			    
			  </div>
			
		</div>
		<div class="card-footer">Footer</div>
	</div>

</div>

<!-- The Modal -->
<div class="modal" id="categoryModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

		<form method="post" id="modalForm">
		<input name="cate_code1" value="0" type="hidden" id="modalCate_code1">
		<input name="cate_code2" value="0" type="hidden" id="modalCate_code2">
	      <!-- Modal body -->
	      <div class="modal-body">
	        <input name="cate_name" class="form-control" id="modalCate_name">
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	      	<button class="btn btn-primary">전송</button>
	        <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
	      </div>
      
      	</form>

    </div>
  </div>
</div>

</body>
</html>
