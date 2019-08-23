<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/27
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="layui-header">
    <div class="layui-logo">后台管理</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="<%=basePath%>/jsp/admin/index/welcome.jsp">控制台</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="<%=basePath%>/jsp/admin/index/admin-info.jsp">
                <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                ${SESSION_USER.name}
            </a>
        </li>
        <li class="layui-nav-item"><a href="<%=basePath%>/jsp/admin/index/login.jsp">退出登录</a></li>
    </ul>
</div>

<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">

            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="<%=basePath%>/jsp/admin/table/user/user_table.jsp">用户管理</a></dd>
                    <dd><a href="<%=basePath%>/jsp/admin/table/car/car_table.jsp">车辆管理</a></dd>
                    <dd><a href="<%=basePath%>/jsp/admin/table/sensor/sensor_table.jsp">传感器管理</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="<%=basePath%>/jsp/admin/index/admin-info.jsp">个人信息</a></li>

        </ul>
    </div>
</div>

