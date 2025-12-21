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

	<script type="text/javascript">
		
		$(function(){
			$(".nav-link").click(function(){

				let cate_code1 = $(this).data("cate_code1");
				location = "list.do?cate_code1=" + cate_code1;
			});
		});
		
	</script>

</head>

<body>
<div class="container">
	<div class="card">
		<div class="card-header">카테고리 관리</div>
		<div class="card-body">
			
			<!-- Nav tabs -->
			  <ul class="nav nav-tabs">
			  <c:forEach items="${bigList }" var="vo">
			    <li class="nav-item">
			      <a class="nav-link ${(vo.cate_code1 == param.cate_code1) ? 'active' : ''}" data-toggle="tab" href="#mid_category" data-cate_code1="${vo.cate_code1 }">
			      	${vo.cate_name }
			      </a>
			    </li>
			  </c:forEach>
			  </ul>
			
			  <!-- Tab panes -->
			  <div class="tab-content">
			    <div id="mid_category" class="container tab-pane active"><br>
			      <h3>카테고리 - 중분류</h3>
			      <ul>
			      	<c:forEach items="${midList }" var="vo">
			      	<li class="list-group-item">${vo.cate_name }</li>
			      	</c:forEach>
			      </ul>
			    </div>
			    <div id="menu1" class="container tab-pane fade"><br>
			      <h3>Menu 1</h3>
			      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			    </div>
			    <div id="menu2" class="container tab-pane fade"><br>
			      <h3>Menu 2</h3>
			      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
			    </div>
			  </div>
			
		</div>
		<div class="card-footer">Footer</div>
	</div>

</div>
</body>
</html>
