<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/4
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>人员管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <jsp:include page="../common/link.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/link.html" -->

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <jsp:include page="../common/header.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/header.html" -->
    <jsp:include page="../common/sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/sidebar.html" -->

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                单位人员管理
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">系统管理</a></li>
                <li class="active">人员管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-warning">
                        <div class="box-header">
                            <h3 class="box-title">人员管理列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>用户名</th>
                                    <th>员工姓名</th>
                                    <th>所属部门</th>
                                    <th>职位</th>
                                    <th>联系方式</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userList}" var="user" varStatus="status">
                                    <tr data-id="${user.id}">
                                        <c:if test="${user.power==1}">
                                            <td>${status.index+1}</td>
                                            <td class="username-text">${user.username}</td>
                                            <td class="realname-text">${user.realName}</td>
                                            <td class="department-text">${user.department}</td>
                                            <td class="position-text">${user.role}</td>
                                            <td class="phone-text">${user.phone}</td>
                                            <td>
                                               <button type="button" class="btn bg-red" disabled="disabled">无法操作</button>
                                            </td>
                                        </c:if>
                                        <c:if test="${user.power>1}">
                                            <td>${status.index+1}</td>
                                            <td class="username-text">${user.username}</td>
                                            <td class="realname-text">${user.realName}</td>
                                            <td class="department-text">${user.department}</td>
                                            <td class="position-text">${user.role}</td>
                                            <td class="phone-text">${user.phone}</td>
                                            <td>
                                                <c:if test="${sessionScope.power>=1 and user.power >=1}">
                                                    <button type="button" class="btn bg-olive change" data-toggle="modal" data-target="#modal-default" data-num="${user.id}">修改</button>
                                                    <button type="button" class="btn bg-blue init" data-num="${user.id}">初始密码</button>
                                                    <button type="button" class="btn bg-red delete" data-num="${user.id}">删除</button>
                                                </c:if>

                                            </td>
                                        </c:if>
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
            <button type="button" class="btn bg-blue" data-toggle="modal" data-target="#add-person">添加人员</button>
            <a href="${website}/export/user" class="btn bg-green export-all">全部导出</a>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../common/footer.jsp"/>
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改人员信息</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="dataId">
                    <div class="form-group">
                        <label>用户名：</label>
                        <input type="text" name="username" value="${user.username}" class="form-control a-require-option username"/>
                    </div>
                    <div class="form-group">
                        <label>真实姓名：</label>
                        <input type="text" name="realName" value="${user.realName}" class="form-control a-require-option realname"/>
                    </div>
                    <div class="form-group">
                        <label>所属部门：</label>
                        <select class="form-control a-require-option department" name="did">

                            <option value="-1">请选择</option>
                            <c:forEach items="${departmentList}" var="department">
                                <option value="${department.id}" selected="">${department.name}</option>
                            </c:forEach>

                        </select>
                    </div>
                    <div class="form-group">
                        <label>职位：</label>
                        <select class="form-control a-require-option position" name="rid">
                            <option value="-1">请选择</option>
                            <c:forEach items="${roleList}" var="role">
                                <c:if test="${role.id !=1}">
                                    <option value="${role.id}" selected="" >${role.name}</option>
                                </c:if>
                                <%--<option value="${role.id}" selected="">${role.name}</option>--%>
                            </c:forEach>

                        </select>
                    </div>
                    <div class="form-group">
                        <label>手机号：</label>
                        <input type="text" name="phone" value="${user.phone}" class="form-control a-require-option phone"/>
                    </div>
                    <p class="text-red tip"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <a href="javascript:;" class="btn btn-primary J-ajax-submit">修改</a>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <div class="modal fade" id="add-person">
        <form action="${website}/user/add" method="post">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">新增人员</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group has-feedback">
                            <label>基本信息：</label>
                            <input type="text" class="form-control require-text" name="username" placeholder="用户名">
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="text" class="form-control require-text" name="realName" placeholder="真实姓名">
                            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                        </div>

                        <div class="form-group has-feedback">
                            <label>部门：</label>
                            <select class="form-control require-option" name="did">
                                <option>请选择</option>
                                <c:forEach items="${departmentList}" var="department" varStatus="status">
                                    <option value="${department.id}">${department.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>职位：</label>
                            <select class="form-control a-require-option position" name="rid">
                                <option value="-1">请选择</option>
                                <c:forEach items="${roleList}" var="role">
                                    <c:if test="${role.id !=1}">
                                        <option value="${role.id}" selected="" >${role.name}</option>
                                    </c:if>
                                    <%--<option value="${role.id}" selected="">${role.name}</option>--%>
                                </c:forEach>

                            </select>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="text" class="form-control require-text" name="phone" placeholder="手机号码">
                            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="hidden" class="form-control require-text psw1" name="password" placeholder="密码" value="123456">
                        </div>
                        <p>提示：默认密码为123456</p>
                        <p class="text-red tip"></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">添加</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
        </form>
    </div>
</div>
<!-- ./wrapper -->
<jsp:include page="../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->
<!-- page script -->
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script src="${staticWebsite}/pages/system/personnel-list.js"></script>
<script>
    $(function () {
        $('#example1').DataTable();
    })
</script>
</body>
</html>
