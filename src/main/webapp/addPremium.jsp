<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="premium" method="get">
		<h1>Dodaj lub usuń uprawnienia PREMIUM </br></br>
		
		<h2><label>Nazwa użytkownika:<input type="text" id="username" name="username"/></label></h1></br>
		<label>Dodaj<input type="radio" name="premium" value="add"><br></label>
		<label>Usun<input type="radio" name="premium" value="remove"><br></label>
		<input type="submit" value="Zapisz"/></h2>
	</form>
</body>
</html>