<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/14
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改菜单</title>
</head>
<body>
    <form action="/daddy/Account/updateAccount" id="updateForm">
<%--${daddyPath}--%>
        <ul>
            <li>
                <input type="text" id="title" name="title"/>
            </li>
            <li>
                <input type="text" id="operatorName" name="operatorName"/>
            </li>
            <li>
                <input type="submit" value="sub" />
            </li>

        </ul>
    </form>
</body>
</html>
