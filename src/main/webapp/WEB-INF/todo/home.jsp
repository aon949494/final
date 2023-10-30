<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-22
  Time: 오후 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>HOME</title>
    <link rel="stylesheet" href="/css/home.css">

</head>
<body>
<div class="wrap">
    <div class="info">
        <div class="home"><a href="/todo/home"><h1>HOME</h1></a></div>
        <div class="info-inner"><h1>MAIN</h1></div>
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
        <br>
        <hr>
        <h1>빅데이터 5기 김예원</h1>
        <hr>
    </div>
</div>
</body>
</html>
