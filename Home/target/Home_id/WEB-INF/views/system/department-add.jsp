<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/4
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>部门管理</title>
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
                部门管理
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">系统管理</a></li>
                <li class="active">部门管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box box-warning">
                <div class="box-header with-border">
                    <h3 class="box-title">增添新部门</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form action="${website}/department/add" method="post">

                        <div class="form-group">
                            <label>部门名称：</label>
                            <input type="text" class="form-control require-text"  placeholder="请输入..." name="name">
                        </div>

                        <div class="box-footer">
                            <a href="${website}/department/list" class="btn bg-olive">返回列表</a>
                            <input type="submit" class="btn btn-primary J-submit" value="提交">
                        </div>
                    </form>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.row -->
        </section>

        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->

    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<jsp:include page="../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->
<script type="text/javascript" src="${staticWebsite}/pages/common/verify.js"></script>
</body>
</html>
