<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
    // Script let
    
    String user = null;
 if(session.getAttribute("uname") == null){
		response.sendRedirect("jsp/login.jsp");
	}else user = (String) session.getAttribute("uname");
	String userName = null;
	String sessionID = null;
    Cookie[] cookies = request.getCookies();
    
    if(cookies != null){
    	
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equalsIgnoreCase("uname")) userName = cookie.getValue();
    		if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
    	}
    }
 if(userName == null)
  response.sendRedirect("jsp/login.jsp"); 
 %>
 
 <h3>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %></h3>
<br>
User=<%=user %>
<br>
<a href="checkoutPage.jsp">Checkout Page</a>
 
 <form action="<%= request.getContextPath() %>/LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>