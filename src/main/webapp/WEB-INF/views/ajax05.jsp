<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-01
  Time: 오후 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>
<%-- ajax(Asynchronous Javascript and XML) --%>
<button onclick="ajax05()">함수호출</button>
</body>
<script>
  const ajax05 = () => {
    const memberEmail = "aa@aa.com";
    const memberPassword = "1q2w3e";
    const memberName = "member1";
    $.ajax({
      type: "get",
      url: "/ajax05",
      data: {
        "memberEmail": memberEmail,
        "memberPassword": memberPassword,
        "memberName": memberName
      },
      success: function (res) {
        console.log("요청성공", res);
        console.log(res.memberEmail);
        console.log(res.memberPassword);
        console.log(res.memberName);
      },
      error: function () {
        console.log("요청실패");
      }
    });
  }
</script>
</html>