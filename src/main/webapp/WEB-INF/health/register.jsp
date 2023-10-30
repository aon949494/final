<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-27
  Time: 오후 3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>HOME</title>
  <link rel="stylesheet" href="/css/home.css">
  <script>

    function setval(){
      var sel = document.getElementById("health-select");
      var ti = document.getElementById("textinner");
      var tk = document.getElementById("textkal")
      var kg = document.getElementById("kg");
      var hour = document.getElementById("hour");
      ti.value = sel.options[sel.selectedIndex].text;
      if(ti.value=="산책"){
        tk.value= 3.52*kg.value*hour.value
      }
      else if(ti.value=="조깅"){
        tk.value= 8.36*kg.value*hour.value
      }
      else if(ti.value=="자전거"){
        tk.value= 5.94*kg.value*hour.value
      }
      else if(ti.value=="줄넘기"){
        tk.value= 8.36*kg.value*hour.value
      }
      else if(ti.value=="등산"){
        tk.value= 7.26*kg.value*hour.value
      }
      else if(ti.value=="요가"){
        tk.value= 2.1*kg.value*hour.value
      }
    }
  </script>

</head>
<body>
<div class="wrap">
  <div class="info">
    <div class="home"><a href="/todo/home"><h1>HOME</h1></a></div>
    <div class="info-inner"><h1>Health Register</h1></div>
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

    <form action="/health/register?id=${loginInfo.mid}" method="post">
      <input type="text" id="height" name="height">cm
      <input type="text" id="kg" name="weight">kg
      <input type="text" id="hour" placeholder="hour">
      <select id="health-select" onchange="setval()">
        <option name="group1" value="선택">선택</option>
        <option name="group1" value="산책">산책</option>
        <option name="group1" value="조깅">조깅</option>
        <option name="group1" value="자전거">자전거</option>
        <option name="group1" value="줄넘기">줄넘기</option>
        <option name="group1" value="등산">등산</option>
        <option name="group1" value="요가">요가</option>
      </select>
      <input type="text" name="move" id="textinner">
      <input type="text" name="kal" id="textkal">kcal
      <input type="date" name="dueDate">
      <input type="submit">
    </form>

    <hr>
  </div>
</div>
</body>
</html>
