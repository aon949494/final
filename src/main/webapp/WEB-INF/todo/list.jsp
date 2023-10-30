<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-22
  Time: 오후 4:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>TodoList</title>
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/todo/list.css">

</head>
<body>
<div class="wrap">
    <div class="info">
        <div class="home"><a href="/todo/home"><h1>HOME</h1></a></div>
        <div class="info-inner"><h1>Todo List</h1></div>
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
        <div class ="list">
            <div class="register">
                <form action="/todo/register">
                    <input type="submit" value="+" class = "reg">
                </form>
            </div>
            <ul>
                <c:forEach items="${dtoList}" var="dto">
                    <li>
                        <div class="total">
                            <span><a href="/todo/read?tno=${dto.tno}">${dto.title}</a></span>
                            <a href="/todo/read?tno=${dto.tno}" style="float: right;padding-right: 20px">${dto.dueDate} ${dto.finished? "DONE":"NOT YET"}</a>
                        </div>
                    </li>
                </c:forEach>
            </ul>


        </div>


    </div>
</div>

</body>
</html>
