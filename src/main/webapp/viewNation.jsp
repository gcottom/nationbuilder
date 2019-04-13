<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
<style>

table, th, td {border: 1px solid black;}
td{height: 40px;}
th, td{padding: 15px; text-align: left;}</style>
<meta charset="utf-8">
<meta http-equiv="refresh" content="30">
    <title>View Nation</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<table>
<thead>
<tr><td>Producing<br>Per Turn:</td>
<td>Population: ${nation.getPopulationTurn()}<br>
Production: ${nation.getProductionTurn()}<br>
Technology: ${nation.getTechnologyTurn()}<br>
Money: ${nation.getMoneyTurn()}</td></tr>

<tr>
<td>Nation Level:</td>
<td>${nation.getNationLevel()}</td></tr>
<tr>
<td><p>Money:</p></td>
<td><p>${nation.getMoney()}</p></td>
</tr>
<tr>
<td><p>Technology</p></td>
<td><p>${nation.getTechnology()}</p></td>
</tr>
<tr><td><p>Population</p></td>
<td>${nation.getPopulation()}</td></tr>
<tr><td><p>Population Limit</p></td>
<td>${nation.getPopulationLimit()}</td></tr>
<tr>
<td><p>Production</p></td>
<td>${nation.getProduction()}</td></tr>
<tr>
<td><p>Nation Name</p></td>
<td><p>${nation.getNationName()}</p></td>
</tr>
<tr>
<td><p>Nation Capitol</p></td>
<td><p>${nation.getNationCapitol()}</p></td>
</tr>
<tr>
<td><p>Government</p></td>
<td><p>${nation.getGovernment()}</p></td>
</tr>
<tr>
<td><p>Resources</p></td>
<td><p>${nation.getResource1()}</p>
<p>${nation.getResource2()}</p>
<p>${nation.getResource3()}</p>
<p>${nation.getResource4()}</p></td>
</tr>
<tr>
<td><p>Improvements</p></td>
<td><p><c:choose>
<c:when test="${nation.isHasLibrary()}">
Library<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isHasMarket()}">
Market<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isHasWorkshop()}">
Workshop<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isHasBasicFarm()}">
Basic Farm<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isGreatLibrary()}">
Great Library<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isLargeMarket()}">
Large Market<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isForge()}">
Forge<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isPlantation()}">
Plantation<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
</p>




</table>
</body>