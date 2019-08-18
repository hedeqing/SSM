<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>网站后台管理</title>
    <link rel="stylesheet" type="text/css" href="../../static/admin/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="../../static/admin/css/admin.css"/>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="../../static/admin/js/echarts.min.js"></script>
</head>
<body>

<div class="main-layout" id='main-layout'>
    <!--侧边栏-->
    <div class="main-layout-side">
        <div class="m-logo">
        </div>
        <ul class="layui-nav layui-nav-tree" lay-filter="leftNav">
            				  <li class="layui-nav-item layui-nav-itemed">
            				    <a href="javascript:;"><i class="iconfont">&#xe607;</i>表单管理</a>
            				    <dl class="layui-nav-child">
            				      <dd><a href="javascript:;" data-url="../../admin/index/user/user_table.jsp" data-id='1' data-text="用户"><span class="l-line"></span>用户</a></dd>
            				      <dd><a href="javascript:;" data-url="../../admin/index/car/car_table.jsp" data-id='2' data-text="车辆"><span class="l-line"></span>车辆</a></dd>
            				      <dd><a href="javascript:;" data-url="../../admin/index/sensible/sensible_table.jsp" data-id='3' data-text="传感器"><span class="l-line"></span>传感器</a></dd>
            				    </dl>
            				  </li>
            				  <li class="layui-nav-item">
            				    <a href="javascript:;"><i class="iconfont">&#xe60d;</i>警报管理</a>
            				  </li>
<%--            				  <li class="layui-nav-item">--%>
<%--            				    <a href="javascript:;"><i class="iconfont">&#xe600;</i>备份管理</a>--%>
<%--            				  </li>--%>

            <li class="layui-nav-item">
                <a href="javascript:;" data-url="../../admin/index/system.jsp" data-id='6' data-text="系统设置"><i
                        class="iconfont">&#xe60b;</i>系统设置</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;" data-url="../../admin/index/admin-info.jsp" data-id='5' data-text="个人信息"><i
                        class="iconfont">&#xe606;</i>个人信息</a>
            </li>
        </ul>
    </div>
    <!--右侧内容-->
    <div class="main-layout-container">
        <!--头部-->
        <div class="main-layout-header">
            <div class="menu-btn" id="hideBtn">
                <a href="javascript:;">
                    <span class="iconfont">&#xe60e;</span>
                </a>
            </div>
            <ul class="layui-nav" lay-filter="rightNav">
<%--                <li class="layui-nav-item"><a href="javascript:;" data-url="../../admin/index/email.jsp" data-id='4'--%>
<%--                                              data-text="邮件系统"><i class="iconfont">&#xe603;</i></a>--%>
<%--                </li>--%>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-url="../../admin/index/admin-info.jsp" data-id='5' data-text="个人信息">管理员</a>
                </li>
                <li class="layui-nav-item">
                    <a href="http://localhost:8080/admin/index/login.jsp" data-url="" data-id='5' data-text="登录">退出</a>
<%--                    <a href="javascript:;" data-url="http://localhost:8080/admin/index/login.jsp" data-id='5' data-text="登录">退出</a>--%>
                </li>
            </ul>
        </div>
        <!--主体内容-->
        <div class="main-layout-body">
            <!--tab 切换-->
            <div class="layui-tab layui-tab-brief main-layout-tab" lay-filter="tab" lay-allowClose="true">
                <ul class="layui-tab-title">
                    <li class="layui-this welcome">后台主页</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show" style="background: #f5f5f5;">
                        <!--1-->
                        <iframe src="../../admin/index/welcome.jsp" width="100%" height="100%" name="iframe"
                                scrolling="auto" class="iframe" framborder="0"></iframe>
                        <!--1end-->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--遮罩-->
    <div class="main-mask">

    </div>

</div>
<script type="text/javascript">
    var scope = {
        link: './welcome.jsp'
    }
</script>
<script src="../../static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="../../static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
<script src="../../static/admin/js/main.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
