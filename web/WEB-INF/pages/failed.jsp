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
        <p class="lead">The book <strong><c:out value="${title}"/></strong> was not saved. '<c:out value="${error}"/>'</p>
    </div>
</div>
<jsp:include page="sections/footer.jsp"/>
</body>
</html>
