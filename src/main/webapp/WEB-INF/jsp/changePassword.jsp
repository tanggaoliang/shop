<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2019/4/30
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<html>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" type="text/css" href="/static/css/home.css">
    <link rel="stylesheet" type="text/css" href="/static/css/register.css">
    <link rel="stylesheet" type="text/css" href="/static/css/changePassword.css">
</head>
<body>
<div id="header">
    <nav class="navbar navbar-fixed-top my-navbar" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <%--                <button type="button" classef="#" id="nav1">我的拼购</a>--%>
            </div>
            <div class="collapse navbar-collapse " id="example-navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/home">我的拼购</a></li>
                    <li><a href="#">我的订单</a></li>
                    <li><a href="/cart">购物车</a></li>
                    <li>
                        <a href="/info">收货地址</a>
                    </li>
                    <li>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle mydropdown" type="button" id="dropdownMenu1"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                ${user.userName}
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu myDropdown" aria-labelledby="dropdownMenu1"
                                style="background: black">
                                <li><a href="/info"><span class="mySpan">信息</span></a></li>
                                <li><a href="/"><span class="mySpan">切换</span></a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div id="outBox">
    <form class="form-horizontal" action="/changePasswordAction" method="post">
        <div class="main">
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
                    <button type="submit" class="btn btn-default" id="bottom1">修改密码</button>
                </div>
            </div>
    </form>

</div>
</div>
</body>
</html>
