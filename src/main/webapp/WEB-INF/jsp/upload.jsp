<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2019/4/17
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<html>
<head>
    <title>UPLOAD</title>
</head>
<body>
<div align="center">
    <form action="uploadImage" method="post" enctype="multipart/form-data">
        选择图片:<input type="file" name="image" accept="image/*"/> <br>
        <input type="submit" value="上传">
    </form>
</div>

</body>
</html>
