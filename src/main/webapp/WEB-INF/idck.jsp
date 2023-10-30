<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-21
  Time: 오후 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function ok(){
            opener.document.getElementById("mid").title = "y";
            window.close();
        }
        function pass(){
            opener.document.getElementById("mid").value="";
            window.close();
        }

    </script>
</head>
<body>
<% String mid = request.getParameter("mid");
    boolean ck = (boolean) request.getAttribute("ck");
  if(ck==true){
      out.println(mid+"는 사용가능한아이디입니다!");
%>
<input type="button" value="사용" onclick="ok()">
<input type="button" value="취소" onclick="pass()">
<%
}
  else{
    out.println(mid+"는 중복된 아이디입니다.다시입력해주세요!");
%>

<input type="button" value="닫기" onclick="pass()">
<%}
%>


</body>
</html>
