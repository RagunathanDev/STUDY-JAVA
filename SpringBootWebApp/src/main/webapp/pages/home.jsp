<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body
>

	<form action="addUser" method="post">
		<section
			style="display: grid; grid-gap: 10px; align-items: center; justify-items: center;">
			<div>
				<h2>Welcome to our websites</h2>
			</div>
			<div>
				<input type="text" placeholder="name" name="name">
			</div>
			<div>
				<input type="text" placeholder="email" name="email">
			</div>
			<div>
				<input type="password" placeholder="password" name="password">
			</div>
			<input type="submit">
		</section>
	</form>
</html>