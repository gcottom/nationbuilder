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
    <title>View User Info</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div style="float: right; width:50%;" class="container"><a href="editNationName">Edit Nation Name</a><br>
<a href="editNationCapitol">Edit Nation Capitol</a><br>
<a href="editResources">Edit Resources</a></div>
<div class="container">
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




</table></div>
</body>