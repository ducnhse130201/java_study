<%--
  Created by IntelliJ IDEA.
  User: King kaki
  Date: 2018/12/12
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h2>
    Error message:
    <%
        out.println(exception.toString());
    %>
</h2>

</body>
</html>
