<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--

  Created by IntelliJ IDEA.
  User: Scarlet
  Date: 2017/1/17
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <script src="js/jquery-1.7.2.js"></script>
    <script src="<c:out value="${basePath}"/>/js/index.js"></script>
    <script src="<c:out value="${basePath}"/>/js/background.js"></script>
    <script src="<c:out value="${basePath}"/>/js/ajaxfileupload.js"></script>
    <script type="text/javascript">

        $(function(){
            alert("   ");
            location.href='<c:out value="${basePath}"/>Login.jsp'
        });

    </script>
  </head>
  <body>
  $END$
  </body>
</html>
