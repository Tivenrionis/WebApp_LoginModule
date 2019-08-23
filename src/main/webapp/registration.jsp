<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div align="center" style="margin-top: 7%;">
		<h1 style="text-align: center; font-weight: bold;">Registration
			page</h1>

		<p style="color: green;; font-weight: bold; font-size: small;">${info}</p>

	</div>

	<div align="center" style="margin-top: 7%;">
		<form action="register"
			style="border-style: double; width: 30%; align-items: center;">

			<br><br> Name: <input type="text" name="name"
				oninvalid="this.setCustomValidity('Enter your name')"
				oninput="setCustomValidity('')" maxlength="20" required><br>
			<p style="color: red; font-weight: bold; font-size: small;">${wrong_name}</p>

			Surname: <input type="text" name="surname"
				oninvalid="this.setCustomValidity('Enter your surname')"
				oninput="setCustomValidity('')" maxlength="40" required><br>
			<p style="color: red; font-weight: bold; font-size: small;">${wrong_surname}</p>

			Email: <input type="email" name="email"
				oninvalid="this.setCustomValidity('Enter your email')"
				oninput="setCustomValidity('')"
				pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2, 3}$" required><br>
			<p style="color: red; font-weight: bold; font-size: small;">${wrong_email}</p>

			Login name: <input type="text" style="" name="username"
				oninvalid="this.setCustomValidity('Enter the username')"
				oninput="setCustomValidity('')" required><br>
			<p style="color: red; font-weight: bold; font-size: small;">${message}</p>

			Password: <input type="password" style="" name="pwd"
				oninvalid="this.setCustomValidity('Enter the password')"
				oninput="setCustomValidity('')" required><br> <br>
			Confirm your password: <input type="password" style=""
				name="pwd_validate"
				oninvalid="this.setCustomValidity('Confirm your password')"
				oninput="setCustomValidity('')" required><br>
			<p style="color: red; font-weight: bold; font-size: small;">${pass}</p>

			<br> <br> <input type="submit" value="Register"><br>
			<br>





		</form>
	</div>

</body>
</html>