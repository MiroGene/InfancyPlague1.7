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
    <title>Title</title>
    <style>
        .formtitle{border-bottom:solid 1px #d0dee5; line-height:35px; position:relative; height:35px; margin-bottom:28px;}
        .formtitle span{font-weight:bold;font-size:14px; border-bottom:solid 3px #66c9f3;float:left; position:absolute; z-index:100; bottom:-1px; padding:0 3px; height:30px; line-height:30px;}
    </style>
</head>
<body>
<div class="frombody">
<div class="formtitle">
    <span style="margin-left: 20px;font-size: 15px;">查看明细</span>
    <div class="btn_box" style="text-align: right;float: right;padding-top: 1px;">
        <input type="button" id="btn4" value="返回" onclick="history.back()"/>
    </div>
</div>
<table border="1px" id="tab" style="table-layout: fixed;word-wrap:break-word;width: 97.5%;margin: 0 auto;">

    <tr class="trs">
        <td style="width: 100px;">组&nbsp;&nbsp;名：</td>
        <td>${appsConf.groupName}</td>
    </tr>
    <tr class="trs">
        <td>键：</td>
        <td>${appsConf.confKey}</td>
    </tr>
    <tr class="trs">
        <td>类&nbsp;&nbsp;型：</td>
        <td>${appsConf.confType}</td>
    </tr>
    <tr class="trs">
        <td>值：</td>
        <td style="padding: 5px;">${appsConf.confValue}</td>
    </tr>
    <tr class="trs">
        <td>备&nbsp;&nbsp;注：</td>
        <td>${appsConf.remarks}</td>
    </tr>
</table>
</div>
</body>
</html>
