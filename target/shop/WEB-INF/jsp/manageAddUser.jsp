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
    <title></title>
    <link rel="stylesheet" href="/static/css/manage.css">
</head>
<body class="layui-layout-body">
    <div class="layui-body">
        <c:if test="${null!=errorInfo}">
            <h1 align="center" style="color:red">错误信息:${errorInfo}</h1>
        </c:if>

        <!-- 内容主体区域 -->
        <div id="outBox">
            <h1 align="center" style="color:green"> 增加用户 </h1>
            <div class="main">
                <form class="form-horizontal" action="/adminAddUserAction/${rid}" method="post">
                    <div class="form-group">
                        <label for="userName" class="col-sm-2 control-label">用户名:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userName" name="userName"
                                   >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password1" class="col-sm-2 control-label">输入密码:</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password1" name="password1"
                                   placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password2" class="col-sm-2 control-label">确认密码:</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password2" name="password2"
                                   placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" id="bottom1">完成</button>
                        </div>
                    </div>
                </form>

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