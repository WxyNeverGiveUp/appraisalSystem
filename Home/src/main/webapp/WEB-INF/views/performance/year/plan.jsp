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
            <div class="box box-default">
              <div class="box-header with-border">
                <h3 class="box-title">测评结果导出</h3>
              </div>
              <!-- /.box-header -->
              <div class="box-body">
                <form role="form">
                  
                    <div class="form-group">
                      <label>所在部门：</label>
                      <select class="form-control">
                        <option>请选择</option>
                        <option>产品部</option>
                        <option>技术部</option>
                      </select>
                    </div>

                    <div class="form-group">
                      <label>考核类型：</label>
                      <select class="form-control">
                        <option>请选择</option>
                        <option>月/季度</option>
                        <option>年度</option>
                      </select>
                    </div>

                    <div class="form-group">
                      <label>月份：</label>
                      <select class="form-control">
                        <option>请选择</option>
                        <option>1月</option>
                        <option>2月</option>
                      </select>
                    </div>

                    <div class="form-group">
                      <label>年份：</label>
                      <select class="form-control">
                        <option>请选择</option>
                        <option>2017年</option>
                        <option>2018年</option>
                      </select>
                    </div>

                    <div class="form-group">
                      <label>考核方式：</label>
                      <select class="form-control">
                        <option>请选择</option>
                        <option>绩效综合能力考核</option>
                        <option>能力指标考核</option>
                      </select>
                    </div>
                    
                    <div class="box-footer">
                        <input type="submit" class="btn btn-primary" value="查询">
                    </div>
                </form>
              </div>
              <!-- /.box-body -->
            </div>
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
                                    <th>所在部门</th>
                                    <th>职位</th>
                                    <th>副总经理考评结果报表</th>
                                    <th>综合绩效考评结果报表</th>
                                    <th>能力指标考评结果报表</th>
                                    <th>综合得分</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>章</td>
                                    <td>13837200544</td>
                                    <td>产品</td>
                                    <td>经理</td>
                                    <td>77</td>
                                    <td>77</td>
                                    <td>77</td>
                                    <td>77</td>
                                    <td>
                                    	<a href="plan-detail.html" class="btn bg-blue">查看综合绩效考评详情</a>
                                    	<button type="button" class="btn bg-green">打印此报表</button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>章</td>
                                    <td>1384</td>
                                    <td>产品</td>
                                    <td>经理</td>
                                    <td>17</td>
                                    <td>17</td>
                                    <td>17</td>
                                    <td>17</td>
                                    <td>
                                    	<a href="plan-detail.html" class="btn bg-blue">查看综合绩效考评详情</a>
                                    	<button type="button" class="btn bg-green">打印此报表</button>
                                    </td>
                                </tr>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>考核计划名称</th>
                                    <th>被考核人姓名</th>
                                    <th>所在部门</th>
                                    <th>职位</th>
                                    <th>副总经理考评结果报表</th>
                                    <th>综合绩效考评结果报表</th>
                                    <th>能力指标考评结果报表</th>
                                    <th>综合得分</th>
                                    <th>操作</th>
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
