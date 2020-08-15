<%@ include file="header.jsp"%>
<form:form action="${context}/reg" modelAttribute="user" class="form-signin" method="post">
    <h2 class="form-heading">Sign up</h2>
    <form:input name="username" path="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
    <form:input name="password" path="password" type="password" class="form-control" placeholder="Password"/>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
</form:form>
</body>
</html>