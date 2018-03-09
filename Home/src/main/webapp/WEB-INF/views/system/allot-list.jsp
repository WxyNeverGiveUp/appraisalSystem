<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/4
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管辖分配</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- select2 -->
    <link rel="stylesheet" href="${staticWebsite}/bower_components/select2/dist/css/select2.min.css">
    <jsp:include page="../common/link.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/link.html" -->

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <jsp:include page="../common/header.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/header.html" -->
    <jsp:include page="../common/sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/sidebar.html" -->

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                管辖分配
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">系统管理</a></li>
                <li class="active">管辖分配</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-warning">
                        <div class="box-header">
                            <h3 class="box-title">管辖分配列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>员工姓名</th>
                                    <th>职位</th>
                                    <th>管辖部门</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userList1}" var="user" varStatus="status">
                                    <tr data-id="${user.id}">
                                        <td>${status.index+1}</td>
                                        <td>${user.realName}</td>
                                        <td>副总经理</td>
                                        <td class="department-text">
                                        <c:forEach items="${allotList}" var="allot">
                                            <c:if test="${allot.uid == user.id}">
                                                <c:forEach items="${departmentList}" var="department">
                                                    <c:if test="${allot.did==department.id}">
                                                        ${department.name}&nbsp;&nbsp;&nbsp;&nbsp;
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </c:forEach>
                                        </td>
                                        <td>
                                            <button type="button" class="btn bg-olive change" data-toggle="modal" data-target="#modal-default" data-num="${user.id}">修改管辖范围</button>
                                            <%--<button type="button" class="btn bg-red delete" data-num="${user.id}">删除</button>--%>
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
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->

    <div class="control-sidebar-bg"></div>
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改管辖范围</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="dataId">
                    <div class="form-group">
                        <label>选择部门：</label>
                        <select class="form-control select2 a-require-options department" multiple="multiple" data-placeholder="请选择..." style="width: 100%;" name="did">
                            <c:forEach items="${departmentList}" var="department">
                                <option value="${department.id}">${department.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <!-- <div class="form-group">
                        <label>备注信息：</label>
                        <textarea class="form-control a-require-text remark" rows="3" placeholder="请输入..."></textarea>
                    </div> -->
                    <p class="text-red tip"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary J-ajax-submit">保存修改</button>
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
<!-- select2 -->
<script src="${staticWebsite}/bower_components/select2/dist/js/select2.full.js"></script>
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script src="${staticWebsite}/pages/system/allot-list.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('.select2').select2();
        $('#example1').DataTable();
    })
</script>
</body>
</html>
