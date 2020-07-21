<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>query_book</title>
</head>
<body>

<form action="./queryBook" method="post">
    查询：<input type="text" name="keyWord">
    <input type="submit" value="查询">
</form>

<table>
    <tbody>
    <tr id="first-row">
        <td>编号</td>
        <td>书名</td>
        <td>作者</td>
        <td>价格</td>
        <td>描述</td>
        <td>是否在馆</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${requestScope.books}" var="g" varStatus="x">
        <tr>
            <td>${g.id}</td>
            <td>${g.bookName}</td>
            <td>${g.author}</td>
            <td>${g.price}</td>
            <td>${g.bookDesc}</td>

            <c:if test="${g.isExistence == 0}">
                <td>不在</td>
            </c:if>

            <c:if test="${g.isExistence == 1}">
                <td>在馆</td>
                <td>
                    <a href="./execBorrowBookServlet?bookId=${g.id}">借阅</a>
                </td>
            </c:if>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
