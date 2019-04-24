<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2019/4/16
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<html lang="zh-CN">
<head>
    <title>拼购网-登录</title>
    <link rel="stylesheet" type="text/css" href="/static/css/login.css">
</head>
<body>
<h1 align="center" id="title">拼购网登录</h1>
<div id="outBox">
    <div class="main">
        <form class="form-horizontal" action="/loginAction" method="post">
            <div class="form-group">
                <label for="userName" class="col-sm-2 control-label">用户名:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="userName" name="userName" placeholder="userName">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" name="password" placeholder="password">
                </div>
            </div>
            <%--            <div class="form-group">--%>
            <%--                <div class="col-sm-offset-2 col-sm-10">--%>
            <%--                    <div class="checkbox">--%>
            <%--                        <label>--%>
            <%--                            <input type="checkbox" id="rememberPassword"> 记住我--%>
            <%--                        </label>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" id="login">登录</button>
                    <button type="button" class="btn btn-default" onclick="location.href='/register'"
                            id="register">注册
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
