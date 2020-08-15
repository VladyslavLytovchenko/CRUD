<%@ include file="header.jsp"%>
<form:form action="${context}/login" class="form-signin" method="post">
    <h2 class="form-heading">Log in</h2>
    <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
    <input name="password" type="password" class="form-control" placeholder="Password"/>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
    <a href="${context}/reg">Sign up</a>
</form:form>
</body>
</html>