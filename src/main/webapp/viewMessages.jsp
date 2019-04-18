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
<th>Nation From ID</th>
<th>Message</th>
</tr>
</thead>
<tbody>
<c:forEach var="message" items="${messages}" >
<tr>
<td><c:out value="${message.getId()}"/></td>
<td><c:out value="${message.getSenderId()}"/></td>
<td><c:out value="${message.getMessage()}"/></td>
</tr>
</c:forEach>
</tbody></table>

</div></body>