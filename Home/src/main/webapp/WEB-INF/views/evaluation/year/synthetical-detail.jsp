<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度考核-绩效综合能力详情</title>
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
                ${testPlan.testName}详情
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">绩效综合能力考核详情</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-success">
                        <div class="box-header">
                            <h3 class="box-title">工作计划设置</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <c:if test="${testPlan.testTypeId == 2}">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>考核年份</th>
                                        <th>1月</th>
                                        <th>2月</th>
                                        <th>3月</th>
                                        <th>4月</th>
                                        <th>5月</th>
                                        <th>6月</th>
                                        <th>7月</th>
                                        <th>8月</th>
                                        <th>9月</th>
                                        <th>10月</th>
                                        <th>11月</th>
                                        <th>12月</th>
                                        <th>平均得分</th>
                                        <th>年度总结得分</th>
                                        <th>您的得分</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                        <td>1</td>
                                            <td>${testPlan.year}</td>
                                            <c:forEach items="${workPlanList}" var="workPlan">
                                                <td>
                                                <c:if test="${workPlan.month == 1}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                                </td>
                                                <td>
                                                <c:if test="${workPlan.month == 2}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                                </td>
                                                <td>
                                                <c:if test="${workPlan.month == 3}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                                </td>
                                                <td>
                                                <c:if test="${workPlan.month == 4}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                                </td>
                                                <td>
                                                <c:if test="${workPlan.month == 5}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                                </td>
                                                <td>
                                                <c:if test="${workPlan.month == 6}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                                </td>
                                                <td>
                                                <c:if test="${workPlan.month == 7}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                                </td>
                                                <td>
                                                <c:if test="${workPlan.month == 8}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                                </td>
                                                <td>
                                                <c:if test="${workPlan.month == 9}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                                </td>
                                                <td>
                                                <c:if test="${workPlan.month == 10}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                                </td>
                                                <td>
                                                <c:if test="${workPlan.month == 11}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                                </td>
                                                <td>
                                                <c:if test="${workPlan.month == 12}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                                </td>
                                            </c:forEach>
                                                <td>${sumScore}</td>
                                                <td>${performance.summaryScore}</td>
                                                <td>${performance.yearScore}</td>
                                            </tr>
                                    </tbody>
                                </c:if>
                                <c:if test="${testPlan.testTypeId == 1}">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>考核年份</th>
                                        <th>一季度</th>
                                        <th>二季度</th>
                                        <th>三季度</th>
                                        <th>四季度</th>
                                        <th>平均得分</th>
                                        <th>年度总结得分</th>
                                        <th>您的得分</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>2</td>
                                        <td>${testPlan.year}</td>
                                        <c:forEach items="${workPlanList}" var="workPlan">
                                            <td>
                                            <c:if test="${workPlan.queater == 1}">
                                                ${workPlan.queaterScore}
                                            </c:if>
                                            </td>
                                            <td>
                                            <c:if test="${workPlan.queater == 2}">
                                                ${workPlan.queaterScore}
                                            </c:if>
                                            </td>
                                            <td>
                                            <c:if test="${workPlan.queater == 3}">
                                                ${workPlan.queaterScore}
                                            </c:if>
                                            </td>
                                            <td>
                                            <c:if test="${workPlan.queater == 4}">
                                                ${workPlan.queaterScore}
                                            </c:if>
                                            </td>
                                        </c:forEach>
                                        <td>${sumScore}</td>
                                        <td>${performance.summaryScore}</td>
                                        <td>${performance.yearScore}</td>
                                    </tr>
                                    </tbody>
                                </c:if>
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
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable()
    })
</script>
</body>
</html>
