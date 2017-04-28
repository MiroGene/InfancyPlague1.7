<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/28
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账单信息</title>
    <style>
        .formtitle{border-bottom:solid 1px #d0dee5; line-height:35px; position:relative; height:35px; margin-bottom:28px;}
        .formtitle span{font-weight:bold;font-size:14px; border-bottom:solid 3px #66c9f3;float:left; position:absolute; z-index:100; bottom:-1px; padding:0 3px; height:30px; line-height:30px;}
    </style>
    <script src="<c:out value="${basePath}"/>/js/jquery-1.7.2.js"></script>
</head>
<body>
<div class="frombody">
<div class="formtitle">
    <span style="margin-left: 20px;font-size: 15px;">查看账单信息</span>
    <div class="btn_box" style="text-align: right;float: right;padding-top: 1px;">
        <input type="button" id="btn4" value="返回" onclick="history.back()"/>
    </div>
</div>
<table border="1px" id="tab" style="table-layout: fixed;word-wrap:break-word;width: 97.5%;margin: 0 auto;">

    <tr class="trs">
        <td style="width: 100px;">账单主题:</td>
        <td>${account.title}</td>
    </tr>
    <tr class="trs">
        <td>申请人：</td>
        <td>${account.userName}</td>
    </tr>
    <tr class="trs">
        <td>金&nbsp;&nbsp;额：</td>
        <td>${account.money}</td>
    </tr>
    <tr class="trs">
        <td>日期：</td>
        <td style="padding: 5px;">${account.date}</td>
    </tr>
    <tr class="trs">
        <td>公&nbsp;&nbsp;司：</td>
        <td>${account.company}</td>
    </tr>
    <tr class="trs">
        <td>详&nbsp;&nbsp;细：</td>
        <td>${account.detail}</td>
    </tr>
    <tr class="trs">
        <td>审核状态：</td>
        <td>${account.states}</td>
    </tr>
</table>
</div>
</body>
</html>
