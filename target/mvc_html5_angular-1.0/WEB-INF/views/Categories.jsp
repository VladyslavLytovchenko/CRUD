<%@ include file="header.jsp"%>
<form:form action="${pageContext.request.contextPath}/logout">
    <button type="submit">LOGOUT</button>
</form:form>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="category" items="${categories}">
        <tr>
            <th>${category.name}</th>
            <th>${category.description}</th>
            <th><a href="categories/${category.id}/edit">Edit</a></th>
            <th><a href="categories/${category.id}/delete">Delete</a></th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${context}/categories/addCategory">Add a category</a>
</body>
</html>
