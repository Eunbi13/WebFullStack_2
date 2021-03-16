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
	<form action="./sub/loginTest.jsp" method="get">
		<input type="text" name="id">
		<input type="text" name="pw">
		<button>Login</button>
	</form>

	<h3><a href="./sub/test.jsp?name=iu&age=20">GO Test</a></h3>

</body>
</html>