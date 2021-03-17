<%@page import="com.iu.s1.bankbook.BankBookDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	//리스트를 꺼내야함 내장객체인 리퀘스트에 있음
	List<BankBookDTO> ar = (List<BankBookDTO>)request.getAttribute("list");//이 이름,,,서비스에 적혀있음,,,
	
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
	
	<div class="container">
		<div class="row">
			<h1>BankBookList</h1>

			<!-- 반복문테이블에 넣을거라고? -->
			<table class="table table-hover">
				<thead>
					<tr>
						<!-- 한개의 로우입니다. -->
						<th>BookName</th>
						<!-- 제목일땐 th쓰자 -->
						<th>Rate</th>
						<th>Sal</th>
					</tr>
				</thead>

				<tbody>
					<% for(int i =0; i<ar.size(); i++){ %>
					<tr>
						<!-- 리스트에 있는 만큼 돌려야 하니까 반복문 필요 -->
						<td><a href="./bankbookSelect.do?bookNum=<%= ar.get(i).getBookNum() %>" ><%= ar.get(i).getBookName() %></a></td>
						<td><%= ar.get(i).getRate() %></td>
						<td><%= ar.get(i).getSal() %></td>
					</tr>
					<% } %>
				</tbody>

			</table>

			
			<a href="./bankbookWrite.do" class="btn btn-danger">Write</a>



		</div>

	</div>

</body>
</html>