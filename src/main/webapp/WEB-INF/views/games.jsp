<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Collection of Video Games</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
<jsp:include page="../includes/header.jsp" />
<div class="containerBase">
<div class="box1">
<h2>List of games :</h2>
<hr>
<c:forEach items = "${gamesList}" var="game">
    <strong>Game's title :</strong> ${game.getTitle()}
    <a href="${pageContext.request.contextPath}/?id=${game.getId()}">  ->  Details</a><br>
</c:forEach>
<hr>
</div>

<div class="box2">
    <h2>Add a game :</h2>
    <hr>
    <form action="" method="post">
        <div><label for="title">Title :</label><input type="text" name="title" id="title" /></div>
        <div><label for="category">Category :</label><input type="text" name="category" id="category"/></div>
        <div><label for="releaseDate">Release Date :</label><input type="text" name="releaseDate" id="releaseDate" /></div>
<%--        <div><label for="price">Price :</label><input type="text" name="price" id="price"/></div>--%>
<%--        <div><label for="stock">Cover :</label><input type="text" name="stock" id="stock"/></div>--%>
<%--        <div> <fieldset><legend>Comment :</legend><textarea name="comment" id="comment"></textarea></fieldset></div>--%>
<%--        <div><label for="imageCover">Cover :</label><input type="file" name="image" id="imageCover"/></div>--%>
        <div class="btn"><button type="submit" >Submit</button></div>
    </form>
    <hr>
</div>
</div>
</body>
</html>
