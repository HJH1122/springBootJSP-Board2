<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<h1>리스트</h1>
<style type="text/css">
	.dataRow:hover{
		background: #eee;
		cursor: pointer;
	}
</style>
<script type="text/javascript">
$(function(){
	
	$(".dataRow").click(function(){
		var no = $(this).find(".no").text();
		location = "view.do?no=" +no+ "&inc=1"
				+ "&page=${pageObject.page}"
				+ "&perPageNum=${pageObject.perPageNum}"
				+ "&key=${pageObject.key}"
				+ "&word=${pageObject.word}"
	});
});
</script>
</head>

<body>
<div class="container">
<table class="table">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
</tr>
<c:forEach items="${list}" var="vo">
<tr class="dataRow">
	<th class="no">${vo.no }</th>
	<th>${vo.title }</th>
	<th>${vo.writer }</th>
	<th><fmt:formatDate value="${vo.writeDate}" pattern="yyyy-MM-dd"/></th>
	<th>${vo.hit }</th>
</tr>
</c:forEach>

</table>

<a href="/board/write.do" class="btn btn-default">글쓰기</a>
</div>
</body>
</html>
