# 图书管理系统（网页端）

## 环境

- openjdk 11
- tomcat9
- mariadb

## 未完成功能

- root级别用户功能未实现
- admin级别用户功能实现不全
- 没有注册功能

## 构想

- user只有借书还书功能（对自己的记录的record表增删改查），以及对图书的查询（book表的查）
- admin可以对图书管理（对book表的增删改查），可以查看所有人的借阅记录（对record的查）
- root用户基于admin多了一个用户管理