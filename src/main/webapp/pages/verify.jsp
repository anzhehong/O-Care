<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/8/3
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp"%>
<%@include file="templates/sidebar.jsp"%>

<html>
<head>
  <link rel="stylesheet" href="/OCare/Assets/CSS/verify.css">
    <title>监护人申请审核</title>
</head>
<body>
<div class="content">
  <div class="ui teal ribbon label">申请审核:</div>
  <div class="ui divided selection list">
    <a class="item">
      <div class="ui red horizontal label">申请ID:</div>
      bulabula
    </a>
    <a class="item">
      <div class="ui horizontal label">老人ID:</div>
      bulabula
    </a>
    <a class="item">
      <div class="ui horizontal label">申请人ID:</div>
      bulabula
    </a>
  </div>
  <img class="ui rounded huge image" src="/OCare/Assets/Images/old-couple.jpg" pagespeed_url_hash="481064615" onload="pagespeed.CriticalImages.checkImageForCriticality(this);">
  <div class="elderID-relativeID">
    <a class="ui red label">
      <i class="icon remove circle"></i>拒绝
    </a>
    <a class="ui teal label">
      <i class="icon add sign"></i>通过
    </a>
    <a class="ui label">
      <i class="icon adjust"></i>暂定
    </a>
  </div>

</div>
</body>
</html>

<%@include file="templates/footer.jsp"%>