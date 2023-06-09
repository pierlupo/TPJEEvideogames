<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Games </title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
<%--<a href="${pageContext.request.contextPath}/">--%>
    <jsp:include page="../includes/header.jsp" />
<%--</a>--%>
<div class="containerBase">
    <div class="box1">
        <h2>List of games :</h2>
        <hr>
    <c:forEach items = "${gamesList}" var="g">
        <strong>Title of the game :</strong> ${g.getTitle()}<br>
        <strong>Category :</strong> ${g.getCategory()}<br>
        <strong>Release Date :</strong> ${g.getreleaseDate()}<br>
        <strong>Upload Cover :</strong> ${g.getCover()}<br>
        <hr>
    </c:forEach>
    </div>
    <div class="box2">

        <h2>Search for a game :</h2>
        <hr>

        <form action="gameslist" method="post">

        <div class="search"><label for="search">Research :</label><input type="search" name="search" id="search"  placeholder="Enter a title…"/></div>
        <div class="btnSearch"><button type="submit" >Submit</button></div>
        </form>
        <hr>

    </div>
    </div>
</body>
</html>
