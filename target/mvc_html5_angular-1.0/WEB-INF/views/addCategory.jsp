<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<form:form action="/PetProject/categories/add" cssStyle="width: 400px" modelAttribute="category" method="POST">
    <div class="form-group">
        <label>Название</label>
        <form:input path="name" type="text" name="id"/>
    </div>
    <div class="form-group">
        <label>Описание</label>
        <form:textarea path="description" name="description"/>
    </div>
    <input class="btn btn-primary" type="submit" value="Submit"/>
</form:form>
</body>
</html>
