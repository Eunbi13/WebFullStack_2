<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<a href="./member/memberLogin.do">Member Login</a>
	
	<form action="./member/memberLogin.do" method="get">
		<input type="text" name="id">
		<input type="text" name="pw">
		<button>Login</button>
	</form>

	<form action="./member/memberJoin.do" method="get">
		<input type="text" name="id">
		<input type="password" name="pw">
		<input type="text" name="name">
		<input type="text" name="phone">
		<input type="text" name="email">
		<button>Join</button>
	</form>


	<h3><a href="./sub/test.jsp?name=iu&age=20">GO Test</a></h3>

</body>
</html>