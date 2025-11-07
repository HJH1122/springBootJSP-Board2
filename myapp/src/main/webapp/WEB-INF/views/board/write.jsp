<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<h1>글쓰기</h1>
</head>
<body>

<form action="write.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="perPageNum" value="${param.perPageNum }">
	<table>
	<tr>
		<th>제목</th>
		<td><input name="title"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="5" style="width: 600px;" name="content"></textarea></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input name="writer"></td>
	</tr>
	<tr>
        <th><label for="imageFile">첨부파일</label></th>
        <td><input name="imageFile" id="imageFile" class="form-control" type="file"></td>
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
