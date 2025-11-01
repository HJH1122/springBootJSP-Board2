<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<h1>글수정</h1>
</head>
<body>

<form action="update.do" method="post">
	<table>
	<tr>
		<th>번호</th>
		<td><input name="no" value="10" readonly="readonly"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input name="title" value="공지 제목"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="5" cols="80" name="content">내용 입니다.</textarea></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input name="writer">홍길동</td>
	</tr>
	<tr>
		<td colspan="2">
			<button>수정</button>
			<button type="reset">새로입력</button>
			<button type="button" onclick="history.back()">취소</button>
		</td>
	</tr>
	
	</table>
	

</form>
	<br>
	<a href="/board/write.do">글쓰기</a>
</body>
</html>
