<%--
  Created by IntelliJ IDEA.
  User: 吴全虎
  Date: 2019/9/11
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
    <meta name="author" content="Vincent Garreau" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <link rel="stylesheet" media="screen" href="css/login/login.css" c>

</head>
<body>
    <!-- particles.js container -->
    <div id="particles-js" style="display: flex;align-items: center;justify-content: center">
    </div>
    <div class="login-page">
        <div class="login-content">
            <div class="login-tit">登录</div>
            <form action="/login.do" method="post">
                <div class="login-input">
                    <input type="text" name="username" placeholder="用户名">
                </div>
                <div class="login-input">
                    <input type="password" name="password" placeholder="密码">
                </div>
                <div class="login-btn">
                    <div class="login-btn-left">
                        <input type="submit" value="登录">
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script src="js/login/particles.js"></script>
    <script src="js/login/app.js"></script>
<script>

    function check(){

    }

    window.onload=function () {
        if("${xinxi}"!=""){
            alert("${xinxi}");
        }
    }
</script>
</body>
</html>
