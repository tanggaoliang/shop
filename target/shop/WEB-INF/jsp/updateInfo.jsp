<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2019/4/29
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<html>
<head>
    <title>增加收货地址</title>
    <link type="text/css" href="/static/css/info.css" rel="stylesheet">
    <link type="text/css" href="/static/css/home.css" rel="stylesheet">
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
<h1 align="center" style="color:green"> 添加收货地址 </h1>

<div class="main">
    <form class="form-horizontal" action="/updateInfoAction" method="post">

        <div class="form-group">
            <label for="userName" class="col-sm-2 control-label">收货人:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="userName" name="userName" value="${info.name}">
            </div>
        </div>

        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">手机号码:</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="phone" name="phoneNumber" value="${info.phoneNumber}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="address" class="col-sm-2 control-label">详细地址:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="address" name="address"
                       value="${info.address}">
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-sm-2 control-label">默认地址:</label>
            <div class="col-sm-10">
                <input type="checkbox" name="checkbox" id="checkbox" value="selected">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button id="finish" type="submit" class="btn btn-default">完成
                </button>
            </div>
        </div>
        <input type="hidden" name="id" value="${info.id}">
        <input type="hidden" id="selected" value="${info.selected}">
    </form>

</div>

<script>
    $(function () {
        var a = $("#selected").val();
        if (a > 0) {
            $("#checkbox").attr("checked", 'checked');
        }
    })
</script>

</body>
</html>
