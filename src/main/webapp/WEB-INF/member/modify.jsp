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
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/member/modify.css">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수
                    var extraAddr = ''; // 참고항목 변수

                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if(data.userSelectedType === 'R'){
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if(data.buildingName !== '' && data.apartment === 'Y'){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if(extraAddr !== ''){
                            extraAddr = ' (' + extraAddr + ')';
                        }
                        // 조합된 참고항목을 해당 필드에 넣는다.
                        document.getElementById("sample6_extraAddress").value = extraAddr;

                    } else {
                        document.getElementById("sample6_extraAddress").value = '';
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('sample6_postcode').value = data.zonecode;
                    document.getElementById("sample6_address").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("sample6_detailAddress").focus();
                    var ad = document.getElementById("maddr");
                    var addr1 = document.getElementById("sample6_address");
                    ad.value = addr1.value;
                }
            }).open();
        }
        function copys(){

        }
        function pwck(){
            var mpw = document.getElementById("mpw");
            var rpw = document.getElementById("rpw");
            if(mpw.value!=rpw.value){
                alert("x")
                return false;
            }
        }
    </script>
</head>
<body>
<div class="wrap">
    <div class="info">
        <div class="home"><a href="/todo/home"><h1>HOME</h1></a></div>
        <div class="info-inner"><h1>회원정보수정</h1></div>
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

        </div>
    </div>
    <div class="main">
        <div class="member-modify">
            <form id="form1" action="/member/modify" method="post" onsubmit="return pwck()">
                <input type="text" class="membermodify-inner" name="mid" id="mid" value="${loginInfo.mid}" size="35px" readonly><br>
                <input type="password" class="membermodify-inner" id="mpw" name="mpw" value="${loginInfo.mpw}"size="35px" required><br>
                <input type="password" class="membermodify-inner" id="rpw" value="${loginInfo.mpw}"size="35px" required><br>
                <input type="text" class="membermodify-inner" name="mname" value="${loginInfo.mname}"size="35px" readonly><br>
                <input type="date" class="membermodify-inner" name="mage" value="${loginInfo.mage}"size="35px" readonly><br>
                <input type="text" class="membermodify-inner" id="sample6_postcode" placeholder="우편번호">
                <input type="button" class="membermodify-inner" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                <input type="text" class="membermodify-inner" id = "maddr" name="addr1" value="${loginInfo.maddr}"required size="35px"><br>
                <input type="hidden" class="membermodify-inner" id="sample6_extraAddress" placeholder="참고항목">
                <input type="text" class="membermodify-inner" id="sample6_detailAddress" name="addr2" size="35px" placeholder="상세주소"><br>
                <input type="hidden" class="membermodify-inner" id="sample6_address" placeholder="주소">
                <input type="submit" class="update" value="modify">
            </form>
        </div>

    </div>
</div>

</body>
</html>
