<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de Livros</h1>
	<ul>
		<c:forEach var="liv" items="${lista}">
			<li>${liv.titulo}</li>
		</c:forEach>
	</ul>
	<br/>
	<br/>
	<input type="button" onclick="window.location.href='cadastro.jsp'" value="Cadastrar">
</body>
</html>