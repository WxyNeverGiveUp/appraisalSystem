<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/4
  Time: 17:44
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
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/link.html" -->
    <jsp:include page="../common/link.jsp"/>

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <jsp:include page="../common/header.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/header.html" -->
    <jsp:include page="../common/sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/sidebar.html" -->

    <div class="content-wrapper">
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
            <div class="box box-warning">
                <div class="box-header with-border">
                    <h3 class="box-title">增添权限</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form action="${website}/power/add" method="post">
                        <div class="form-group">
                            <label>权限等级：</label>
                            <select class="form-control require-option" name="power">
                                <option value="-1">请选择</option>
                                <option value="1">管理员</option>
                                <option value="2">超级管理员</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>备注信息：</label>
                            <textarea class="form-control require-text" name="detail" rows="3" placeholder="请输入..."></textarea>
                        </div>

                        <div class="box-footer">
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


<!-- page script -->
<!-- 验证模块 -->
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script>
    $(function () {
        $('#example1').DataTable();
    })
</script>
</body>
</html>
