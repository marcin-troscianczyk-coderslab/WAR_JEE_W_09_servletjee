<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add books</title>
</head>
<body>
  <h3>Dodawanie książek:</h3>

  <form method="post">
      <c:forEach begin="1" end="5" var="index">
          <p>Tytuł książki ${index}: <input type="text"name="title${index}" /></p>
          <p>Autor książki ${index}: <input type="text" name="author${index}" /></p>
          <p>ISBN książki ${index}:  <input type="text" name="isbn${index}" /></p>
      </c:forEach>
      <input type="submit" value="Dodaj książki">
  </form>
</body>
</html>
