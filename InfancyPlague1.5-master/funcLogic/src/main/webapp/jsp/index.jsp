<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/30
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href='<c:out value="${basePath}"/>/css/index.css' rel="stylesheet" type="text/css" />
</head>
<body>
        <div style="background: red" class="top"><a id="hello">您好,您已登录&nbsp;<span style="color:red">{${title}}</span></a>
            <a id="exit" href="javascript:location.href='${restPath}/user/logout'">退出</a>
            <a id="global" href="javascript:global();">全局配置-----------${daddyPath}</a>
            <a id="apps" href="javascript:location.href='${basePath}jsp/webconf/index.jsp'">应用配置</a>
        </div>
        <div class="in_head" style="background: orange">
            <img id="logoImg" src='<c:out value="${basePath}"/>/images/logo.png' />
            <div class="clear"></div>
        </div>
        <div class="content" >
            <div class="c_list clearFix" style="width:100%;">

                <div class="left" style="width: 15%; height: 100%;">
                    <iframe id="iframe_left" width="100%"  height="100%" src='/succ.jsp' scrolling="yes"  frameborder="0"></iframe>
<%--
                    <iframe id="iframe_left" width="100%"  height="100%" src='<c:out value="${daddy}"/>/apps/getDisList' scrolling="yes"  frameborder="0"></iframe>
--%>
                </div>
                <div class="left" style="width: 85%; height: 100%; "><%--
                    <iframe id="iframe_content" width="100%"  height="100%" src='<c:out value="${restPath}"/>/apps/pageSelect?appName=""' scrolling="yes"  frameborder="0"></iframe>--%>
                    <iframe id="iframe_content" width="100%"  height="100%" src='"<c:out value="${daddyPath}"/>"/Account/selectAccountPage' scrolling="yes"  frameborder="0"></iframe>
                </div>
                <div id="bottomm" style="display:none;">
                    <iframe id="iframe_bottom"  width="100%"  height="100%"  frameborder="0" ></iframe>
                </div>
            </div>
        </div>
</body>
</html>
