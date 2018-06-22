<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Many To Many </title>
    <link href="/res/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>


<div class="container">

    <h1>Many To Many</h1>
    <h2>FILMS</h2>
    <ul class="lista-film">
        <c:forEach var="film" items="${films}">
            <li>
                <h3>${film.titolo}</h3>
                <div>id=${film.id} -> ${film.titolo} [coupon: ${film.coupon.id}]</div>
                <div>${film}</div>
                <h3>Attori</h3>
                <ul>
                    <c:forEach var="attore" items="${film.cast}">
                        <li><c:out value="${attore.id}"/> ->
                            <c:out value="${attore.nome}"/> <c:out value="${attore.cognome}"/>
                        </li>
                    </c:forEach>
                </ul>
                <h3>Coupon</h3>
                <div>id=${film.coupon.id} -> ${film.coupon.code} [value=${film.coupon.sold}]</div>
            </li>
        </c:forEach>
    </ul>


    <%--
    <h3>Attori</h3>
    <ul>
        <c:forEach var="attore" items="${attori}">
            <li><c:out value="${attore.id}"/> ->
                <c:out value="${attore.nome}"/> <c:out value="${attore.cognome}"/>
            </li>
        </c:forEach>
    </ul>
    --%>


    <h3>ATTORE</h3>
    <div><c:out value="${attore.id}"/> ->
        <c:out value="${attore.nome}"/> <c:out value="${attore.cognome}"/></div>

    <div>Ecco il link di verifica: <a href="/m2m/${attore.id}"> CONTROLLA </a></div>

</div>

</body>
</html>