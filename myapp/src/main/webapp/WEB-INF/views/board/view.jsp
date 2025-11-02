<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<h1>상세 보기</h1>
</head>
<body>

<table>
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

<a href="/board/update.do?no=10">글수정</a>
<a href="/board/delete.do?no=10">글삭제</a>

</body>
</html>
