
<%@ page import="com.gogo.entity.User"%>
<%@ page import="com.gogo.service.UserService"%>
<%@ page import="com.gogo.entity.Financial"%>
<%@ page import="com.gogo.service.MoneyServiceImpl"%>
<%@ page import="com.gogo.service.MoneyService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- https://canvasjs.com/jsp-charts/doughnut-chart/ -->
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%-- need to set user and "spending" here for use in scriptlet
     don't confuse this user with ${user } --%>
<c:set var="user" value="${pass}" />
<c:set var="spending" value="${spending}" />
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

Object userScriptlet = pageContext.getAttribute("user");
User userS = (User) userScriptlet; 
Object spendScriptlet = pageContext.getAttribute("spending");
HashMap<String,Double> spendS = (HashMap<String,Double>) spendScriptlet;

for(String c : spendS.keySet() ){
	map = new HashMap<Object,Object>(); 
	map.put("category", c);    // the hashmap's key is the label ... 
	map.put("y", spendS.get(c)); // ... and value is the "y-axis" (which is value)
	list.add(map);
}

String dataPoints = gsonObj.toJson(list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- https://canvasjs.com/jsp-charts/doughnut-chart/ -->
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme: "light2",
	backgroundColor: "transparent",
	title: {
		text: "Spending Summary"
	},
	subtitles: [{
		text: "$$$"
	}],
	data: [{
		type: "doughnut",
		yValueFormatString: "$#,##0",
		indexLabel: "{category}: {y}",
		toolTipContent: "{y}",
		indexLabelFontSize: 14,
		dataPoints : <%out.print(dataPoints);%>
	}]
});
chart.render();
 
}
</script>



<title>Home</title>
<style>
h1 {
	border: 2px solid green;
	border-radius: 8px;
	padding: 50px;
	width: 1000px;
	height: 50px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	font-size: 200%;
	background: #89DE5C;
}

body {
	background-color: #D9F5CA;
	text-align: center;
}

table {
	margin-left: auto;
	margin-right: auto;
	padding: 50px;
	font-size: 120%;
}
#buttons{
	text-align: center;
}

#gogoAmount {
	border-radius: 25px;
	background: #89DE5C;
	padding: 20px;
	width: 200px;
	height: 50px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	font-size: 200%;
}

p {
	font-size: 150%;
}
</style>
<style><%@include file="/resources/css/styleBody.css"%></style>
<style><%@include file="/resources/css/styleForm.css"%></style>
<style><%@include file="/resources/css/styleTable.css"%></style>
</head>
<body>
	

	<h1>Welcome ${pass.user_first_name}!</h1>


	<p>Your remaining GoGo Money is:
	<p>
	<p id="gogoAmount">
		<fmt:formatNumber value="${surplus}" type="currency" />
	</p>
	<br>

	<!-- https://canvasjs.com/jsp-charts/doughnut-chart/ -->
	<!-- <div id="chartContainer" style="height: 370px; width: 50%;"></div> -->
	<div id="chartContainer" style="height: 370px; width: 50%; margin:0 auto;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>


	<form:form action="processUser/${user.user_id}" modelAttribute="financial" method="post">
	<p>Enter a new small transaction:</p>
		<table>
			<tr>
				<th>Amount $:</th>
				<th>Name</th>
				<th>Category</th>
				<th>Income or Expense?</th>
				<th>Transaction Date</th>
			</tr>
			<tr>
				<td><form:input path="amount" /></td>
				<td><form:input path="name" /></td>
				<td><form:select path="category">
						<form:options items="${financeList}" />
					</form:select></td>
				<td><form:select path="income_outcome">
						<form:options items="${inOrOutList}" />
					</form:select></td>
				<td><form:input path="transaction_date" type="date" pattern="yyyy-MM-dd" /></td>
				<td><form:hidden path="recur_interval" value="Once"/></td>
				<td><form:hidden path="recurring" value="FALSE"/></td>			
			</tr>
		</table>
	<br>
	
	<input type="hidden" name="callingMap" value="displaySummary">
	<input type="submit" value="Submit and Add Another" />
	</form:form>
	




	<br>

	<table>
		<tr>
			<td>
				<%-- <form> --%>
				<div>
					<%-- <form:form action="/gogoMoney/displayTransactions" modelAttribute="user" method="post"> --%>
					<form:form action="displayTransactions" modelAttribute="user"
						method="post">
						<input type="hidden" name="user_id" value="${pass.user_id}">
						<input type="hidden" name="user_first_name"
							value="${pass.user_first_name}">
						<input type="hidden" name="user_last_name"
							value="${pass.user_last_name}">
						<input type="hidden" name="email" value="${pass.email}">
						<input type="hidden" name="password" value="${pass.password}">
						<input type="hidden" name="start_balance"
							value="${pass.start_balance}">
						<input type="hidden" name="amount_to_save"
							value="${pass.amount_to_save}">
						<input type="submit" value="Transaction History">
					</form:form>
				</div>
			</td>

			<td>
				<div>
					<%-- <form:form action="/gogoMoney/populateFinances" modelAttribute="user" method="post"> --%>
					<form:form action="populateFinances" modelAttribute="user"
						method="post">
						<input type="hidden" name="user_id" value="${pass.user_id}">
						<input type="hidden" name="user_first_name"
							value="${pass.user_first_name}">
						<input type="hidden" name="user_last_name"
							value="${pass.user_last_name}">
						<input type="hidden" name="email" value="${pass.email}">
						<input type="hidden" name="password" value="${pass.password}">
						<input type="hidden" name="start_balance"
							value="${pass.start_balance}">
						<input type="hidden" name="amount_to_save"
							value="${pass.amount_to_save}">
						<input type="submit" value="Recurring Finances">
					</form:form>
				</div>
			</td>

			<td id="buttons">
				<div>
					<%-- <form:form action="/gogoMoney" modelAttribute="user" method="post"> --%>
					<form:form action="/gogo" modelAttribute="user" method="post">
						<input type="submit" value="Logout">
					</form:form>
				</div>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	
	
	<br><br><br>
	


 	
	<br><br><br>

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
			Clayton's note: Why not just send $ {pass} as value, instead of separate attributes?
			<br>
			${pass}
			<%-- <form:form action="/gogoMoney/displayTransactions" modelAttribute="user" method="post"> --%>
			<form:form action="displayTransactions" modelAttribute="user" method="post">
				<input type="hidden" name="user" value="${pass}">
				<input type="submit" value="Transaction History">
			</form:form>
		</div>
		
	
	<%-- user:<br><%= userS %><br> --%>
	<%-- <%= userScriptlet.toString() %><br> --%>
	<%-- email: <%= userS.getEmail() %><br> --%>
	<%-- user id: <%= userS.getUser_id() %><br> --%>
	<%-- <%= userScriptlet.getEmail() %><br>  --%>
	<%-- spending: <%= spendS.getClass() %><br> --%>
	<%-- spending: <%= spendS %> --%>
	
	<br><br><br><br>
	
		

</body>
</html>