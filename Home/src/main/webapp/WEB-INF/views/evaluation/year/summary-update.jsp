<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/8
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度考核-个人总结</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
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
                个人总结
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">个人总结</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box box-success">
                <div class="box-header with-border">
                    <h3 class="box-title">修改个人总结</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form action="${website}/summary/update/${summary.id}" method="post">
                        <%--<div class="form-group">--%>
                            <%--<label>文章标题：</label>--%>
                            <%--<input type="text" class="form-control require-text" value="2017年个人总结">--%>
                        <%--</div>--%>

                        <div class="form-group">
                            <label>年度总结年份：</label>
                            <input type="text" class="form-control" value="${summary.year}" disabled="disabled">
                        </div>

                        <div class="form-group">
                            <label>个人总结：</label>
                            <textarea id="editor1" name="content" rows="10" cols="80">
                      ${summary.content}
                </textarea>
                        </div>

                        <div class="box-footer">
                            <a href="${website}/summary/list" class="btn bg-olive">返回列表</a>
                            <input type="submit" class="btn btn-primary J-submit" value="提交"/>
                        </div>
                    </form>
                </div>
                <!-- /.box-body -->
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->

    <div class="control-sidebar-bg"></div>
</div>
<jsp:include page="../../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->
<!-- page script -->
<!-- CKeditor -->
<script src="${staticWebsite}/bower_components/ckeditor/ckeditor.js"></script>
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script>
    $(function () {
        $('#example1').DataTable();
        CKEDITOR.replace('editor1');
    })
</script>
</body>
</html>
