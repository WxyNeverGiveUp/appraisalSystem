<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${testPlan.testName}详情</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- select2 -->
    <link rel="stylesheet" href="${staticWebsite}/bower_components/select2/dist/css/select2.min.css">
    <!-- daterange picker -->
    <link rel="stylesheet" href="${staticWebsite}/bower_components/bootstrap-daterangepicker/daterangepicker.css">
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
                月考核工作计划详情
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">工作计划详情</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-success">
                        <div class="box-header">
                            <h3 class="box-title">${testPlan.testName}详情信息</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>工作计划内容</th>
                                    <th>考核时间</th>
                                    <%--<th>结束时间</th>--%>
                                    <th>权重</th>
                                    <th>预期工作成果</th>
                                    <th>工作完成情况</th>
                                    <th>领导评价</th>
                                    <th>考核得分</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${workDetailList}" var="detail" varStatus="status">
                                    <tr data-id="${detail.id}">
                                        <td>${status.index+1}</td>
                                        <td class="content-text">${detail.planContent}</td>
                                        <td class="time-text">${detail.startTime}</td>
                                        <td class="weight-text">${detail.weight}%</td>
                                        <td class="result-text">${detail.expectResult}</td>
                                        <td class="performance-text">${detail.workCompletion}</td>
                                        <td>${detail.completion}</td>
                                        <td>${detail.testScore}</td>
                                        <td>
                                            <button type="button" class="btn bg-olive change" data-toggle="modal" data-target="#update-list" data-num="${detail.id}">修改计划</button>
                                            <button type="button" class="btn bg-blue refer" data-toggle="modal" data-target="#performance" data-num="${detail.id}">填写工作完成情况</button>
                                            <%--<button type="button" class="btn bg-red delete" data-toggle="modal" data-num="${detail.id}">--%>
                                                <%--删除--%>
                                            <%--</button>--%>
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

            <p class="weight-error text-red none">总权重大于100%，请重新设置题目权重，否则测评结果将不准确</p>
            <a href="${website}/workplan/month/list" class="btn bg-olive">返回列表</a>
            <a href="${website}/workplan/month/to/add/${workPlan1.id}" class="btn bg-blue">添加计划</a>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../../common/footer.jsp"/>


    <div class="control-sidebar-bg"></div>
    <!-- 更改 -->
    <div class="modal fade" id="update-list">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改计划</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="dataId">
                    <div class="form-group">
                      <label>计划名称：</label>
                        <input type="text" class="form-control" value="${testPlan.testName}" disabled="disabled">
                    </div>

                    <div class="form-group">
                        <label>选择时间：</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" class="form-control pull-right time" id="reservation">
                        </div>
                    </div>

                    <div class="form-group">
                        <label>所占权重：</label>
                        <input type="text" class="form-control require-text weight" >
                        <input type="hidden" class="already-weight">
                    </div>

                    <div class="form-group">
                        <label>工作内容：</label>
                        <textarea id="editor1" rows="10" cols="80" class="content">

                        </textarea>
                    </div>
                    <div class="form-group">
                        <label>预期工作成果：</label>
                        <input type="text" class="form-control require-text expect-result">
                    </div>
                    <p class="text-red tip"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary J-ajax-submit">修改</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- 填写完成情况 -->
    <div class="modal fade" id="performance">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">填写工作完成情况</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="dataId2">
                    <div class="form-group">
                      <label>计划名称：</label>
                        <input type="hidden" value="${testPlan.id}" class="tid">
                        <input type="text" class="form-control" value="${testPlan.testName}" disabled="disabled">
                    </div>

                    <div class="form-group">
                        <label>工作完成情况：</label>
                        <input type="text" class="form-control performance-result" name="workCompletion">
                    </div>
                    <p class="text-red tip"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary J-ajax-submit2">修改</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<!-- select2 -->
<script src="${staticWebsite}/bower_components/select2/dist/js/select2.full.js"></script>

<!-- date-range-picker -->
<script src="${staticWebsite}/bower_components/moment/min/moment-with-locales.js"></script>
<script src="${staticWebsite}/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- ckeditor -->
<script src="${staticWebsite}/bower_components/ckeditor/ckeditor.js"></script>
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script src="${staticWebsite}/pages/evaluation/month/plan-detail.js"></script>
<!-- page script -->
<script>
    $(function () {
        function init() {
            $('#example1').DataTable();
            CKEDITOR.replace('editor1');
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
    })
</script>
</body>
</html>
