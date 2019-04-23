<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

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
<p>Current Nation Name:${nation.getNationName()}</p><br>
<form method="POST" action="${contextPath}/editNationName" class="form-editnationname">
<input name="nationName" type="text" class="form-control"/>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 <button class="btn btn-lg btn-primary btn-block" type="submit">Update Nation Name</button>
</form>
</div>
</body>
