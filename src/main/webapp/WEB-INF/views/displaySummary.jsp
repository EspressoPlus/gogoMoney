<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
h1 {
	border: 2px solid green;
	border-radius: 8px;
	padding: 50px;
	width: 1000px;
	height: 50px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	font-size: 200%;
	background: #89DE5C;
}

body {
	background-color: #D9F5CA;
	text-align: center;
}

table {
	margin-left: auto;
	margin-right: auto;
	padding: 50px;
	font-size: 120%;
}
#buttons{
	text-align: center;
}

#gogoAmount {
	border-radius: 25px;
	background: #89DE5C;
	padding: 20px;
	width: 200px;
	height: 50px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	font-size: 200%;
}

p {
	font-size: 150%;
}
</style>
<style><%@include file="/resources/css/styleBody.css"%></style>
<style><%@include file="/resources/css/styleForm.css"%></style>
<style><%@include file="/resources/css/styleTable.css"%></style>
</head>
<body>

	<h1>Welcome ${pass.user_first_name}!</h1>


	<p>Your remaining GoGo Money is:
	<p>
	<p id="gogoAmount">
		<fmt:formatNumber value="${surplus}" type="currency" />
	</p>
	<br>

	<form:form action="processUser/${user.user_id}"
		modelAttribute="financial" method="post">
		<p>Enter a new small transaction:</p>
		<table>
			<tr>
				<th>Amount $:</th>
				<th>Name</th>
				<th>Category</th>
				<th>Income or Expense?</th>
			</tr>
			<tr>
				<td><form:input path="amount" /></td>
				<td><form:input path="name" /></td>
				<td><form:select path="category">
						<form:options items="${financeList}" />
					</form:select></td>
				<td><form:select path="income_outcome">
						<form:options items="${inOrOutList}" />
					</form:select></td>
				<td><input type="hidden" name="callingMap"
					value="displaySummary"> <input type="submit"
					value="Submit and Add Another" /></td>
			</tr>
		</table>



	</form:form>



	<br>

	<table>
		<tr>
			<td>
				<%-- <form> --%>
				<div>
					<%-- <form:form action="/gogoMoney/displayTransactions" modelAttribute="user" method="post"> --%>
					<form:form action="displayTransactions" modelAttribute="user"
						method="post">
						<input type="hidden" name="user_id" value="${pass.user_id}">
						<input type="hidden" name="user_first_name"
							value="${pass.user_first_name}">
						<input type="hidden" name="user_last_name"
							value="${pass.user_last_name}">
						<input type="hidden" name="email" value="${pass.email}">
						<input type="hidden" name="password" value="${pass.password}">
						<input type="hidden" name="start_balance"
							value="${pass.start_balance}">
						<input type="hidden" name="amount_to_save"
							value="${pass.amount_to_save}">
						<input type="submit" value="Transaction History">
					</form:form>
				</div>
			</td>

			<td>
				<div>
					<%-- <form:form action="/gogoMoney/populateFinances" modelAttribute="user" method="post"> --%>
					<form:form action="populateFinances" modelAttribute="user"
						method="post">
						<input type="hidden" name="user_id" value="${pass.user_id}">
						<input type="hidden" name="user_first_name"
							value="${pass.user_first_name}">
						<input type="hidden" name="user_last_name"
							value="${pass.user_last_name}">
						<input type="hidden" name="email" value="${pass.email}">
						<input type="hidden" name="password" value="${pass.password}">
						<input type="hidden" name="start_balance"
							value="${pass.start_balance}">
						<input type="hidden" name="amount_to_save"
							value="${pass.amount_to_save}">
						<input type="submit" value="Recurring Finances">
					</form:form>
				</div>
			</td>

			<td id="buttons">
				<div>
					<%-- <form:form action="/gogoMoney" modelAttribute="user" method="post"> --%>
					<form:form action="/gogo" modelAttribute="user" method="post">
						<input type="submit" value="Logout">
					</form:form>
				</div>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<div>
		Why not just send $ {pass} as value, instead of separate attributes? <br>
		${pass}
		<%-- <form:form action="/gogoMoney/displayTransactions" modelAttribute="user" method="post"> --%>
		<form:form action="displayTransactions" modelAttribute="user"
			method="post">
			<input type="hidden" name="user" value="${pass}">
			<input type="submit" value="Transaction History">
		</form:form>
	</div>


	<%-- </form> --%>

</body>
</html>