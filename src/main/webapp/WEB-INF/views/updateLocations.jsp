	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Location</title>
</head>
<body>
	<form action="updateloc" method="post" >
	<pre>
		Id:<input type="text" name="id" value="${locationKey.id}" readonly="readonly">
		 name:<input type="text" name="name" value="${locationKey.name}"> 
			code:<input type="text" name="code" value="${locationKey.code}">
		type:Urban<input type="radio" name="type" value="URBAN" ${locationKey.type=='URBAN'?'checked':''}>
		     Rural<input type="radio" name="type" value="RURAL" ${locationKey.type=='RURAL'?'checked':''}>
			<input type="submit" value="save">
    </pre>
	</form>


</body>
</html>