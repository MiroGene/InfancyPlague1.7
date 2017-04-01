<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/31
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script src="js/jquery-1.7.2.js"></script>
    <script src="<c:out value="${basePath}"/>/js/jquery-1.7.2.js"></script>
    <script src="<c:out value="${basePath}"/>/js/index.js"></script>
    <script src="<c:out value="${basePath}"/>/js/background.js"></script>
    <script src="<c:out value="${basePath}"/>/js/ajaxfileupload.js"></script>
    <script type="text/javascript">
        $(function () {
            alert("   ");
        });
    </script>
</head>
<body>
<form action="${daddyPath}/Lgn/checkUsr" method="post">
    ${daddyPath}<br>
        用户名<input type="text" id="usrNme" name="usrNme"/>
        密码<input type="password" id="usrPwd" name="usrPwd"/>
        手机号<input type="password" id="usrPwd" name="usrPwd"/>
    <input type="submit">
</form>
</body>
</html>
