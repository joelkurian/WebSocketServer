<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
<title>Register</title>
</head>
<body>
<div class="container">
<form class="form-horizontal" method="post" action="Register">
  <div class="control-group">
    <label class="control-label" for="inputEmail">Email</label>
    <div class="controls">
      <input type="text" id="inputEmail" placeholder="Enter Email" name="email">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputPassword">Password</label>
    <div class="controls">
      <input type="password" id="inputPassword" placeholder="Enter Password" name="passwd">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputRetypePassword">Re-enter Password</label>
    <div class="controls">
      <input type="password" id="inputRetypePassword" placeholder="Re-enter Password">
    </div>
  </div>
  <div class="control-group">
    <div class="controls">
      <label class="checkbox">
        <input type="checkbox"> Accept blah blah...
      </label>
      <button type="submit" class="btn">Sign up</button>
    </div>
  </div>
</form>
</div>
<script src="js/jquery-2.0.0.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>