<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/4
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>权限管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <jsp:include page="../common/link.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/link.html" -->

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <jsp:include page="../common/header.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/header.html" -->
    <jsp:include page="../common/sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/sidebar.html" -->

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                职位权限管理
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">系统管理</a></li>
                <li class="active">权限管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-warning">
                        <div class="box-header">
                            <h3 class="box-title">已有权限管理</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>权限等级</th>
                                    <th>备注信息</th>
                                    <%--<th>操作</th>--%>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${powerList}" var="power" varStatus="status">
                                    <tr data-id="${power.id}">
                                        <td>${status.index+1}</td>
                                        <td class="level-text">${power.power}</td>
                                        <td class="remark-text">${power.detail}</td>
                                        <%--<td>--%>
                                            <%--<button type="button" class="btn bg-olive change" data-toggle="modal" data-target="#modal-default"  data-num="${power.id}">修改</button>--%>
                                            <%--<a class="btn bg-red delete" data-num="${power.id}" href="javascript:;">删除权限</a>--%>
                                        <%--</td>--%>
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
            <%--<a href="${website}/power/toadd" class="btn bg-olive">添加</a>--%>
        </section>

        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->

    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改权限信息</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="dataId">
                    <div class="form-group">
                        <label>权限等级：</label>
                        <input type="text" class="form-control a-require-text level" placeholder="请输入...">
                    </div>
                    <div class="form-group">
                        <label>备注信息：</label>
                        <textarea class="form-control a-require-text remark" rows="3" placeholder="请输入..."></textarea>
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
</div>
<!-- ./wrapper -->
<jsp:include page="../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script src="${staticWebsite}/pages/system/jurisdiction-list.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable();
    })
</script>
</body>
</html>
