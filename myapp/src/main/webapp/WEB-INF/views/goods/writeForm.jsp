<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>상품등록</title>

</head>

<body>
<div class="container">
	 <h3>상품등록</h3>	
	 <form action="write.do" method="post" enctype="multipart/form-data">
	 	<div class="form-group">
	 		<label for="title">제목</label>
			<input type="text" class="form-control" placeholder="ID 입력" id="title" name="title" autocomplete="none">	 		
	 	</div>
	  <div class="form-group">
	    	<label for="pw">Password</label>
			<input type="password" class="form-control" placeholder="패스워드 입력" id="pw" name="pw">
	  </div>
	  <button type="submit" class="btn btn-primary">로그인</button>
	</form>
</div>
</body>
</html>
