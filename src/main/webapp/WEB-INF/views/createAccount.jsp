<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<body style="background-color:rgba(119,188,63,255);">
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
<style>
table.center {
  margin-left: auto; 
  margin-right: auto;
  table-layout: fixed;
}

h1 {
	font-family: Arial;
	text-align: center;
 }
td {
	font-family: Arial;
	text-align: center;
</style>
</head>
<body>
	<h1 style="color:white">Create your account!</h1>
	<form:form action="processAccount" modelAttribute="user" method="post">
		
		<table class=center>
			<tr>
				<td><img src=file:///C:/Users/dager/Desktop/GoGoMoney/gogoMoney-main/src/main/webapp/WEB-INF/images/GoGo%20Money-logos.jpeg style="width: 300px; height: 300px;" ></td>
				<td><table>
						<tr>
							<td style="font-family: verdana" ;style="color:white"><b>Enter
								First Name</b></td>
							<td><input type="text" name="user_first_name" required></td>
						</tr>
						<tr>
							<td style="font-family: Arial" ;style="color:white"><b>Enter
								Last Name<b></td>
							<td><input type="text" name="user_last_name" required></td>
						</tr>
						<tr>
							<td style="font-family: Arial" ;style="color:white"><b>Email<b></td>
							<td><input type="text" name="email" required></td>
						</tr>
						<tr>
							<td style="font-family: Arial" ;style="color:white"><b>Password<b></td>
							<td><input type="password" name="password" required></td>
						</tr>
						<tr>
							<td style="font-family: Arial" ;style="color:white"><b>Current Bank Account Balance<b></td>
							<td><input type="text" name="start_balance" required></td>
						</tr>
						<tr>
							<td style="font-family: Arial" ;style="color:white"><b>Total To Be Saved<b></td>
							<td><input type="text" name="amount_to_save" required></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" class="btn btn-primary btn-sm active" value="Add User"></td>
						</tr>
					</table>
					</td>
				<td><img src=file:///C:/Users/dager/Desktop/GoGoMoney/gogoMoney-main/src/main/webapp/WEB-INF/images/money%20logo%202.PNG style="width: 275px; height: 180px;"></td>
			</tr>
		</table>
		<div class="form-group-row">
		
		</div>


		
	</form:form>
</body>
</html>
