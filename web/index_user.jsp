<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>index_user</title>
</head>
<body>
<span class="navbar-brand">欢迎您，<c:out value="${activeUser.username}" default="null_name"></c:out>！</span>
<a href="./execLogoutServlet">退出</a>
<ul>
    <li><a href="./queryBook">借阅书本</a></li>
    <li><a href="./queryRecord">借阅记录</a></li>
</ul>
</body>
</html>
