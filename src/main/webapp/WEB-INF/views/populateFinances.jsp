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
<title>Populate Finances</title>
<style>
p{
font-weight: bold;
}
table {
	text-align: center;
	width: 200%;
	margin-left: auto;
	margin-right: auto;
}

input {
	font-size: 80%;
}

tr {
	text-align: center;
	width: 100%;
}

td {
	text-align: left;
}

th {
	text-align: left;
	font-size: 110%;
}

.button {
	text-align: center;
}

#hover:hover {
	background-color: #a4f6fd;
}

div{
	padding: 20px;
	width: 800px;
	height: 220px;
	margin-left: auto;
	margin-right: auto;
	
	
}

body {
	background-color: #D9F5CA;
	text-align: center;
	font-size: 150%;
}
</style>

<style><%@include file="/resources/css/styleBody.css"%></style>
<style><%@include file="/resources/css/styleForm.css"%></style>
<style><%@include file="/resources/css/styleTable.css"%></style>
</head>
<body>
	<div><img src='${pageContext.request.contextPath}/images/gogoLogoLong.jpg' style="width: 800px; height: 220px;"></div>
	<h1>Let's populate your Finances, ${user.user_first_name}</h1>
	<p>Add and delete your recurring finances</p>
	<%-- <form:form action="/gogoMoney/processUser/${user.user_id}" modelAttribute="financial" method="post"> --%>
	<form:form action="processUser/${user.user_id}"
		modelAttribute="financial" method="post">
		<table>
			<tr>
				<th>Current Balance</th>
				<th>
				<th>Savings Goal</th>
				<th>
				<th>Surplus</th>
				<th>Months Until Goal</th>
			</tr>
			<tr>
				<td><fmt:formatNumber value="${user.start_balance}"
						type="currency" />
				<td>
				<td><fmt:formatNumber value="${user.amount_to_save}"
						type="currency" />
				<td>
				<td><fmt:formatNumber value="${surplus}" type="currency" /></td>
				<td>${time}</td>
			</tr>
		</table>
		<br>
		<p>Please Enter Bi-weekly or monthly income/expense and the day of
			month deposit</p>
		<br>
		<table>
			<tr>
				<th>Income or Expense?</th>
				<th>Name</th>
				<th>Amount $:</th>
				<th>Category</th>
				<th>Recurrence</th>
				<th>Interval: (optional)</th>
				<th>Day:</th>
				<th>How many recurrences: (optional)</th>
				<th>Transaction Date</th>
			</tr>
			<tr>
				<td><form:select path="income_outcome">
						<form:options items="${inOrOutList}" />
					</form:select></td>
				<td><form:input path="name" /></td>
				<td><form:input path="amount" /></td>
				<td><form:select path="category">
						<form:options items="${financeList}" />
					</form:select></td>
				<td><form:select path="recurring">
						<form:options items="${recurrList}" />
					</form:select></td>
				<td><form:select path="recur_interval">
						<form:options items="${intervalList}" />
					</form:select></td>
				<td><form:input path="recurr_day" /></td>
				<td><form:input path="recurr_count" /></td>
				<td><form:input path="transaction_date" type="date"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</table>
		<br>
		<input type="hidden" name="callingMap" value="populateFinances">
		<input type="submit" value="Add Another" />
		<br>
		<br>
	</form:form>
	<%-- <form:form action="/gogoMoney/displaySummary" modelAttribute="user" method="post"> --%>
	<form:form action="displaySummary" modelAttribute="user" method="post">
		<input type="hidden" name="user_id" value="${user.user_id}">
		<input type="hidden" name="user_first_name"
			value="${user.user_first_name}">
		<input type="hidden" name="user_last_name"
			value="${user.user_last_name}">
		<input type="hidden" name="email" value="${user.email}">
		<input type="hidden" name="password" value="${user.password}">
		<input type="hidden" name="start_balance"
			value="${user.start_balance}">
		<input type="hidden" name="amount_to_save"
			value="${user.amount_to_save}">
		<input type="submit" value="Done">
	</form:form>
	<br>
	<br>
	<table>
		<tr>
			<th>Transaction Type</th>
			<th>Name</th>
			<th>Amount</th>
			<th>Recurring?</th>
			<th>Interval</th>
			<th>Date</th>
			<th>Number of Recurrences</th>
			<th>Transaction Date</th>
			<th>Entry Date</th>
			<th></th>
		</tr>
		<c:forEach var="finance" items="${current}">
			<tr id="hover">
				<td>${finance.income_outcome}</td>
				<td>${finance.name}</td>
				<td>${finance.amount}</td>
				<td>${finance.recurring}</td>
				<td>${finance.recur_interval}</td>
				<td>${finance.recurr_day}</td>
				<td>${finance.recurr_count}</td>
				<td>${finance.transaction_date}</td>
				<td>${finance.entry_date}</td>
				<%-- <td><form action="/gogoMoney/deleteFinance" method="post"> --%>
				<td><form action="deleteFinance" method="post">
						<input type="hidden" name="financial_id"
							value="${finance.financial_id}" /> <input type="hidden"
							name="user_id" value="${user.user_id}" /> <input type="submit"
							value="Delete">
					</form></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>

</body>
</html>