<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<h1>상세 보기</h1>
</head>
<body>
<div class="container">
<table class="table">
<tr>
	<th>번호</th>
	<th>${vo.no}</th>
</tr>
<tr>
	<th>제목</th>
	<th>${vo.title}</th>
</tr>
<tr>
	<th>내용</th>
	<th>${vo.content}</th>
</tr>
<tr>
	<th>작성자</th>
	<th>${vo.no}</th>
</tr>
<tr>
	<th>작성일</th>
	<th><fmt:formatDate value="${vo.writeDate}" pattern="yyyy-MM-dd"/></th>
</tr>
<tr>
	<th>조회수</th>
	<th>${vo.hit}</th>
</tr>
</table>

<a href="/board/update.do?no=${vo.no}&page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}" class="btn btn-default">글수정</a>
<a href="/board/delete.do?no=${vo.no}&perPageNum=${param.perPageNum}" class="btn btn-default">글삭제</a>
<a href="/board/list.do?page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}" class="btn btn-default">리스트</a>
</div>
</body>
</html>
