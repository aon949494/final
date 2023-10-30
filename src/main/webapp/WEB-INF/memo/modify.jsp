<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-25
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/memo/modify.css">

</head>
<body>
<div class="wrap">
    <div class="info">
        <div class="home"><a href="/todo/home"><h1>HOME</h1></a></div>
        <div class="info-inner"><h1>Memo Modify</h1></div>
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
            <form id="form1" action="/memo/modify" method="post">
                    <input type="hidden" class="read-con" name="tno" value="${dto.tno}" readonly>
                    <input type="text" class="title" name="title" value="${dto.title}" ><br>
                    <textarea name="memo" class="read-con" cols="60" rows="20" value="${dto.memo}">${dto.memo}</textarea><br>
                    <input type="date" hidden="hidden" name="dueDate" value="${dto.dueDate}" >
                    <input type="hidden" name="id" value="${dto.id}">
                    <button type="submit" class="update">Modify</button>
            </form>
            <form id="form2" action="/memo/remove" method="post">
                <input type="hidden" name="tno" value="${dto.tno}" readonly>
                <input type="hidden" name="id" value="${dto.id}" readonly>
                <div>
                    <button type="submit" class="delete">Remove</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

