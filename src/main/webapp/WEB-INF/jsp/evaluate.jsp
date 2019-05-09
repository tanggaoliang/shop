<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2019/4/24
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<html>
<head>
    <title>评价</title>
    <link rel="stylesheet" type="text/css" href="/static/css/cart.css">
    <link rel="stylesheet" type="text/css" href="/static/css/evaluate.css">
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <script type="text/javascript" src="/static/layui/layui.js"></script>
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
                            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1"
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
<h1 align="center" style="color:green"> 我的评价 </h1>
<div id="main">
    <div class="info"><h2>商品名称:${product.name}</h2></div>
    <div id="test1" class="layui-inline info">
        <ul class="layui-rate">
            <li class="layui-inline"><i class="layui-icon layui-icon-rate"></i></li>
            <li class="layui-inline"><i class="layui-icon layui-icon-rate"></i></li>
            <li class="layui-inline"><i class="layui-icon layui-icon-rate"></i></li>
            <li class="layui-inline"><i class="layui-icon layui-icon-rate"></i></li>
            <li class="layui-inline"><i class="layui-icon layui-icon-rate"></i></li>
        </ul>
    </div>
    <form action="/evaluateAction" class="info">
        <div class="info"><h2>评价内容:</h2></div>
        <input type="hidden" name="starNum" id="starNum" value="">
        <textarea class="form-control info" rows="3" name="content"></textarea>
        <input type="hidden" name="pid" id="pid" value="${product.id}">
        <input type="hidden" name="uid" value="${user.id}">
        <button type="submit" class="btn btn-default" id="submitEvaluate">提交</button>
    </form>
</div>
<div id="right">

</div>
<script>
    layui.use(['rate'], function () {
        var rate = layui.rate;
        //基础效果}
        rate.render({
            elem: '#test1', text: true
            , choose: function (value) {
                $("#starNum").val(value)
            }
        });
    });

</script>
</body>
</html>
