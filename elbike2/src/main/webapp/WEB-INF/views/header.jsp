<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <spring:url value="/resources/style.css" var="style" />
    <link href="${style}" rel="stylesheet" />
</head>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar">
    <div class="container">
            <ul>
                <li><a href="/ElBike">Contact List</a></li>
                <li><a href="newBike">New Bike</a></li>
                <li><a href="newEmployee">New Employee</a></li>
            </ul>
    </div>
</nav>