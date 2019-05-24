<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2019/5/6
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<%@ include file="/WEB-INF/jsp/base2.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>拼购网后台</title>
    <link rel="stylesheet" href="/static/css/manage.css">
</head>
<body class="layui-layout-body">


    <div class="layui-body">

        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div id="main">
                <div id="SearcherDiv">
                    <div id="addProductDiv"><button class="layui-btn" onclick="location.href='/addProduct'" id="addProduct">增加商品</button></div>
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