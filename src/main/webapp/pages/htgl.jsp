<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/10/31
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp"%>
<%@include file="templates/sidebar.jsp"%>

<link rel="stylesheet" href="/OCare/Assets/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="/OCare/Assets/bootstrap-table/src/bootstrap-table.css">
<link rel="stylesheet" href="/OCare/Assets/examples.css">

<link rel="stylesheet" href="/OCare/Assets/CSS/homepage1.css">


<div class="container main_content">

    <div class="monitor" id="container">
  <table id="table"
         data-toggle="table"
         data-pagination="true"
         data-search="true"
         data-advanced-search="true"
         data-id-table="advancedTable"
         data-url="/OCare/app/contract/listAllEldersContractAndMonitorsYu">
    <thead>
    <tr>
      <th data-field="contract_id" data-sortable="true">合同编号</th>
      <th data-field="old_name" data-sortable="true">参养老年人</th>
      <th data-field="old_id" data-sortable="true">参养老年人身份证号</th>
      <th data-field="keeper1_name" data-sortable="true">监护人1姓名</th>
      <th data-field="keeper1_id" data-sortable="true">监护人1身份证号</th>
      <th data-field="keeper2_name" data-sortable="true">监护人2姓名</th>
      <th data-field="keeper2_id" data-sortable="true">监护人2身份证号</th>
      <th data-field="execution" data-sortable="true">合同执行情况</th>
      <th data-field="date" data-sortable="true">合同起止日期</th>
      <th data-field="service" data-sortable="true">合同约定服务</th>
      <th data-field="payment" data-sortable="true">合同付费情况</th>

    </tr>
    </thead>
  </table>
    </div>
</div>

<%--<script>--%>
<%--$.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN']);--%>
<%--</script>--%>
<script src="/OCare/Assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/OCare/Assets/bootstrap-table/src/bootstrap-table.js"></script>
<script src="/OCare/Assets/bootstrap-table/src/extensions/toolbar/bootstrap-table-toolbar.js"></script>
<script src="/OCare/ga.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/locale/bootstrap-table-zh-CN.min.js"></script>

<%@include file="templates/footer.jsp"%>