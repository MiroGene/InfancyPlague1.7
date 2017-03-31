<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/30
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<frameset rows="88,*" cols="*" frameborder="no" border="0"
          framespacing="0">
    <frame src="<c:out value="${basePath}"/>/jsp/top.jsp" name="topFrame" scrolling="" noresize="noresize"
           id="topFrame" title="topFrame" />

    <frameset cols="210,*" frameborder="no" border="0" framespacing="0">
        <frame src="<c:out value="${restPath}"/>/main/getUserMenus?proId=${proId}" name="leftFrame" scrolling=no
               noresize="noresize" id="leftFrame" title="_blank" />

        <frame src="<c:out value="${basePath}"/>/jsp/hello.jsp" name="rightFrame"
               id="rightFrame" title="_blank" />
    </frameset>
</frameset>
<body>

</body>
</html>
