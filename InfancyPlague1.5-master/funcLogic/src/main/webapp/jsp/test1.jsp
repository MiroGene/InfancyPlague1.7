<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/21
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>try1</title>
    <script type="text/javascript">
        function test(){
            $('#main').empty();
        }
        /**
         * 自引用函数
         */
        function invokeSelf(){

        }
    </script>
</head>
<body>
<header>
    <h2>Race</h2>
</header>
<div id="main">
    <ul class="idTabs">
        <li><a href="#male">Male Finishers</a></li>
        <li><a href="#female">Female Finishers</a> </li>
        <li><a href="#all">all Finishers</a> </li>
        <li>
            <ul id="circle1"><li>aaa</li></ul>
        </li>
    </ul>


    <div id="male">
        <h4>Male Finishers</h4>+
        <ul id="finishers-m"></ul>
    </div>

    <div id="female">
        <h4>Female Finishers</h4>
        <ul id="finishers-f"></ul>
    </div>
</div>
<script src="/js/jquery-1.7.2.js"></script>
</body>
</html>


