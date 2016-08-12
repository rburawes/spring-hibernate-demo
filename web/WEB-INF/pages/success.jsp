<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spring Hibernate Demo</title>
</head>
<body>
    <h2>The book '<c:out value="${title}"/>' has been successfully added. The following are the authors:</h2>
    <br>
    <c:catch var="exception">
        <c:forEach var="author" items="${authors}">
            <c:out value="${author.givenName} ${author.familyName}"/><br>
        </c:forEach>
    </c:catch>
    <c:if test="${exception != null}" >
        <td>Authors cannot be loaded. ${exception.message}</td>
    </c:if>
</body>
</html>
