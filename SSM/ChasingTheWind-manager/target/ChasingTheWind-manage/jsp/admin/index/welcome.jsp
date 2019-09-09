<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page contentType="text/html; charset=gb2312" %>--%>
<%@ page language="java" %>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date " %>
<%@ page import="com.northuniversity.model.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String driverName = "com.mysql.jdbc.Driver";
//数据库信息
    String userName = "root";
//密码
    String userPasswd = "123456";
//数据库名
    String dbName = "co_detection_system";
//表名
//将数据库信息字符串连接成为一个完整的url（也可以直接写成url，分开写是明了可维护性强）
    int userCount = 0;
    int carCount = 0;
    int sensorCount = 0;
    Connection con = null;
    Date now = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
    String time = dateFormat.format( now );

    PreparedStatement ps = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost/" + dbName + "?user=" + userName + "&password=" + userPasswd;
    Class.forName("com.mysql.jdbc.Driver").newInstance();
//    Connection conn=DriverManager.getConnection(url);
//    Statement stmt = conn.createStatement();
    String sql = "SELECT COUNT(*) FROM user";
    String sql1 = "SELECT COUNT(*) FROM sensor";
    String sql2 = "SELECT COUNT(*) FROM car";
    con = DriverManager.getConnection(url);
    ps = con.prepareStatement(sql);
    rs = ps.executeQuery();
    if (rs.next()) {
        userCount = rs.getInt(1);
    }
    con = DriverManager.getConnection(url);
    ps = con.prepareStatement(sql1);
    rs = ps.executeQuery();
    if (rs.next()) {
        carCount = rs.getInt(1);
    }
    con = DriverManager.getConnection(url);
    ps = con.prepareStatement(sql2);
    rs = ps.executeQuery();
    if (rs.next()) {
        sensorCount = rs.getInt(1);
    }
    con.close();

%>
<meta charset="utf-8">
<head style="margin-top: 0px">
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>网站后台管理</title>
    <link rel="stylesheet" type="text/css" href="../../static/admin/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="../../static/admin/css/admin.css"/>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="/jsp/admin/common/header.jsp"></jsp:include>
    <div class="row">
        <div class="welcome-left-container col-lg-9" style="margin-left: 190px;margin-top: 5px">
            <div class="data-show">
                <ul class="clearfix">
                    <li class="col-sm-12 col-md-4 col-xs-12">
                        <a href="javascript:;" class="clearfix">
                            <div class="icon-bg bg-org f-l">
                                <span class="iconfont">&#xe606;</span>
                            </div>
                            <div class="right-text-con">
                                <p class="name">会员数</p>
                                <p><span class="color-org"><%=userCount%></span>数据<span class="iconfont">&#xe628;</span></p>
                            </div>
                        </a>
                    </li>
                    <li class="col-sm-12 col-md-4 col-xs-12">
                        <a href="javascript:;" class="clearfix">
                            <div class="icon-bg bg-blue f-l">
                                <span class="iconfont">&#xe602;</span>
                            </div>
                            <div class="right-text-con">
                                <p class="name">车辆数</p>
                                <p><span class="color-blue"><%=carCount%></span>数据<span class="iconfont">&#xe628;</span></p>
                            </div>
                        </a>
                    </li>
                    <li class="col-sm-12 col-md-4 col-xs-12">
                        <a href="javascript:;" class="clearfix">
                            <div class="icon-bg bg-green f-l">
                                <span class="iconfont">&#xe605;</span>
                            </div>
                            <div class="right-text-con">
                                <p class="name">传感器数</p>
                                <p><span class="color-green"><%=sensorCount%></span>数据<span class="iconfont">&#xe628;</span></p>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>

            <!--图表-->
            <div class="chart-panel panel panel-default">
                <form class="layui-form" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">请选择车辆</label>
                            <div class="layui-input-inline">
                                <input type="text" name="license" class="layui-input" id="license"
                                       placeholder="粤g: 8888">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">请选择日期</label>
                            <div class="layui-input-inline">
                                <input type="text" name="date" class="layui-input" id="date" placeholder="20190812">
                            </div>
                        </div>

                        <div style="margin-left: 670px;margin-top: 0px">
                            <button id="show" type="button" class="layui-btn layui-btn-normal">可视化</button>
                        </div>
                    </div>
                </form>
                <div class="panel-body" id="chart" style="height: 376px; margin-left: 5px">
                </div>
            </div>
            <!--服务器信息-->
            <div class="server-panel panel panel-default">
                <div class="panel-header">服务器信息</div>
                <div class="panel-body clearfix">
                    <div class="col-md-2">
                        <p class="title">服务器环境</p>
                        <span class="info">Tomcat 8.6.43 (Win64)</span>
                    </div>
                    <div class="col-md-2">
                        <p class="title">服务器IP地址</p>
                        <span class="info">127.0.0.1   </span>
                    </div>
                    <div class="col-md-2">
                        <p class="title">服务器域名</p>
                        <span class="info">localhost </span>
                    </div>
                    <div class="col-md-2">
                        <p class="title">数据库信息</p>
                        <span class="info">8.0 </span>
                    </div>
                    <div class="col-md-2">
                        <p class="title">服务器当前时间</p>
                        <span class="info"><%=time%></span>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <div class="panel panel-default contact-panel">
                <div class="panel-header">联系我们</div>
                <div class="panel-body">
                    <p>QQ：240484406</p>
                    <p>E-mail:240484406@qq.com</p>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="../../static/admin/lib/echarts/echarts.js"></script>

<script type="text/javascript">
    layui.use(['layer', 'jquery', 'laydate',], function () {
        var layer = layui.layer;
        var $ = layui.jquery;
        var laydate = layer.laydate;
        //图表
        var myChart;
        require.config({
            paths: {
                echarts: '../../static/admin/lib/echarts'
            }
        });
        require(
            [
                'echarts',
                'echarts/chart/bar',
                'echarts/chart/line',
                'echarts/chart/map'
            ],
            function (ec) {

                //--- 折柱 ---
                myChart = ec.init(document.getElementById('chart'));
                myChart.setOption({
                    title: {
                        text: 'CO浓度折线图'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        // data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
                        data: ['传感器一', '传感器二', '传感器三']
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: ['0：00', '2：00', '4：00', '6：00', '8：00', '10：00','12：00', '14：00', '16：00', '18：00', '20：00', '22：00',]
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [
                        {
                            name: '传感器一',
                            type: 'line',
                            stack: '总量',
                            data: [120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90, 230, 210]
                        },
                        {
                            name: '传感器二',
                            type: 'line',
                            stack: '总量',
                            data: [220, 182, 191, 234, 290, 330, 310,220, 182, 191, 234, 290, 330, 310]
                        },
                        {
                            name: '传感器三',
                            type: 'line',
                            stack: '总量',
                            data: [150, 232, 201, 154, 190, 330, 410,150, 232, 201, 154, 190, 330, 410]
                        },
                    ]
                });


                var option = {
                    title: {
                        text: '折线图堆叠'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['传感器一', '传感器二', '传感器三']
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: ['0：00', '2：00', '4：00', '6：00', '8：00', '10：00','12：00', '14：00', '16：00', '18：00', '20：00', '22：00',]
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [
                        {
                            name: '传感器一',
                            type: 'line',
                            stack: '总量',
                            data: [120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90, 230, 210]
                        },
                        {
                            name: '传感器二',
                            type: 'line',
                            stack: '总量',
                            data: [220, 182, 191, 234, 290, 330, 310,220, 182, 191, 234, 290, 330, 310]
                        }, {
                            name: '传感器三',
                            type: 'line',
                            stack: '总量',
                            data: [0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0]
                        },

                    ]
                };

                $(document).ready(function () {
                    $("button").click(function () {
                        var a = $("#license").val();
                        var b = $("#date").val();
                        //渲染数据
                        $.ajax({
                            type: "POST",
                            url: '<%=basePath%>/android/searchShow?license=' + a + "&date=" + b,
                            dataType: "json",
                            success: function (result) {
                                var jsonobj = eval(result);

                                var series_arr = jsonobj.series;
                                var bean = eval(jsonobj)
                                //驱动图表生成的数据内容，数组中每一项代表一个系列的特殊选项及数据
                                for (var i = 0; i < series_arr.length; i++) {
                                    option.series[i] = result.series[i];
                                }
                                //过渡控制，隐藏loading（读取中）
                                myChart.hideLoading();
                                // 为echarts对象加载数据
                                myChart.setOption(option);
                                // alert("set option success")
                            }
                        });
//
                    })
                });
            }
        );
        $(window).resize(function () {
            myChart.resize();
        })
    });
</script>
</body>
</html>
