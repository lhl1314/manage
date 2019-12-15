<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
		<style>
			body {
				height: 100%;
				width: 100%;
				background: #EBF3EE;
				font-family: myFont;
			}
			@font-face {
				font-family: 'myFont';
				src: url('${pageContext.request.contextPath}/font01.ttf');
			}
			.adminLogin {
				height: 400px;
				width: 600px;
				margin: 150px auto;
				background: white;
				/*padding-top: 80px;*/
			}
		</style>
	</head>

	<body>
		<div class="adminLogin">
			<h2 style="text-align: center; padding-top: 30px; padding-bottom: 30px;">用户管理系统</h2>
			<form class="form-horizontal" role="form" action="#">
				<div class="form-group">
					<label for="firstname" class="col-xs-3 col-sm-3 col-xl-3 col-lg-3 col-lg-offset-1 control-label">用户名</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名">
					</div>
				</div>
				<br />
				<br />
				<div class="form-group">
					<label for="firstname" class="col-xs-3 col-sm-3 col-xl-3 col-lg-3 col-lg-offset-1 control-label">密码</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<input type="text" class="form-control" name="password" id="password" placeholder="请输入密码">
					</div>
				</div>
				<br />

				<div class="form-group">
					<label for="firstname" class="col-xs-3 col-sm-3 col-xl-3 col-lg-3 col-lg-offset-1 control-label"></label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6" style="padding-top: 5px;">
						<button type="button" style="width: 100%;" id="submitButton" class="btn btn-default">立刻登录</button>
					</div>
				</div>

			</form>

		</div>

	<script>
		$("#submitButton").click(function () {
			$.ajax({
				url:"${pageContext.request.contextPath}/LoginController",
				async:false,
				type:"post",
				data:{
					username:$("#username").val(),
					password:$("#password").val()
				},
				success:function (msg) {
					if (msg==1){
						location.href="${pageContext.request.contextPath}/admin/home.jsp";
					}else {
						alert("用户名或者密码错误!")
					}
				}
			})
		})
	</script>
	</body>

</html>