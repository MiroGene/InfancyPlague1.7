<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/31
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>account_list</title>
    <link href='<c:out value="${basePath}"/>/css/index.css' rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        function beforeInsert(){
/*            var userName=$("#user_name_search").val();
            var userPhone=$("#user_phone_search").val();
            var userEmail=$("#user_email_search").val();*/
            var userId="${user.userId}"
            alert(userId);
            location.href="<c:out value="${jspPath}"/>/account_insert.jsp?userId="+userId;
                /* location.href="c:out value="{jspPath}"//user/selectInfo?userAccount="+userAccount+"&user_name_search="+encodeURI(userName)+
             "&user_phone_search="+encodeURI(userPhone)+"&user_email_search="+encodeURI(userEmail)+"&pageIndex=c:out value="{page.pageIndex}"/>";*/
        }
    </script>
</head>
<body>

<%--账单列表，创建新账单按钮，查找按钮及输入框，个人信息修改--%>
<div class="place">
    <span>账单列表</span>
</div>
<div class="rightinfo">
    <div class="tools">
        --------------------<c:out value="${daddyPath}"/>
        <form id="searchForm" method="post" action="${daddyPath }/Account/selectAccountPage?pageIndex=1">
            <ul class="toolbar">
                <li style="float: left;background-image: none;border: none;vertical-align:middle;">姓名：
                    <input placeholder="请输入姓名" id="user_search" name="user_name_search"  class="dfinput" style="height: 25px;width: 120px;margin: auto auto;"/></li>
                    <%--<input placeholder="请输入姓名" id="user_search" name="user_name_search" value="${accountOperator}" class="dfinput" style="height: 25px;width: 120px;margin: auto auto;"/></li>--%>
                <li style="float: left;background-image: none;border: none;vertical-align:middle;">操作员姓名：
                    <input placeholder="请输入操作员" id="operator_search" name="user_phone_search"  class="dfinput" style="height: 25px;width: 120px;margin: auto auto;"/></li>
                <li style="float: left;background-image: none;border: none;vertical-align:middle;">日期：
                    <input placeholder="请输入日期" id="date_search" name="user_email_search"class="dfinput" style="height: 25px;width: 160px;margin: auto auto;"/></li>
                <li class="but" id="search1" style="width: 50px;text-align: center;" >&nbsp;&nbsp;&nbsp;
                    <input id="search" type="submit" value="搜索" /></li>
                <li class="but" id="gaoji"><span><img
                        src="<c:out value="${basePath}"/>/images/t01.png" /></span>添加</li>

            </ul>
        </form>
        <a href="javascript:beforeInsert()" class="tablelink">增加</a>|
    </div>
    <table class="tablelist" style="table-layout: fixed;word-wrap:break-word;">
        <thead>
        <tr>
            <th width="30px"></th>
            <th width="220px">主题</th>
            <th width="120px">姓名</th>
            <th width="140px">审核状态</th>
            <th width="120px">操作员</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="account" items="${accountVoList}" varStatus="i">
            <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>
                    <form action="${daddy}/Account/selectAccountPage">
                    <a href="javascript:selectInfo('<c:out value="${account.accountId}"/>')" class="tablelink">查看</a>|
                    <a href="javascript:beforeEdit('<c:out value="${account.accountId}"/>')" class="tablelink">修改</a>|
                    <a href="javascript:del('<c:out value="${user.userId}"/>','<c:out value="${account.accountId}"/>')" class="tablelink">删除</a>
                    </form>
                </td>
                <td><c:out value="${account.title}" /></td>
                <%--<td><c:out value="${account.userName}" /></td>--%>
                <td><c:out value="${account.states}" /></td>
                <td><c:out value="${account.accountOperator}" /></td>
 <%--               <td>
                    <c:forEach var="userPer" items="${userPers}">
                        <c:if test="${user.userId eq userPer.userId}" >
                            ${userPer.projectNameStr}
                        </c:if>
                    </c:forEach>
                </td>
                <td><c:out value="${user.userRemarks}" /></td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">

    </div>
</div>


<!-- 页码 -->
<div style="text-align: right;">
    <input
            <c:if test="${pageIndex eq 1 }">disabled="disabled"</c:if>
            type="button" value="首页" onclick="goPage(1)"
            style="width: 60px; height: 25px; font-size: 14px; cursor: pointer;" />&nbsp;&nbsp;&nbsp;
    <input
            <c:if test="${pageIndex eq 1 }">disabled="disabled"</c:if>
            type="button" value="上一页"
            onclick="goPage(${pageIndex-1})"
            style="width: 60px; height: 25px; font-size: 14px; cursor: pointer;" />&nbsp;&nbsp;&nbsp;
    <c:forEach items="${pages}" var="pageNum1">
        <a href="javascript:goPage(${pageNum1});"
           <c:if test="${pageNum1 eq pageIndex}">onclick = "return false;"</c:if>
           style="font-size: 16px;line-height: 25px; <c:if test='${pageNum1 eq page.pageIndex}'>color:#DDDDDD;</c:if>">${pageNum1}</a>&nbsp;&nbsp;
    </c:forEach>
    &nbsp;&nbsp; <input
        <c:if test="${page.pageIndex eq page.totalPage }">disabled="disabled"</c:if>
        type="button" value="下一页"
        onclick="goPage(${page.pageIndex+1})"
        style="width: 60px; height: 25px; font-size: 14px; cursor: pointer;" />&nbsp;&nbsp;&nbsp;
    <input
            <c:if test="${page.pageIndex eq page.totalPage }">disabled="disabled"</c:if>
            type="button" value="末页"
            onclick="goPage(${page.totalPage})"
            style="width: 60px; height: 25px; font-size: 14px; cursor: pointer;" />
</div>
</body>
</html>
