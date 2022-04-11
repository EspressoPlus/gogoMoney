<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Populate Finances</title>
<style></style>
</head>
<body>
	<h1>This is the populate Finances page</h1>
	<form>
		<table>
			<tr>
				<td>Please Enter your current monetary bank amount</td>
			</tr>
			
			<tr>
				<td> <%-- <form:input path="currentBankAmount" /> --%> $: _____</td>
			</tr>
			
			<tr>
				<td>Please Enter Bi-weekly or monthly income and the day of
					month deposit</td>
			</tr>
			
			<tr>
				<td> <%--<form:input path="$" /> --%> $:______ </td>
				<td> <%--<form:input path="day" /> --%> Day: _______ </td>
				<td> <%--<form:input path="secondDay" /> --%> and second Day: _____ (optional) </td>
			</tr>
			
			<tr>
			<td>Please Enter any other income name, amount, and the day of deposit</td>
			</tr>
			
			<tr>
				<td> <%--<form:input path="otherIncomeName" --%> Name:______</td>
				<td> <%--<form:input path="otherIncomeAmount" --%> $:______</td>
				<td> <%--<form:input path="otherIncomeDay" --%> Day:_______</td>
			</tr>
			
			<tr>
				<td>Please Enter recurring bill name, amount, category it falls under, and day of the month occurrence</td>
			</tr>
			
			<tr>
				<td><%--form:input path="billName" --%> Bill Name:______</td>
				<td> <%--form:input path="billAmount" --%> Bill Amount:_______</td>
				<td></td>
			</tr>
		</table>
		<div>
			<a href="${pageContext.request.contextPath}/displaySummary/"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">Back to Home</a>
		</div>
	</form>
</body>
</html>