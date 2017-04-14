<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/27
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>填写账单</title>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            var userId = "${userId}";
            alert(userId);
        })
    </script>
</head>
<body>
<div>
    <form action="${daddyPath}/Account/insertAccount" id="insertForm">
        <ul>
            <li>
                <input type="text" id="userName" name="userName" value="姓名"/>
            </li>

            <li>
                <input type="text" id="accountTitle" name="accountTitle" value="主题"/>
            </li>
            <li>
                <input type="text" id="money" name="money" value="金额"/>
            </li>
            <li>
                审核状态:<input type="text" id="states" name="states"/>
            </li>
            <li>
                <input type="text" id="company" value="company"/>
            </li>
    <%--        <li>
                <input type="text" id="" name=""/>
            </li>
            <li>
                <input type="text" id="" name=""/>
            </li>
            <li>
                <input type="text" id="" name=""/>
            </li>--%>
            <li>
                <textarea id="detail" name="confValue"  style="float: left;width:650px;" cols="" rows="" class="textinput"></textarea><br>
            </li>
            <li>
                <input type="submit" />
            </li>
            <%--隐藏，不可选的input--%>
            <li>
                <input type="text" id="userId" name="userId" value="<c:out value="${userId}"/>
            </li>
        </ul>
    </form>



</div>


</body>
</html>
