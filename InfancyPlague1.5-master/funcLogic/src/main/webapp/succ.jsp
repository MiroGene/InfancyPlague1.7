<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
  Created by IntelliJ IDEA.
  User: Scarlet
  Date: 2017/1/10
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<link rel="stylesheet" href="<c:out value="${basePath}"/>/css/index.css"/>  c:out使用范例,css文件导入范例--%>
        <script src="js/jquery-1.7.2.js"></script>
    <script src="<c:out value="${basePath}"/>/js/index.js"></script>
    <script src="<c:out value="${basePath}"/>/js/background.js"></script>
    <script src="<c:out value="${basePath}"/>/js/ajaxfileupload.js"></script>
    <title>TestLgn</title>
    <script type="text/javascript">
        $(function () {
            var a = "${name}";
            alert(a);
            alert("   ");
        });


    </script>
</head>
<body>
${name} <br/>
${password}
</body>
</html>
