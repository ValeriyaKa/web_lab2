<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Web lab_2</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="style.css">
    <script src="js/script.js"></script>
    <script src="js/graf.js"></script>
    <meta name="theme-color" content="#fafafa">
</head>
<body>
<h1>Результаты:</h1>

<table id="resultTable">
    <thead>
    <tr>
        <th>X</th>
        <th>Y</th>
        <th>R</th>
        <th>Время выполнения</th>
        <th>Результат</th>
        <th>Время</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty resultList}">
        <c:forEach var="result" items="${resultList}">

            <tr>
                <td>${result.x}</td>
                <td>${result.y}</td>
                <td>${result.r}</td>
                <td>${result.execTime}</td>
                <td>${result.value}</td>
                <td>${result.time}</td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<form action="/ControllerServlet" method="post">
<%--    <input type="hidden" name="clearResults" value="true"/>--%>
<%--    <button class="button2" id="cleaResult" type="click">Очистить результаты</button>--%>
</form>
</body>
</html>
