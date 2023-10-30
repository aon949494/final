<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-22
  Time: 오전 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function pass(){
            window.close();
        }
    </script>
</head>
<body>
${mid}님 정말 탈퇴하시겠습니까?
<form action="/member/remove?mid=${mid}" method="post">
    <input type="submit" value="remove">
    <input type="button" value="close" onclick="pass()">
</form>

</body>
</html>
