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
    <title>${product.name}-商品详情页</title>
    <link rel="stylesheet" type="text/css" href="/static/css/detail.css">
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
                        <a href="#">我的收藏</a>
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
<div id="left">
    <img src="${product.fileName}" alt="">
</div>
<div id="right">
    <form action="/createSingleOrder">
        <input type="hidden" name="productId" value="${product.id}">
        <div id="productName" class="info">产品名称 : <span>${product.name}</span></div>
        <div id="productPrice" class="info">产品价格 :￥<span>${product.price}</span></div>
        <div id="productNumber" class="info">购买数量 : <input type="number" value="1" id="productNumberInput"
                                                           name="productNumberInput"></div>
        <div id="buy" class="info">
            <button type="button" class="btn btn-success" id="addToCart">加入购物车</button>
            <button type="submit" class="btn btn-danger" id="buyNow">拼单购买</button>
        </div>
    </form>
</div>

<div id="bottom">
    <div class="info">
        <h1 align="center" style="color:green"> 商品介绍 </h1>
        <h1 align="center" style="color:black"><span class="productInfo">${product.info}</span></h1>
    </div>

    <h1 align="center" style="color:green"> 评价 </h1>
    <c:forEach items="${evaluateList}" var="evaluate" varStatus="st">
        <div class="evaluateList">
            <span>评价人 : ${evaluate.user.userName}</span> <br>
            <span>评分 : ${evaluate.starNum}星</span> <br>
            <span>时间 : ${evaluate.time}</span>
            <h2>${evaluate.content}</h2>
        </div>
    </c:forEach>
</div>
<script>
    $(window).scroll(function () {
        if ($(".navbar").offset().top > 50) {
            $(".navbar-fixed-top").addClass("top-nav");
        } else {
            $(".navbar-fixed-top").removeClass("top-nav");
        }
    })

    <%--加入购物车功能--%>
    $("#addToCart").click(function (event) {
        var pid =${product.id};
        var num = parseInt($('#productNumberInput').val());
        var page = "/addProductToCart";
        $.get(
            page,
            {"num": num, "pid": pid});
    })

</script>


</body>
</html>
