<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: qingfengteng
  Date: 2019/1/14
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Landing Page</title>
</head>
<body>

<h2>Spring Landing PAge</h2>
<p>Click below button to get a simple HTML page</p>

<form:form method="POST" action="/staticpage" >
    <table>
        <tr>
            <td><input type="submit" value="Get HTML Page"></td>
        </tr>
    </table>
</form:form>


</body>
</html>
