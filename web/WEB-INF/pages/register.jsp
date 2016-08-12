<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring Hibernate Demo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <jsp:include page="sections/header.jsp"/>
    <div>
        <form:form class="form-horizontal" method="post" modelAttribute="book" action="/bookstore/add" name="book" id="book">
            <c:catch var="exception">
                <div class="form-group">
                    <form:label path="title">Title</form:label>
                    <form:input path="title" cssClass="form-control" placeholder="Title"/>
                </div>
                <div class="form-group">
                    <form:label path="authors">Authors</form:label>
                    <form:select multiple="true" cssClass="form-control" path="authors" title="Select author(s)..."
                                 id="authors">
                        <c:forEach var="author" items="${authors}">
                            <form:option value="${author}">
                                <c:out value="${author.givenName} ${author.familyName}"/>
                            </form:option>
                        </c:forEach>
                    </form:select>
                    <c:if test="${exception != null}">
                        Authors cannot be loaded. ${exception.message}
                    </c:if>
                </div>
            </c:catch><p/>
            <div class="form-actions">
                <form:button type="submit" class="btn btn-success">Add</form:button>
                <form:button type="button" class="btn">Cancel</form:button>
            </div>
        </form:form>
    </div>
    <jsp:include page="sections/footer.jsp"/>
</div>
</body>
</html>
