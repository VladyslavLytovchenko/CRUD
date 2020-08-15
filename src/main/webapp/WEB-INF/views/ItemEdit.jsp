<%@ include file="header.jsp"%>
<form:form action="${pageContext.request.contextPath}/logout">
    <button type="submit">LOGOUT</button>
</form:form>
<form:form class="form-signin" action="/PetProject/items/add" cssStyle="width: 400px" modelAttribute="item" method="POST">
    <form:input  readonly="true" class="form-control" path="id" type="hidden" name="id"/>
    <div class="form-group">
        <label>Name</label>
        <form:input  class="form-control" path="name" type="text" name="id"/>
    </div>
    <div class="form-group">
        <label>Описание</label>
        <form:textarea class="form-control" path="description" name="description"/>
    </div>
    <div class="form-group">
        <label>Цена</label>
        <form:input class="form-control"  path="price" type="text" name="price"/>
    </div>
    <div class="form-group">
        <label>Картинка</label>
        <form:input class="form-control-file" path="picture" type="file" name="picture"/>
    </div>
    <p>
        <label for="exampleFormControlSelect1">Категория</label>
        <form:select class="form-control" id="exampleFormControlSelect1" path="category.id">
            <c:forEach var="cat" items="${categories}">
                <c:choose>
                    <c:when test="${item.category.id==cat.id}">
                        <option selected value=${cat.id}>${cat.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value=${cat.id}>${cat.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
    </p>
    <input class="btn btn-primary" type="submit" value="Submit"/>
</form:form>
</body>
</html>
