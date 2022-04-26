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

#banner {
	
	padding: 10px;
	width: 800px;
	height: 220px;
	margin-left: auto;
	margin-right: auto;
}

body {
	background-color: #D9F5CA;
	
}

table.center {
	margin-left: auto;
	margin-right: auto;
	table-layout: fixed;
}

form {
	border-radius: 25px;
	border: 2px solid #73AD21;
	padding: 10px;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	padding: 100px;
	background: #AAE888;
	
}

h2 {
	font-family: Arial;
	text-align: center;
}

td {
	font-family: Arial;
	text-align: center;
	
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
	<div id="banner"><img src='${pageContext.request.contextPath}/images/gogoLogoLong.jpg' style="width: 800px; height: 220px;"></div>
	
	<form:form action="processAccount" modelAttribute="user" method="post">
		<h2 style="color: black">Create your account!</h2>
		<br>
		<table class=center>
			<tr>
				<td><img src='${pageContext.request.contextPath}/images/money%20logo%202.PNG' style="width: 300px; height: 300px;"></td>
				<td><table>
						<tr>
							<td style="font-family: verdana" ;style="color:white"><b>Enter
									First Name</b></td>
							<td><input type="text" name="user_first_name" required
								value=John></td>
						</tr>
						<tr>
							<td style="font-family: Arial" ;style="color:white"><b>Enter
									Last Name<b></td>
							<td><input type="text" name="user_last_name" required
								value=Doe></td>
						</tr>
						<tr>
							<td style="font-family: Arial" ;style="color:white"><b>Email<b></td>
							<td><input type="text" name="email" required value=jd@jd.com></td>
						</tr>
						<tr>
							<td style="font-family: Arial" ;style="color:white"><b>Password<b></td>
							<td><input type="password" name="password" required
								value=bort></td>
						</tr>
						<tr>
							<td style="font-family: Arial" ;style="color:white"><b>Current
									Bank Account Balance<b></td>
							<td><input type="text" name="start_balance" required
								value=2200></td>
						</tr>
						<tr>
							<td style="font-family: Arial" ;style="color:white"><b>Total
									To Be Saved<b></td>
							<td><input type="text" name="amount_to_save" required
								value=1500></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit"
								class="btn btn-primary btn-sm active" value="Add User"></td>
						</tr>
					</table></td>
				<td>
					<!-- src=file:///C:/Users/dager/Desktop/GoGoMoney/gogoMoney-main/src/main/webapp/WEB-INF/images/money%20logo%202.PNG -->
					<img src='${pageContext.request.contextPath}/images/money%20logo%202.PNG' style="width: 300px; height: 300px;"></td>
			</tr>
		</table>
		<div class="form-group-row"></div>



	</form:form>
	
	
	
</body>
</html>
