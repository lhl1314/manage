<%--
  Created by IntelliJ IDEA.
  User: lhl
  Date: 2019/11/27
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<html>
<head>
<title>添加管理员</title>
<link
	href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<style>
body {
	height: 100%;
	width: 100%;
	background: white;
}

.addAdminUser {
	height: 800px;
	width: 1000px;
	background: white;
}
.redInput{
color:red;
font-weight: bolder;
}
</style>
</head>
<body>
	<h2 style='text-align: center;'>创建用户信息</h2>
		<div class="container-fluid">
			<div class="row" style="border-bottom: 1px solid black;padding:10px;margin:20px;">
				<div class="col-xs-6 col-md-4">用户基本信息</div>
				<div class="col-xs-6 col-md-8" style="text-align: right;">
					注：带<span class="redInput">*</span>为必填项</div>
			</div>
		</div>

		<div class="addAdminUser">
			<form class="form-horizontal" role="form"
				action="${pageContext.request.contextPath}/addOrUpdateUser">
				<input type="text" name="id" value="100" style="display: none;">
				<div class="form-group">
					<label for="username"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3 control-label">部门</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<input type="text" class="form-control" name="depName"
							id="depName" required placeholder="请输入部门">
					</div>
				</div>
				<div class="form-group">
					<label for="password"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3 control-label">姓名</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<input type="text" class="form-control" name="username"
							id="username" required placeholder="请输入姓名">
					</div>
				</div>
				<div class="form-group">
					<label for="mobile"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3 control-label">用户编号</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<input type="text" class="form-control" name="mobile" id="mobile"
							placeholder="请输入用户编号">
					</div>
				</div>
				<div class="form-group">
					<label for="email"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3 control-label">岗位名称</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<input type="text" class="form-control" id="email" name="email"
							placeholder="请输入岗位名称">
					</div>
				</div>
				<div class="form-group">
					<label for="sex"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3  control-label">名字</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6"
						style="padding-top: 5px;">
						<input type="radio" name="sex" id="sex" value="男" aria-label="...">&nbsp;&nbsp;男&nbsp;&nbsp;
						<input type="radio" name="sex" id="sex" value="女" aria-label="...">&nbsp;&nbsp;女&nbsp;&nbsp;
					</div>
				</div>



				<div class="form-group">
					<label for="email"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3 control-label">工作电话</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<input type="text" class="form-control" id="email" name="email"
							placeholder="请输入工作电话">
					</div>
				</div>

				<div class="form-group">
					<label for="email"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3  control-label">手机号码</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<input type="text" class="form-control" id="email" name="email"
							placeholder="请输入手机号码">
					</div>
				</div>


				<div class="form-group">
					<label for="email"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3  control-label">邮箱</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<input type="text" class="form-control" id="email" name="email"
							placeholder="请输入邮箱">
					</div>
				</div>



				<div class="form-group">
					<label for="email"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3  control-label">工作QQ</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<input type="text" class="form-control" id="email" name="email"
							placeholder="请输入工作QQ">
					</div>
				</div>


				<div class="form-group">
					<label for="email"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3  control-label">短号</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<input type="text" class="form-control" id="email" name="email"
							placeholder="请输入短号">
					</div>
				</div>


				<div class="form-group">
					<label for="email"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3  control-label">职位级别</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<select class="form-control">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="email"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3  control-label">职位类别</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<select class="form-control">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="email"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3  control-label">员工状态</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<select class="form-control">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="email"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3 control-label">权限组</label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6">
						<select class="form-control">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
				</div>


				<div class="form-group">
					<label for="email"
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3  control-label">备注</label>
					<div class="col-xs-8 col-sm-8 col-xl-8 col-lg-8">
						<textarea class="form-control" rows="3"></textarea>
					</div>
				</div>


				<div class="form-group">
					<label for=""
						class="col-xs-3 col-sm-3 col-xl-3 col-lg-3 control-label"></label>
					<div class="col-xs-6 col-sm-6 col-xl-6 col-lg-6"
						style="padding-top: 5px;">
						<button type="submit" class="btn btn-default">添加管理员</button>
					</div>
				</div>

			</form>

		</div>


</body>
</html>
