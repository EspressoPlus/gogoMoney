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
<style>
table, th, td {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	font-size: 110%;
}
p{
	text-align: center;
	color: #4a65b9;
}
</style>
</head>
<body>
	<h1>Welcome to GoGo Money!</h1>
	<form:form action="processUser" modelAttribute="user" method="post">
	<p>Please fill out the information below and select submit to create your account!</p>
	
		<table>
			<tr>
				<td> First Name</td>
				<td><input type="text" name="Fname" required /></td>
			</tr>
			<tr>
				<td> Last Name</td>
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
			value="Submit" />
			<p>You will be redirected to fill out the financial questionnaire</p>
		</div>


		<div>
			<a href="${pageContext.request.contextPath}/populateFinances/"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">Finances</a>  <%--I made this link so I could navigate through
				the pages but this will need to be removed it is not needed --%>
		</div>
	</form:form>
</body>
</html>