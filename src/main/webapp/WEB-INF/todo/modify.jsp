<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-25
  Time: 오전 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="/css/home.css">
  <link rel="stylesheet" href="/css/todo/modify.css">

</head>
<body>
<div class="wrap">
  <div class="info">
    <div class="home"><a href="/todo/home"><h1>HOME</h1></a></div>
    <div class="info-inner"><h1>Todo Modify</h1></div>
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
      <form id="form1" action="/todo/modify" method="post">
        <input type="hidden" class="read-con" name="tno" value="${dto.tno}" readonly>
        <input type="text"class="read-con" name="title" value="${dto.title}" ><br>
        <input type="date"class="read-con" name="dueDate" value="${dto.dueDate}"><br>
        <input type="checkbox" class="read-con" name="finished" ${dto.finished? "checked":""} ><br>
        <input type="hidden" name="id" value="${dto.id}">
        <button type="submit" class="update">Modify</button>
      </form>
      <form id="form2" action="/todo/remove" method="post">
        <input type="hidden" name="tno" value="${dto.tno}" readonly>
        <input type="hidden" name="id" value="${dto.id}" readonly>
        <button type="submit" class="delete">Remove</button>
      </form>
    </div>

  </div>
</div>
</body>
</html>
