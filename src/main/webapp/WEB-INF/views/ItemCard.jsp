<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="context"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead class="thead-light">
    <tr>
<th style="text-align: center"><a href="${item.id}/edit">EDIT</a></th>
<th style="text-align: center"><a href="${item.id}/delete">DELETE</a></th>
    </tr>
    </thead>
</table>
<div style="width:20%" class="card">
    <img src="${context}/images/pict.jpg" alt="" style="width:100%">
    <h1>${item.name}</h1>
    <p class="price">${item.price}</p>
    <p>${item.description}</p>
    <p><button>Добавить карточку</button></p>
</div>
</body>
</html>
