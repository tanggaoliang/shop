<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2019/5/6
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title></title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <link rel="stylesheet" href="/static/css/manage.css">
    <%--    <link rel="stylesheet" href="/static/css/search.css">--%>
    <script type="text/javascript" src="/static/layui/layui.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">拼购网后台</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="/static/image/head.jpg" class="layui-nav-img">
                    ${user.userName}
                </a>
            </li>
            <li class="layui-nav-item"><a href="/">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="/manage">首页</a></li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/manageProduct/1">手机</a></dd>
                        <dd><a href="/manageProduct/2">电脑</a></dd>
                        <dd><a href="/manageProduct/3">服装</a></dd>
                        <dd><a href="/manageProduct/4">食品</a></dd>
                        <dd><a href="/manageProduct/5">图书</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/manageUser/1">普通用户</a></dd>
                        <dd><a href="/manageUser/2">管理员</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <c:if test="${null!=errorInfo}">
            <h1 align="center" style="color:red">错误信息:${errorInfo}</h1>
        </c:if>

        <!-- 内容主体区域 -->
        <div id="outBox">
            <div class="main">
                <form class="form-horizontal" action="/updateUser" method="post">
                    <div class="form-group">
                        <label for="userName" class="col-sm-2 control-label">用户名:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userName" name="userName"
                                   value=${user.userName}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password1" class="col-sm-2 control-label">输入密码:</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password1" name="password1"
                                   placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password2" class="col-sm-2 control-label">确认密码:</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password2" name="password2"
                                   placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" id="bottom1">完成</button>
                        </div>
                    </div>
                    <input type="hidden" name="id" value="${user.id}">
                </form>

            </div>
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