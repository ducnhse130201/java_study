<%--
  Created by IntelliJ IDEA.
  User: King kaki
  Date: 2018/12/12
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>getProperty and setProperty</head>
<body>
<jsp:useBean id="employee" class="Property.Employee" />
<jsp:setProperty name="employee" property="firstName" value="Abigail" />
First Name: <jsp:getProperty name="employee" property="firstName" />
</body>
</html>