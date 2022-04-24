<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo money</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/styleBody.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/styleForm.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/styleTable.css">

</head>
<body>

	<h1>CPS 298 | EspressoPlus | gogoMoney</h1>
	<br>


	<form:form action="showTransactions" method="post">
		<select name="userId" id="userId">
			<optgroup>
				<option disabled selected>-- choose user --</option>
				<c:forEach var="u" items="${users}">
					<option value="${u}">${u}</option>
				</c:forEach>
			</optgroup>
		</select>

		<br>
		<br>
		<input type="submit" value="login" />
	</form:form>

</body>
</html>






