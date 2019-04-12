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
<p>In order to upgrade to nation level 2, you must meet the following requirements:<br>
Technology:${nation.getTechnology()}/250<br>
Production: ${nation.getProduction()}/1000<br>
Money: ${nation.getMoney()}/1000<br>
Population: ${nation.getPopulation()}/1000<br>
Built Workshop: ${nation.isHasWorkshop()}<br>
Built Library: ${nation.isHasLibrary()}<br>
Built Basic Farm: ${nation.isHasBasicFarm()}<br>
Built Market: ${nation.isHasMarket()}</p>
<p>Nation Level 2 unlocks level 2 improvements and wonders</p>
<c:choose>
<c:when test ="${canBuild.getCanBuild()}">
<a href="upgradeToNationLevel2-gc23">Click here to upgrade to nation level 2!</a>
</c:when>
<c:otherwise>
<p>Unable to build at this time!</p>
<p><a href="user">Return to User</a></p>
</c:otherwise>
</c:choose>
</div>