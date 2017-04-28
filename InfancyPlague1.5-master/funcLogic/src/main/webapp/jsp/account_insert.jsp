<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/27
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>填写账单</title>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        function submitt() {
            var userId = "${userId}";
            alert(userId);
            $("#insertForm").attr("action","${daddyPath}/Account/insertAccount");
            alert("aaaa");
            $("#insertForm").submit();
            alert("aaaa");
        };

    </script>
</head>
<body>
<div>
    <form id="insertForm"> <%--action="${daddyPath}/Account/insertAccount" --%>
        <ul>
            <li>
                姓名${userId}:<input type="text" id="userName" name="userName" value="姓名"/>
            </li>

            <li>
                主题${daddyPath}:<input type="text" id="accountTitle" name="accountTitle" value="主题"/>
            </li>
            <li>
                金额:<input type="text" id="money" name="money" value="金额"/>
            </li>
            <li>
                审核状态:<input type="text" id="states" name="states"/>
            </li>
            <li>
                公司:<input type="text" id="company" value="company"/>
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
                详细:    <textarea id="detail" name="detail"  style=" float: left;width:650px;" cols="" rows="" class="textinput"></textarea><br>
            </li>
            <li>
                <input type="hidden" name="userId" value="<c:out value="${userId}"/>"/>
            </li>
            <li>
                <input   type="button"	class="btn" value="保存" onclick="submitt()"/>
            </li>
        </ul>
    </form>



</div>


</body>
</html>
