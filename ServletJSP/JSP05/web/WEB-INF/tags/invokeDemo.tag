<%@ attribute name="productDetails" fragment="true" %>
<%@ variable name-given="productName" %>
<%@ variable name-given="description" %>
<%@ variable name-given="price" %>
<%
    jspContext.setAttribute("productName", "Pelesonic DVD Player");
    jspContext.setAttribute("description",
            "Dolby Digital output through coaxial digital-audio jack.");
    jspContext.setAttribute("price", "65");
%>
<jsp:invoke fragment="productDetails" />