<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<% request.setCharacterEncoding("UTF-8"); %>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<form:form action="/PetProject/items/add" cssStyle="width: 400px" modelAttribute="item" method="POST">
    <div class="form-group">
        <label >Название</label>
        <form:input class="form-control" path="name" type="text" name="id"/>
    </div>
    <div class="form-group">
        <label>Описание</label>
        <form:textarea class="form-control" path="description" name="description"/>
    </div>
    <div class="form-group">
        <label>Цена</label>
        <form:input class="form-control" path="price" type="text" name="price"/>
    </div>
    <div class="form-group">
        <label>Картинка</label>
        <form:input class="form-control-file" path="picture" type="file" name="picture"/>
    </div>
    <p>
        <label for="exampleFormControlSelect1">Категория</label>
        <form:select class="form-control" id="exampleFormControlSelect1" path="category.id">
            <c:forEach var="cat" items="${categories}">
                <option value=${cat.id}>${cat.name}</option>
            </c:forEach>
        </form:select>
    </p>
    <input class="btn btn-primary" type="submit" value="Submit"/>
</form:form>
</body>
</html>
