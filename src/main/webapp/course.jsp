<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer page</title>
</head>
<body>
<!-- for post method we use @PostMapping('/detailsxyz') in the controller class and it takes '/detailsxyz' as arguments-->
<!-- similarly we have @getMapping('args') based on action='' -->
<form method='post' action="details">
enter id:<input type='number' name='custid'/><br/>
enter name number:<input type='text' name='cname'/><br/>
enter email number:<input type='text' name='cemail'/><br/>
<button type='submit' placeholder='submit'></button>
</form>
</body>
</html>