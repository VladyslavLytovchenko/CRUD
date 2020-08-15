<%@ include file="header.jsp"%>
<form:form action="/PetProject/items/add" class="form-signin" cssStyle="width: 400px" modelAttribute="item" method="POST">
    <div class="form-group">
        <label>Name</label>
        <form:input class="form-control" path="name" type="text" name="id"/>
    </div>
    <div class="form-group">
        <label>Description</label>
        <form:textarea class="form-control" path="description" name="description"/>
    </div>
    <div class="form-group">
        <label>Price</label>
        <form:input class="form-control" path="price" type="text" name="price"/>
    </div>
    <div class="form-group">
        <label>Picture</label>
        <form:input class="form-control-file" path="picture" type="file" name="picture"/>
    </div>
    <p>
        <label for="exampleFormControlSelect1">Category</label>
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
