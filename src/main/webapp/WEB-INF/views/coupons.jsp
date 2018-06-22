<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Just Watch It - Home Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/skeleton/2.0.4/skeleton.min.css"/>
    <link href="/res/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>


<div class="container">

    <h1>Just Watch It</h1>
    <h2>Coupons</h2>

    <c:if test="${not empty mex}">
        <div class="">${mex}</div>
    </c:if>

    <ul>
        <c:forEach var="coupon" items="${coupons}">
            <li><c:out value="${coupon.code}"/> (<c:out value="${coupon.sold}"/>)</li>
        </c:forEach>
    </ul>


</div>

</body>
</html>