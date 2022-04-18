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
<style></style>
</head>
<body>
<h1>GoGo Money</h1>
	<p>Login</p>
	<p>If you don't have an account, please select create account!</p>
	<form method="post" action="validate">
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
            <div>
			<a href="${pageContext.request.contextPath}/createAccount/"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">Create Account</a>
			</div>
        </form>
			
		



</body>
</html>