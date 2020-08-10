<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set value="${pageContext.request.contextPath}" var="context"/>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file='style.css' %>
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<form:form action="${pageContext.request.contextPath}/logout">
    <button type="submit">LOGOUT</button>
</form:form>
<div style="display: flex;justify-content: space-around">
<table style="width: 200px;" class="table">
    <caption style="text-align: center;caption-side: top;">Категории</caption>
    <thead class="thead-light">
    <tr>
        <th>Категория</th>
    </tr>
    </thead>
    <tbody>
    <tr style="background-color: darkred;">
        <th><a style="color:white" href="<c:url value="/items"/>">Сброс</a></th>
    </tr>
    <c:forEach var="c" items="${categories}">
        <tr>
            <th><a href="<c:url value="/items/category${c.id}"/>">${c.name}</a></th>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <div style="display: flex;flex-direction: column;justify-content: center">
<c:choose>
    <c:when test="${not empty items}">
<table style="width:30%;" class="table">
    <caption style="text-align: center;caption-side: top;">${items.get(0).category.name}</caption>
    <thead class="thead-dark">
    <tr>
        <th>Имя</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Категория</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">
        <tr>
            <th><a href="${context}/items/${item.id}">${item.name}</a></th>
            <th>${item.description}</th>
            <th>${item.price}</th>
            <th>${item.category.name}</th>
        </tr>
    </c:forEach>
    </tbody>
</table>
    </c:when>
    <c:otherwise>
        <p>Результатов нет</p>
    </c:otherwise>
</c:choose>
<button class="btn btn-dark" style="width: 220px;"><a href="${pageContext.request.contextPath}/items/addItem">Добавить продукт</a></button>
    </div>
    </div>
</body>
</html>
