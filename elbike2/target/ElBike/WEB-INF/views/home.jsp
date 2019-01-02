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
        <div>
            <table class="tables" align="center">
                <h3>Electric bike administration list</h3>
                <th>No</th>
                <th>Employee</th>
                <th>Bike ID</th>
                <th>From date:</th>
                <th>To date:</th>
                <th>Actions</th>

                <c:forEach var="user" items="${listUser}" varStatus="status">
                    <tr>
                        <td width="20px">${status.index + 1}</td>
                        <td>${user.employee}</td>
                        <td>${user.name}</td>
                        <td width="100px">${user.date1}</td>
                        <td width="100px">${user.date2}</td>
                        <td>
                            <a class = "button" href="editUserBike?id=${user.id}">Add/edit bike</a>
                    <form:form action="removeBike" method="post">
                        <a class = "button" href="removeBike?id=${user.id}">Remove bike</a>
                    </form:form>
                    <a class = "buttonDelete" href="deleteUser?id=${user.id}">Delete employee</a>
                    </td>

                    </tr>
                </c:forEach>	        	
            </table>
        </div>
        <hr>
        <div align="center">
            <table><tr><td class="tablerow">
                        <table class="tables">
                            <h3>All bikes</h3>
                            <th>Bike ID</th>
                            <th>Status</th>
                            <th>Available</th>
                            <th>Actions</th>
                                <c:forEach var="bike" items="${listBike}" varStatus="status">
                                <tr>
                                    <td>${bike.bikename}</td>
                                    <td width="50px" align="center">
                                        <img src="resources/${bike.status}.png" />
                                    </td>
                                    <td width="50px" align="center">
                                        <img src="resources/${bike.available}.png" />
                                    </td>
                                    <td>
                                        <a class = "button" href="editBike?id=${bike.id}">Edit</a>
                                        <a class = "buttonDelete" href="deleteBike?id=${bike.id}">Delete</a>
                                    </td>

                                </tr>
                            </c:forEach>	        	
                        </table>
                    </td><td  class="tablerow">
                        <table class="tables">
                            <h3>Available bikes</h3>
                            <th>Bike ID</th>
                            <th width="50px">Status</th>
                            <th width="50px">Available</th>

                            <c:forEach var="bike" items="${listAvailable}" varStatus="status">
                                <tr>
                                    <td>${bike.bikename}</td>
                                    <td width="50px" align="center">
                                        <img src="resources/${bike.status}.png" />
                                    </td>
                                    <td width="50px" align="center">
                                        <img src="resources/${bike.available}.png" />
                                    </td>

                                </tr>
                            </c:forEach>	        	
                        </table>
                    </td>
                </tr></table>
        </div>

        <jsp:include page="../views/footer.jsp" />
    </body>
</html>
