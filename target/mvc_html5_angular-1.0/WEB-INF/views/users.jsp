<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<form:form action="${pageContext.request.contextPath}/logout">
    <button type="submit">LOGOUT</button>
</form:form>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>Имя</th>
        <th>Описание</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="user" items="${users}">
        <tr>
            <form:form method="POST" action="${pageContext.request.contextPath}/editUser/${user.username}" modelAttribute="user">

            <th><form:input path="username" value="${user.username}"/></th>
            <th><form:input path="password" value="${user.password}"/></th>
                <c:forEach items="${roles}" var="role" varStatus="status">
                    <th> <form:checkbox path="roles" value="${role.role}" label="${role.role}" /></th>
                </c:forEach>
            <th><button class="btn btn-lg btn-primary btn-block" type="submit">Save</button></th>
            </form:form>
            <th><a href="categories/${user.username}/delete">Delete</a></th>
        </tr>
    </c:forEach>

    </tbody>
</table>


<a href="${pageContext.request.contextPath}/categories/addCategory">Добавить Категорию</a>
</body>
</html>
