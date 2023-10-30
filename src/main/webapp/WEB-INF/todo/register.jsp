<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-14
  Time: 오후 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/todo/register.css">

</head>
<body>
<div class="wrap">
    <div class="info">
        <div class="home"><a href="/todo/home"><h1>HOME</h1></a></div>
        <div class="info-inner"><h1>Todo Register</h1></div>
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
        <div class="register">
            <form action="/todo/register?id=${loginInfo.mid}" method="post">
                <div class="register-con">
                    <input type="text" name="title" class="register-concon" placeholder="INSERT TITLE"><br>
                    <input type="date" name="dueDate" class="register-concon">
                    <input type="hidden" name="id"><br>
                    <button type="reset" class="reset">RESET</button>
                    <button type="submit" class="reg">REGISTER</button>
                </div>

            </form>
        </div>

    </div>
</div>
</body>
</html>

