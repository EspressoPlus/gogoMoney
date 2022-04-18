<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    /* try{
        String email = request.getParameter("email");   
        String password = request.getParameter("password");
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gogomoney03-02?" + "user=gogo&password=gogo");    
        PreparedStatement pst = conn.prepareStatement("Select email, password from user where email=? and password=?");
        pst.setString(1, email);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();                        
        if(rs.next())           
           out.println("Valid login credentials");        
        else
           out.println("Invalid login credentials");            
   }
   catch(Exception e){       
       out.println("Something went wrong !! Please try again");       
   }       */
  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
		<p>${user.user_first_name} ${user.user_last_name}</p>
		<br>
		<h5>Outcome</h5>
		<table>
			<c:forEach var="outcome" items="${outcome}">
			<tr>
				<td>${outcome.name}</td>
				<td>${outcome.amount}</td>
				<td>${outcome.category_id.category_name}</td>
				<td>${outcome.recurring}</td>
				<td>${outcome.recur_interval}</td>
				<td>${outcome.recurr_day}</td>
				<td>${outcome.recurr_count}</td>
				<td>${outcome.transaction_date}</td>
				<td>${outcome.entry_date}</td>
			</tr>
			</c:forEach>
		</table>
		<h5>Income</h5>
		<table>
			<c:forEach var="income" items="${income}">
			<tr>
				<td>${income.name}</td>
				<td>${income.amount}</td>
				<td>${income.category_id.category_name}</td>
				<td>${income.recurring}</td>
				<td>${income.recur_interval}</td>
				<td>${income.recurr_day}</td>
				<td>${income.recurr_count}</td>
				<td>${income.transaction_date}</td>
				<td>${income.entry_date}</td>
			</tr>
			</c:forEach>
		</table>
	<p>${none}</p>
</body>
</html>
