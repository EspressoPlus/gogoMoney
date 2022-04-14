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
	<h1>This is the populate Finances page</h1>
	<div>
			<a href="${pageContext.request.contextPath}/displaySummary/"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">Back to Home</a>
		</div>
	<form>

		<p>Please Enter your current monetary bank amount</p>
		<table>
			<tr>
				<td> $:</td>	
			</tr>
			<tr>
				<td> <%-- <form:input path="currentBankAmount" /> --%> <input /></td>	
			</tr>
		</table>
			
				<p>Please Enter Bi-weekly or monthly income and the day of month deposit</p>
			
			<table>
			<tr>
				<td> $:  </td>
				<td> Day:  </td>
				<td> and second Day:  (optional) </td>
			</tr>
			<tr>
				<td><input /><%--<form:input path="amount" /> --%> </td>
				<td><input /><%--<form:input path="day" /> --%></td>
				<td><input /> <%--<form:input path="secondDay" /> --%></td>
			</tr>
			</table>
			
			<p>Please Enter any other income name, amount, and the day of deposit</p>
			
			<table>
			<tr>
				<td>  $: </td>
				<td>  Day: </td>
				<td>  Name: </td>
			</tr>
			<tr>
				<td><input /> <%--<form:input path="otherIncomeAmount" --%></td>
				<td><input /> <%--<form:input path="otherIncomeDay" --%></td>
				<td><input /> <%--<form:input path="otherIncomeName" --%> </td>
			</tr>
			</table>
			
				<p>Please Enter recurring bill name, amount, category it falls under, and day of the month occurrence</p>
			
			<table>
			<tr>
				<td> Bill Name: </td>
				<td>  Bill Amount:  </td>
			</tr>
			<tr>
				<td><input /> <%--form:input path="billName" --%> </td>
				<td> <input /> <%--form:input path="billAmount" --%></td>
			</tr>
		</table>
		<input type="submit" value="Save" />
		
	
	</form>
</body>
</html>