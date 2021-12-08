<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Locations</h2>
<table>
<tr>
<th>Id</th>
<th>name</th>
<th>code</th>
<th>type</th>
</tr>


<c:forEach items="${allLocationsKey}" var="location">
<tr>
<td>${location.id}</td>
<td>${location.name}</td>
<td>${location.code}</td>
<td>${location.type}</td>
<td><a href="deleteLocation?id=${location.id}">delete</a></td>
<td><a href="updateLocation?id=${location.id}">update</a></td>

</tr>
</c:forEach>

</table>

<a href="showCreate">Add Location</a>

</body>
</html>