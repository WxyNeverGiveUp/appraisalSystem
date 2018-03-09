<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/5
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>季度考核-工作计划结果报表</title>
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
                季度考核-工作计划结果报表
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">成绩查询</a></li>
                <li class="active">季度考核-工作计划结果报表</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- /.box-header -->

            <c:if test="${sessionScope.power<=6}">
                <div class="box box-default">
                    <div class="box-header with-border">
                        <h3 class="box-title">测评结果导出</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <form action="${website}/query/quarter/query" method="post">
                            <div class="form-group">
                                <label>所在部门：</label>
                                <select class="form-control" name="departmentId">
                                    <option value="-1" selected = "selected">请选择</option>
                                    <c:forEach items="${departmentList}" var="department">
                                        <option value="${department.id}">${department.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>职位：</label>
                                <select class="form-control" name="roleId">
                                    <option value="-1" selected = "selected">请选择</option>
                                    <c:forEach items="${roleList}" var="role" >
                                        <option value="${role.id}">${role.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>年份：</label>
                                <input type="text" name="year" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>姓名：</label>
                                <input type="text" name="username" class="form-control">
                            </div>
                            <div class="box-footer">
                                <input type="submit" class="btn btn-primary" value="查询">
                                    <%--<a href="#" class="btn bg-green export-all">全部导出</a>--%>
                            </div>
                        </form>
                    </div>
                    <!-- /.box-body -->
                </div>
            </c:if>
            <c:if test="${list.size()!=0}">
                <c:if test="${sessionScope.power<=6}">
                    <div class="box-footer">
                            <%--<input type="submit" class="btn btn-primary" value="查询">--%>
                        <a href="${website}/export/quarter/query" class="btn bg-green export-all">导出查询结果</a>
                    </div>
                </c:if>
                <c:if test="${sessionScope.power==7||sessionScope.power ==8}">
                    <div class="box-footer">
                            <%--<input type="submit" class="btn btn-primary" value="查询">--%>
                        <a href="${website}/export/quarter/query/did/${sessionScope.did}" class="btn bg-green export-all">全部导出</a>
                    </div>
                </c:if>
                <c:if test="${sessionScope.power==9}">
                    <div class="box-footer">
                            <%--<input type="submit" class="btn btn-primary" value="查询">--%>
                        <a href="${website}/export/quarter/query/uid/${sessionScope.uid}" class="btn bg-green export-all">全部导出</a>
                    </div>
                </c:if>
            </c:if>


            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-default">
                        <div class="box-header">
                            <h3 class="box-title">全部考核列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>考核计划名称</th>
                                    <th>部门</th>
                                    <th>姓名</th>
                                    <th>职位</th>
                                    <th>一季度</th>
                                    <th>二季度</th>
                                    <th>三季度</th>
                                    <th>四季度</th>
                                    <th>总结得分</th>
                                    <th>能力指标得分</th>
                                    <th>综合得分</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="list" varStatus="status">
                                        <tr>
                                            <td>${status.index+1}</td>
                                            <td>${list.year}年度成绩</td>
                                            <td>${list.department}</td>
                                            <td>${list.username}</td>
                                            <td>${list.role}</td>
                                            <td>${list.queater1}</td>
                                            <td>${list.queater2}</td>
                                            <td>${list.queater3}</td>
                                            <td>${list.queater4}</td>
                                            <td>${list.summaryScore}</td>
                                            <td>${list.abilityScore}</td>
                                            <td>${list.yearScore}</td>
                                        </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>序号</th>
                                    <th>考核计划名称</th>
                                    <th>部门</th>
                                    <th>姓名</th>
                                    <th>职位</th>
                                    <th>一季度</th>
                                    <th>二季度</th>
                                    <th>三季度</th>
                                    <th>四季度</th>
                                    <th>总结得分</th>
                                    <th>能力指标得分</th>
                                    <th>综合得分</th>
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
    <jsp:include page="../../common/footer.jsp"/>

    <!-- <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">导出信息</h4>
                </div>
                <div class="modal-body">
                    <p>是否确认导出年度季度信息？</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary export">导出</button>
                </div>
            </div>
        </div>
    </div> -->
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
