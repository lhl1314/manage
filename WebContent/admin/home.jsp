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


        .list-group-item {
            padding-left: 60px;
        }

        .list-group-item:hover {
            background: olive;
            cursor: pointer;
        }

        .navbar {
            border-radius: 0px;
        }

        .panel > .panel-collapse > .list-group:last-child .list-group-item:last-child {
            border-radius: 0px;
        }

        .panel-heading {
            border-radius: 0px;
        }

        .panel-title {
            cursor: pointer;
        }

        .tree_click_color {
            background: coral;
        }
    </style>
</head>

<body>
<div class="myBody">
    <div class="myNav">

        <nav class="navbar navbar-inverse" role="navigation" style="margin: 0px;">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#example-navbar-collapse">
                        <span class="sr-only">切换导航</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">用户管理系统后台</a>
                </div>
                <div class="collapse navbar-collapse" id="example-navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active">
                            <a href="#">欢迎管理员:${sessionScope.user.username}</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/LogoutController">注销</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

    </div>
    <div class="myContente">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-6 col-lg-2 myTree"
                     style="padding: 0px;background: white;height: 700px;">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default" style="margin: 0px;">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#accordion"
                                 href="#collapseOne">
                                <h4 class="panel-title">
                                    主页
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in">
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <a href="${pageContext.request.contextPath}/admin/zhu.jsp" target="zhuye">主页</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel panel-default" style="margin: 0px;">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#accordion"
                                 href="#collapse1">
                                <h4 class="panel-title">
                                    用户管理
                                </h4>
                            </div>
                            <div id="collapse1" class="panel-collapse collapse in">
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <a href="${pageContext.request.contextPath}/GetUserController?pageNum=1"
                                           target="zhuye">用户管理</a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="${pageContext.request.contextPath}/RolePermissionListController?pageNum=1"
                                           target="zhuye">权限管理</a>
                                    </li>
                                     <li class="list-group-item">
                                        <a href="${pageContext.request.contextPath}/DoLogListController?pageNum=1"
                                           target="zhuye">操作日志</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel panel-default" style="margin: 0px;">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#accordion"
                                 href="#collapse2">
                                <h4 class="panel-title">
                                   系统配置 
                                </h4>
                            </div>
                            <div id="collapse2" class="panel-collapse collapse in">
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <a href="${pageContext.request.contextPath}/DepmentListController?pageNum=1"
                                           target="zhuye">部门管理</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel panel-default" style="margin: 0px;">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#accordion"
                                 href="#collapse3">
                                <h4 class="panel-title">
                                <a href="${pageContext.request.contextPath}/LogoutController"> 退出系统 </a>
                                                      
                                </h4>
                            </div>
                          
                        </div>
                    </div>
                </div>
                <div class="col-xs-0 col-sm-0 col-md-6 col-lg-10" style="background: gainsboro;height: 700px;">
                    <iframe src="${pageContext.request.contextPath}/admin/zhu.jsp" height="100%" width="100%"
                            name="zhuye"></iframe>
                </div>
            </div>

        </div>
    </div>

</div>
</div>

<script>
</script>

</body>

</html>