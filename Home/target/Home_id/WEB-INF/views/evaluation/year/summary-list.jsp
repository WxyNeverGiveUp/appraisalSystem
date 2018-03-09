<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/8
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度考核-个人总结</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${staticWebsite}/bower_components/select2/dist/css/select2.min.css">
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/link.html" -->
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <jsp:include page="../../common/header.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/header.html" -->
    <jsp:include page="../../common/sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/sidebar.html" -->

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                年度考核-个人总结
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">个人总结考核</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-success">
                        <div class="box-header">
                            <h3 class="box-title">年度能力指标列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>年份</th>
                                    <th>所属部门</th>
                                    <th>角色</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${summaryList}" var="summary" varStatus="status">
                                    <tr>
                                        <td>${status.index+1}</td>
                                        <td>${summary.year}</td>
                                        <td>
                                        <c:forEach items="${departmentList}" var="department">
                                            <c:if test="${user.did == department.id}">
                                                ${department.name}
                                            </c:if>
                                        </c:forEach>
                                        </td>
                                        <td>
                                        <c:forEach items="${roleList}" var="role">
                                            <c:if test="${user.rid == role.id}">
                                                ${role.name}
                                            </c:if>
                                        </c:forEach>
                                        </td>
                                        <td>
                                            <a href="${website}/summary/detail/${summary.id}" class="btn bg-blue">查看详情</a>
                                            <%--<button type="button" class="btn bg-red">删除此能力指标考核</button>--%>
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
            <a href="${website}/summary/toadd" class="btn bg-olive">添加个人总结</a>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->

    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->
<!-- page script -->
<script src="${staticWebsite}/bower_components/select2/dist/js/select2.full.js"></script>
<script>
    $(function () {
        // 表格
        $('#example1').DataTable();
        // 下拉框
        $('.select2').select2();
    })
</script>
</body>
</html>
