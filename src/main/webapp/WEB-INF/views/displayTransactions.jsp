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
	font-size: 150%;
}
tr:hover {
	background-color: #a4f6fd;
}
</style>
</head>
<body>
	<h1>This is the displayTransactions page. The transaction
		spreadsheet page</h1>
	<form>
		<div>
			<a href="${pageContext.request.contextPath}/displaySummary/"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">Back to Home</a>
		</div>
	</form>
	<table>
		<tr>
			<th>Day</th>
			<th>Transaction Name</th>
			<th>Amount</th>
			<th>Category</th>
		</tr>
		<%-- <c:forEach var="eachTrans" items="${transactions}"> --%>
		<tr>
			<td>
				<%--${eachTrans.day} --%>
			</td>
			<td>
				<%--${eachTrans.transactionName} --%>
			</td>
			<td>
				<%--${eachTrans.amount} --%>
			</td>
			<td>
				<%--${eachTrans.category} --%>
			</td>
			<td>
				<%--<form  action="deleteTrans" method="post" >--%>
				<%--<input type="hidden" name="transactionId" value="${eachTrans.id}"--%> 
				<input type="submit" value="Delete" />
				<%-- </form>--%>
			</td>
		</tr>
		<%-- </c:forEach> --%>
	</table>
	
</body>
</html>