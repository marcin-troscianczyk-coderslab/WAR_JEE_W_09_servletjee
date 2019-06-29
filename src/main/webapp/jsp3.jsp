<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>Parametr a: ${not empty param.a ? param.a.concat('dupa2') : 'brak'}</p>
<p>Parametr b: ${not empty param.b ? param.b : 'brak'}</p>


<p>Wersja z EL</p>

<p>Cookie foo: ${not empty cookie.foo ? cookie.foo.value : "brak cookie"}</p>


<p>Wersja ze skryptletem -- TAK NIE ROBIMY!!!</p>

<%

    int a = 5;
    Cookie[] cookies = request.getCookies();
    if (a == 5) {
        return;
    }
    for (Cookie cookie : cookies) {
        if ("foo".equals(cookie.getName())) {
            %>
                <p> Cookie foo: <%=cookie.getValue()%></p>
            <%
        }
    }

%>
</body>
</html>
