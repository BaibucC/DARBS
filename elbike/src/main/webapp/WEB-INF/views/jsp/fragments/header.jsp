<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Spring MVC Form Handling Example</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Electric bikes & employees</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">Add employee</a></li>
			</ul>
                        <ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">Add Bike</a></li>
			</ul>
                        <ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">Use bike</a></li>
			</ul>
		</div>
	</div>
</nav>