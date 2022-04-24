<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		${financial.name}<br> ${financial.income_outcome}<br>
		${financial.amount}<br> ${financial.category}<br>
		${financial.recurring}<br> ${financial.recur_interval}<br>
		${financial.recurr_day}<br> ${financial.recurr_count}<br>
		${financial.transaction_date}<br> ${entryDate}<br>
		${financial.user.user_first_name}<br>
	</div>
</body>
</html>