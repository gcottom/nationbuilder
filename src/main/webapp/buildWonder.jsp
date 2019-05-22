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
<p>In order to build ${text.getText()} you must meet the following requirements:<br>
Technology:${nation.getTechnology()}/${text.getCost()}<br>
Production: ${nation.getProduction()}/${text.getCost()}<br>
Money: ${nation.getMoney()}/${text.getCost()}</p>
<p>${text.getText()} provides: <br>
${text.getBenefits()}<br>
Maintenance: <br>
${text.getMaintenance()}
</p>
<c:choose>
<c:when test ="${canBuild.getCanBuild()}">
<a href="${text.getLink()}">Click here to build ${text.getText()}!</a>
</c:when>
<c:otherwise>
<p>Unable to build at this time!</p>
<p><a href="user">Return to User</a></p>
</c:otherwise>
</c:choose>
</div>