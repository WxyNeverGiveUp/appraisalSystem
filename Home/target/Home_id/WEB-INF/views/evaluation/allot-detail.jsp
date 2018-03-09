<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>考核分配管理</title>
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

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                考核分配
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">考核分配管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-success">
                        <div class="box-header">
                            <h3 class="box-title">考核分配-全部员工列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>考核计划名称</th>
                                    <th>所属部门</th>
                                    <th>姓名</th>
                                    <th>职位</th>
                                    <th>是否参与本次考核</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="user" varStatus="status">
                                    <tr>
                                        <td>${status.index+1}</td>
                                        <td>${testPlan.testName}</td>
                                        <td>${user.department}</td>
                                        <td>${user.realName}</td>
                                        <td>${user.role}</td>
                                        <td class="status">
                                            <c:forEach items="${joinTestList}" var="joinTest" varStatus="status">
                                                <c:if test="${joinTest.uid == user.id}">
                                                    已参与
                                                </c:if>
                                            </c:forEach>
                                        </td>

                                        <td>
                                            <button class="btn bg-blue add" data-test="${testPlan.id}" data-user="${user.id}">添加</button>
                                            <button type="button" class="btn bg-red delete" data-test="${testPlan.id}" data-user="${user.id}">移除</button>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>序号</th>
                                    <th>考核计划名称</th>
                                    <th>所属部门</th>
                                    <th>姓名</th>
                                    <th>职位</th>
                                    <th>是否参与本次考核</th>
                                    <th>
                                        操作
                                        <button type="button" class="btn bg-blue add-all" data-test="${testPlan.id}">全部添加</button>
                                    </th>
                                </tr>
                                </tfoot>
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
<script src="${staticWebsite}/pages/evaluation/allot-detail.js"></script>
<script>
    $(function () {
        $('#example1').DataTable();
    })
</script>
</body>
</html>
