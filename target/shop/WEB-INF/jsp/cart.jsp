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
    <title>购物车</title>
    <link rel="stylesheet" type="text/css" href="/static/css/cart.css">
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
<h1 align="center" style="color:green"> 我的购物车 </h1>
<div id="main">
    <table class="table">
        <thead>
        <%--        <th>选中</th>--%>
        <th>商品名称</th>
        <th>单价</th>
        <th>数量</th>
        <th>删除</th>
        </thead>
        <c:forEach items="${orderItems}" var="orderItem" varStatus="st">
            <!-- On cells (`td` or `th`) -->
            <tr>
                <td class="active"><a href="/detail/${orderItem.product.id}">${orderItem.product.name}</a></td>
                <td class="success"><span class="productPrice"
                                          id="${orderItem.id}">￥${orderItem.product.price}</span></td>
                <td class="warning"><input type="number" value="${orderItem.num}" class="productNumber"
                                           id="${orderItem.id}"></td>
                <td class="danger"><a href="deleteOrderItem/${orderItem.id}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3" align="right" class="info">
                <input readonly="readonly" id="allTotalPrice" value="合计:￥${totalPrice}"/>
            </td>
            <td colspan="3" align="right" class="info">
                <a href="/createOrder">结算</a>
            </td>
        </tr>
    </table>

</div>
<div id="right">

</div>
<script>
    $(window).scroll(function () {
        if ($(".navbar").offset().top > 50) {
            $(".navbar-fixed-top").addClass("top-nav");
        } else {
            $(".navbar-fixed-top").removeClass("top-nav");
        }
    })
    // 计算价格的js
    //1.检测checkBox是否选中
    //2.检测商品的数量是否改变
    //3.商品数量的改变要提交到数据库

    $('.productNumber').on("input", function () {
        var totalPrice;
        var id = $(this).attr("id");
        var num = parseInt($(this).val());
        var page = "/updateOrderItem";
        $.ajax({
            url: page,
            async: false,
            type: "GET",
            dataType: 'json',
            contentType: "application/json",
            data: {"num": num, "id": id},
            success: function (data) {
                $("#allTotalPrice").val(data.totalPrice)
                // alert("测试进入success方法");
            }
        });
    });


</script>
</body>
</html>
