<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style></style>
</head>
<body>

	<h1>Welcome @Name! This is home/displaySummary</h1>

	
	
	
	
	<br><br><br><br><br>
		<div>
			<a href="${pageContext.request.contextPath}/displayTransactions/"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">Transaction History</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/populateFinances/"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">Finances</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">Login/logout</a>
		</div>
	
</body>
</html>