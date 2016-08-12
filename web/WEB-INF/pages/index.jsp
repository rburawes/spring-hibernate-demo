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
    <div>
        <jsp:include page="sections/header.jsp"/>
        <a href="/bookstore">Let's add book.</a>
    </div>
    <jsp:include page="sections/footer.jsp"/>
</div>
</body>
</html>
