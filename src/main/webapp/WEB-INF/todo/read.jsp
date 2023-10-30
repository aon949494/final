<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-19
  Time: 오전 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read</title>
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/todo/read.css">

</head>
<body>
<div class="wrap">
    <div class="info">
        <div class="home"><a href="/todo/home"><h1>HOME</h1></a></div>
        <div class="info-inner"><h1>Todo Read</h1></div>
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
                <li><a href="/memo/list">MEMO</a></li>
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="list-con">
            <input type ="hidden" class="read-con" name="tno" value="${dto.tno}" readonly><br>
            <input type ="text" class="read-con" name="title" value="${dto.title}" readonly><br>
            <input type ="date" class="read-con" name="dueDate" value="${dto.dueDate}" readonly><br>
            <input type ="checkbox" class="read-con" name="finished" ${dto.finished? "checked":""} disabled><br>
            <button class="update"><a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a></button>
        </div>
    </div>
</div>
</body>
</html>
