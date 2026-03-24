<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Employee Insertion</h3>
	<form action="AddEmployee"  method="post">
		Emp ID: <input type="text" name="T1" /> <br/><br>
		Emp Name: <input type="text" name="T2" /> <br/><br>
		Emp Salary: <input type="text" name="T3" /> <br/><br>
		<input type="submit" value="Save" />
	</form>
	
	<a href="index.jsp">Back to Home</a>
</body>
</html>