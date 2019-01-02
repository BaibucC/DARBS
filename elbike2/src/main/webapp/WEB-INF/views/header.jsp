<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <spring:url value="/resources/style.css" var="style" />
    <link href="${style}" rel="stylesheet" />
</head>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar">
    <div id="navigation">
        <table align="center" class="navtable">
            <tr>
                <a href="/ElBike" class="navlink">Electric bike administration</a>
                <a href="newBike" class="navlink">New Bike</a>
                <a href="newEmployee" class="navlink">New Employee</a>
            </tr>
        </table>           
    </div>
</nav>