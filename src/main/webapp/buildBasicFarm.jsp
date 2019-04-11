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
<p>In order to build a basic farm you must meet the following requirements:<br>
Technology:${nation.getTechnology()}/25<br>
Production: ${nation.getProduction()}/50<br>
Money: ${nation.getMoney()}/500</p>
<p>Library provides: +3 population</p>
<c:choose>
<c:when test ="${canBuild.getCanBuild()}">
<form>
<a href="buildBasicFarm-gc23">Click here to build basic farm!</a>
</c:when>
<c:otherwise>
<p>Unable to build at this time!</p>
<p><a href="user">Return to User</a></p>
</c:otherwise>
</c:choose>
</div>