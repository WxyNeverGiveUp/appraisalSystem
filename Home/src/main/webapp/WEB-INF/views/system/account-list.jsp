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
    <meta htt-equiv="X-UA-Compatible" content="IE=edge">
    <title>账号管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="widh=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <jsp:include page="../common/link.jsp"/>

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <jsp:include page="../common/header.jsp"/>
    <jsp:include page="../common/sidebar.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                账号管理
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">系统管理</a></li>
                <li class="active">账号管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-warning">
                        <div class="box-header">
                            <h3 class="box-title">账号管理列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>员工姓名</th>
                                    <th>手机号</th>
                                    <th>所属部门</th>
                                    <th>职位</th>
                                    <th>账号审核状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${userList}" var="user" varStatus="status">
                                        <tr data-id="${user.id}">
                                        <c:if test="${user.power == 1}">
                                            <td>${status.index+1}</td>
                                            <td>${user.realName}</td>
                                            <td>${user.phone}</td>
                                            <td>
                                                    ${user.department}
                                            </td>
                                            <td>
                                                    ${user.role}
                                            </td>
                                            <td class="status">
                                                    <c:if test="${user.status == 1}">
                                                        审核通过
                                                    </c:if>
                                                    <c:if test="${user.status == 0}">
                                                        未审核
                                                    </c:if>
                                                    <c:if test="${user.status == 2}">
                                                        审核不通过
                                                    </c:if>
                                            </td>

                                            <td>
                                                <button type="button" class="btn bg-red" disabled="disabled">无法操作</button>
                                            </td>
                                        </c:if>
                                            <c:if test="${user.power >1}">
                                                <td>${status.index+1}</td>
                                                <td>${user.realName}</td>
                                                <td>${user.phone}</td>
                                                <td>
                                                        ${user.department}
                                                </td>
                                                <td>
                                                        ${user.role}
                                                </td>
                                                <td class="status">
                                                    <c:if test="${user.status == 1}">
                                                        审核通过
                                                    </c:if>
                                                    <c:if test="${user.status == 0}">
                                                        未审核
                                                    </c:if>
                                                    <c:if test="${user.status == 2}">
                                                        审核不通过
                                                    </c:if>
                                                </td>

                                                <td>
                                                    <button type="button" class="btn bg-olive pass" data-num="${user.id}">审核通过</button>
                                                    <button type="button" class="btn bg-red refuse" data-num="${user.id}">审核不通过</button>
                                                </td>
                                            </c:if>
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
</div>
<!-- ./wrapper -->
<jsp:include page="../common/script.jsp"/>
<script src="${staticWebsite}/pages/system/account-list.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable()
    })
</script>
</body>
</html>

