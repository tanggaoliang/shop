<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2019/5/6
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<%@ include file="/WEB-INF/jsp/base2.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>拼购网后台</title>
    <link rel="stylesheet" href="/static/css/manage.css">
</head>
<body class="layui-layout-body">


    <div class="layui-body">
        <h1 align="center" style="color:green"> ${head} </h1>
        <!-- 内容主体区域 -->
        <div id="main">
            <table class="table">
                <thead>
                <%--        <th>选中</th>--%>
                <th>id</th>
                <th>用户名</th>
                <th>编辑</th>
                <th>删除</th>
                </thead>
                <c:forEach items="${users}" var="user" varStatus="st">
                    <!-- On cells (`td` or `th`) -->
                    <tr>
                            <%--                <td><input type="checkbox" class="myCheckbox"></td>--%>
                        <td class="active">${user.id}</td>
                        <td class="success"><span class="productPrice"
                                                  id="${user.id}">${user.userName}</span></td>
                        <td class="warning"><a href="/editUser/${user.id}">编辑</a></td>
                        <td class="danger"><a href="/deleteUser/${user.id}">删除</a></td>
                    </tr>
                </c:forEach>
                <tr>

                    <td colspan="4" align="center" class="info">
                        <a href="/adminAddUser/${rid}">增加用户</a>
                    </td>
                </tr>
            </table>

        </div>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <h3 align="center" style="color:black"> @拼购网后台管理</h3>
    </div>
</div>

<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>