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
    <h2>New Coupon</h2>


    <form action="saveCoupon" method="POST">
        <div>Codice Coupon</div>
        <div class="row">
            <div class="four columns">
                <div><input type="text" name="code" placeholder="codice sconto..." required class="u-full-width"/></div>
                <div>Sconto (%)</div>
                <div><input type="number" name="sold" min="0" , max="100" step="0.01" placeholder="valore" required
                            class="u-full-width"/></div>

                <div>Film</div>
                <select name="film" class="u-full-width">
                    <option value="" selected>...</option>
                    <c:forEach var="film" items="${films}" >
                        <option value="${film.id}"><c:out value="${film.titolo}" />
                            (<c:out value="${film.anno}"/>)</option>
                    </c:forEach>
                </select>

                <c:if test="${not empty mex}">
                    <div class="error">${mex}</div>
                </c:if>

                <input type="submit" value="SALVA" class="button-primary"/>
            </div>
        </div>
    </form>







</div>

</body>
</html>