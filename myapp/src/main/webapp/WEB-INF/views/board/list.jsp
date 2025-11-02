<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<h1>리스트</h1>
</head>
<body>

<table>
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
</tr>
<c:forEach items="${list}" var="vo">
<tr onclick="location='view.do?no=${vo.no}&inc=1'" class="dataRow">
	<th>${vo.no }</th>
	<th>${vo.title }</th>
	<th>${vo.writer }</th>
	<th><fmt:formatDate value="${vo.writeDate}" pattern="yyyy-MM-dd"/></th>
	<th>${vo.hit }</th>
</tr>
</c:forEach>

</table>

<a href="/board/write.do">글쓰기</a>

</body>
</html>
