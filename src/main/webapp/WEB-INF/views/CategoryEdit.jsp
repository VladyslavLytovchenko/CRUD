<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file='login.css' %>
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<form:form action="${pageContext.request.contextPath}/logout">
    <button type="submit">LOGOUT</button>
</form:form>
<form:form class="form-signin" action="/PetProject/categories/add" cssStyle="width: 400px" modelAttribute="category" method="POST">
    <form:input  readonly="true" class="form-control" path="id" type="hidden" name="id"/>
    <div class="form-group">
        <label>Название</label>
        <form:input class="form-control" path="name" type="text" name="id"/>
    </div>
    <div class="form-group">
        <label>Описание</label>
        <form:textarea class="form-control" path="description" name="description"/>
    </div>
    <input class="btn btn-primary" type="submit" value="Submit"/>
</form:form>

</body>
</html>
