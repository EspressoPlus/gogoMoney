<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Welcome to GoGo Money! Please Login or create an account!</h1>

<b>Login Page</b>

	<form method="post" action="validate">
		<table>
			<tr>
                        <td>Email</td>
                        <td><input type="text" name="email" required/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Login" />
                            &nbsp;&nbsp;
                            <input type="reset" value="Reset" />
                        </td>                        
                    </tr>                    
                
            </table>
            
        </form>
			
		<div>
			<a href="${pageContext.request.contextPath}/createAccount/"
				class="btn btn-primary btn-sm active" role="button"
				aria-pressed="true">Create Account</a>
		</div>



</body>
</html>