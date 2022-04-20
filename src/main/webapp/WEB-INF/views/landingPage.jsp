<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<b>Login Page</b>

	<form method="post" action="displaySummary">
		<c:set var="error" value="${error}"></c:set>
		<table>
			<tr>
                        <td>Email</td>
                        <td><input type="text" name="email" required/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" required/></td>
                    </tr>
                   	<c:choose>
                   		<c:when test="${error==true}">
                   			<tr>
                   				<td></td>
                   				<td style="color: red;">Invalid Email or Password</td>
                   			</tr>
                   		</c:when>
                   	</c:choose>
                    <tr>
                    	<td></td>
                        <td colspan="2" align="center"><input type="submit" value="Login" />
                            &nbsp;&nbsp;
                            <input type="reset" value="Reset" />
                        </td>                        
                    </tr>                    
                
            </table>
            
	</form>
            
            <div>
			<a href="${pageContext.request.contextPath}/createAccount"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">/createAccount</a>
			<br><br>
			<a href="${pageContext.request.contextPath}/displaySummary"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">/displaySummary</a>
			<br><br>
			<a href="${pageContext.request.contextPath}/displayTransactions"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">/displayTransactions</a>
			<br><br>
			<a href="${pageContext.request.contextPath}/populateFinances"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">/populateFinances</a>
			</div>
        

</body>
</html>