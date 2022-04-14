<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction History</title>
<style></style>
</head>
<body>
<h1>This is the displayTransactions page. The transaction spreadsheet page</h1>
	<form>
		<div><a href="${pageContext.request.contextPath}/displaySummary/"
			class="btn btn-primary btn-sm active" role="button"
			aria-pressed="true">Back to Home</a></div>
	</form>
	
	<br><br><br>
	<table>
			<tr>
			<th>name</th>
			<th>amount</th>
			<th>user_id</th>
			<th>category_id</th>
			<th>recurring</th>
			<th>recur_interval</th>
			<th>recur_day</th>
			<th>recur_count</th>
			<th>transaction_date</th>
			<th>entry_date</th>
			
		</tr>
		<c:forEach var="o" items="${outcomes}">
		<tr>
			<th>${o.name}</th>
			<th>amount</th>
			<th>user_id</th>
			<th>category_id</th>
			<th>recurring</th>
			<th>recur_interval</th>
			<th>recur_day</th>
			<th>recur_count</th>
			<th>transaction_date</th>
			<th>entry_date</th>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>