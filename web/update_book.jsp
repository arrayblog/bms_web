<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>add_book</title>
</head>
<body>
<form action="./execUpdateBookServlet" method="post">
    编号：<input type="text" name="id" value="${book.id}" readonly="readonly">
    <br>
    书名：<input type="text" name="bookName" value="${book.bookName}">
    <br>
    作者：<input type="text" name="author" value="${book.author}">
    <br>
    价格：<input type="text" name="price" value="${book.price}">
    <br>
    介绍：<input type="text" name="bookDesc" value="${book.bookDesc}">
    <br>
    分类：
    <select name="bookTypeId">
        <c:forEach items="${requestScope.bookTypes}" var="g" varStatus="x">
                <option value="${g.id}">${g.bookTypeName}</option>
        </c:forEach>
    </select>
    <br>
    <input type="submit">
</form>
</body>
</html>
