<%@ include file="header.jsp"%>
<form:form class="form-signin" action="/PetProject/categories/add" cssStyle="width: 400px" modelAttribute="category" method="POST">
    <form:input  readonly="true" class="form-control" path="id" type="hidden" name="id"/>
    <div class="form-group">
        <label>Name</label>
        <form:input class="form-control" path="name" type="text" name="id"/>
    </div>
    <div class="form-group">
        <label>Description</label>
        <form:textarea class="form-control" path="description" name="description"/>
    </div>
    <input class="btn btn-primary" type="submit" value="Submit"/>
</form:form>

</body>
</html>
