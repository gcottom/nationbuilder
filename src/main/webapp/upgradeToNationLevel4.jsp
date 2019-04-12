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
<p>In order to upgrade to nation level 4, you must meet the following requirements:<br>
Technology:${nation.getTechnology()}/2500<br>
Production: ${nation.getProduction()}/5000<br>
Money: ${nation.getMoney()}/5000<br>
Population: ${nation.getPopulation()}/10000</p>
<p>Nation Level 4 unlocks level 4 improvements and wonders</p>
<c:choose>
<c:when test ="${canBuild.getCanBuild()}">
<a href="upgradeToNationLevel4-gc23">Click here to upgrade to nation level 4!</a>
</c:when>
<c:otherwise>
<p>Unable to build at this time!</p>
<p><a href="user">Return to User</a></p>
</c:otherwise>
</c:choose>
</div>