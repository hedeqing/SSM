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
    <title>后台大布局</title>
    <link rel="stylesheet" href="../../static/plugins/layuiadmin/layui/css/layui.css">
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
    欢迎
</h1>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

</body>
</html>