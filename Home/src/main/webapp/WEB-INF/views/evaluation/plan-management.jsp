<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>考核计划管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- select2 -->
    <link rel="stylesheet" href="${staticWebsite}/bower_components/select2/dist/css/select2.min.css">
    <!-- daterange picker -->
    <link rel="stylesheet" href="${staticWebsite}/bower_components/bootstrap-daterangepicker/daterangepicker.css">
    <jsp:include page="../common/link.jsp"/>

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <jsp:include page="../common/header.jsp"/>
    <jsp:include page="../common/sidebar.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                考核计划管理
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">考核计划管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-success">
                        <div class="box-header">
                            <h3 class="box-title">考核计划</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>考核计划名称</th>
                                    <th>考核性质</th>
                                    <th>考核时间</th>
                                    <th>是否开启</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${testPlanList}" var="testPlan" varStatus="status">
                                    <tr data-id="${testPlan.id}">
                                        <td>${status.index+1}</td>
                                        <td class="name-text">${testPlan.testName}</td>
                                        <td class="nature-text">
                                        <c:forEach items="${testTypeList}" var="testType">
                                            <c:if test="${testPlan.testTypeId == testType.id}">
                                                ${testType.name}
                                            </c:if>
                                        </c:forEach>
                                        </td>
                                        <td class="time-start-text">${testPlan.startTime}</td>
                                        <c:if test="${testPlan.isAvailable==2}">
                                            <td class="status-text">考核开启</td>
                                        </c:if>
                                        <c:if test="${testPlan.isAvailable==1}">
                                            <td class="status-text">填写开启</td>
                                        </c:if>
                                        <c:if test="${testPlan.isAvailable==0}">
                                            <td class="status-text">未开启</td>
                                        </c:if>
                                        <td>
                                            <button type="button" class="btn bg-olive change" data-toggle="modal" data-target="#modal-default" data-num="${testPlan.id}">修改计划</button>
                                            <a class="btn bg-blue" href="${website}/testplan/toallot/${testPlan.id}">分配考核人员</a>
                                            <button class="btn btn-warning status" data-num="${testPlan.id}">改变状态</button>
                                            <button type="button" class="btn bg-red delete" data-num="${testPlan.id}">删除</button>
                                        </td>
                                    </tr>
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
            <a href="${website}/testplan/toadd" class="btn bg-olive">添加</a>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/header.html" -->

    <div class="control-sidebar-bg"></div>
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改计划</h4>
                </div>
                <div class="modal-body">
                    <!-- 获取隐藏的点击按钮的次序 -->
                    <input type="hidden" id="dataId">
                    <div class="form-group">
                        <label>考核计划名称：</label>
                        <input type="text" class="form-control name a-require-text" placeholder="请输入...">
                    </div>
                    <div class="form-group">
                        <label>考核计划所属年份：</label>
                        <input type="text" class="form-control year a-require-text" placeholder="请输入...">
                    </div>

                    <div class="form-group">
                        <label>考核性质：</label>
                        <select class="form-control nature a-require-option" name="testTypeId" disabled="true">
                            <option value="-1">请选择</option>
                            <c:forEach items="${testTypeList}" var="testType" varStatus="status">
                                <option selected = "" value="${testType.id}">${testType.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                      <label>选择时间：</label>
                      <div class="input-group">
                        <div class="input-group-addon">
                          <i class="fa fa-calendar"></i>
                        </div>
                        <input type="text" class="form-control pull-right" id="reservation" name="startTime">
                      </div>
                    </div>

                    <p class="text-red tip"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary J-ajax-submit">保存修改</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</div>
<!-- ./wrapper -->
<jsp:include page="../common/script.jsp"/>
<!-- select2 -->
<script src="${staticWebsite}/bower_components/select2/dist/js/select2.full.js"></script>

<!-- date-range-picker -->
<script src="${staticWebsite}/bower_components/moment/min/moment-with-locales.js"></script>
<script src="${staticWebsite}/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script src="${staticWebsite}/pages/evaluation/plan-management.js"></script>
<!-- page script -->
<script>
    function init() {
      $('#example1').DataTable();
      $('.select2').select2();
            //定义locale汉化插件
            var locale = {
                "format": 'YYYY-MM-DD',
                "separator": " 到 ",
                "applyLabel": "确定",
                "cancelLabel": "取消",
                "fromLabel": "起始时间",
                "toLabel": "结束时间'",
                "customRangeLabel": "自定义",
                "weekLabel": "W",
                "daysOfWeek": ["日", "一", "二", "三", "四", "五", "六"],
                "monthNames": ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                "firstDay": 1
            };
            //初始化显示当前时间
            $('#reservation span').html(moment().subtract('hours', 1).format('YYYY-MM-DD') + ' - ' + moment().format('YYYY-MM-DD'));
            //日期控件初始化
            $('#reservation').daterangepicker(
                {
                    'locale': locale,
                    //汉化按钮部分
                    startDate: moment().subtract(29, 'days'),
                    endDate: moment()
                },
                function (start, end) {
                    $('#daterange-btn span').html(start.format('YYYY-MM-DD') + ' - ' + end.format('YYYY-MM-DD'));
                }
           );
    };
        $(document).ready(function() {
            init(); 
        });
</script>
</body>
</html>
