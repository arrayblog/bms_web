<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>query_record</title>
</head>
<body>
借阅书本名称 借阅时间 归还时间 归还
<table>
    <tbody>
    <tr id="first-row">
        <td>编号</td>
        <td>书本编号</td>
        <td>借阅时间</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${requestScope.records}" var="g" varStatus="x">
        <tr>
            <td>${g.id}</td>
            <td>${g.bookId}</td>
            <td>${g.date}</td>
            <td><a href="./execReturnBookServlet?recordId=${g.id}&bookId=${g.bookId}">归还</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
