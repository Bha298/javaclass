<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="Post">
		<div align="center">
			<div>UserName:</div>
			<div>
				<input type="text" name="username">
			</div>

			<div>PassWord:</div>
			<div>
				<input type="password" name="password">
			</div>

			<div>
				<input type="submit" value="Login">
			</div>


		</div>
	</form>
</body>
</html>