<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electric bike administration</title>
    </head>

    <jsp:include page="../views/header.jsp" />

    <body>
        <div align="center">
            <table border="1">
                <th>No</th>
                <th>Name</th>
                <th>Employee</th>
                <th>Date1</th>
                <th>Date2</th>
                <th>Action</th>

                <c:forEach var="user" items="${listUser}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${user.name}</td>
                        <td>${user.employee}</td>
                        <td>${user.date1}</td>
                        <td>${user.date2}</td>
                        <td>
                            <a href="editUserBike?id=${user.id}">Add/edit bike</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                    <form:form action="removeBike" method="post">
                        <a href="removeBike?id=${user.id}">Remove bike</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </form:form>
                    <a href="deleteUser?id=${user.id}">Delete employee</a>
                    </td>

                    </tr>
                </c:forEach>	        	
            </table>
        </div>
<div align="center">
            <table border="1">
                <h3>Bike list</h3>
                <th>Bikename</th>
                <th>Status</th>
                <th>In use</th>

                <c:forEach var="bike" items="${listBike}" varStatus="status">
                    <tr>
                        <td>${bike.bikename}</td>
                        <td>${bike.status}</td>
                        <td>${bike.inuse}</td>
                        <td>
                            <a href="editBike?id=${bike.id}">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="deleteBike?id=${bike.id}">Delete</a>
                        </td>

                    </tr>
                </c:forEach>	        	
            </table>
        </div>

        <jsp:include page="../views/footer.jsp" />
    </body>
</html>
