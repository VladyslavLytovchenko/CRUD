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
        <th>id</th>
        <th>Имя</th>
        <th>Пароль</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="user" items="${users}">
        <tr>
            <form:form method="POST" action="${pageContext.request.contextPath}/editUser/${user.id}" modelAttribute="user">
                <th><form:input disabled="true" path="id" value="${user.id}"/></th>
            <th><form:input path="username" value="${user.username}"/></th>
            <th><form:input path="password" value="${user.password}"/></th>
                <th>
                <c:forEach items="${roles}" var="role" varStatus="status">
                    <p><form:checkbox path="roles" value="${role.id}" label="${role.role}" /></p>
                </c:forEach>
                </th>
            <th><button class="btn btn-lg btn-primary btn-block" type="submit">Save</button></th>
            </form:form>
            <th><a href="${pageContext.request.contextPath}/deleteUser/${user.id}">Delete</a></th>
        </tr>
    </c:forEach>
    </tbody>
</table>


<a href="${pageContext.request.contextPath}/categories/addCategory">Добавить Категорию</a>
</body>
</html>
