<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<body  class="layui-layout-body" >
<%--<div class="wrap-container welcome-container">--%>

    <div class="layui-layout layui-layout-admin">
        <jsp:include page="/jsp/admin/common/header.jsp"></jsp:include>
    <div class="row">
        <div class="welcome-left-container col-lg-9" style="margin-left: 190px;margin-top: 5px" >
            <div class="data-show">
                <ul class="clearfix">
                    <li class="col-sm-12 col-md-4 col-xs-12">
                        <a href="javascript:;" class="clearfix">
                            <div class="icon-bg bg-org f-l">
                                <span class="iconfont">&#xe606;</span>
                            </div>
                            <div class="right-text-con">
                                <p class="name">会员数</p>
                                <p><span class="color-org">89</span>数据<span class="iconfont">&#xe628;</span></p>
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
                                <p><span class="color-blue">189</span>数据<span class="iconfont">&#xe628;</span></p>
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
                                <p><span class="color-green">221</span>数据<span class="iconfont">&#xe60f;</span></p>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>

            <!--图表-->
            <div class="chart-panel panel panel-default">
                <form class="layui-form" action="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">选择对象</label>
                        <p></p>
                        <div class="layui-input-inline"  lay-filter="user">
                            <select name="user" lay-verify="required" lay-search="">
                                <option value="">直接选择或搜索</option>
                                <option value="1">layer</option>
                                <option value="2">form</option>
                                <option value="3">layim</option>
                                <option value="4">element</option>
                                <option value="5">laytpl</option>
                                <option value="6">upload</option>
                                <option value="7">laydate</option>
                                <option value="8">laypage</option>
                                <option value="9">flow</option>
                                <option value="10">util</option>
                                <option value="11">code</option>
                                <option value="12">tree</option>
                                <option value="13">layedit</option>
                                <option value="14">nav</option>
                                <option value="15">tab</option>
                                <option value="16">table</option>
                                <option value="17">select</option>
                                <option value="18">checkbox</option>
                                <option value="19">switch</option>
                                <option value="20">radio</option>
                            </select>
                        </div>
                        <div class="layui-input-inline" lay-filter="car">
                            <select name="car" lay-verify="required" lay-search="">
                                <option value="">直接选择或搜索车辆</option>
                                <option value="1">layer</option>
                                <option value="2">form</option>
                                <option value="3">layim</option>
                                <option value="4">element</option>
                                <option value="5">laytpl</option>
                                <option value="6">upload</option>
                                <option value="7">laydate</option>
                                <option value="8">laypage</option>
                                <option value="9">flow</option>
                                <option value="10">util</option>
                                <option value="11">code</option>
                                <option value="12">tree</option>
                                <option value="13">layedit</option>
                                <option value="14">nav</option>
                                <option value="15">tab</option>
                                <option value="16">table</option>
                                <option value="17">select</option>
                                <option value="18">checkbox</option>
                                <option value="19">switch</option>
                                <option value="20">radio</option>
                            </select>
                        </div>
                        <div>
                            <button type="button" class="layui-btn layui-btn-normal">提交</button>
                        </div>
                    </div>
                </form>
                <div class="panel-body" id="chart" style="height: 376px;">
                </div>
            </div>
            <!--服务器信息-->
            <div class="server-panel panel panel-default">
                <div class="panel-header">服务器信息</div>
                <div class="panel-body clearfix">
                    <div class="col-md-2">
                        <p class="title">服务器环境</p>
                        <span class="info">Apache/2.4.4 (Win32) PHP/5.4.16</span>
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
                        <p class="title"> PHP版本</p>
                        <span class="info">5.4.16</span>
                    </div>
                    <div class="col-md-2">
                        <p class="title">数据库信息</p>
                        <span class="info">5.6.12-log </span>
                    </div>
                    <div class="col-md-2">
                        <p class="title">服务器当前时间</p>
                        <span class="info">2016-06-22 11:37:35</span>
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
    layui.use(['layer', 'jquery'], function () {
        var layer = layui.layer;
        var $ = layui.jquery;
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
                myChart.setOption(
                    {
                        title: {
                            text: "数据统计",
                            textStyle: {
                                color: "rgb(85, 85, 85)",
                                fontSize: 18,
                                fontStyle: "normal",
                                fontWeight: "normal"
                            }
                        },
                        tooltip: {
                            trigger: "axis"
                        },
                        legend: {
                            data: ["会员", "文章", "评论"],
                            selectedMode: false,
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                dataView: {
                                    show: false,
                                    readOnly: true
                                },
                                magicType: {
                                    show: false,
                                    type: ["line", "bar", "stack", "tiled"]
                                },
                                restore: {
                                    show: true
                                },
                                saveAsImage: {
                                    show: true
                                },
                                mark: {
                                    show: false
                                }
                            }
                        },
                        calculable: false,
                        xAxis: [
                            {
                                type: "category",
                                boundaryGap: false,
                                data: ["周一", "周二", "周三", "周四", "周五", "周六", "周日"]
                            }
                        ],
                        yAxis: [
                            {
                                type: "value"
                            }
                        ],
                        grid: {
                            x2: 30,
                            x: 50
                        },
                        series: [
                            {
                                name: "会员",
                                type: "line",
                                smooth: true,
                                itemStyle: {
                                    normal: {
                                        areaStyle: {
                                            type: "default"
                                        }
                                    }
                                },
                                data: [10, 12, 21, 54, 260, 830, 710]
                            },
                            {
                                name: "文章",
                                type: "line",
                                smooth: true,
                                itemStyle: {
                                    normal: {
                                        areaStyle: {
                                            type: "default"
                                        }
                                    }
                                },
                                data: [30, 182, 434, 791, 390, 30, 10]
                            },
                            {
                                name: "评论",
                                type: "line",
                                smooth: true,
                                itemStyle: {
                                    normal: {
                                        areaStyle: {
                                            type: "default"
                                        },
                                        color: "rgb(110, 211, 199)"
                                    }
                                },
                                data: [1320, 1132, 601, 234, 120, 90, 20]
                            }
                        ]
                    }
                );
            }
        );
        $(window).resize(function () {
            myChart.resize();
        })

    });
</script>
<script>
    layui.use('form', function () {
    });<!--加载form模块-->
</script>
</body>
</html>
