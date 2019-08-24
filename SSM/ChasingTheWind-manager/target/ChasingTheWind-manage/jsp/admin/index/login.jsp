<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>后台登录</title>
		<link rel="stylesheet" type="text/css" href="jsp/static/admin/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="jsp/static/admin/css/login.css" />
		<link rel="stylesheet" type="text/css" href="../../static/admin/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="../../static/admin/css/login.css" />
	</head>

	<body>
		<div class="m-login-bg">
			<div class="m-login">
				<h3>后台系统登录</h3>
				<div class="m-login-warp">
<%--					调用controller--%>
					<form class="layui-form" action="<%=basePath%>/user/login" method="post">

						<div class="layui-form-item">
							<input type="text" name="number" required lay-verify="required" placeholder="号码" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-form-item">
							<input type="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">
						</div>
<%--						<div class="layui-form-item">--%>
<%--							<div class="layui-inline">--%>
<%--								<input type="text" name="verity" required lay-verify="required" placeholder="验证码" autocomplete="off" class="layui-input">--%>
<%--							</div>--%>
<%--							<div class="layui-inline">--%>
<%--								<img class="verifyImg" onclick="this.src=this.src+'?c='+Math.random();" src="../../../static/admin/images/login/yzm.jpg" />--%>
<%--							</div>--%>
<%--						</div>--%>
						<div class="layui-form-item m-login-btn">
							<div class="layui-inline">
								<button class="layui-btn layui-btn-normal" lay-submit lay-filter="login">登录</button>
							</div>
							<div class="layui-inline">
								<button type="reset" class="layui-btn layui-btn-primary">取消</button>
							</div>
						</div>
					</form>
				</div>
				<p class="copyright">Copyright 2019-2020 by HEDEQING</p>
			</div>
		</div>
		<script src="../../static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="jsp/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script>
			layui.use(['form', 'layedit', 'laydate'], function() {
				var form = layui.form(),
					layer = layui.layer;


				//自定义验证规则
				form.verify({
					number: function(value) {
						if(value.length < 5) {
							return '标题至少得5个字符啊';
						}
					},
					password: [/(.+){6,12}$/, '密码必须6到12位'],
					verity: [/(.+){6}$/, '验证码必须是6位'],
					
				});

				
				//监听提交
				form.on('submit(login)', function(data) {
					layer.alert(JSON.stringify(data.field), {
						number: '最终的提交信息'
					})
					return false;
				});

			});
		</script>
	</body>

</html>