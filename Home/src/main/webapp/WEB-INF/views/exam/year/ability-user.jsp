<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>被考核用户列表</title>
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
                被考核用户列表
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">测评模块</a></li>
                <li class="active">${testPlan.testName}</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">我的考核计划列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>所属部门</th>
                                    <th>被考核用户名</th>
                                    <th>所属角色</th>
                                    <th>考核时间</th>
                                    <th>考核状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${joinTestList}" var="joinTest">
                                        <c:forEach items="${userList}" var="user"  varStatus="status">
                                            <c:if test="${joinTest.uid == user.id and user.id != sessionScope.uid}">
                                                <tr>
                                                <td>${status.index+1}</td>
                                                <td>${user.department}</td>
                                                <td>${user.username}</td>
                                                <td>${user.role}</td>
                                                <td>${testPlan.startTime}</td>
                                                <td class="status">
                                                    <c:forEach items="${abilityTestIsJoins}" var="abilityTest">
                                                    <c:if test="${abilityTest.isJoin == 1 and abilityTest.beCheckId == user.id and abilityTest.checkId==sessionScope.uid}">
                                                        已参与
                                                    </c:if>
                                                    </c:forEach>
                                                </td>
                                                <td>
                                                        <a href="${website}/check/year/ability/detail/${testPlan.id}&${joinTest.uid}" class="btn bg-green">进入考核</a>
                                                </td>
                                            </c:if>
                                            </tr>
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
</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->

<!-- CKeditor -->
<script src="${staticWebsite}/bower_components/ckeditor/ckeditor.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable();
        // 简单判断
        function test() {
            $('.status').each(function (i,o) {
                var text = $(this).text(),
                    status = text.indexOf('已参与');
                console.log(status);
                if(status != -1){
                    $(this).next().find('a').attr({
                        disabled:'disabled',
                        href:'javascript:;'
                    });
                    $(this).next().find('a').text('已考核');
                    $(this).next().find('a').removeClass('bg-green').addClass('bg-red');
                }
            });
        }
        test();
        // 点击就会触发
        $('body').click(function () {
            test();
        })
    })
</script>
</body>
</html>
