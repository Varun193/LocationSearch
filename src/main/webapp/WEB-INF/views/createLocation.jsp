	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="saveloc" method="post" >
	<pre>
		Id:<input type="text" name="id">
		 name:<input type="text" name="name"> 
			code:<input type="text" name="code">
		type:Urban<input type="radio" name="type" value="URBAN">
		     Rural<input type="radio" name="type" value="RURAL">
			<input type="submit" value="save">
	</pre>

	</form>
	${msg}
	
	<a href="dislpayLocations">view All Locations</a>

</body>
</html>