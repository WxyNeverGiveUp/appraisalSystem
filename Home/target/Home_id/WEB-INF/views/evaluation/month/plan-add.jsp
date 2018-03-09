<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="box box-success">
                <div class="box-header with-border">
                    <h3 class="box-title">增添新工作计划</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form action="${website}/workplan/month/add" method="post">
                        <input type="hidden" class="form-control require-text" name="wid" value="${workPlan.id}" />
                        <div class="form-group">
                            <label>所属考核计划：</label>
                            <input type="text" class="form-control require-text" value="${testPlan.testName}" disabled>
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

                        <div class="form-group">
                            <label>所占权重：</label>
                            <input type="text" class="form-control require-text weight"  name="weight" placeholder="请输入1-100内的整数">
                            <input type="hidden" class="already-weight" value="${weightSum}">
                        </div>

                        <div class="form-group">
                            <label>工作内容：</label>
                            <textarea id="editor1" name="planContent" rows="10" cols="80">
                            </textarea>
                        </div>
                        <div class="form-group">
                            <label>预期工作成果：</label>
                            <input type="text" class="form-control require-text"  name="excpetResult">
                        </div>
                        <input type="hidden" name="tid"  value="${testPlan.id}"/>
                        <div class="box-footer">
                            <p class="tip text-red"></p>
                            <input type="submit" class="btn btn-primary J-submit" value="提交">
                        </div>
                        <h3>${error}</h3>
                    </form>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->

    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<!-- select2 -->
<script src="${staticWebsite}/bower_components/select2/dist/js/select2.full.js"></script>

<!-- date-range-picker -->
<script src="${staticWebsite}/bower_components/moment/min/moment-with-locales.js"></script>
<script src="${staticWebsite}/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="${staticWebsite}/bower_components/ckeditor/ckeditor.js"></script>
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script src="${staticWebsite}/pages/evaluation/month/plan-add.js"></script>
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
