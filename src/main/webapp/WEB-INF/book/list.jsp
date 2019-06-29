<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show book</title>
</head>
<body>
  <c:forEach items="${books}" var="book" varStatus="loopStatus">
    <p>Książka ${loopStatus.count}, tytuł: ${book.title}, author: ${book.author}, isbn: ${book.isbn}</p>
  </c:forEach>
</body>
</html>
