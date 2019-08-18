<%--
  Created by IntelliJ IDEA.
  User: hedeqing
  Date: 2019/8/18
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../../static/admin/layui/css/layui.css" charset="UTF-8" media="all">
    <link rel="stylesheet" href="../../../static/admin/js/global.js" charset="UTF-8" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<div class="demoTable">
    搜索ID：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>

<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>


<script src="../../../static/admin/layui/layui.all.js"  type="text/html"  charset="gbk"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('table', function(){
        var table = layui.table;

        //方法级渲染
        table.render({
            elem: '#LAY_table_user'
            ,url: 'http://localhost:8080/selectAll'
            ,cols: [[
                {type: 'checkbox', fixed: false}
                ,{field: 'id', title: 'ID', width:80, sort: true,  totalRowText: '合计：'}
                ,{field: 'userName', title: '用户名', width:80}
                ,{field: 'gender', title: '性别', width:80, sort: true}
                ,{field: 'number', title: '号码', width: 80, sort: true}
                ,{field: 'password', title: '密码', width:150}
                ,{fixed: 'right', width: 300, align:'center', toolbar: '#barDemo'}
            ]]
            ,id: 'testReload'
            ,page: true
            ,height: 310
        });

        var $ = layui.$, active = {
            reload: function(){
                var demoReload = $('#demoReload');

                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        key: {
                            id: demoReload.val()
                        }
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>

</body>
</html>