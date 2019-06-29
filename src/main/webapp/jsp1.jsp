<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>zażółć gęślą jaźń</h1>

<p>Liczba kilometrów ${param.km}</p>

<%-- Przelicz ile to mil (mila = km * 1,609344), a następnie wyświetl wartość. --%>

<p>Liczba mil ${param.km / 1.609344}</p>


</body>
</html>
