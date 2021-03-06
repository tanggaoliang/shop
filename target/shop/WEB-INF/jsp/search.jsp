<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2019/4/23
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<html>
<head>
    <title>搜索</title>
    <link rel="stylesheet" type="text/css" href="/static/css/home.css">
    <link rel="stylesheet" type="text/css" href="/static/css/search.css">

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
                            <ul class="dropdown-menu myDropdown" aria-labelledby="dropdownMenu1" style="background: black">
                                <li><a href="/info"><span class="mySpan">改密</span></a></li>
                                <li><a href="/"><span class="mySpan">切换</span></a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div id="left">
    <div class="btn-group-vertical" id="navigation-vertical">
        <button class="btn btn-primary" onclick="location.href='/showCategory/1'">手机</button>
        <button class="btn btn-success " onclick="location.href='/showCategory/2'">电脑</button>
        <button class="btn btn-info" onclick="location.href='/showCategory/3'">服装</button>
        <button class="btn btn-warning" onclick="location.href='/showCategory/4'">食品</button>
        <button class="btn btn-danger" onclick="location.href='/showCategory/5'">图书</button>
    </div>
</div>
<div id="main">
    <div id="SearcherDiv">
        <form class="navbar-form navbar-left" role="search" id="searchForm" action="/search">
            <div class="form-group" id="searchBox">
                <input type="text" class="form-control" placeholder="Search" id="searchContent" name="name">
            </div>
            <button type="submit" class="btn btn-default" id="searchButton">搜索</button>
        </form>
    </div>
    <c:forEach items="${products}" var="product" varStatus="st">
        <a href="/detail/${product.id}" class="product_a">
            <div class="productDiv">
                <div class="photo"><img src="${product.fileName}"></div>
                <div class=" name"><span>${product.name}</span></div>
                <div class="price"><span>￥${product.price}</span></div>
            </div>
        </a>
    </c:forEach>
</div>
<div class="footer">
    <div >
        <a href="?start=0">首 页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <span style="font-weight:bold">${page.pageNum}</span>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末 页</a>
        <span style="font-weight:bold">共${page.pageCount}页</span>
    </div>
</div>



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
