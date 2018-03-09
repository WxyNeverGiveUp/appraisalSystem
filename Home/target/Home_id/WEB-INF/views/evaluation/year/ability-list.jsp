<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度考核-能力指标</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${staticWebsite}/bower_components/select2/dist/css/select2.min.css">
    <jsp:include page="../../common/link.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/link.html" -->

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
                年度考核-能力指标
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">能力指标考核</li>
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
                                    <td>序号</td>
                                    <th>考核计划名称</th>
                                    <th>所属考核计划</th>
                                    <th>考核时间</th>
                                    <th>是否开启</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${testPlanList}" var="testPlan" varStatus="status">
                                    <tr>
                                        <td>${status.index+1}</td>
                                        <td>${testPlan.testName}</td>
                                        <td>年度能力指标考核</td>
                                        <td>${testPlan.startTime}</td>
                                        <c:if test="${testPlan.isAvailable == 1}">
                                            <td>填写开启</td>
                                            <td>
                                                <a href="${website}/test/position/list/${testPlan.id}" class="btn bg-blue">查看详情</a>
                                            </td>
                                        </c:if>
                                        <c:if test="${testPlan.isAvailable == 2}">
                                            <td>考核开启</td>
                                            <td>
                                                <a disabled="disabled"  class="btn bg-red">填写未开启</a>
                                            </td>
                                        </c:if>
                                        <c:if test="${testPlan.isAvailable == 0}">
                                            <td>未开启</td>
                                            <td>
                                                <a disabled="disabled"  class="btn bg-red">暂未开启</a>
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
            <%--<a href="ability-add.html" class="btn bg-olive">添加能力指考核</a>--%>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../../common/footer.jsp"/>

    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
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
