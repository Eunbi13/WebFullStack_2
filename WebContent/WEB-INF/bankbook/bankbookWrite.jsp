<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.getAttribute("write");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Page 1-1</a></li>
						<li><a href="#">Page 1-2</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
				<li><a href="./bankbook/bankbookList.do">BankBook</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="./member/memberJoin.do"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="./member/memberLogin.do"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</nav>



	<form class="form-horizontal" action="./bankbookWrite.do" method="post">
		<div class="form-group">
			<label class="control-label col-sm-2" for="bookName">BookNmae:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="bookName"
					placeholder="Enter bookName" name="bookName">

			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="rate">Rate:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="rate"
					placeholder="Enter rate" name="rate">
			</div>
		</div>
		<div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="sel1">Select Sal:</label> 
				<div class="col-sm-10">
					<select class="form-control " id="sal" name="sal">
					<!-- 제일 중요한 게 name 잊지 말자 이거 없으면 파라미터로 정보가 안넘어간다! -->
					<option>Y</option>
					<option>N</option>
				</select>
				</div>
			</div>
		</div>
		<!-- <div class="form-group"> 체크박스를 써서 하는거는 위에,,ㅎ
			<label class="control-label col-sm-2" for="sal">Sal:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="sal"
					placeholder="Enter sal" name="sal">
			</div>
		</div> -->

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</div>
	</form>
</body>
</html>