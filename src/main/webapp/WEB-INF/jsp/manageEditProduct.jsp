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
    <link rel="stylesheet" href="/static/css/manageEditProduct.css">
</head>
<body class="layui-layout-body">



    <div class="layui-body">

        <!-- 内容主体区域 -->
        <div id="left">
            <img src="${product.fileName}" alt="">
            <form action="/uploadImage" method="post" enctype="multipart/form-data" class="upload">
                <span>修改图片</span><br><br>
                <input type="file" name="image" accept="image/*" id="imgChoose"/> <br>
                <input type="hidden" name="pid" value="${product.id}"><br>
                <input type="submit" value="修改图片" style="display: none" id="submitPhoto">
            </form>
        </div>
        <script>
            $("#imgChoose").on("input", function () {
                $("#submitPhoto").click();
            })
        </script>
        <div id="right">
            <form action="/updateProduct">
                <input type="hidden" name="fileName" id="fileName" value="${product.fileName}">
                <input type="hidden" name="id" value="${product.id}">
                <div id="productName" class="info">产品名称 : <input type="text" name="name" value="${product.name}">
                </div>
                <div id="productPrice" class="info">产品价格 : <input type="text" name="price"
                                                                  value="${product.price}"></div>
                <div id="productPrice2" class="info">拼单价格 : <input type="text" name="price2"
                                                                  value="${product.price2}"></div>
                <div id="productInfo" class="info">产品信息 : <textarea type="text" name="info" rows="3"
                >${product.info}</textarea></div>

                <button type="submit" class="btn btn-success" id="submitChange">更新</button>

                <input type="button" class="btn btn-danger" onclick="location.href='/deleteProduct/${id}'"
                       id="deleteProduct" value="删除">
            </form>
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