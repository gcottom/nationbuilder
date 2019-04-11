<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
    <title>View User Info</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h1>My Information</h1>
<p>Username:${pageContext.request.userPrincipal.name}</p><br>
<p>Current Government:${nation.getGovernment()}</p><br>
<h3>Information:</h3>
<p>Democracy:+4 money, +1 population, +1 production</p>
<p>Monarchy: +3 money, +2 population, +1 production</p>
<p>Communism: +2 money, +2 population, +2 production</p>
<p>Republic: +3 money, +1 population, +2 production</p>
<form:form method="POST" action="${contextPath}/editGovernment" class="form-editgovernment" modelAttribute="nation">
<form:select path="government">
<form:options items="${resources}" />
</form:select>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 <button class="btn btn-lg btn-primary btn-block" type="submit">Update Resources</button>
</form:form>
</div>
