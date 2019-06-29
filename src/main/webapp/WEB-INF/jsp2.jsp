<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <c:set var="dupa" value="Ala ma kota" scope="page"/>

  <p>Liczby</p>
  <c:forEach begin='${start}' end='${end}' var='i'>
      ${i}
  </c:forEach>

  <p>Liczby z kolekcji</p>
  <c:forEach items="${request.numbers}" var="i">
      <c:out value="${i}" />
  </c:forEach>

  ${request.dupa}
</body>
</html>
