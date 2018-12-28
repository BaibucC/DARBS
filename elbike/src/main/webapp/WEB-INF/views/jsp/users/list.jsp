<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="../fragments/header.jsp" />

    <body>

        <div class="container">

            <c:if test="${not empty msg}">
                <div class="alert alert-${css} alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <strong>${msg}</strong>
                </div>
            </c:if>

            <h1>All Users</h1>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#ID</th>
                        <th>Country</th>
                        <th>Name</th>
                        <th>Date1</th>
                        <th>Date2</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>
                            ${user.id}
                        </td>
                        <td>${user.country}</td>
                        <td>${user.name}</td>
                        <td>${user.date1}</td>
                        <td>${user.date2}</td>
                        <td>
                            <spring:url value="/users/${user.id}/delete" var="deleteUrl" /> 
                            <spring:url value="/users/${user.id}/update" var="editUrl" />


                            <button class="btn btn-edit" onclick="location.href = '${editUrl}'">Labot</button>
                            <button class="btn btn-delete" onclick="this.disabled = true;post('${deleteUrl}')">Dzēst</button></td>
                    </tr>
                </c:forEach>
            </table>

        </div>

        <jsp:include page="../fragments/footer.jsp" />

    </body>
</html>