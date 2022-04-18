<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
<style></style>
</head>
<body>
	<h1>Create your account!</h1>
	<form:form action="processUser" modelAttribute="user" method="post">
		<table>
			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="Fname" required /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="Lname" required /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" required /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required /></td>
			</tr>
		</table>
		<div class="form-group-row">
		<input type="submit" class="btn btn-primary btn-sm active"
			value="Add User" />
		</div>


		<div>
			<a href="${pageContext.request.contextPath}/populateFinances/"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">Finances</a>
		</div>
	</form:form>
</body>
</html>