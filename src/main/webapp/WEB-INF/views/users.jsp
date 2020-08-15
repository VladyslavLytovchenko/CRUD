<%@ include file="header.jsp"%>
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
                <th><form:input readonly="true" path="id" value="${user.id}"/></th>
            <th><form:input path="username" value="${user.username}"/></th>
            <th><form:input readonly="true" path="password" value="${user.password}"/></th>
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
