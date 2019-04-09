<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Nation Builder:Create Nation</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Create Nation</h1>
    <form action="#" th:action="${createnation}" th:object="${nation}" method="post">
     <dxa:csrf-token/>
    	<p>Username:${pageContext.request.userPrincipal.name }
    	<p>Nation Name: <input type="text" th:field="*{nationName}" /></p>
        <p>Nation Capitol: <input type="text" th:field="*{nationCapitol}" /></p>
     <!--    <p>Government: <select th:field="*{government}>"
        <option th:value="Democracy"> Democracy</option>
        <option th:value="Communism" >Communism</option>
        <option th:value="Republic" >Republic</option>
        </select>
        </p>
         <p>Resource 1 (You may choose more than one of the same resource):
        <select th:field="*{resource1}">
        <option th:value ="Gold" th:text="Gold">Gold</option>
        <option th:value ="Water" th:text="Water">Water</option>
        <option th:value ="Wheat" th:text="Wheat">Wheat</option>
        <option th:value ="Coal" th:text="Coal">Coal</option>
        <option th:value ="Oil" th:text="Oil">Oil</option>
        <option th:value ="Uranium" th:text="Uranium">Uranium</option>
        <option th:value ="Meat" th:text="Meat">Meat</option>
        <option th:value ="Silver" th:text="Silver">Silver</option>
        <option th:value ="Cotton" th:text="Cotton">Cotton</option>
        <option th:value ="Wood" th:text="Wood">Wood</option>
        </select></p>
        <!-- 
        <p>Resource 2 (You may choose more than one of the same resource):
        <select id ="resource2" name = "Resource2">
        <option value ="Gold">Gold</option>
        <option value ="Water">Water</option>
        <option value ="Wheat">Wheat</option>
        <option value ="Coal">Coal</option>
        <option value ="Oil">Oil</option>
        <option value ="Uranium">Uranium</option>
        <option value ="Meat">Meat</option>
        <option value ="Silver">Silver</option>
        <option value ="Cotton">Cotton</option>
        <option value ="Wood">Wood</option>
        </select></p>
        <p>Resource 3 (You may choose more than one of the same resource):
        <select id = "resource3" name = "Resource3">
       <option value ="Gold">Gold</option>
        <option value ="Water">Water</option>
        <option value ="Wheat">Wheat</option>
        <option value ="Coal">Coal</option>
        <option value ="Oil">Oil</option>
        <option value ="Uranium">Uranium</option>
        <option value ="Meat">Meat</option>
        <option value ="Silver">Silver</option>
        <option value ="Cotton">Cotton</option>
        <option value ="Wood">Wood</option>
        </select></p>
        <p>Resource 4 (You may choose more than one of the same resource):
        <select id = "resource4" name = "Resource4">
        <option value ="Gold">Gold</option>
        <option value ="Water">Water</option>
        <option value ="Wheat">Wheat</option>
        <option value ="Coal">Coal</option>
        <option value ="Oil">Oil</option>
        <option value ="Uranium">Uranium</option>
        <option value ="Meat">Meat</option>
        <option value ="Silver">Silver</option>
        <option value ="Cotton">Cotton</option>
        <option value ="Wood">Wood</option>
        </select></p>
        -->
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
    </form>
</body>
</html>