<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<h1>글수정</h1>
<script>
	$(function(){
		$("#cancelBtn").click(function(){
			history.back();
		});
	});
</script>
</head>
<body>

<form action="update.do" method="post">
<input type="hidden" name="page" value="${param.page }">
<input type="hidden" name="perPageNum" value="${param.perPageNum }">

	<table>
	<tr>
		<th>번호</th>
		<td><input name="no" id="no" class="form-controll" readonly value="${vo.no }"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input name="title" id="title" class="form-controll" value="${vo.title }"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="5" style="width: 600px;" name="content" class="form-controll">${vo.content }</textarea></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input name="writer" id="writer" class="form-controll" value="${vo.writer }"></td>
	</tr>

	<tr>
		<td colspan="2"><button>등록</button></td>
		<td colspan="2"><button type="reset">초기화</button></td>
		<td colspan="2"><button type="button" id="cancelBtn">취소</button></td>
	</tr>
	
	</table>
	

</form>
	<br>
	<a href="/board/write.do">글쓰기</a>
</body>
</html>
