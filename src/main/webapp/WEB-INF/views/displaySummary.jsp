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
<style></style>
</head>
<body>

	<h1>Welcome ${pass.user_first_name}! This is home/displaySummary</h1>

	Your remaining GoGo Money is:
	<fmt:formatNumber value="${surplus}" type="currency"/>
	<br><br>
	
	<form:form action="processUser/${user.user_id}" modelAttribute="financial" method="post">
	Enter a new transaction:
 	<table>
		<tr>
			<td> Amount $:  </td>
			<td> Name </td>
			<td> Category </td>
			<td> Income or Expense? </td>
		</tr>
		<tr>
			<td><form:input path="amount"/></td>
			<td><form:input path="name"/></td>
			<td><form:select path="category">
				<form:options items="${financeList}"/>
			</form:select></td>
			<td><form:select path="income_outcome">
				<form:options items="${inOrOutList}"/>
			</form:select></td>
		</tr>
	</table>
	<br>
	<input type="hidden" name="callingMap" value="displaySummary">
	<input type="submit" value="Add Another" />

	</form:form>
	
	
	<br><br><br>
	

 	
	<br><br><br>


	<%-- <form> --%>
		<div>
			<%-- <form:form action="/gogoMoney/displayTransactions" modelAttribute="user" method="post"> --%>
			<form:form action="displayTransactions" modelAttribute="user" method="post">
				<input type="hidden" name="user_id" value="${pass.user_id}">
				<input type="hidden" name="user_first_name" value="${pass.user_first_name}">
				<input type="hidden" name="user_last_name" value="${pass.user_last_name}">
				<input type="hidden" name="email" value="${pass.email}">
				<input type="hidden" name="password" value="${pass.password}">
				<input type="hidden" name="start_balance" value="${pass.start_balance}">
				<input type="hidden" name="amount_to_save" value="${pass.amount_to_save}">
				<input type="submit" value="Transaction History">
			</form:form>
		</div>
		<br>
		<div>
			<%-- <form:form action="/gogoMoney/populateFinances" modelAttribute="user" method="post"> --%>
			<form:form action="populateFinances" modelAttribute="user" method="post">
				<input type="hidden" name="user_id" value="${pass.user_id}">
				<input type="hidden" name="user_first_name" value="${pass.user_first_name}">
				<input type="hidden" name="user_last_name" value="${pass.user_last_name}">
				<input type="hidden" name="email" value="${pass.email}">
				<input type="hidden" name="password" value="${pass.password}">
				<input type="hidden" name="start_balance" value="${pass.start_balance}">
				<input type="hidden" name="amount_to_save" value="${pass.amount_to_save}">
				<input type="submit" value="Finances">
			</form:form>
		</div>
		<br>
		<div>
			<%-- <form:form action="/gogoMoney" modelAttribute="user" method="post"> --%>
			<form:form action="/gogo" modelAttribute="user" method="post">
				<input type="submit" value="Login/Logout">
			</form:form>
		</div>
		<br><br><br>
		<div>
			Why not just send $ {pass} as value, instead of separate attributes?
			<br>
			${pass}
			<%-- <form:form action="/gogoMoney/displayTransactions" modelAttribute="user" method="post"> --%>
			<form:form action="displayTransactions" modelAttribute="user" method="post">
				<input type="hidden" name="user" value="${pass}">
				<input type="submit" value="Transaction History">
			</form:form>
		</div>
		
		
	<%-- </form> --%>
</body>
</html>