<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/10/15
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp"%>
<%@include file="templates/sidebar.jsp"%>

<div class="ui ordered steps">
  <div class="active step">
    <div class="content">
      <div class="title">填写信息</div>
    </div>
  </div>
  <div class="disabled step">
    <div class="content">
      <div class="title">申请审核</div>
    </div>
  </div>
  <div class="disabled step">
    <div class="content">
      <div class="title">注册成功</div>
    </div>
  </div>
</div>

<table>
  <tr>
    <td>机构名称：</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
      <td>组织结构代码证号：</td>
      <td></td>
      <td></td>
      <td></td>
  </tr>
  <tr>
    <td>法人姓名：</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
  <td>法人身份证号：</td>
  <td></td>
  <td></td>
  <td></td>
  </tr>
  <tr>
    <td>法人手机号：</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
  <td>密码</td>
  <td></td>
  <td></td>
  <td></td>
  </tr>
  <tr>
    <td>再次输入密码</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
</table>
<%@include file="templates/footer.jsp"%>