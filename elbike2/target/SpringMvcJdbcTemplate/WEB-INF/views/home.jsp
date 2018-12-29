<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electric bike administration</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Contact List</h1>
	        <h3><a href="newUser">New User</a></h3>
                <h3><a href="newEmployee">New Employee</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Name</th>
	        	<th>Country</th>
	        	<th>Date1</th>
	        	<th>Date2</th>
	        	<th>Action</th>
	        	
				<c:forEach var="user" items="${listUser}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${user.name}</td>
					<td>${user.country}</td>
					<td>${user.date1}</td>
					<td>${user.date2}</td>
					<td>
						<a href="editUser?id=${user.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteUser?id=${user.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
