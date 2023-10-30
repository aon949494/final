<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-25
  Time: 오후 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>

        function setval(){
            var sel = document.getElementById("health-select");
            var ti = document.getElementById("textinner");
            var tk = document.getElementById("textkal")
            var kg = document.getElementById("kg");
            var hour = document.getElementById("hour");
            ti.value = sel.options[sel.selectedIndex].text;
            if(ti.value=="걷기"){
                tk.value= 7.26*kg.value*hour.value
            }
            else if(ti.value=="달리기"){
                tk.value= 8.36*kg.value*hour.value
            }
            else if(ti.value=="자전거"){
                tk.value= 5.94*kg.value*hour.value
            }
            else if(ti.value=="줄넘기"){
                tk.value= 8.36*kg.value*hour.value
            }
        }
    </script>
</head>
<body>
    <h1>select</h1>
    <form action="/health" method="post">
        <input type="text" id="kg" placeholder="kg">
        <input type="text" id="hour" placeholder="hour">
        <select id="health-select" onchange="setval()">
            <option name="group1" value="선택">선택</option>
            <option name="group1" value="걷기">걷기</option>
            <option name="group1" value="달리기">달리기</option>
            <option name="group1" value="자전거">자전거</option>
            <option name="group1" value="줄넘기">줄넘기</option>
            <option name="group1" value="스쿼트">스쿼트</option>
            <option name="group1" value="윗몸일으키기">윗몸일으키기</option>
        </select>
        <input type="text" name="test" id="textinner">
        <input type="text" name="testkal" id="textkal">
        <input type="submit">
    </form>

</body>
</html>
