<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/5
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度考核成绩查询</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <jsp:include page="../../common/header.jsp"/>
    <jsp:include page="../../common/sidebar.jsp"/>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                年度度考核
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">成绩查询</a></li>
                <li class="active">年度度考核</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-default">
                        <div class="box-header">
                            <h3 class="box-title">......考核</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>考核计划名称</th>
                                    <th>被考核人姓名</th>
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
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>章</td>
                                    <td>13837200544</td>
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
                                </tr>
                                <tr>
                                    <td>章</td>
                                    <td>1384</td>
                                    <th>1分</th>
                                    <th>2分</th>
                                    <th>3分</th>
                                    <th>4分</th>
                                    <th>5分</th>
                                    <th>6分</th>
                                    <th>7分</th>
                                    <th>8分</th>
                                    <th>9分</th>
                                    <th>10分</th>
                                    <th>11分</th>
                                    <th>12分</th>
                                </tr>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>考核计划名称</th>
                                    <th>被考核人姓名</th>
                                    <th>1分</th>
                                    <th>2分</th>
                                    <th>3分</th>
                                    <th>4分</th>
                                    <th>5分</th>
                                    <th>6分</th>
                                    <th>7分</th>
                                    <th>8分</th>
                                    <th>9分</th>
                                    <th>10分</th>
                                    <th>11分</th>
                                    <th>12分</th>
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
