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
<td>Money:</td>
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
<td>
<img width="30" height="30" src="/resources/${nation.getResource1()}.png" title="${nation.getResource1()}"/>
<img width="30" height="30" src="/resources/${nation.getResource2()}.png" title="${nation.getResource2()}"/>
<img width="30" height="30" src="/resources/${nation.getResource3()}.png" title="${nation.getResource3()}"/>
<img width="30" height="30" src="/resources/${nation.getResource4()}.png" title="${nation.getResource4()}"/></td>

</tr>
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
<img src="/resources/IndustryArea.png" width="30" height="30" title="Industry Area"/>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isAgricultureArea()}">
<img src="/resources/AgricultureArea.png" width="30" height="30" title="Agriculture Area"/>

</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isCampusArea()}">
<img src="/resources/CampusArea.png" width="30" height="30" title="Campus Area"/>

</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${nation.isCommercialArea()}">
<img src="/resources/CommercialArea.png" width="30" height="30" title="Commercial Area"/>

</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>





</table>
</body>