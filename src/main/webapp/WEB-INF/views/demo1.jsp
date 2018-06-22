<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>One to one</title>
    <link href="/res/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>


<div class="container">

    <h1>One To One</h1>

    <%--
        <ul>
    <c:forEach var="film" items="${elencofilm}" >
        <li><c:out value="${film.titolo}" /> di
            <c:out value="${film.regista}" />
            (<c:out value="${film.anno}"/>)</li>
    </c:forEach>
    </ul>
    --%>
    <h3>Film</h3>
    <div>id=${film.id} -> ${film.titolo} [coupon: ${film.coupon.id}]</div>
    <div>${film}</div>

    <h3>Coupon</h3>
    <div>id=${coupon.id} -> ${coupon.code} [value=${coupon.sold}]</div>

    <p>Film del coupon</p>
    <div>id=${coupon.film.id} -> ${coupon.film.titolo} </div>
    <hr>
    <div>Ecco il link di verifica: <a href="/121/${coupon.id}"> CONTROLLA </a></div>

</div>

</body>
</html>