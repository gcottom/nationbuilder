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

<p>Total Troops: ${troops}</p>
<p>Recommended troop deployment: ${recTroops}</p>
<p>Choose how many troops you would like to deploy. It is recommended to keep 10% of your troops at home. 
<form method="POST" action="attackCheck">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input name="troops" type="number" step="1" pattern="\d+" placeholder="0"/>
<button type ="submit">Deploy Troops</button>
</form>

<p><a href="user">Return to User</a></p>

</div>