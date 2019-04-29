<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
<style>

table, th, td {border: 1px solid black;}
td{height: 25px; vertical-align: middle; padding: 20px; text-align:left;}
</style>
<meta charset="utf-8">
<meta http-equiv="refresh" content="30">
    <title>View User Info</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div style="float: right; width:50%; text-align: right;" class="container">
<p>Turn: ${turn}</p>
<h3>Customize your nation</h3>
<a href="editNationName">Edit Nation Name</a><br>
<a href="editNationCapitol">Edit Nation Capitol</a><br>
<a href="editResources">Edit Resources</a><br>
<a href="editGovernment">Edit Government</a><br>
<c:choose>
<c:when test="${message}">
<a href="/user/viewMessages" style="color:red">New Message</a><br>
</c:when>
<c:otherwise>
<a href="/user/viewMessages" >View Messages</a><br>
</c:otherwise>
</c:choose>
<c:if test="${nation.getNationLevel() gt 2}">
<a href="/nation/viewAll">View All Nations</a><br>
</c:if>
<br>
<h3>Build Housing</h3>
<a href="buyHousing">Buy Housing</a><br>
<c:if test="${nation.getNationLevel() gt 3}">
<a href="buyAdvancedHousing">Buy Advanced Housing</a><br>
</c:if>
<c:if test="${nation.getNationLevel() gt 2}">
<h3>Manage Troops</h3>
<a href="buyTroops">Manage Troops</a>
</c:if>
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
Username:${pageContext.request.userPrincipal.name}
<table>
<thead>
<tr><td>Producing<br>Per Turn:</td>
<td>Population: ${nation.getPopulationTurn()}<br>
Production: ${nation.getProductionTurn()}<br>
Technology: ${nation.getTechnologyTurn()}<br>
Money: ${nation.getMoneyTurn()}</td></tr>

<tr>
<td>Nation Level</td>
<td>${nation.getNationLevel()}</td></tr>
<tr>
<td>Money</td>
<td>${nation.getMoney()}</td>
</tr>
<tr>
<td>Technology</td>
<td>${nation.getTechnology()}</td>
</tr>
<tr><td>Population</td>
<td>${nation.getPopulation()}</td></tr>
<tr><td>Population Limit</td>
<td>${nation.getPopulationLimit()}</td></tr>
<tr>
<td>Production</td>
<td>${nation.getProduction()}</td></tr>
<tr>
<td>Nation Name</td>
<td>${nation.getNationName()}</td>
</tr>
<tr>
<td>Nation Capitol</td>
<td>${nation.getNationCapitol()}</td>
</tr>
<tr>
<td>Government</td>
<td>${nation.getGovernment()}</td>
</tr>
<tr>
<td>Resources</td>
<td>${nation.getResource1()}<br>
${nation.getResource2()}<br>
${nation.getResource3()}<br>
${nation.getResource4()}</td>
</tr>
<tr>
<td>At War</td>
<td>${nation.isAtWar()}</td></tr>
<c:if test="${nation.isAtWar()}">
<tr><td>At War<br> Against:</td>
<td><a href="nation/${ nation.getAtWarWith()}">Nation</a>
</td>
</tr>
</c:if>
<c:if test="${nation.getNationLevel() gt 2}">
<tr>
<td>Troops</td>
<td>${nation.getTroops()}</td>
</tr>
</c:if>
<tr>
<td>Improvements</td>
<td><c:choose>
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
<c:choose>
<c:when test="${nation.isResearchLab()}">
Research Lab<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isHarbor()}">
Harbor<br></c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isAdvancedFarming()}">
Advanced Farming<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isAdvancedForge()}">
Advanced Forge<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>

<c:choose>
<c:when test="${nation.isFactory()}">
Factory<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isAdvancedPlantation()}">
Advanced Plantation<br></c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isUniversity()}">
University<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isStockExchange()}">
Stock Exchange<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>

<c:choose>
<c:when test="${nation.isIndustryArea()}">
Industry Area<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isAgricultureArea()}">
Agriculture Area<br></c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isCampusArea()}">
Campus Area<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isCommercialArea()}">
Commercial Area<br>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>

</td></tr>



</table></div>
</body>