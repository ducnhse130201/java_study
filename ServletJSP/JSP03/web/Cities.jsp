<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: King kaki
  Date: 2018/12/12
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Big Cities</title>
    <style>
        table, tr, td{
            border: 1px solid #aaee77;
            padding: 3px;
        }
    </style>
</head>
<body>
Capitals
<table>
    <tr style="background: #448755; color: white; font-weight: bold">
        <td>Country</td>
        <td>Capital</td>
    </tr>
    <c:forEach items="${capitals}" var="mapItem">
        <tr>
            <td>${mapItem.key}</td>
            <td>${mapItem.value}</td>
        </tr>
    </c:forEach>
</table>
<br>
Big Cities
<table>
    <tr style="background: #448755; color: white; font-weight: bold">
        <td>Country</td>
        <td>Cities</td>
    </tr>
    <c:forEach items="${bigCities}" var="mapTitem">
        <tr>
            <td>${mapTitem.key}</td>
            <td>
                <c:forEach items="${mapTitem.value}" var="city" varStatus="status">
                   <c:out value="${city}"></c:out><c:if test="${!status.last}">,</c:if>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
