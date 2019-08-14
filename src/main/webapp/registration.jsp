<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div align="center">
		<p style="text-align: center; font-weight: bold;">Registration
			page</p>
			
			<p style="color: green;; font-weight: bold; font-size:small;">${info}</p>
			
	</div>

	<div align="center" style="margin-top: 10%;">
		<form action="register"
			style="border-style: double; width: 30%; align-items: center;">

			<br> Name: <input type="text" name="name"><br>
			<p style="color: red; font-weight: bold; font-size:small;">${wrong_name}</p>
			Surname: <input type="text" name="surname"><br>
			<p style="color: red; font-weight: bold; font-size:small;">${wrong_surname}</p>
			Email: <input type="text" name="email"><br>
			<p style="color: red; font-weight: bold; font-size:small;">${wrong_email}</p>
			Login name: <input type="text" style="" name="username"><br>
			<p style="color: red; font-weight: bold; font-size:small;">${message}</p>
			Password: <input type="password" style="" name="pwd"><br>
			<p style="color: red; font-weight: bold; font-size:small;">${pass}</p>
			Confirm your password: <input type="password" style="" name="pwd_validate"><br>
			<p style="color: red; font-weight: bold; font-size:small;">${pass}</p>
			<br> <br> <input type="submit" value="Register"><br>
			<br>

			



		</form>
	</div>

</body>
</html>