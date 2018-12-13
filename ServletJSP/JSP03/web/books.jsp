<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: King kaki
  Date: 2018/12/12
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
    <style>
        table, tr, td{
            border: 1px solid brown;
        }
    </style>
</head>
<body>
Books in Simple Table

<table>
    <tr>
        <td>ISBN</td>
        <td>Title</td>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
        </tr>
    </c:forEach>
</table>
<br>
Books in Sytled Table
<table>
    <tr style="background: #ababff">
        <td>ISBN</td>
        <td>Title</td>
    </tr>
    <c:forEach items="${books}" var="book" varStatus="status">
        <c:if test="${status.count % 2 == 0}">
            <tr style="background: #eeeeff">
        </c:if>
        <c:if test="${status.count % 2 != 0}">
            <tr style="background: #dedeff">
        </c:if>
        <td>${book.isbn}</td>
        <td>${book.title}</td>
        </tr>
    </c:forEach>
</table>

<br>

ISBNs only:
    <c:forEach items="${books}" var="book" varStatus="status">
        ${book.isbn} <c:if test="${!status.last}">,</c:if>
    </c:forEach>


</body>
</html>
