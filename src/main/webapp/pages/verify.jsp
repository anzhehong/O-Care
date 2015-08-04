<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/8/3
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
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
      <div class="ui red horizontal label">申请ID: </div> <c:out value="${request.id}"/>
    </a>
    <a class="item">
      <div class="ui horizontal label">老人ID:&nbsp;</div><c:out value="${request.elder_id}"/>
    </a>
    <a class="item">
      <div class="ui horizontal label">申请人ID:</div><c:out value="${request.relative_id}"/>
    </a>
    <a class="item">
      <div class="ui horizontal label">当前状态:</div>
      <c:if test="${request.type==1||request.type==2}">
        已通过
      </c:if>
      <c:if test="${request.type==3}">
        待审核
      </c:if>
      <c:if test="${request.type==4}">
        已拒绝
      </c:if>
    </a>
  </div>
  <%--<c:out value="${request.togetherImg}"/>  数据库里没有图片 只能显示以下样图--%>
  <img class="ui rounded huge image" src="/OCare/Assets/Images/together -image.jpg" pagespeed_url_hash="481064615" onload="pagespeed.CriticalImages.checkImageForCriticality(this);">
  <div class="elderID-relativeID">
    <a class="ui huge red label" id="reject">
      <i class="icon remove circle"></i>拒绝
    </a>
    <a class="ui huge label" href="/OCare/monitor/list" id="undesided" style="margin: 30px">
      <i class="icon adjust"></i>暂定
    </a>
    <a class="ui huge teal label" id="agree" style="margin: 30px">
      <i class="icon add sign"></i>通过
    </a>
  </div>
</div>
</body>
</html>

<%@include file="templates/footer.jsp"%>