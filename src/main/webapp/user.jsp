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
    <title>View User Info</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div style="float: right; width:50%;" class="container"><a href="editNationName">Edit Nation Name</a><br>
<a href="editNationCapitol">Edit Nation Capitol</a><br>
<a href="editResources">Edit Resources</a><br>
<a href="editGovernment">Edit Government</a><br><br>
<br>
<a href="buyHousing">Buy Housing</a><br>
<c:choose>
<c:when test="${nation.isHasLibrary()}">
</c:when>
<c:otherwise>

<a href="buildLibrary">Build Library</a><br>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isHasMarket()}">
</c:when>
<c:otherwise>
<a href="buildMarket">Build Market</a><br>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isHasBasicFarm()}">
</c:when>
<c:otherwise>
<a href="buildBasicFarm">Build Basic Farm</a><br>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isHasWorkshop()}">
</c:when>
<c:otherwise>
<a href="buildWorkshop">Build Workshop</a><br>
</c:otherwise>
</c:choose>
</div>
<div class="container" style="float: left; width:50%;">
<h1>My Information</h1>
<p>Username:${pageContext.request.userPrincipal.name}</p>
<table>
<thead>
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
</p>




</table></div>
</body>