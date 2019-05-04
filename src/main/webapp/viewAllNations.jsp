<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head><title>View All Nations</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<style>
        table, th, td {
            border: 1px solid black;
            padding: 1px;
        }
    </style>
</head>
<body>
<div>
<h2>Results</h2>
<table>
<thead>
<tr>
<th>ID</th>
<th>Nation Name</th>
<th>Nation Ruler</th>
<th>Link</th>
<th>Message</th>
<th>Declare War</th>
</tr>
</thead>
<tbody>
<c:forEach var="nation" items="${nations}" >
<tr>
<td><c:out value="${nation.getId()}"/></td>
<td><c:out value="${nation.getNationName()}"/></td>
<td><c:out value="${nation.getRulerName()}"/></td>
<td><a href="<c:out value="${nation.getLink()}"/>">Link</a></td>
<td><a href="<c:out value="${nation.getLink()}/sendMessage"/>">Message</a></td>
<td>
<c:if test="${nation.getNationLevel() gt 2}">
<a href="${nation.getLink()}/declareWar">Declare War</a></td>
</c:if>
</tr>
</c:forEach>
</tbody></table>

</div></body>