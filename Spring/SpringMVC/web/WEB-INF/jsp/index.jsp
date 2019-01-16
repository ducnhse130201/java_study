<%@ taglib prefix="page" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: qingfengteng
  Date: 2019/1/14
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Page Redirection</title>
</head>
<body>

<h2>Spring Page Redirection</h2>
<p>Click below button to redirect the result to new page</p>

<page:form  method="GET" action="/redirect" >
    <table>
        <tr><input type="submit" value="Redirect Page" /></tr>
    </table>
</page:form>

</body>
</html>
