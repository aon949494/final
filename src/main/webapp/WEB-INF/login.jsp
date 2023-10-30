<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-22
  Time: 오후 2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN</title>
  <link rel="stylesheet" href="/css/login.css">
</head>
<body>
<div class = "main">
  <div class = "login">
    <h1>LOGIN</h1>
    <form action="/login" method="post">
      <input type="text" class="midpw" name="mid" placeholder="ID"><br>
      <input type="password" class="midpw" name="mpw" placeholder="PW"><br>
      <input type="checkbox" class="button" name="auto" style="zoom: 1.5">
      <input type="submit"class="button1"  value="login">
    </form>
    <form action="/join">
      <input type="submit"class="button2"  value="join">
    </form>
  </div>


</div>
</body>
</html>
