<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2019/5/6
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>拼购网后台</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <link rel="stylesheet" href="/static/css/manage.css">
    <%--    <link rel="stylesheet" href="/static/css/search.css">--%>
    <script type="text/javascript" src="/static/layui/layui.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">拼购网后台</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="/static/image/head.jpg" class="layui-nav-img">
                    ${user.userName}
                </a>
            </li>
            <li class="layui-nav-item"><a href="/">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="/manage">首页</a></li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/manageProduct/1">手机</a></dd>
                        <dd><a href="/manageProduct/2">电脑</a></dd>
                        <dd><a href="/manageProduct/3">服装</a></dd>
                        <dd><a href="/manageProduct/4">食品</a></dd>
                        <dd><a href="/manageProduct/5">图书</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/manageUser/1">普通用户</a></dd>
                        <dd><a href="/manageUser/2">管理员</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">

        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div id="main">
                <div id="SearcherDiv">
                    <button class="layui-btn" id="addProduct">增加商品</button>
                    <form class="navbar-form navbar-left" role="search" id="searchForm" action="/search">
                        <div class="form-group" id="searchBox">
                            <input type="text" class="form-control" placeholder="Search" id="searchContent" name="name">
                        </div>
                        <button type="submit" class="btn btn-default" id="searchButton">搜索</button>
                    </form>
                </div>
               <div>
                   <c:forEach items="${products}" var="product" varStatus="st">
                       <a href="/manageEditProduct/${product.id}" class="product_a">
                           <div class="productDiv">
                               <div class="photo"><img src="/static/image/${product.fileName}"></div>
                               <div class=" name"><span>${product.name}</span></div>
                               <div class="price"><span>￥${product.price}</span></div>
                           </div>
                       </a>
                   </c:forEach>
               </div>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <h3 align="center" style="color:black"> @拼购网后台管理</h3>
    </div>
</div>

<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>