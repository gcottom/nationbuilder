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
<p>Current Resources:${nation.getResource1()},${nation.getResource2()},${nation.getResource3()},${nation.getResource4()}</p><br>
<h3>Information:</h3>
<p>Gold= +5 money</p>
<p>Water= +3 population</p>
<p>Wheat= +2 population</p>
<p>Coal= +2 production</p>
<p>Oil= +2 production</p>
<p>Uranium= +1 production</p>
<p>Meat= +2 population</p>
<p>Silver= +3 money</p>
<p>Cotton= +2 production</p>
<p>Wood= +3 production</p>

<form:form method="POST" action="${contextPath}/editResources" class="form-editresources" modelAttribute="nation">
<form:select path="resource1">
<form:options items="${resources}" />
</form:select>
<br>
<form:select path="resource2">
<form:options items="${resources}" />
</form:select>
<br>
<form:select path="resource3">
<form:options items="${resources}" />
</form:select>
<br>
<form:select path="resource4">
<form:options items="${resources}" />
</form:select>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 <button class="btn btn-lg btn-primary btn-block" type="submit">Update Resources</button>
</form:form>
</div>
