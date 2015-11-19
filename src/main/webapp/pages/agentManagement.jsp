<%--
  Created by IntelliJ IDEA.
  User: douyutong
  Date: 2015/10/26
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@include file="templates/header.jsp"%>
<link rel="stylesheet" href="/OCare/Assets/CSS/agentManagement.css">
<div>
  <div>
    <div class="mainbox">
        <h2>请选择您要进入的机构</h2>

        <table class="ui stripe table">
          <thead>
            <th>机构ID</th><th>机构名称</th><th>机构地址</th>
          </thead>
          <tbody>
            <tr onclick="enterHomepage(accountType)">
              <td>101200211</td><td>黄渡敬老院</td><td>安亭镇&nbsp;&nbsp;&nbsp;新黄路24号 </td>
            </tr>
            <tr>
              <td>101123123</td><td>方泰敬老院</td><td>安亭镇&nbsp;&nbsp;&nbsp;方中路160号</td>
            </tr>
            <tr>
              <td>101123123</td><td>方泰敬老院</td><td>安亭镇&nbsp;&nbsp;&nbsp;方中路160号</td>
            </tr>
          <!--在此加入动态数据-->
          </tbody>
        </table>

        <a href="/OCare/pages/applyCompany.jsp" style="float:right;margin-top: 20px">
          <button class="ui inverted teal button"><i class="add icon"></i>注册机构</button>
        </a>
      </div>

    </div>
  <div>
    <!--  <button> -->
  </div>
</div>
<div class="footer" style="position: absolute">
  @ copyright Tongji University
</div>
<script>
  function enterHomepage(AccountType){
    //undefined
  }
</script>

</body>
</html>