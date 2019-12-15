<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<html>
<head>
<title>Title</title>
<link
	href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<style>
	body{
	padding:20px;
	}
	</style>
</head>
<body>
<h2 style='text-align:center;margin-top:20px;margin-bottom:20px;'>用户列表</h2>
<div class="container-fluid">
  <div class="row">
    <div class="col-xs-6 col-md-4">
    
    	<form class="form-inline"
		action="${pageContext.request.contextPath}/GetUserController?pageNume=1">
		<input type='text' name='pageNum' value='1' style='display: none;' />
		<input type='text' name='columnName' value='username'
			style='display: none;' />
		<div class="form-group">
			<label for="exampleInputEmail1">姓名：</label> <input type="text"
				class="form-control" name='columnValue'
				value='${sessionScope.columnValue }' placeholder="请输入姓名">
		</div>
		<button type="submit" class="btn btn-primary">搜索</button>
	</form>
	
    </div>
    <div class="col-xs-6 col-md-8" style="text-align:right;">
    
    <a style="width:150px;" class="btn btn-info" href="${pageContext.request.contextPath}/admin/user/addAdminUser.jsp">
    <i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;新增用户
    </a>
    </div>
  </div>
</div>

	
	
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>用户编号</th>
				<th>姓名</th>
				<th>部门</th>
				<th>权限组</th>
				<th>工作电话</th>
				<th>手机号码</th>
				<th>创建日期</th>
				<th>状态</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty page.list}">
				<c:forEach items="${page.list}" var="item">
					<tr id="${item.id}">
						<td>${item.id}</td>
						<td>${item.username}</td>
						<td>部门</td>
						<td>权限组</td>
						<td>${item.workPhone}</td>
						<td>${item.mobile}</td>

						<td>${item.createTime}</td>
						<td>
						<c:if test="${item.staffStatus==1 }">
						 <span style='color:orange;'>正常</span>
						</c:if>
						<c:if test="${item.staffStatus==0 }">
						  <span style='color:red;'>异常</span>
						</c:if>
						</td>
						<td>${item.remark}</td>
						<td><a class="btn btn-danger" href="javascript:void(0)"
							onclick="delUser('${item.id}')">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>

		</tbody>
	</table>


	<h3 class="page_h3" align="center">
		<ul class="pagination">
			<c:if test="${requestScope.page.pageNum!=0}">
				<li><a
					href="${pageContext.request.contextPath}/GetUserController?pageNum=${page.pageNum}&columnName=${sessionScope.columnName}&columnValue=${sessionScope.columnValue}"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>
			<c:if test="${requestScope.page.pageNum==0}">
				<li class="previous disabled"><a href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>

			<c:if test="${page.end>0}">
				<c:forEach begin="${page.start}" end="${page.end-1}" var="i"
					step="1">
					<c:if test="${page.pageNum==i}">
						<li class="active"><a
							href="${pageContext.request.contextPath}/GetUserController?pageNum=${i+1}&columnName=${sessionScope.columnName}&columnValue=${sessionScope.columnValue}">${i+1}</a></li>
					</c:if>
					<c:if test="${page.pageNum!=i}">
						<li><a
							href="${pageContext.request.contextPath}/GetUserController?pageNum=${i+1}&columnName=${sessionScope.columnName}&columnValue=${sessionScope.columnValue}">${i+1}</a></li>
					</c:if>
				</c:forEach>
			</c:if>

			<c:if test="${page.end==0}">
				<li class="active"><a
					href="${pageContext.request.contextPath}/GetUserController?pageNum=1&columnName=${sessionScope.columnName}&columnValue=${sessionScope.columnValue}">1</a></li>
			</c:if>



			<c:if test="${requestScope.page.pageTotal>0 }">

				<c:if
					test="${requestScope.page.pageNum!=requestScope.page.pageTotal-1}">
					<li><a
						href="${pageContext.request.contextPath}/GetUserController?pageNum=${page.pageNum+2}&columnName=${sessionScope.columnName}&columnValue=${sessionScope.columnValue}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				<c:if
					test="${requestScope.page.pageNum==requestScope.page.pageTotal-1}">
					<li class="previous disabled"><a href="#" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</c:if>

			<c:if test="${requestScope.page.pageTotal==0 }">

				<li class="previous disabled"><a href="#" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>




			<li><a>第${page.pageNum+1 }页/共${page.pageTotal}页/共${page.dataSize}条数据</a></li>
		</ul>
	</h3>




	<script>
		function delUser(id, type) {
			if (confirm("确定删除该管理员吗?")) {
				delU(id);
			}
		}

		function delU(id) {
			$.ajax({
				type : "post",
				async : false,
				url : "${pageContext.request.contextPath}/deleteUser",
				data : {
					id : id
				},
				success : function(msg) {
					alert("删除成功!")
					$("#" + id).remove();
				},
				dataType : "json"
			});
		}
	</script>
</body>
</html>
