<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-25
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="/css/home.css">
  <link rel="stylesheet" href="/css/memo/register.css">

</head>
<body>
<div class="wrap">
  <div class="info">
    <div class="home"><a href="/todo/home"><h1>HOME</h1></a></div>
    <div class="info-inner"><h1>Memo Register</h1></div>
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
    <div class="register">
      <form action="/memo/register" method="post">
          <input type="text" class="title" name="title" placeholder="INSERT TITLE"><br>
          <textarea class="register-concon" cols="60" rows="20" name="memo" placeholder="INSERT INNER"></textarea><br>
          <input type="hidden" name="id" value="${loginInfo.mid}">
          <button type="reset" class="reset">RESET</button>
          <button type="submit" class="reg">REGISTER</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>
