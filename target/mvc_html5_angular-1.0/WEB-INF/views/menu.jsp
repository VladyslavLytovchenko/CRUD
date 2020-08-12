<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set value="${pageContext.request.contextPath}" var="context"/>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file='login.css' %>
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<form class="form-signin">
<button class="btn btn-lg btn-primary btn-block" type="submit"><a style="color:white" href="${context}/items">ITEMS</a></button>
<button class="btn btn-lg btn-primary btn-block" type="submit"><a style="color:white" href="${context}/categories">Categories</a></button>
</form>
</body>
</html>
