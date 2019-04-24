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
    <title>拼购网-注册</title>
    <link rel="stylesheet" type="text/css" href="/static/css/register.css">
</head>
<body>
<h1 align="center" id="title">拼购网注册</h1>
<div id="outBox">
    <div class="main">
        <form class="form-horizontal" action="/addUser" method="post">
            <div class="form-group">
                <label for="userName" class="col-sm-2 control-label">用户名:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="userName" name="userName" placeholder="Username">
                </div>
            </div>
            <div class="form-group">
                <label for="password1" class="col-sm-2 control-label">输入密码:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password1" name="password1" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <label for="password2" class="col-sm-2 control-label">确认密码:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password2" name="password2" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" id="bottom1">注册</button>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button id="bottom2" type="button" class="btn btn-default" onclick="location.href='/'">返回登录
                    </button>
                </div>
            </div>
        </form>

    </div>
</div>
</body>
</html>
