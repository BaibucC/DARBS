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
                <li><a href="newBike" onclick="window.open('newBike', 'newwindow', 'width=300, height=250 ,resizable=yes , scrollbars=yes')">New Bike</a></li>
                <li><a href="newEmployee" onclick="window.open('newEmployee', 'newwindow', 'width=300, height=250 ,resizable=yes , scrollbars=yes')">New Employee</a></li>
            </ul>
    </div>
</nav>