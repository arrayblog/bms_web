<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>add_book_type</title>
</head>
<body>
<form action="./execAddBookTypeServlet" method="post">
    图书类型名称：<input type="text" name="bookTypeName">
    <br>
    图书类型描述：<input type="text" name="bookTypeDesc">
    <br>
    <input type="submit">
</form>
</body>
</html>