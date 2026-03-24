<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.util.*" %>
	<%@ page import="model.*" %>
	
	<% @SuppressWarnings("unchecked") List<Employee> list = (List<Employee>) request.getAttribute("list"); %>
	
	<h3>Employee List</h3>
	<table border="1">
		<tr><th>Emp ID</th><th>NAME</th><th>Salary</th></tr>
		<%for(Employee E : list) {%>
			<tr>
				<td> <%=E.getEmpid() %> </td><td> <%=E.getName() %> </td><td> <%=E.getSalary() %> </td>
			</tr>
		<%}%>
	</table>
	
	<br/><br/>
	<a href ="index.jsp">Back to Home</a><br/>
</body>
</html>