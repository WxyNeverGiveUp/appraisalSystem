<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/11
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度考核-能力指标详情</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${staticWebsite}/plugins/iCheck/all.css">
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
                ${testPlan.testName}详情
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">绩效综合能力考核详情</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="none" id="id">${id}</div>
            <div class="row">
                <div class="col-md-12">
                    <form action="${website}/check/year/ability/check" method="post">
                        <div class="box box-success">
                            <div class="box-header">
                                <h3 class="box-title">绩效综合能力题目预览</h3>
                            </div>
                            <div class="box-body">
                                <ul class="timeline">
                                    <!-- timeline time label -->
                                    <li class="time-label">
                                        <span class="bg-green">
                                            考核开始
                                        </span>
                                    </li>
                                    <c:forEach items="${abilityPositionList}" var="abilityPosition" varStatus="status">
                                        <li>
                                            <i class="fa bg-blue">${status.index+1}</i>
                                            <div class="timeline-item">
                                                <h3 class="timeline-header">
                                                    <a href="#">【${abilityPosition
                                                            .targetTypeId}
                                                            <span class="weight">${abilityPosition.weight}</span>%】</a>
                                                        ${abilityPosition.targetId}
                                                </h3>
                                                <div class="timeline-body box-body">
                                                    <c:forEach items="${abilityOptionList}" var="option">
                                                        <c:if test="${abilityPosition.id == option.positionId}">
                                                            <div class="form-group">
                                                                <c:if test="${option.optionName == 1}">
                                                                    <label>
                                                                        <input type="radio" name="${status.index+1}" class="minimal answer" data-order="1">
                                                                        A.${option.optionContent}
                                                                    </label>
                                                                    <a class="btn bg-olive btn-xs">优(9.0分~10.0分)</a>
                                                                </c:if>
                                                            </div>
                                                            <div class="form-group">
                                                                <c:if test="${option.optionName == 2}">
                                                                    <label>
                                                                        <input type="radio" name="${status.index+1}" class="minimal answer" data-order="2">
                                                                        B.${option.optionContent}
                                                                    </label>
                                                                    <a class="btn btn-primary btn-xs">良(8.0分~9.0分)</a>
                                                                </c:if>
                                                            </div>
                                                            <div class="form-group">
                                                                <c:if test="${option.optionName == 3}">
                                                                    <label>
                                                                        <input type="radio" name="${status.index+1}" class="minimal answer" data-order="3">
                                                                        C.${option.optionContent}
                                                                    </label>
                                                                    <a class="btn bg-orange btn-xs">中(6.0分~8.0分)</a>
                                                                </c:if>

                                                            </div>
                                                            <div class="form-group">
                                                                <c:if test="${option.optionName == 4}">
                                                                    <label>
                                                                        <input type="radio" name="${status.index+1}" class="minimal answer" data-order="4">
                                                                        D.${option.optionContent}
                                                                    </label>
                                                                    <a class="btn bg-red btn-xs">差(0分~6.0分)</a>
                                                                </c:if>

                                                            </div>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                                <div class="timeline-footer">
                                                    <div class="form-group">
                                                        <label>请输入分数：</label>
                                                        <input type="text" class="form-control require-text score" placeholder="请填写分数...">
                                                        <p class="text-red score-tip"></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>

                                    <li class="time-label">
                                    <span class="bg-green">
                                        考核结束
                                    </span>
                                    </li>
                                    <!-- /.timeline-label -->
                                    <li>
                                        <i class="fa fa-clock-o bg-gray"></i>
                                    </li>
                                </ul>
                            </div>
                            <div class="box-footer">
                                <input type="hidden" name="score" class="total" value="">
                                <input type="hidden" name="beCheckId" value="${uid}">
                                <input type="hidden" name="testId" value="${testPlan.id}">
                                <input type="hidden" name="year" value="${testPlan.year}">
                                <p class="text-red tip"></p>
                                <a href="${website}/check/year/ability/user/${id}" class="btn bg-olive">返回列表</a>
                                <input type="submit" class="btn btn-primary J-submit" value="提交">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>

    <jsp:include page="../../common/footer.jsp"/>

</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>

<script src="${staticWebsite}/pages/common/verify.js"></script>
<script src="${staticWebsite}/pages/evaluation/year/ability-detail.js"></script>
<!-- page script -->
<script src="${staticWebsite}/plugins/iCheck/icheck.min.js"></script>


<script src="${staticWebsite}/pages/exam/year/exam-detail.js"></script>
<!-- page script -->
<script>
    $(function () {
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })
    })
</script>
</body>
</html>
