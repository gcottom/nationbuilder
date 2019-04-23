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
<div style="float: right; width:50%;" class="container">
<h3>Customize your nation</h3>
<a href="editNationName">Edit Nation Name</a><br>
<a href="editNationCapitol">Edit Nation Capitol</a><br>
<a href="editResources">Edit Resources</a><br>
<a href="editGovernment">Edit Government</a><br>
<c:choose>
<c:when test="${message}">
<a href="/user/viewMessages" style="color:red">New Message</a>
</c:when>
<c:otherwise>
<a href="/user/viewMessages" >View Messages</a>
</c:otherwise>
</c:choose>
<br>
<h3>Build Housing</h3>
<a href="buyHousing">Buy Housing</a><br>
<c:choose>
<c:when test="${nation.isLevel4()}">
<a href="buyAdvancedHousing">Buy Advanced Housing</a>
</c:when>
</c:choose>
<c:choose>
<c:when test="${nation.isLevel5()}">
<a href="buyAdvancedHousing">Buy Advanced Housing</a>
</c:when>
</c:choose>
<c:choose>
<c:when test="${nation.isLevel6()}">
<a href="buyAdvancedHousing">Buy Advanced Housing</a>
</c:when>
</c:choose>
<h3>Upgrade Nation</h3>
<c:choose>
<c:when test="${nation.isLevel1()}">
<a href="upgradeToLevel2">Upgrade to Nation Level 2</a><br>
<h3>Build Improvements</h3>
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
</c:choose></c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isLevel2()}">
<a href="upgradeToLevel3">Upgrade to Nation Level 3</a><br>
<h3>Build Improvements</h3>
<c:choose>
<c:when test="${nation.isGreatLibrary()}">
</c:when>
<c:otherwise>

<a href="buildGreatLibrary">Build Great Library</a><br>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isLargeMarket()}">
</c:when>
<c:otherwise>
<a href="buildLargeMarket">Build Large Market</a><br>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isPlantation()}">
</c:when>
<c:otherwise>
<a href="buildPlantation">Build Plantation</a><br>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isForge()}">
</c:when>
<c:otherwise>
<a href="buildForge">Build Forge</a><br>
</c:otherwise>
</c:choose>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isLevel3()}">
<a href="upgradeToLevel4">Upgrade to Nation Level 4</a><br>
<h3>Build Improvements</h3>
<c:choose>
<c:when test="${nation.isCollege()}">
</c:when>
<c:otherwise>

<a href="buildCollege">Build College</a><br>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isBank()}">
</c:when>
<c:otherwise>
<a href="buildBank">Build Bank</a><br>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isCropRotation()}">
</c:when>
<c:otherwise>
<a href="buildCropRotation">Build Crop Rotation</a><br>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isAdvancedWorkshop()}">
</c:when>
<c:otherwise>
<a href="buildAdvancedWorkshop">Build Advanced Workshop</a><br>
</c:otherwise>
</c:choose>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isLevel4()}">
<a href="upgradeToLevel5">Upgrade to Nation Level 5</a><br>
<h3>Build Improvements</h3>
<c:choose>
<c:when test="${nation.isResearchLab()}">
</c:when>
<c:otherwise>

<a href="buildResearchLab">Build Research Lab</a><br>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isHarbor()}">
</c:when>
<c:otherwise>
<a href="buildHarbor">Build Harbor</a><br>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isAdvancedFarming()}">
</c:when>
<c:otherwise>
<a href="buildAdvancedFarming">Build Advanced Farming</a><br>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isAdvancedForge()}">
</c:when>
<c:otherwise>
<a href="buildAdvancedForge">Build Advanced Forge</a><br>
</c:otherwise>
</c:choose>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isLevel5()}">
<a href="upgradeToLevel6">Upgrade to Nation Level 6</a><br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
</div>
<div class="container" style="float: left; width:50%;">
<h1>My Information</h1>
<p>Username:${pageContext.request.userPrincipal.name}</p>
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
<c:choose>
<c:when test="${nation.isAdvancedWorkshop()}">
Advanced Workshop<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isCropRotation()}">
Crop Rotation<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isCollege()}">
College<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isBank()}">
Bank<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
</p>




</table></div>
</body>