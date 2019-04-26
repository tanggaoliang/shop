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
    <title>商品详情页</title>
    <link rel="stylesheet" type="text/css" href="/static/css/detail.css">
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
                        <a href="#">我的收藏</a>
                    </li>
                    <li>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                ${user.userName}
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu myDropdown" aria-labelledby="dropdownMenu1" style="background: black">
                                <li><a href="#"><span class="mySpan">信息</span></a></li>
                                <li><a href="#"><span class="mySpan">切换</span></a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div id="left">
    <img src="/static/image/${product.fileName}.png" alt="">
</div>
<div id="right">
    <div id="productName" class="info">产品名称 : <span>${product.name}</span></div>
    <div id="productPrice" class="info">产品价格 : <span>${product.price}</span></div>
    <div id="productNumber" class="info">购买数量 : <input type="number" value="1"></div>
    <div id="buy" class="info">
        <button type="button" class="btn btn-success">加入购物车</button>
        <button type="button" class="btn btn-danger" id="buyNow">立即购买</button>
    </div>
</div>
<div id="bottom"></div>
<script>
    $(window).scroll(function () {
        if ($(".navbar").offset().top > 50) {
            $(".navbar-fixed-top").addClass("top-nav");
        } else {
            $(".navbar-fixed-top").removeClass("top-nav");
        }
    })</script>
</body>
</html>
