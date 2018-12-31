<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New employee</title>
</head>
<body>
	<div align="center">
		<h1>Bike employee form</h1>
		<form:form action="saveUserBike" method="post" modelAttribute="user">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Name:</td>
				<td><form:select path="name">
                                             <form:option value = "NONE" label = "Select"/>
                                             <form:options items = "${optionBike}" /></form:select></td>
			</tr>
			<tr>
				<td>Employee:</td>
				<td><form:select path="employee" readonly="true"  disabled="true" >
                                             <form:option value = "NONE" label = "Select" />
                                             <form:options items = "${optionUser}" /></form:select></td>
			</tr>
			<tr>
				<td>Date1:</td>
				<td><form:input path="date1" /></td>
			</tr>
			<tr>
				<td>Date2:</td>
				<td><form:input path="date2" /></td>
			</tr>
                        </form:form>
			<tr>
                            <td colspan="2" align="center"><input type="submit" value="Save"><a href="/ElBike/"><input type="button" value="Cancel" /></a></<td>
			</tr>
		</table>
		
	</div>
</body>
</html>