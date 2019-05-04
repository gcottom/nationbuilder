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
<p>In order to upgrade to nation level 5, you must meet the following requirements:<br>
Technology:${nation.getTechnology()}/10000<br>
Production: ${nation.getProduction()}/10000<br>
Money: ${nation.getMoney()}/10000<br>
Population: ${nation.getPopulation()}/50000</p>
<p>Built Research Lab: ${nation.isResearchLab()}<br>
Built Harbor: ${nation.isHarbor()}<br>
Built Advanced Farming: ${nation.isAdvancedFarming()}<br>
Built Advanced Forge: ${nation.isAdvancedForge()}</p>

<p>Nation Level 5 unlocks level 5 improvements and wonders</p>
<c:choose>
<c:when test ="${canBuild.getCanBuild()}">
<a href="upgradeToNationLevel5-gc23">Click here to upgrade to nation level 5!</a>
</c:when>
<c:otherwise>
<p>Unable to build at this time!</p>
<p><a href="user">Return to User</a></p>
</c:otherwise>
</c:choose>
</div>