<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Bike</h1>
		<form:form action="saveBike" method="post" modelAttribute="bike">
		<table>
                    <form:hidden path="id"/>
			<tr>
				<td>Bike name:</td>
				<td><form:input path="bikename" /></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td><form:input path="status" /></td>
			</tr>
			<tr>
				<td>In use:</td>
				<td><form:input path="inuse" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>