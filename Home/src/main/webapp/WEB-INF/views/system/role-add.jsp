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
            <div class="box box-warning">
                <div class="box-header with-border">
                    <h3 class="box-title">增添新角色</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form action="${website}/role/add" method="post">
                        <div class="form-group">
                            <label>角色名称：</label>
                            <input type="text" class="form-control require-text" placeholder="请输入..." name="name">
                        </div>

                        <div class="form-group">
                            <label>选择权限：</label>
                            <select class="form-control select2 require-options" multiple="multiple" data-placeholder="请选择..." style="width: 100%;" name="pid">
                                <c:forEach items="${powerList}" var="power">
                                    <option value="${power.id}">${power.power}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${power.detail}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="box-footer">
                            <p class="text-red none">信息不完整，请完整填写所需信息</p>
                            <a href="${website}/role/list" class="btn bg-olive">返回列表</a>
                            <input type="submit" class="btn btn-primary J-submit" value="提交">
                        </div>
                    </form>
                </div>
                <!-- /.box-body -->
            </div>
        </section>

        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->
</div>
<!-- ./wrapper -->
<jsp:include page="../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->

<!-- select2 -->
<script src="${staticWebsite}/bower_components/select2/dist/js/select2.full.js"></script>
<!-- 验证模块 -->
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script>
    $(function () {
        $('.select2').select2();
    })
</script>
</body>
</html>
