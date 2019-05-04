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
    <title>收货地址列表</title>
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
<h1 align="center" style="color:green"> 最上面的收货地址为默认地址 </h1>
<div id="main">
    <table class="table">
        <thead>
        <%--        <th>选中</th>--%>
        <th>收货人</th>
        <th>手机号码</th>
        <th>收货地址</th>
        <th>编辑</th>
        <th>删除</th>
        </thead>
        <c:forEach items="${infoList}" var="info" varStatus="st">
            <tr>
                <td class="active">${info.name}</td>
                <td class="success"><span>${info.phoneNumber}</span></td>
                <td class="warning"><span>${info.address}</span></td>
                <td class="danger"><a href="editInfo/${info.id}">编辑</a></td>
                <td class="info"><a href="deleteInfo/${info.id}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3" align="center" class="info">
                <a href="addInfo/${info.id}">添加收货地址</a>
            </td>

        </tr>
    </table>

</div>