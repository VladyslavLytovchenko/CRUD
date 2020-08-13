<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set value="${pageContext.request.contextPath}" var="context"/>
<html>
<head>
    <title>Spring Security Example </title>
    <style>
        <%@include file='login.css' %>
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<form:form action="${context}/login" class="form-signin" method="post">
    <h2 class="form-heading">Log in</h2>
     <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
   <input name="password" type="password" class="form-control" placeholder="Password"/>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
</form:form>
</body>
</html>