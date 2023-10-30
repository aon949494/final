<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-22
  Time: 오후 3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Join</title>
  <link rel="stylesheet" href="/css/join.css">
  <script src = "/js/jquery.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
    function sample6_execDaumPostcode() {
      new daum.Postcode({
        oncomplete: function(data) {
          var addr = '';
          var extraAddr = '';
          if (data.userSelectedType === 'R') {
            addr = data.roadAddress;
          } else {
            addr = data.jibunAddress;
          }
          if(data.userSelectedType === 'R'){
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
              extraAddr += data.bname;
            }
            if(data.buildingName !== '' && data.apartment === 'Y'){
              extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            if(extraAddr !== ''){
              extraAddr = ' (' + extraAddr + ')';
            }
            document.getElementById("sample6_extraAddress").value = extraAddr;
          } else {
            document.getElementById("sample6_extraAddress").value = '';
          }
          document.getElementById('sample6_postcode').value = data.zonecode;
          document.getElementById("sample6_address").value = addr;
          document.getElementById("sample6_detailAddress").focus();
        }
      }).open();
    }
    function idcopy(){
      var mid = document.getElementById("mid");
      var mid2 = document.getElementById("mid2");
      mid2.value=mid.value;
    }
    function pwck(){
      var mpw = document.getElementById("mpw");
      var rpw = document.getElementById("rpw");
      if(mpw.value!=rpw.value){
        alert("비밀번호가 일치하지않습니다!")
        return false;
      }
    }
    function idckno(){
      var ckid = document.getElementById("mid").title;
      if(ckid=='n'){
        alert("ID중복체크해주세요!");
        document.getElementById("mid").focus();
      }
    }
    function idck(){
      var nullid = document.getElementById("mid");
      if(nullid.value.trim()==""||nullid.value==null){
        alert("ID를 입력하세요!");
      }
      else{
        var target ="/idCheck?mid="+nullid.value;
        window.open(target,"","width = 400,height=100,left=800,top=300");
      }
    }
    function change() {
      $("#mid").change(function () {
        document.getElementById("mid").title = "n";
      });
    }
    function ididck(){
      var mid = document.getElementById("mid").value;
      var idck_inner = document.getElementById("idck-inner")
      var dto = [];
      <c:forEach items="${dtoList}" var="dto">
        dto.push("${dto.mid}")
      </c:forEach>
      for(var i=0;i<dto.length;i++){
        if(mid.trim()==""||mid==null){
          idck_inner.textContent="ID 중복체크해주세요!"
          alert("ID를 입력하세요!");
          break;
        }
        else if(dto.includes(mid)){
          idck_inner.textContent="중복된ID입니다!"
          $("#idck-inner").css("color","red")
          document.getElementById("mid").title="n";
          break;
        }
        else{
          idck_inner.textContent="사용가능한 ID입니다."
          $("#idck-inner").css("color","black")
          document.getElementById("mid").title="y";
          break;
        }
      }
    }
  </script>
</head>
<body>
<div class = "main">
  <div class = "join">
    <h1 class="textjoin">JOIN</h1>

    <form id="form2" action="/join" method="post" onsubmit="return pwck()">
      <input type="text" class="inner" name="mid" id="mid" title="n" required onchange="change()">
      <input type="button" id="idck" class="inner" value="ID중복체크" onclick="ididck()"><br>
      <span id="idck-inner" style="font-size: 15px">ID 중복체크해주세요!</span><br>
      <input type="password" class="inner" id="mpw" name="mpw" required placeholder="PW" onclick="idckno();"><br>
      <input type="password" class="inner" id="rpw" required  placeholder="rPW"><br>
      <input type="text" class="inner" name="mname" required placeholder="name"><br>
      <input type="date" class="inner" name="mage" required><br>
      <input type="text" class="inner" id="sample6_postcode" placeholder="우편번호">
      <input type="button" class="inner" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
      <input type="text"class="inner" id="sample6_address" name="addr1" placeholder="주소"><br>
      <input type="text" class="inner" id="sample6_extraAddress" placeholder="참고항목">
      <input type="text" class="inner" id="sample6_detailAddress" name="addr2" placeholder="상세주소"><br>
      <input type="submit" class="button" value="JOIN">
    </form>
  </div>
</div>
</body>
</html>
