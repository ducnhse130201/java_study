<%--
  Created by IntelliJ IDEA.
  User: King kaki
  Date: 2018/12/13
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="/WEB-INF/mytags.tld" prefix="easy"%>
<html>
<head>
    <title>Testing DataFormatterTag</title>
</head>
<body>
<easy:dataFormatter header="States" items="Alabama, Alaska, Feorgia, Florida" />
<br>
<easy:dataFormatter header="Countries">
    <jsp:attribute name="items">
        US, UK, Canada, Korea
    </jsp:attribute>
</easy:dataFormatter>

</body>
</html>
