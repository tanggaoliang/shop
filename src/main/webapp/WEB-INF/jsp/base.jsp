<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="shortcut icon" type="image/x-icon" href="/static/favicon.ico"/>
<link rel="stylesheet" type="text/css" href="/static/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/static/bootstrap/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/static/bootstrap/js/bootstrap.min.js"></script>

<c:if test="${null!=errorInfo}">
    <h1 align="center" style="color:red">错误信息:${errorInfo}</h1>
</c:if>
