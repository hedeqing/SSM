<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

    <!--<meta charset="utf-8">-->
    <!--<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">-->
    <title>后台管理系统</title>
    <link rel="stylesheet" href="../../static/plugins/layuiadmin/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="../../static/admin/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="../../static/admin/css/admin.css"/>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <!--<style>-->

        <!--body{margin: 10px;}-->
        <!--.demo-carousel{height: 200px; line-height: 200px; text-align: center;}-->
    <!--</style>-->
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="/jsp/admin/common/header.jsp"></jsp:include>
    <div class="layui-body">
        <!-- 内容主体区域 -->

    <div class="main-layout-body">

        <h1>
            欢迎来到后台系统
        </h1>

    </div>

</div>

</body>
</html>