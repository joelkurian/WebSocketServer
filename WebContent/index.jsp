<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
<title>Glitch - Remote Control for your Desktops</title>
</head>
<body>
	<div class="container">

		<form class="form-signin" method="post" action="SignIn">
			<h2 class="form-signin-heading">Sign in</h2>
			<input type="text" class="input-block-level"
				placeholder="Email address" name="email"> <input
				type="password" class="input-block-level" placeholder="Password"
				name="passwd"> <label class="checkbox"> <input
				type="checkbox" value="remember-me"> Remember me
			</label>
			<button class="btn btn-primary" type="submit">Sign in</button>
			<span> or <a href="register.jsp">Register?</a></span>
		</form>

	</div>
	<!-- /container -->
	<script src="js/jquery-2.0.0.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>