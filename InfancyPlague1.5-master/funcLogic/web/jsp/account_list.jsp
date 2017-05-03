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
        $(function () {
            var userId="${user.userId}";
            var name = "${userId}";
            alert(name);
            alert(userId);
        });
        function beforeInsert(){
            /*            var userName=$("#user_name_search").val();
             var userPhone=$("#user_phone_search").val();
             var userEmail=$("#user_email_search").val();*/
            var userId="${user.userId}";
            location.href="${daddyPath}/Account/beforeInsert?userId="+userId;
            /* location.href="c:out value="{jspPath}"//user/selectInfo?userAccount="+userAccount+"&user_name_search="+encodeURI(userName)+
             "&user_phone_search="+encodeURI(userPhone)+"&user_email_search="+encodeURI(userEmail)+"&pageIndex=c:out value="{page.pageIndex}"/>";*/
        }
        function del() {
            var delCheckBox=$(".delectBox");
            var delCheckBoxVal=$(".delectBox");
            //var delCheckBoxValN = $("#del")
            alert("delCheckBox--------------------"+delCheckBox);
            for (var i=0;i<delCheckBox.length;i++){
                if (delCheckBox[i].checked){
                    alert("delCheckBox========"+delCheckBox[i].value);
                }
            }
            //                    <a href="javascript:detailInfo('<c:out value="${account.accountId}"/>')" class="tablelink">查看</a>|
            $("#form").attr("action","<c:out value="${daddyPath}"/>/Account/deleteAccount?delAccountId="+delCheckBox.val());

            $("#form").attr("method","POST");
            //$("#form").attr("target","_blank");
            // $("#form").attr("method","POST");
            //$("#form").attr("enctype","application/x-www-form-urlencoded");
            // $("#form").attr("encoding","application/x-www-form-urlencoded");
            $("#form").submit();
        }
        function detailInfo(accountId) {
            $("#form").attr("action","<c:out value="${daddyPath}"/>/Account/detailAccount?accountId="+accountId);
            $("#form").attr("method","POST");
            $("#form").submit();
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
        <form method="post" action="${restPath}/selectAccountPage/?pageIndex=1">
            <ul class="toolbar">
                <li style="float: left;background-image: none;border: none;vertical-align:middle;">姓名：
                    <input placeholder="请输入姓名" id="user_name_search" name="user_name_search" value="${userName}" class="dfinput" style="height: 25px;width: 120px;margin: auto auto;"/></li>
                <li style="float: left;background-image: none;border: none;vertical-align:middle;">主题：
                    <input placeholder="请输入手机号" id="user_phone_search" name="user_phone_search" value="${userPhone }" class="dfinput" style="height: 25px;width: 120px;margin: auto auto;"/></li>
                <li style="float: left;background-image: none;border: none;vertical-align:middle;">操作员：
                    <input placeholder="请输入邮箱号" id="user_email_search" name="user_email_search" value="${userEmail }" class="dfinput" style="height: 25px;width: 160px;margin: auto auto;"/></li>
                <li class="but" id="search" style="width: 50px;text-align: center;">&nbsp;&nbsp;&nbsp;搜索</li>
                <li class="but" id="gaoji"><span><img
                        src="<c:out value="${basePath}"/>/images/t01.png" /></span>添加</li>
            </ul>

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
                <td><input  type="checkbox" name="delCheckBox" value="${account.accountId}" class="delectBox"/></td>
                <td>
                    <a href="javascript:selectInfo('<c:out value="${account.accountId}"/>')" class="tablelink">查看</a>|
                    <a href="javascript:beforeEdit('<c:out value="${account.accountId}"/>')" class="tablelink">修改</a>|
                    <a href="javascript:del('<c:out value="${user.userId}"/>','<c:out value="${account.accountId}"/>')" class="tablelink">删除</a>
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
</form>

<!-- 页码 -->
<div style="text-align: right;">
    <input
            <c:if test="${page.pageIndex eq 1 }">disabled="disabled"</c:if>
            type="button" value="首页" onclick="goPage(1)"
            style="width: 60px; height: 25px; font-size: 14px; cursor: pointer;" />&nbsp;&nbsp;&nbsp;
    <input
            <c:if test="${page.pageIndex eq 1 }">disabled="disabled"</c:if>
            type="button" value="上一页"
            onclick="goPage(${page.pageIndex-1})"
            style="width: 60px; height: 25px; font-size: 14px; cursor: pointer;" />&nbsp;&nbsp;&nbsp;
    <c:forEach items="${pages}" var="pageNum1">
        <a href="javascript:goPage(${pageNum1});"
           <c:if test="${pageNum1 eq page.pageIndex}">onclick = "return false;"</c:if>
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
