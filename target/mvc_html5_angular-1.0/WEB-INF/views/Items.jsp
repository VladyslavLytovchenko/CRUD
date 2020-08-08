<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file='style.css' %>
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<table class="table">
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
            <th><a href="${item.id}">${item.name}</a></th>
            <th>${item.description}</th>
            <th>${item.price}</th>
            <th>${item.category.name}</th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/items/addItem">Добавить продукт</a>


<c:forEach var="c" items="${categories}">
    <p><a href="<c:url value="/items/category${c.id}"/>">${c.name}</a></p>
</c:forEach>
<!--
<div class="products">
<c:forEach var="i" items="${items}">
    <div class="item">
        <img src="${pageContext.request.contextPath}/images/pict.jpg" alt="Джинсы из денима" style="width:100%">
        <h1>${i.name}</h1>
        <p class="price">${i.price}</p>
        <p>${i.description}</p>
        <p><button>В корзину</button></p>
    </div>
</c:forEach>
</div>
-->
</body>
</html>
