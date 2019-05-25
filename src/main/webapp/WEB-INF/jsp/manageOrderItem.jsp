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
    <h1 align="center" style="color:black">订单管理</h1>
    <h1 align="center" style="color:green"> ${head} </h1>
    <!-- 内容主体区域 -->
    <div id="main">
        <table class="table">
            <thead>
            <th>用户名</th>
            <th>商品名称</th>
            <th>单价</th>
            <th>数量</th>
            <th>时间</th>
            <th>删除</th>
            </thead>
            <c:forEach items="${orderItemList1}" var="orderItem" varStatus="st">
                <tr>
                    <td class="info">${orderItem.user.userName}</td>
                    <td class="active"><a href="/manageEditProduct/${orderItem.product.id}">${orderItem.product.name}</a></td>
                    <td class="success"><span class="productPrice"
                                              id="${orderItem.id}">￥${orderItem.product.price}</span></td>
                    <td class="warning"><span>${orderItem.num}</span></td>
                    <td class="danger"><span>${orderItem.time}</span></td>
                    <td><a href="/orderItemService2/${orderItem.id}">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
            </tr>
        </table>

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