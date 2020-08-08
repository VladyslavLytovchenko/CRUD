<%--
  Created by IntelliJ IDEA.
  User: jeakm
  Date: 08.08.2020
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${item.id}/edit">EDIT</a>
<a href="${item.id}/delete">asd</a>
<a></a>
<div class="card">
    <img src="${pageContext.request.contextPath}/images/pict.jpg" alt="" style="width:100%">
    <h1>${item.name}</h1>
    <p class="price">${item.price}</p>
    <p>${item.description}</p>
    <p><button>Добавить карточку</button></p>
</div>
</body>
</html>
