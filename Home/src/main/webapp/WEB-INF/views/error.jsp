<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>操作错误页面</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <jsp:include page="common/link.jsp" />
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">

  <jsp:include page="common/header.jsp" />

  <jsp:include page="common/sidebar.jsp" />

  <div class="content-wrapper">

    <section class="content">
      <div class="error-page">

        <div class="error-content">
          <h3><i class="fa fa-warning text-yellow"></i> 对不起.您的操作出现错误</h3>

            我们找不到您要找的那一页。
            您可以返回 <button type="button" class="btn bg-green" onclick="window.history.back(-1);">上一步</button>
            <br>
            或在导航栏重新选择栏目
        </div>
        <!-- /.error-content -->
      </div>
      <!-- /.error-page -->
    </section>
    <!-- /.content -->
  </div>
	<jsp:include page="common/footer.jsp" />


</div>
	<jsp:include page="common/script.jsp" />
</body>
</html>
