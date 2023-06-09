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
  <title>Game's Details ${game.getId()}</title>
  <jsp:include page="../includes/head.jsp" />
</head>
<body>
<%--<a href="${pageContext.request.contextPath}/">--%>
    <jsp:include page="../includes/header.jsp" />
<%--</a>--%>
<div class="containerBase">
 <div class="box1">
<h2>Details of a game :</h2>
     <hr>
     <strong>Title :</strong> ${game.getTitle()}<br>
     <strong>Category :</strong> ${game.getCategory()}<br>
     <strong>Release Date :</strong> ${game.getReleaseDate()}<br>
     <strong>Cover :</strong> ${game.getCover()}<br>
     <hr>
 </div>
 <div class="box2">

 </div>

</div>

</body>
</html>
