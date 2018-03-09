<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/4
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>角色管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- select2 -->
    <link rel="stylesheet" href="http://localhost:8080/resources/js/bower_components/select2/dist/css/select2.min.css">
    <jsp:include page="../common/link.jsp"/>

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <jsp:include page="../common/header.jsp"/>
    <jsp:include page="../common/sidebar.jsp"/>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                职位角色管理
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">系统管理</a></li>
                <li class="active">角色管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-warning">
                        <div class="box-header">
                            <h3 class="box-title">角色管理列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>角色</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${roleList}" var="role" varStatus="status">
                                    <tr data-id="${role.id}">
                                        <td>${status.index+1}</td>
                                        <td class="role-text">${role.name}</td>
                                        <td>
                                            <button class="btn bg-olive change"  data-toggle="modal" data-target="#modal-default" data-num="${role.id}">修改</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
            <a href="${website}/role/toadd" class="btn bg-olive">添加</a>
        </section>

        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../common/footer.jsp"/>

        <div class="modal fade" id="modal-default">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">修改角色信息</h4>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" id="dataId">
                        <div class="form-group">
                            <label>角色名称：</label>
                            <input type="text" class="form-control a-require-text role"  placeholder="请输入..." name="name">
                        </div>
                        <div>
                            <label>权限备注信息：</label>
                            <textarea class="form-control remark" disabled="disabled" name="detail"></textarea>
                        </div>
                        <p class="text-red tip"></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary J-ajax-submit">修改</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
<!-- ./wrapper -->
<jsp:include page="../common/script.jsp"/>
<!-- select2 -->
<script src="${staticWebsite}/bower_components/select2/dist/js/select2.full.js"></script>
<!-- 验证模块 -->
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script src="${staticWebsite}/pages/system/role-list.js"></script>
<script>
    $(function () {
        $('.select2').select2();
        $('#example1').DataTable();
    })
</script>
</body>
</html>
