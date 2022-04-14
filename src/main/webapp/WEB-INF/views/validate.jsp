<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>
<%
    try{
        String email = request.getParameter("email");   
        String password = request.getParameter("password");
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gogomoney03-02?" + "user=root&password=XCVbooT32");    
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
   }      
%>