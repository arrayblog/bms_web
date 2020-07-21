<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>manage_book</title>
</head>
<body>

<a href="./addBook">添加图书</a>
<a href="./add_book_type.jsp">添加图书类型</a>

<br>

<form action="./manageBook" method="post">
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
        <td colspan="3">操作</td>
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
            </c:if>

            <td>
                <a href="./execDelBookServlet?id=${g.id}">删除</a>&nbsp;&nbsp;
            </td>
            <td>
                <a href="./updateBook?id=${g.id}">修改</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
