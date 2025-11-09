<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<h1>상세 보기</h1>
	
	<style type="text/css">
		#imageChangeDiv {
			display: none;
			
		}
	</style>
	
	<script type="text/javascript">
		$(function(){
			$("#imageChangeDivShowBtn").click(function(){
				$("#imageChangeDiv").show();
			});
			
		});
	</script>
</head>
<body>
<div class="container">

	<ul class="list-group">
		<li class="list-group-item">${vo.no }</li>
		<li class="list-group-item">${vo.title }</li>
		<li class="list-group-item">
			<img src="${vo.fileName }" />
			<div>
				<button id="imageChangeDivShowBtn">이미지 바꾸기</button>
				<div id="imageChangeDiv">
					<form action="imageChange.do" method="post" enctype="multipart/form-data">
						<input type="hidden" name="no" value="${vo.no }">
						<input type="hidden" name="page" value="${param.page }">
						<input type="hidden" name="perPageNum" value="${param.perPageNum }">
						<input type="hidden" name="key" value="${param.key }">
						<input type="hidden" name="word" value="${param.word }">
						<input type="hidden" name="deleteName" value="${vo.fileName }">
						<div class="form-group">
							<label for="imageFile">바꿀 파일</label>
							<input type="file" name="imageFile" id="imageFile" required="required" class="form-control">
						</div>
						<button class="btn btn-default">바꾸기</button>
						<button type="button" id="cancelBtn" class="btn btn-default">취소</button>
					</form>
				</div>
			</div>
		</li>
		<li class="list-group-item">${vo.content }</li>
		<li class="list-group-item">${vo.writer }</li>
		<li class="list-group-item"><fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd"/></li>
	</ul>

	<div>
		<a href="/board/update.do?no=${vo.no}&page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}" class="btn btn-default">글수정</a>
		<a href="/board/delete.do?no=${vo.no}&deleteName=${vo.deleteName}&perPageNum=${param.perPageNum}" class="btn btn-default">글삭제</a>
		<a href="/board/list.do?page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}" class="btn btn-default">리스트</a>
	</div>
</div>
</body>
</html>
