<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/10
  Time: 14:51
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
    <jsp:include page="../../common/link.jsp"/>

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <jsp:include page="../../common/header.jsp"/>
    <jsp:include page="../../common/sidebar.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                个人总结详情
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
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">${summary.year}年度总结</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <article>
                                ${summary.content}
                            </article>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <a href="${website}/check/year/user/${id}" class="btn bg-green">返回列表</a>
                            <c:if test="${summary.isJoin==1}">
                                <button type="button" class="btn  bg-red" data-toggle="modal" disabled="true">已打分</button>
                            </c:if>
                            <c:if test="${summary.isJoin==0}">
                                <button type="button" class="btn btn-primary mark" data-toggle="modal" data-target="#modal-default">打分</button>
                            </c:if>

                            您所打的分数：<span class="score-text">${summary.summaryScore}</span>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">打分</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="dataId" value="${summary.beCheckId}">
                    <input type="hidden" value="${summary.year}" class="year">
                    <div class="form-group">
                        <label>您的分数</label>
                        <input type="text" class="form-control score a-require-text" placeholder="请输入0-100内数字..." name="role">
                    </div>
                    <p class="text-red tip"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary J-ajax-submit">打分</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <jsp:include page="../../common/footer.jsp"/>
</div>
<jsp:include page="../../common/script.jsp"/>
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script src="${staticWebsite}/pages/exam/year/summary-detail.js"></script>
</body>
</html>
