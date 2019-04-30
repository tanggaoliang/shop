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
    <title>支付成功</title>
    <link rel="stylesheet" type="text/css" href="/static/css/home.css">
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
                    <li><a href="/order">我的订单</a></li>
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
                                <li><a href="/changePassword"><span class="mySpan">改密</span></a></li>
                                <li><a href="/"><span class="mySpan">切换</span></a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<h1 align="center" style="color:green"> 您已支付成功! </h1>
</body>
</html>
