<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-22
  Time: 오전 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function reremove(){
            var mid = document.getElementById("mid")
            var rp = "/member/remove?mid="+mid.value;
            window.open(rp,"","width = 400,height=100,left=800,top=300");
        }
    </script>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>HOME</title>
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/member/memberInfo.css">
</head>
<body>
<div class="wrap">
    <div class="info">
        <div class="home"><a href="/todo/home"><h1>HOME</h1></a></div>
        <div class="info-inner"><h1>회원정보</h1></div>
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
            <form id="form1" action="/member/modify" method="get">
                <input type="submit" class="update" value="회원정보수정"><br>
                <input type="button" class="remove" value="회원탈퇴" onclick="reremove()">
        </div>
    </div>
    <div class="main">
        <div class="memberInfo-list">
            <input type="text" class="memberInfo-list_inner" size="40px" name="mid" id="mid" value="${loginInfo.mid}" readonly><br>
            <input type="password" class="memberInfo-list_inner" size="40px" name="mpw" value="${loginInfo.mpw}" readonly><br>
            <input type="text"  class="memberInfo-list_inner"size="40px" name="mname" value="${loginInfo.mname}" readonly><br>
            <input type="date" class="memberInfo-list_inner" name="mage" value="${loginInfo.mage}" readonly><br>
            <input type="text" class="memberInfo-list_inner" size="40px" name="maddr" value="${loginInfo.maddr}" readonly><br>
            </form>
        </div>
    </div>

</div>
</body>
</html>
