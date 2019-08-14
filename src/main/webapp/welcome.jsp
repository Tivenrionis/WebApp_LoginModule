<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//http 1.1
		response.setHeader("Pragma", "no-cache"); //http 1.0
		if (session.getAttribute("uname") == null) {
			response.sendRedirect("home.jsp");
		}
	%>

	<div align="center">
		;
		<p style="text-align: center; font-weight: bold; margin-top: 15%;">
			Welcome ${fn:toUpperCase(uname) } to the content page....<br>
			All features coming soon <br>
		</p>
	</div>
	<div align="center">
		<br> <a href="secret.jsp"> Another protected site</a>
	</div>
	<br>
	<br>
	<div align="center">
		<form action="logout">
			<input type="submit" value="Logout">
		</form>
	</div>

</body>
</html>