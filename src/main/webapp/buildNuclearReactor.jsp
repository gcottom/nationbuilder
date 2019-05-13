<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
</head>
<body>
<div>
<p>In order to build a nuclear reactor you must meet the following requirements:<br>
Technology:${nation.getTechnology()}/1000<br>
Production: ${nation.getProduction()}/5000<br>
Money: ${nation.getMoney()}/50000</p>
<p>Nuclear reactor provides: <br>
+10 money<br>
+5 production<br>
+1 technology
</p>
<p>Nuclear reactor requires that one of your resources be Uranium to provide resources.</p>
<c:choose>
<c:when test ="${canBuild.getCanBuild()}">
<a href="buildNuclearReactor-gc23">Click here to build nuclear reactor!</a>
</c:when>
<c:otherwise>
<p>Unable to build at this time!</p>
<p><a href="user">Return to User</a></p>
</c:otherwise>
</c:choose>
</div>