<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show book</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty book}">
        <h3>Dodana książka:</h3>
        <p>Tytuł: ${book.title}</p>
        <p>Autor: ${book.author}</p>
        <p>ISBN: ${book.isbn}</p>
    </c:when>
    <c:otherwise>
        <p>Nie dodano książki</p>
    </c:otherwise>
</c:choose>
</body>
</html>

