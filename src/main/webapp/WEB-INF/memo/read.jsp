<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-25
  Time: 오후 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/memo/read.css">

</head>
<body>
<div class="wrap">
    <div class="info">
        <div class="home"><a href="/todo/home"><h1>HOME</h1></a></div>
        <div class="info-inner"><h1>Memo Read</h1></div>
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
        <div class="list-con">
            <input type ="hidden" class="read-con" name="tno" value="${dto.tno}" readonly>
            <input type ="text" class="title" name="title" value="${dto.title}" readonly><br>
            <textarea name="memo" class="read-con" readonly cols="60" rows="20">${dto.memo}</textarea><br>
            <input type ="date" hidden="hidden" name="dueDate" value="${dto.dueDate}" readonly>
            <button class="update"><a href="/memo/modify?tno=${dto.tno}">MODIFY/REMOVE</a></button>
        </div>
    </div>
</div>
</body>
</html>
