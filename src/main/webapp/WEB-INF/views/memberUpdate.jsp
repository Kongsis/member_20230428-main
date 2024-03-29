<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-01
  Time: 오전 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
<%@include file="./component/header.jsp"%>
<%@include file="./component/nav.jsp"%>
    <div id="section">
        <form action="/update" method="post" name="updateForm">
            <input type="text" name="id" value="${member.id}" readonly placeholder="id"> <br>
            <input type="text" name="memberEmail" value="${member.memberEmail}" readonly placeholder="email"> <br>
            <input type="text" name="memberPassword" id="memberPassword" placeholder="password"> <br>
            <input type="text" name="memberName" value="${member.memberName}" placeholder="name"> <br>
            <input type="text" name="memberBirth" value="${member.memberBirth}" readonly placeholder="birth"> <br>
            <input type="text" name="memberMobile" value="${member.memberMobile}" placeholder="mobile"> <br>
            <input type="button" onclick="update_check()" value="수정">
        </form>
    </div>
<%@include file="./component/footer.jsp"%>
</body>
<script>
    const update_check = () => {
        const inputPass = document.getElementById("memberPassword").value;
        const DBPass = '${member.memberPassword}';
        if(inputPass == DBPass) {
            document.updateForm.submit();
        } else {
            alert("비밀번호가 일치하지 않습니다.");
        }
    }
</script>
</html>