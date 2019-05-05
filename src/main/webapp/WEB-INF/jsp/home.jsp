<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2019/4/21
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="/static/css/home.css">
    <%--    轮播图个--%>
    <link rel="stylesheet" href="/static/css/Cooldog.css">
    <link rel="stylesheet" href="/static/css/iconfont.css">
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/Cooldog.js"></script>
</head>
<body>
<div id="header">
    <nav class="navbar navbar-fixed-top my-navbar" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
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
                            <ul class="dropdown-menu myDropdown" aria-labelledby="dropdownMenu1" style="background: black">
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
<div id="left">
    <div class="btn-group-vertical" id="navigation-vertical">
        <button class="btn btn-primary" onclick="location.href='/showCategory/1'">手机</button>
        <button class="btn btn-success " onclick="location.href='/showCategory/2'">电脑</button>
        <button class="btn btn-info" onclick="location.href='/showCategory/3'">服装</button>
        <button class="btn btn-warning" onclick="location.href='/showCategory/4'">食品</button>
        <button class="btn btn-danger" onclick="location.href='/showCategory/5'">图书</button>
    </div>
</div>

<div id="right">
    <div id="SearcherDiv">
        <form class="navbar-form navbar-left" role="search" id="searchForm" action="/search">
            <div class="form-group" id="searchBox">
                <input type="text" class="form-control" placeholder="Search" id="searchContent" name="name">
            </div>
            <button type="submit" class="btn btn-default" id="searchButton">搜索</button>
        </form>
    </div>
    <div id="carousel">
        <div class="Cooldog_container">
            <div class="Cooldog_content">
                <ul>
                    <li class="p1">
                        <a href="/detail/17">
                            <img src="/static/image/1.png" alt="">
                        </a>
                    </li>
                    <li class="p2">
                        <a href="/detail/24">
                            <img src="/static/image/2.png" alt="">
                        </a>
                    </li>
                    <li class="p3">
                        <a href="/detail/25">
                            <img src="/static/image/3.png" alt="">
                        </a>
                    </li>
                    <li class="p4">
                        <a href="/detail/2">
                            <img src="/static/image/4.png" alt="">
                        </a>
                    </li>
                    <li class="p5">
                        <a href="/detail/1">
                            <img src="/static/image/5.png" alt="">
                        </a>
                    </li>
                    <li class="p5">
                        <a href="/detail/3">
                            <img src="/static/image/6.png" alt="">
                        </a>
                    </li>
                    <li class="p5">
                        <a href="/detail/21">
                            <img src="/static/image/7.png" alt="">
                        </a>
                    </li>

                </ul>
            </div>
            <a href="javascript:;" class="btn_left">
                <i class="iconfont icon-zuoyoujiantou"></i>
            </a>
            <a href="javascript:;" class="btn_right">
                <i class="iconfont icon-zuoyoujiantou-copy-copy"></i>
            </a>
            <%--            <a href="javascript:;" class="btn_close">--%>
            <%--                <i class="iconfont icon-icon-test"></i>--%>
            <%--            </a>--%>
            <div class="buttons clearfix">
                <a href="javascript:;" class="color"></a>
                <a href="javascript:;"></a>
                <a href="javascript:;"></a>
                <a href="javascript:;"></a>
                <a href="javascript:;"></a>
                <a href="javascript:;"></a>
                <a href="javascript:;"></a>
            </div>
        </div>
    </div>
</div>

<div id="main">
    <h1 align="center" style="color:green"> 手机 </h1>
    <%--    <a href="#" class="product_a">--%>
    <%--        <div class="productDiv">--%>
    <%--            <div class="photo"><img src="/static/image/peijian2.png"></div>--%>
    <%--            <div class="name"><span>小米6 硅胶保护套</span></div>--%>
    <%--            <div class="price"><span>49元</span></div>--%>
    <%--        </div>--%>
    <%--    </a>--%>

    <c:forEach items="${products}" var="product" varStatus="st">
        <a href="/detail/${product.id}" class="product_a">
            <div class="productDiv">
                <div class="photo"><img src="/static/image/${product.fileName}.png"></div>
                <div class=" name"><span>${product.name}</span></div>
                <div class="price"><span>￥${product.price}</span></div>
            </div>
        </a>
    </c:forEach>


</div>
<%--<div id="footer"></div>--%>
<%--导航栏运动js--%>
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
