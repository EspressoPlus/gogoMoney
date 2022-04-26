<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction History</title>
<style>
table, th, td {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	font-size: 120%;
}

body {
	background-color: #D9F5CA;
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

h2 {
	text-align:center;
	font-size: 120%;
}
p{
	font-weight: bold;
}
</style>
<style>

</style>
<style><%@include file="/resources/css/styleBody.css"%></style>
<style><%@include file="/resources/css/styleForm.css"%></style>
<style><%@include file="/resources/css/styleTable.css"%></style>

</head>
<body>
<div><img src='${pageContext.request.contextPath}/images/gogoLogoLong.jpg' style="width: 800px; height: 220px;"></div>
<h1>${user.user_first_name}
		${user.user_last_name}</h1>
	<h1>Previous Transaction History</h1>
	
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
		<input type="submit" value="Home">
	</form:form>



	
	<br>
	<p>If you incorrectly entered in a transaction, delete it here and reenter it on the home page!</p>
	<h2>Outcome</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Amount</th>
			<th>Category</th>
			<th>Recurring</th>
			<th>Recur Interval</th>
			<th>Recur Day</th>
			<th>Recur Count</th>
			<th>Transaction Date</th>
			<th>Entry Date</th>
			<th></th>

		</tr>
		<c:forEach var="outcome" items="${outcome}">
			<tr id="hover">
				<td>${outcome.name}</td>
				<td>${outcome.amount}</td>
				<td>${outcome.category}</td>
				<td>${outcome.recurring}</td>
				<td>${outcome.recur_interval}</td>
				<td>${outcome.recurr_day}</td>
				<td>${outcome.recurr_count}</td>
				<td>${outcome.transaction_date}</td>
				<td>${outcome.entry_date}</td>
				<td><form:form
						action="${pageContext.request.contextPath}/deleteTransaction"
						method="post">
						<input type="hidden" name="incomeId"
							value="${outcome.financial_id}" />
						<input type="submit" value="Delete" />
					</form:form></td>
			</tr>
		</c:forEach>
	</table>
	<h2>Income</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Amount</th>
			<th>Category</th>
			<th>Recurring</th>
			<th>Recur Interval</th>
			<th>Recur Day</th>
			<th>Recur Count</th>
			<th>Transaction Date</th>
			<th>Entry Date</th>
			<th></th>

		</tr>
		<c:forEach var="income" items="${income}">
			<tr id="hover">
				<td>${income.name}</td>
				<td>${income.amount}</td>
				<td>${income.category}</td>
				<td>${income.recurring}</td>
				<td>${income.recur_interval}</td>
				<td>${income.recurr_day}</td>
				<td>${income.recurr_count}</td>
				<td>${income.transaction_date}</td>
				<td>${income.entry_date}</td>
				<td><form:form
						action="${pageContext.request.contextPath}/deleteTransaction"
						method="post">
						<input type="hidden" name="outcomeId"
							value="${income.financial_id}" />
						<input type="submit" value="Delete" />
					</form:form></td>
			</tr>
		</c:forEach>
	</table>




</body>
</html>