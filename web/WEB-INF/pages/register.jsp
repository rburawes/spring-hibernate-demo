<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring Hibernate Demo</title>
</head>
<body>

<h2>Sample Registration Form</h2>
<form:form method="post" modelAttribute="book" action="/bookstore/add">
    <table>
        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <c:catch var="exception">
                <c:forEach var="author" items="${authors}">
                    <td><form:checkbox path="authors" value="${author}"/> <c:out value="${author.givenName} ${author.familyName}"/></td>
                </c:forEach>
            </c:catch>
            <c:if test="${exception != null}" >
                <td>Authors cannot be loaded. ${exception.message}</td>
            </c:if>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
