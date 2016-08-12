<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <p class="lead">The book <strong><c:out value="${title}"/></strong> has been successfully added! Here are the new list of available books:</p>
    </div><p/>
    <div class="row">
        <table class="table">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Authors</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.title}</td>
                    <td>
                        <c:forEach items="${book.authors}" var="author" varStatus="status">
                            <c:out value="${author.givenName} ${author.familyName}${status.last ? '' : ', '}"/>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <jsp:include page="sections/footer.jsp"/>
</div>
</body>
</html>
