<%--
  Created by IntelliJ IDEA.
  User: King kaki
  Date: 2018/12/16
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>Form Values</title>
</head>
<body>
<table>
    <tr>
        <td>Name:</td>
        <td>
            ${param.name}
            (length:${fn:length(param.name)})
        </td>
    </tr>
    <tr>
        <td>Address:</td>
        <td>
            ${param.address}
            (length:${fn:length(param.address)})
        </td>
    </tr>

</table>
</body>
</html>
