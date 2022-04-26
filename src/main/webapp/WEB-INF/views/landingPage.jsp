<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
div{
	padding: 20px;
	width: 800px;
	height: 220px;
	margin-left: auto;
	margin-right: auto;
	
	
}

body {
	background-color: #D9F5CA;
}

form {
	border-radius: 25px;
	border: 2px solid #73AD21;
	padding: 20px;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	padding: 100px;
	background: #AAE888;
	font-size: 120%;
}

table {
	margin-left: auto;
	margin-right: auto;
	padding: 50px;
}

h2 {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	font-size: 200%;
}

input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=password], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-family: Arial;
	cursor: pointer;
}
</style>

</head>
<body>
	<div><img src='${pageContext.request.contextPath}/images/gogoLogoLong.jpg' style="width: 800px; height: 220px;"></div>
	


	<form method="post" action="displaySummary">
		<c:set var="error" value="${error}"></c:set>
		<c:set var="errMsg" value="${errMsg}"></c:set>
		<h2>Login to Access Your GoGo Account</h2>
		
		
		<table>

			<tr>
				<td>Email</td>
				<td><input type="text" name="email" required
					value=henry@gmail.com /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required value=bort /></td>
			</tr>
			<c:choose>
				<c:when test="${error==true}">
					<tr>
						<td></td>
						<td style="color: red;">Invalid Email or Password</td>
					</tr>
				</c:when>
			</c:choose>
			
			<c:choose>
				<c:when test="${!empty errMsg}">
					<tr>
						<td></td>
						<td style="color: red;">Invalid Email or Password</td>
					</tr>
				</c:when>
			</c:choose>
			
			<tr>
				<td></td>
				<td colspan="2" align="center"><input type="submit"
					value="Login" /> &nbsp;&nbsp; <input type="reset" value="Reset" />
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td>Or click create account!</td>
				<td><a href="${pageContext.request.contextPath}/createAccount"
					class="btn btn-primary btn-sm active" role="button"
					aria-pressed="true">Create Account</a></td>
			</tr>

		</table>

	</form>

	


</body>
</html>