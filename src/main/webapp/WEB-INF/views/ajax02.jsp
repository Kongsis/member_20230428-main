<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-01
  Time: 오후 3:22
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
<button onclick="ajax02()">함수호출</button>
</body>
<script>
    const ajax02 = () =>{
        $.ajax({
            type:"post",
            url: "/ajax02",
            success: function (res){
                console.log("요청성공",res);
            },
            error: function (){
                console.log("요청실패");
            }
        });
    }
</script>
</html>