<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
Today's date:
<br>
<tags:varDemo>
    In long format: ${longDate}
</tags:varDemo>
<br>
<tags:varDemo>
    In short format: ${shortDate}
</tags:varDemo>