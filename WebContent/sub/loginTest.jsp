<%@page import="com.iu.s1.member.MemberDTO"%>
<%@page import="com.iu.s1.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Test JSP Page</h1>
	
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto=dao.login(dto);

		String write = null;
		if(dto !=null){
		write	="success";
		} 
		
	%>
	<h3><%=id %></h3>
	<h3><%=pw %></h3>
	<h1><%=write %></h1>
	
	
</body>
</html>