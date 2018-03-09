<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/2
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>修改密码</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${staticWebsite}/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${staticWebsite}/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${staticWebsite}/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${staticWebsite}/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="${staticWebsite}/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="javascript:;">绩效管理系统密码管理</a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">请输入原密码</p>

        <form action="${website}/upwd" method="post">
            <div class="form-group has-feedback">
                <input type="text" name="password" class="form-control" placeholder="原密码">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <p class="login-box-msg">请在下面输入新密码</p>
            <div class="form-group has-feedback">
                <input type="password" class="form-control require-text psw1" placeholder="新密码" name="newPassword">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control require-text psw2" placeholder="重复新密码">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                <p class="psw-tip text-red"></p>
                <p class="tip text-red"></p>
            </div>
            <div class="row">
                <div class="col-xs-8">
                </div>
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat J-submit">修改</button>
                </div>
                <!-- /.col -->
            </div>
        </form>
        <p class="text-red">${msg}</p>
        <a href="${website}/tologin" class="text-center">已经有账号?这里登录!</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 3 -->
<script src="${staticWebsite}/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${staticWebsite}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${staticWebsite}/pages/common/verify.js"></script>
<script src="${staticWebsite}/pages/update-password.js"></script>
</body>
</html>

