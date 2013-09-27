<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="http://ec2-54-225-125-154.compute-1.amazonaws.com:9000/PAASRest/mobile/App/AddUser" method="Post">
		FName : <input type="text" name="fName">
		<br>
		<br>
		lName : <input type="text" name="lName">
		<br>
		<br>
		Gender :<input type="text" name="gender">
		<br>
		<br>
		age :<input type="text" name="age">
		<br>
		<br>
		email :<input type="text" name="email">
		<br>
		<br>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>