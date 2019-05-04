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
<p>In order to upgrade to nation level 3, you must meet the following requirements:<br>
Technology:${nation.getTechnology()}/1000<br>
Production: ${nation.getProduction()}/2500<br>
Money: ${nation.getMoney()}/2500<br>
Population: ${nation.getPopulation()}/2500</p>
<p>
Built Forge: ${nation.isForge()}<br>
Built Great Library: ${nation.isGreatLibrary()}<br>
Built Plantation: ${nation.isPlantation()}<br>
Built Large Market: ${nation.isLargeMarket()}</p>
<p>Nation Level 3 unlocks level 3 improvements and wonders</p>
<c:choose>
<c:when test ="${canBuild.getCanBuild()}">
<a href="upgradeToNationLevel3-gc23">Click here to upgrade to nation level 3!</a>
</c:when>
<c:otherwise>
<p>Unable to build at this time!</p>
<p><a href="user">Return to User</a></p>
</c:otherwise>
</c:choose>
</div>