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
table, tr {
	text-align: center;
	width: 75%
}

td {
	text-align: left;
}

th {
	text-align: center;
	font-size: 110%;
}
.button{
	text-align:center;
}

tr:hover {
	background-color: #a4f6fd;
}
</style>
</head>
<body>
	<h1>Let's populate your Finances, ${user.user_first_name}</h1>
	<form:form action="/gogoMoney/processUser/${user.user_id}" modelAttribute="financial" method="post">
			<table>
				<tr>
					<td> Current Balance <td>
					<td> Savings Goal <td>
				</tr>
				<tr>
					<td><fmt:formatNumber value="${user.start_balance}" type="currency"/><td>
					<td><fmt:formatNumber value="${user.amount_to_save}" type="currency"/><td>
				</tr>
			</table>
			<br>
			<p>Please Enter Bi-weekly or monthly income/expense and the day of month deposit</p>
			<br>
			<table>
			<tr>
				<td> Income or Expense? </td>
				<td> Name </td>
				<td> Amount $:  </td>
				<td> Category </td>
				<td> Recurrence </td>
				<td> Interval:   (optional) </td>
				<td> Day:  </td>
				<td> How many recurrences:  (optional) </td>
				<td> Transaction Date </td>
			</tr>
			<tr>
				<td><form:select path="income_outcome">
					<form:options items="${inOrOutList}"/>
				</form:select></td>
				<td><form:input path="name"/></td>
				<td><form:input path="amount"/></td>
				<td><form:select path="category">
					<form:options items="${financeList}"/>
				</form:select></td>
				<td><form:select path="recurring">
					<form:options items="${recurrList}"/>
				</form:select></td>
				<td><form:select path="recur_interval">
					<form:options items="${intervalList}"/>
				</form:select></td>
				<td><form:input path="recurr_day"/></td>
				<td><form:input path="recurr_count"/></td>
				<td><form:input path="transaction_date" type="date" pattern="yyyy-MM-dd"/></td>
			</tr>
			</table>
		<br>
				<input type="submit" value="Add Another" />
				
	</form:form>
				<form action="/gogoMoney/displaySummary" method="post">
					<input type="submit" value="Done">
				</form>
	<br>
	<br>
	<table>
		<tr>
			<td>Transaction Type</td>
			<td>Name</td>
			<td>Amount</td>
			<td>Recurring?</td>
			<td>Interval</td>
			<td>Date</td>
			<td>Number of Recurrences</td>
			<td>Transaction Date</td>
			<td>Entry Date</td>
			<td> </td>
		</tr>
		<c:forEach var="finance" items="${current}">
		<tr>
			<td>${finance.income_outcome}</td>
			<td>${finance.name}</td>
			<td>${finance.amount}</td>
			<td>${finance.recurring}</td>
			<td>${finance.recur_interval}</td>
			<td>${finance.recurr_day}</td>
			<td>${finance.recurr_count}</td>
			<td>${finance.transaction_date}</td>
			<td>${finance.entry_date}</td>
			<td><form action="/gogoMoney/deleteFinance" method="post">
				<input type="hidden" name="financial_id" value="${finance.financial_id}"/>
				<input type="hidden" name="user_id" value="${user.user_id}"/>
				<input type="submit" value="Delete">
			</form>
		</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<div>
			<a href="${pageContext.request.contextPath}/displaySummary/"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">Back to Home</a>
	</div>
	
</body>
</html>