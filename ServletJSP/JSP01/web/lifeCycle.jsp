<%--
  Created by IntelliJ IDEA.
  User: King kaki
  Date: 2018/12/10
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public void jspInit(){
        System.out.println("JspInit...");
    }

    public void jspDestory(){
        System.out.println("JspDestory...");
    }
%>
<html>
<head>
    <title>jspInit and jspDestory</title>
</head>
<body>
Overriding jspInit and jspDestroy
</body>
</html>
