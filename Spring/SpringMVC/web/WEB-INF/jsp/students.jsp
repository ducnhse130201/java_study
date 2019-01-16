<%--
  Created by IntelliJ IDEA.
  User: qingfengteng
  Date: 2019/1/14
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>Spring MVC Exception Handling</title>
</head>
<body>
<h2>Student Information</h2>
<form:form method = "POST" action = "/HelloWeb/addStudent" commandName="command" modelAttribute="command">
    <table>
        <tr>
            <td><form:label path = "name">Name</form:label></td>
            <td><form:input path = "name" /></td>
        </tr>
        <tr>
            <td><form:label path = "age">Age</form:label></td>
            <td><form:input path = "age" /></td>
        </tr>
        <tr>
            <td><form:label path = "id">id</form:label></td>
            <td><form:input path = "id" /></td>
        </tr>
        <tr>
            <td colspan = "2"><input type = "submit" value = "Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>