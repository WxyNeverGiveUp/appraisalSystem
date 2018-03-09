<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/5
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>考核计划管理</title>
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

    <div class="content-wrapper">
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
            <div class="box box-success">
                <div class="box-header with-border">
                    <h3 class="box-title">增添新考核计划</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form action="${website}/testplan/add" method="post" class="col-xs-8">
                        <div class="form-group">
                            <label>考核计划名称：</label>
                            <input type="text" class="form-control require-text" placeholder="请输入..." name="testName">
                        </div>

                        <div class="form-group">
                            <label>考核计划所属年份：</label>
                            <select  class="form-control month-option" name="year">
                                <option value="-1">请选择</option>
                                <option value="2016">2016</option>
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019">2019</option>
                                <option value="2020">2020</option>
                                <option value="2021">2021</option>
                                <option value="2022">2022</option>
                                <option value="2023">2023</option>
                                <option value="2024">2024</option>
                                <option value="2025">2025</option>
                                <option value="2026">2026</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>考核性质</label>
                            <select class="form-control require-option type" name="testTypeId">
                                <option value="-1">请选择</option>
                                <c:forEach items="${testTypeList}" var="testType">
                                    <option value="${testType.id}">${testType.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group month none">
                            <label>考核月份</label>
                            <select class="form-control month-option" name="month">
                                <option value="-1">请选择</option>
                                <option value="1">一月</option>
                                <option value="2">二月</option>
                                <option value="3">三月</option>
                                <option value="4">四月</option>
                                <option value="5">五月</option>
                                <option value="6">六月</option>
                                <option value="7">七月</option>
                                <option value="8">八月</option>
                                <option value="9">九月</option>
                                <option value="10">十月</option>
                                <option value="11">十一月</option>
                                <option value="12">十二月</option>
                            </select>
                        </div>
                        <div class="form-group quarter none">
                            <label>考核季度</label>
                            <select class="form-control quarter-option" name="quarter">
                                <option value="-1">请选择</option>
                                <option value="1">第一季度</option>
                                <option value="2">第二季度</option>
                                <option value="3">第三季度</option>
                                <option value="4">第四季度</option>
                            </select>
                        </div>
                        <div class="form-group">
                          <label>选择时间:</label>
                          <div class="input-group">
                            <div class="input-group-addon">
                              <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" class="form-control pull-right" id="reservation" name="startTime">
                          </div>
                        </div>

                        <div class="box-footer">
                            <input type="submit" class="btn btn-primary J-submit" value="提交">
                        </div>
                    </form>
                </div>
                <!-- /.box-body -->
            </div>
        </section>
    </div>
    <jsp:include page="../common/footer.jsp"/>

    <div class="control-sidebar-bg"></div>
</div>
<jsp:include page="../common/script.jsp"/>
<!-- date-range-picker -->
<script src="${staticWebsite}/bower_components/moment/min/moment-with-locales.js"></script>
<script src="${staticWebsite}/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- select2 -->
<script src="${staticWebsite}/bower_components/select2/dist/js/select2.full.js"></script>
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script src="${staticWebsite}/pages/evaluation/plan-management-add.js"></script>
<!-- page script -->
<script>
    function init() {
      $('.select2').select2();
            //定义locale汉化插件
            var locale = {
                "format": 'YYYY-MM-DD',
                "separator": " —— ",
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
