<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Secret Page</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache"); //http 1.0

		if (session.getAttribute("uname") == null) {
			response.sendRedirect("home.jsp");
		}
	%>
	<div align="center" style="margin-top: 10%" >
		<iframe width="560" height="315"
			src="https://www.youtube.com/embed/8fJy_j0h8oU"></iframe>
	</div>

	<div align="center">
		<form action="logout">
			<input type="submit" value="Logout">
		</form>
	</div>
</body>
</html>