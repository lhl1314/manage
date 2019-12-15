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
body {
	padding: 20px;
}
</style>
</head>
<body>
	<h2 style='text-align: center; margin-top: 20px; margin-bottom: 20px;'>操作日志信息列表</h2>
	
	<form class="form-inline"
		action="${pageContext.request.contextPath}/DoLogListController?pageNume=1">
		<input type='text' name='pageNum' value='1' style='display: none;' />

		<div class="form-group">
			<label for="exampleInputEmail1"> <select class="form-control"
				name='columnName'>
					<option value=''>全部</option>

					<c:if test="${sessionScope.columnName=='id'}">
						<option selected="selected" value='id'>编号</option>
					</c:if>
					<c:if test="${sessionScope.columnName!='id'}">
						<option value='id'>编号</option>
					</c:if>


					<c:if test="${sessionScope.columnName=='username'}">
						<option selected="selected" value='username'>姓名</option>
					</c:if>
					<c:if test="${sessionScope.columnName!='username'}">
						<option value='username'>姓名</option>
					</c:if>


					<c:if test="${sessionScope.columnName=='depName'}">
						<option selected="selected" value='depName'>部门名称</option>
					</c:if>
					<c:if test="${sessionScope.columnName!='depName'}">
						<option value='depName'>部门名称</option>
					</c:if>



					<c:if test="${sessionScope.columnName=='roleName'}">
						<option selected="selected" value='roleName'>模块名称</option>
					</c:if>
					<c:if test="${sessionScope.columnName!='roleName'}">
						<option value='roleName'>模块名称</option>
					</c:if>


					<c:if test="${sessionScope.columnName=='loginIp'}">
						<option selected="selected" value='loginIp'>登录IP</option>
					</c:if>
					<c:if test="${sessionScope.columnName!='loginIp'}">
						<option value='loginIp'>登录IP</option>
					</c:if>

					<c:if test="${sessionScope.columnName=='function'}">
						<option selected="selected" value='function'>功能</option>
					</c:if>
					<c:if test="${sessionScope.columnName!='function'}">
						<option value='function'>功能</option>
					</c:if>


			</select>
			</label> <input type="text" class="form-control" name='columnValue'
				value='${sessionScope.columnValue }' placeholder="请输入关键字">
		</div>
		<button type="submit" class="btn btn-primary">搜索</button>
	</form>
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>部门名称</th>
				<th>模块名称</th>
				<th>登录IP</th>
				<th>登录时间</th>
				<th>功能</th>
				<th>操作时间</th>
				<th>操作状态</th>
				<th>退出时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty page.list}">
				<c:forEach items="${page.list}" var="item">
					<tr id="${item.id}">
						<td>${item.id}</td>
						<td>${item.username}</td>
						<td>${item.depName }</td>
						<td>${item.roleName }</td>
						<td>${item.loginIp}</td>
						<td>${item.loginTime}</td>

						<td>${item.function}</td>
						<td>${item.doTime}</td>
						<td>${item.status }</td>
						<td>${item.logoutTime }</td>
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
					href="${pageContext.request.contextPath}/DoLogListController?pageNum=${page.pageNum}&columnName=${sessionScope.columnName}&columnValue=${sessionScope.columnValue}"
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
							href="${pageContext.request.contextPath}/DoLogListController?pageNum=${i+1}&columnName=${sessionScope.columnName}&columnValue=${sessionScope.columnValue}">${i+1}</a></li>
					</c:if>
					<c:if test="${page.pageNum!=i}">
						<li><a
							href="${pageContext.request.contextPath}/DoLogListController?pageNum=${i+1}&columnName=${sessionScope.columnName}&columnValue=${sessionScope.columnValue}">${i+1}</a></li>
					</c:if>
				</c:forEach>
			</c:if>

			<c:if test="${page.end==0}">
				<li class="active"><a
					href="${pageContext.request.contextPath}/DoLogListController?pageNum=1&columnName=${sessionScope.columnName}&columnValue=${sessionScope.columnValue}">1</a></li>
			</c:if>



			<c:if test="${requestScope.page.pageTotal>0 }">

				<c:if
					test="${requestScope.page.pageNum!=requestScope.page.pageTotal-1}">
					<li><a
						href="${pageContext.request.contextPath}/DoLogListController?pageNum=${page.pageNum+2}&columnName=${sessionScope.columnName}&columnValue=${sessionScope.columnValue}"
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
