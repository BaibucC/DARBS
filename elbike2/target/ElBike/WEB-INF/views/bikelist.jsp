<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
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

    </body>
</html>
