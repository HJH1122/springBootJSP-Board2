<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<h1>리스트</h1>
</head>
<body>
${list}

<table>
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
</tr>
<tr onclick="location='view.do?no=10'">
	<th>10</th>
	<th>제목1</th>
	<th>내용</th>
	<th>2022-01-02</th>
	<th>10</th>
</tr>

</table>

<a href="/board/write.do">글쓰기</a>

</body>
</html>
