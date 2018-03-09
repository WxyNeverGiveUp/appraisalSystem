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
    <title>年度考核-绩效综合能力</title>
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
                绩效综合能力考核设置
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">绩效综合能力考核</li>
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
                                <thead>
                                <tr>
                                    <%--<th>序号</th>--%>
                                    <th>考核名称</th>
                                    <th>考核时间</th>
                                    <th>考核状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${testPlanList}" var="testPlan">
                                    <c:forEach items="${joinTestList}" var="jointest" varStatus="status">
                                        <c:if test="${jointest.testId==testPlan.id}">
                                            <c:if test="${testPlan.testTypeId ==1 ||testPlan.testTypeId==2}">
                                                <tr>
                                                    <%--<td>${status.index+1}</td>--%>
                                                    <td>${testPlan.testName}</td>
                                                    <td>${testPlan.startTime}</td>
                                                        <c:if test="${testPlan.isAvailable == 2}">
                                                            <td>考核开启</td>
                                                            <td>
                                                                <button type="button" class="btn bg-red" disabled="disabled">填写未开启</button>
                                                            </td>
                                                        </c:if>
                                                    <c:if test="${testPlan.isAvailable == 1}">
                                                        <td>填写开启</td>
                                                        <td>
                                                            <a href="${website}/performance/detail/${testPlan.id}" class="btn bg-blue">查看详情</a>
                                                        </td>
                                                    </c:if>
                                                    <c:if test="${testPlan.isAvailable == 0}">
                                                        <td>未开启</td>
                                                        <td>
                                                            <button type="button" class="btn bg-red" disabled="disabled">暂未开放</button>
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
            <!-- <a href="${website}/performance/add" class="btn bg-olive">新增</a> -->

            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../../common/footer.jsp"/>

    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <form class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">打分</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>您的分数</label>
                        <input type="text" class="form-control" placeholder="请输入0-100内数字..." required="required" name="role">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <input type="submit" class="btn btn-primary" value="打分">
                </div>
            </form>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<script>
    $(function () {
        $('#example1').DataTable();
    })
</script>
</body>
</html>
