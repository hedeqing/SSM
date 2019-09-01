<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

    <!--<meta charset="utf-8">-->
    <!--<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">-->
    <title>后台大布局</title>
    <link rel="stylesheet" href="../../../static/plugins/layuiadmin/layui/css/layui.css">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <!--<style>-->

    <!--body{margin: 10px;}-->
    <!--.demo-carousel{height: 200px; line-height: 200px; text-align: center;}-->
    <!--</style>-->
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="/jsp/admin/common/header.jsp"></jsp:include>


    <div class="layui-body" style="margin-top: 5px;margin-left: 5px">
        <!-- 内容主体区域 -->


        <div class="demoTable">
            搜索车牌：
            <div class="layui-inline">
                <input class="layui-input" name="id" id="demoReload" autocomplete="off">
            </div>
            <button class="layui-btn" data-type="reload">搜索</button>
        </div>

        <table class="layui-hide" id="demo" lay-filter="test"></table>

        <script type="text/html" id="barDemo">
            <!--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>-->
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>


<script src="../../../static/plugins/layuiadmin/layui/layui.js"></script>
<script>
    //JavaScript代码区域

    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , element = layui.element //元素操作
            , slider = layui.slider //滑块


        //监听Tab切换
        element.on('tab(demo)', function (data) {
            layer.tips('切换了 ' + data.index + '：' + this.innerHTML, this, {
                tips: 1
            });
        });

        //执行一个 table 实例
        table.render({
            elem: '#demo'
            , height: 420
            // , url: 'http://localhost:8080/user/search?number=123456' //数据接口
            , url: '<%=basePath%>/sensor/selectAllSensor' //数据接口
            , title: '=传感器表'
            , id: 'testReload'
            , page: true //开启分页
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度
            , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            // ,totalRow: true //开启合计行
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'id', title: 'ID', sort: true, fixed: 'left'}
                ,{field: 'license', title: '车牌' }
                ,{field: 'concentrationId', title: '浓度ID',  sort: true, edit: 'text'}
                ,{field: 'sensorName', title: '传感器名字',  sort: true, edit: 'text'}
                ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
            ]]
        });

        //监听头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id)
                , data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.open({
                        title : '添加传感器',
                        type : 2,
                        area: ['500px', '500px'],
                        content : '<%=basePath%>/sensor/addSensorJsp',//这是 URL，直接发送的这个请求controller会接受到并返回userList页面。也就是弹出来的页面
                        // btn : ['确定'] ,
                        yes : function(index , layero){
                            layer.close(index);
                        }

                    });
                    // layer.msg('添加');
                    break;
                case 'update':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else if (data.length > 1) {
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.alert('编辑 [id]：' + checkStatus.data[0].id);
                    }
                    break;
                case 'delete':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
            }
            ;
        });

        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令

                    $.ajax({
                        url: '<%=basePath%>/sensor/delete/',
                        type: 'post',
                        data: data,
                        success: function (data) {
                            var msg = data.msg
                            layer.msg(msg);
                        }
                    });
                });
            } else if (layEvent === 'edit') {
                $.ajax({
                    url: '<%=basePath%>/sensor/update',
                    type: 'post',
                    data: data,
                    success: function (data) {
                        if (data == '1') {
                            layer.msg('编辑成功');
                        } else {
                            layer.msg('编辑失败');
                        }
                    }
                })

            }
        });
        var $ = layui.$, active = {
            reload: function () {
                var license = $('#demoReload').val();//获取搜索框里面的内容
                var  index = layer.msg("查询中，请稍后",{icon: 16,time :false,shade:0})
                table.reload('testReload', {
                    url: '<%=basePath%>/sensor/search?license='+license,
                    method: 'post',
                    page: {
                        curr: 1 //重新从第 1 页开始
                    },
                    // where: {
                    //     number: number
                    // }
                })
                layer.close(index)
            }
        }
        // $('.chu .layui-btn').on('click', function () {
        //     var type = $(this).data('type');
        //
        //     if ($('#textdemo').val() == "") {
        //         layer.msg('查询项目不能为空');
        //         return false;
        //     }
        //     active[type] ? active[type].call(this) : '';
        // });
        //绑定搜索框，点击事件
        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
        //执行一个轮播实例
        // carousel.render({
        //     elem: '#test1'
        //     ,width: '100%' //设置容器宽度
        //     ,height: 200
        //     ,arrow: 'none' //不显示箭头
        //     ,anim: 'fade' //切换动画方式
        // });
        //
        // //将日期直接嵌套在指定容器中
        // var dateIns = laydate.render({
        //     elem: '#laydateDemo'
        //     ,position: 'static'
        //     ,calendar: true //是否开启公历重要节日
        //     ,mark: { //标记重要日子
        //         '0-10-14': '生日'
        //         ,'2018-08-28': '新版'
        //         ,'2018-10-08': '神秘'
        //     }
        //     ,done: function(value, date, endDate){
        //         if(date.year == 2017 && date.month == 11 && date.date == 30){
        //             dateIns.hint('一不小心就月底了呢');
        //         }
        //     }
        //     ,change: function(value, date, endDate){
        //         layer.msg(value)
        //     }
        // });

        //分页
        // laypage.render({
        //     elem: 'pageDemo' //分页容器的id
        //     ,count: 100 //总页数
        //     ,skin: '#1E9FFF' //自定义选中色值
        //     //,skip: true //开启跳页
        //     ,jump: function(obj, first){
        //         if(!first){
        //             layer.msg('第'+ obj.curr +'页', {offset: 'b'});
        //         }
        //     }
        // });

        //上传
        // upload.render({
        //     elem: '#uploadDemo'
        //     ,url: '' //上传接口
        //     ,done: function(res){
        //         console.log(res)
        //     }
        // });

        // slider.render({
        //     elem: '#sliderDemo'
        //     ,input: true //输入框
        // });

        //底部信息
        // var footerTpl = lay('#footer')[0].innerHTML;
        // lay('#footer').html(layui.laytpl(footerTpl).render({}))
        //     .removeClass('layui-hide');
    });
</script>
</body>
</html>