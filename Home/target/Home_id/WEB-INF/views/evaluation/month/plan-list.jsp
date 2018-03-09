<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>月度考核-工作计划列表</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
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
                工作计划设置
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">工作计划</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-success">
                        <div class="box-header">
                            <h3 class="box-title">工作计划列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>所属考核名称</th>
                                    <th>所属考核计划</th>
                                    <th>考核时间</th>
                                    <th>是否开启</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${joinTestList}" var="joinTest" varStatus="st">
                                        <c:forEach items="${testPlanList}" var="testPlan" varStatus="status">
                                            <c:if test="${joinTest.testId == testPlan.id}">
                                                <c:if test="${testPlan.testTypeId ==5 ||testPlan.testTypeId==6}">
                                                    <tr data-id="${st.index+1}">
                                                        <td>${st.index+1}</td>
                                                        <td>${testPlan.testName}</td>
                                                        <td>
                                                        <c:forEach items="${testTypeList}" var="testType">
                                                            <c:if test="${testPlan.testTypeId == testType.id}">
                                                                ${testType.name}
                                                            </c:if>
                                                        </c:forEach>
                                                        </td>
                                                        <td>${testPlan.startTime}</td>
                                                        <c:if test="${testPlan.isAvailable ==1}">
                                                            <td>填写开启</td>
                                                            <td>
                                                                <a href="${website}/workplan/month/detail/${testPlan.id}" class="btn bg-blue">查看详情</a>
                                                            </td>
                                                        </c:if>
                                                        <c:if test="${testPlan.isAvailable ==0}">
                                                            <td>未开启</td>
                                                            <td>
                                                                <a href="#" class="btn bg-red" disabled="disabled">暂未开启</a>
                                                            </td>
                                                        </c:if>
                                                        <c:if test="${testPlan.isAvailable ==2}">
                                                            <td>考核开启</td>
                                                            <td>
                                                                <a href="#" class="btn bg-red" disabled="disabled">填写未开启</a>
                                                            </td>
                                                        </c:if>
                                                    </tr>
                                                </c:if>
                                            </c:if>
                                        </c:forEach>
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
    <jsp:include page="../../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->

</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable()
    })
</script>
</body>
</html>
