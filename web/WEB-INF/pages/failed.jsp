<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spring Hibernate Demo</title>
</head>
<body>
    <h2>The book '<c:out value="${title}"/>' was not saved. '<c:out value="${error}"/>'</h2>
</body>
</html>
