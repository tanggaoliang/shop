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
    <script type="text/javascript" src="/static/layui/layui.js"></script>
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
        <div id="productPrice2" class="info">拼购价格 :￥<span>${product.price2}</span>
            <input type="text" readOnly="true"
                   value="当前有${groupNum}人拼单,3人即可拼单"/>
        </div>
        <div id="productNumber" class="info">购买数量 : <input type="number" value="1" id="productNumberInput"
                                                           name="productNumberInput"
                                                           onkeyup="value=value.replace(/^(0+)|[^\d]+/g,'')"></div>
        <div id="buy" class="info">
            <button type="button" class="btn btn-success" id="addToCart">加入购物车</button>
            <button type="submit" class="btn btn-danger" id="buyNow">单独购买</button>
            <input type="button" class="btn btn-danger" id="groupBuy"
                   value="拼单购买"></input>
        </div>
    </form>
    <script>
        // 拼单链接功能
        $('#groupBuy').on("click", function () {
            var pid =${product.id};
            var uid =${user.id};
            var num = parseInt($('#productNumberInput').val());
            var page = "/groupBuy";
            layui.use('layer', function () {
                var layer = layui.layer;
                $.ajax({
                    url: page,
                    async: false,
                    type: "GET",
                    dataType: 'json',
                    contentType: "application/json",
                    data: {"pid": pid, "uid": uid, "num": num},
                    success: function () {
                        layer.open({
                            type: 1,
                            area: ['300px', '200px'],
                            title: '拼购网提示',
                            content: $("#info12").html(),
                            btn: ['确定'],
                            btnAlign: 'c',//按钮居中,
                            yes: function (index) {
                                layer.close(index);
                            }
                        });


                    }

                });
            });
        })


    </script>

</div>

<div id="bottom">
    <div class=" introduction">
        <h1 align="center" style="color:green"> 商品介绍 </h1>
        <h3 align="center" style="color:black;text-align: left;margin-top: 2%"><p
                class="productInfo">${product.info}</p></h3>
    </div>

    <div><h1 align="center" style="color:green"> 评价 </h1></div>
    <c:forEach items="${evaluateList}" var="evaluate" varStatus="st">
        <div class="evaluateList">
            <span>评价人 : ${evaluate.user.userName}</span> <br>
            <span>评分 : ${evaluate.starNum}星</span> <br>
            <span>时间 : ${evaluate.time}</span>
            <h2>${evaluate.content}</h2>
        </div>
    </c:forEach>

</div>
<div id="info11" style="display: none">
    <h4 align="center" style="color:black;margin-top: 20%"> 加入购物车成功 </h4>
</div>
<div id="info12" style="display: none">
    <h4 align="center" style="color:black;margin-top: 20%"> 拼购成功 </h4>
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
    $("#addToCart").click(function () {
        var pid =${product.id};
        var num = parseInt($('#productNumberInput').val());
        var page = "/addProductToCart";
        layui.use('layer', function () {
            var layer = layui.layer;
            $.ajax({
                url: page,
                async: true,
                type: "GET",
                dataType: 'json',
                contentType: "application/json",
                data: {"num": num, "pid": pid},
                success: function () {
                    layer.open({
                        type: 1,
                        area: ['300px', '200px'],
                        title: '拼购网提示',
                        content: $("#info11").html(),
                        btn: ['确定'],
                        btnAlign: 'c',//按钮居中,
                        yes: function (index) {
                            layer.close(index);
                        }
                    });


                }

            });
        });
    })
</script>


</body>
</html>
