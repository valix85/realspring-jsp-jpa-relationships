<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>One To Many / Many To One</title>
    <link href="/res/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>


<div class="container">

    <h1>One To Many / Many To One</h1>
    <h3>Film</h3>
    <div>id=${film.id} -> ${film.titolo} [coupon: ${film.coupon.id}]</div>
    <div>${film}</div>
    <h3>Coupon</h3>
    <div>id=${film.coupon.id} -> ${film.coupon.code} [value=${film.coupon.sold}]</div>
    <h3>Dischi</h3>

    <ul>
        <c:forEach var="disco" items="${dischi}">
            <li><c:out value="${disco.id}"/> ->
                <c:out value="${disco.barcode}"/>
            </li>
        </c:forEach>
    </ul>


    <div>Ecco il link di verifica: <a href="/12m/${film.id}"> CONTROLLA </a></div>

</div>

</body>
</html>