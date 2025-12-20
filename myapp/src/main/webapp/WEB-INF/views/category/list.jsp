<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<h1>카테고리 관리</h1>

</head>

<body>
<div class="container">
	<div class="card">
		<div class="card-header">카테고리 관리</div>
		<div class="card-body">
			
			<!-- Nav tabs -->
			  <ul class="nav nav-tabs">
			    <li class="nav-item">
			      <a class="nav-link active" data-toggle="tab" href="#home">Home</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" data-toggle="tab" href="#menu1">Menu 1</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" data-toggle="tab" href="#menu2">Menu 2</a>
			    </li>
			  </ul>
			
			  <!-- Tab panes -->
			  <div class="tab-content">
			    <div id="home" class="container tab-pane active"><br>
			      <h3>HOME</h3>
			      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			    </div>
			    <div id="menu1" class="container tab-pane fade"><br>
			      <h3>Menu 1</h3>
			      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			    </div>
			    <div id="menu2" class="container tab-pane fade"><br>
			      <h3>Menu 2</h3>
			      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
			    </div>
			  </div>
			
		</div>
		<div class="card-footer">Footer</div>
	</div>

</div>
</body>
</html>
