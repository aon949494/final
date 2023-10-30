<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-25
  Time: 오전 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/memo/list.css">

</head>
<body>
<div class="wrap">
    <div class="info">
        <div class="home"><a href="/todo/home"><h1>HOME</h1></a></div>
        <div class="info-inner"><h1>Memo List</h1></div>
    </div>
    <div class="header">
        <div class="h1">
            <h1>${loginInfo.mid}</h1>
            ${loginInfo.mname}님
        </div>
        <div class="h1_1">
            <form action="/member/memberInfo">
                <input type="submit" class="myPage"  value="MYPAGE">
            </form>
            <form action="/logout" method="post">
                <input type="submit" class="logOut" value="LOGOUT">
            </form>
        </div>
        <div class="h2">
            <ul>
                <li><a href="/todo/list?id=${loginInfo.mid}">TodoList</a></li>
                <li><a href="/memo/list?id=${loginInfo.mid}">MEMO</a></li>
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="list">
            <form action="/memo/register">
                <input type="submit" value="+" class="reg">
            </form>
            <ul>
                <c:forEach items="${dtoList}" var="dto">
                <li>
                    <a href="/memo/read?tno=${dto.tno}">${dto.title}</a>
                    <a href="/memo/read?tno=${dto.tno}" style="float: right;padding-right: 20px">${dto.dueDate}</a>
                </li>
                </c:forEach>
        </div>

    </div>
</div>
</body>
</html>
