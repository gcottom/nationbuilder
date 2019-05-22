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
<p>In order to upgrade to nation level 6, you must meet the following requirements:<br>
Technology:${nation.getTechnology()}/50000<br>
Production: ${nation.getProduction()}/100000<br>
Money: ${nation.getMoney()}/1000000<br>
Population: ${nation.getPopulation()}/1000000</p>
<p>Built University: ${nation.isUniversity()}<br>
Built Stock Exchange: ${nation.isStockExchange()}<br>
Built Advanced Plantation: ${nation.isAdvancedPlantation()}<br>
Built Factory: ${nation.isFactory()}</p>

<p>Nation Level 6 unlocks level 6 improvements and wonders</p>
<c:choose>
<c:when test ="${canBuild.getCanBuild()}">
<a href="upgradeToNationLevel6-gc23">Click here to upgrade to nation level 2!</a>
</c:when>
<c:otherwise>
<p>Unable to build at this time!</p>
<p><a href="user">Return to User</a></p>
</c:otherwise>
</c:choose>
</div>