
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>网站后台管理模版</title>
		<link rel="stylesheet" type="text/css" href="../../static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="../../static/admin/css/admin.css"/>
	</head>
	<body>
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="/jsp/admin/common/header.jsp"></jsp:include>
		<div class="layui-tab page-content-wrap" style="margin-left: 190px">
		  <ul class="layui-tab-title">
		    <li class="layui-this">修改资料</li>
		    <li>修改密码</li>
		  </ul>
		  <div class="layui-tab-content">
		    <div class="layui-tab-item layui-show">
		    	<form class="layui-form"  style="width: 90%;padding-top: 20px;">
				  <div class="layui-form-item">
				    <label class="layui-form-label">ID：</label>
				    <div class="layui-input-block">
				      <input type="text" name="id" disabled autocomplete="off" class="layui-input layui-disabled" value="1">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">用户名：</label>
				    <div class="layui-input-block">
				      <input type="text" name="username" disabled autocomplete="off" class="layui-input layui-disabled" value="admin">
				    </div>
				  </div>
				   <div class="layui-form-item">
				    <label class="layui-form-label">姓名：</label>
				    <div class="layui-input-block">
				      <input type="text" name="name" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" value="未知">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">号码：</label>
				    <div class="layui-input-block">
				      <input type="text" name="email" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" value="240484406@qq.com">
				    </div>
				  </div>
				  <div class="layui-form-item layui-form-text">
				    <label class="layui-form-label">备注：</label>
				    <div class="layui-input-block">
				      <textarea name="desc" placeholder="管理员" class="layui-textarea"></textarea>
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminInfo">立即提交</button>
				    </div>
				  </div>
				</form>
		    </div>
		    <div class="layui-tab-item">
		    	<form class="layui-form" v style="width: 90%;padding-top: 20px;">
				  <div class="layui-form-item">
				    <label class="layui-form-label">用户名：</label>
				    <div class="layui-input-block">
				      <input type="text" name="username" disabled autocomplete="off" class="layui-input layui-disabled" value="admin">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">旧密码：</label>
				    <div class="layui-input-block">
				      <input type="password" name="password1" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">新密码：</label>
				    <div class="layui-input-block">
				      <input type="password" name="password2" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">重复密码：</label>
				    <div class="layui-input-block">
				      <input type="password" name="password3" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminPassword">立即提交</button>
				    </div>
				  </div>
				</form>
		    </div>
		  </div>
		</div>
	<script src="../../static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>
		//Demo
		layui.use(['form','element'], function(){
		  var form = layui.form();
		  var element = layui.element();
		  form.render();
		  //监听信息提交
		  form.on('submit(adminInfo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });
		  //监听密码提交
		   form.on('submit(adminPassword)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });
		});
	</script>
	</body>
</html>