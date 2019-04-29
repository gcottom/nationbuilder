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
<p>
Money: ${nation.getMoney()}/1 per troop</p>
<form method="POST" action="buyTroopsCheck">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input name="troops" type="number" step="1" pattern="\d+" placeholder="${troops}"/>
<button type ="submit">Purchase</button>
</form>

<p><a href="user">Return to User</a></p>

</div>