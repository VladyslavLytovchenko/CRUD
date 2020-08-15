<%@ include file="header.jsp"%>
<div style="display: flex;justify-content: space-around">
<table style="width: 200px;" class="table">
    <caption style="text-align: center;caption-side: top;">Categories</caption>
    <thead class="thead-light">
    <tr>
        <th>Category</th>
    </tr>
    </thead>
    <tbody>
    <tr style="background-color: darkred;">
        <th><a style="color:white" href="<c:url value="/items"/>">Reset</a></th>
    </tr>
    <c:forEach var="c" items="${categories}">
        <tr>
            <th><a href="<c:url value="/items/category${c.id}"/>">${c.name}</a></th>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <div style="display: flex;flex-direction: column;justify-content: center">
<c:choose>
    <c:when test="${not empty items}">
<table style="width:30%;" class="table">
    <caption style="text-align: center;caption-side: top;">${items.get(0).category.name}</caption>
    <thead class="thead-dark">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Category</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">
        <tr>
            <th><a href="${context}/items/${item.id}">${item.name}</a></th>
            <th>${item.description}</th>
            <th>${item.price}</th>
            <th>${item.category.name}</th>
        </tr>
    </c:forEach>
    </tbody>
</table>
    </c:when>
    <c:otherwise>
        <p>No results</p>
    </c:otherwise>
</c:choose>
<button class="btn btn-dark" style="width: 220px;"><a href="${pageContext.request.contextPath}/items/addItem">Add an item</a></button>
    </div>
    </div>
</body>
</html>
