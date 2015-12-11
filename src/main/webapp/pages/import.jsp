<%--
  Created by IntelliJ IDEA.
  User: 重书
  Date: 2015/10/20
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp"%>
<%@include file="templates/sidebar.jsp"%>
<link rel="stylesheet" href="/OCare/Assets/CSS/homepage.css">
<div class="ui container Entry">
    <div class="ui three column grid">
        <div class="column">
          <div class="ui fluid buttons">

              <div class="ui button">
              <input id="File1" runat="server" name="UpLoadFile" type="file" />
              </div>
              <button class="ui blue fluid button">职工信息导入</button>

          </div>

        </div>
    </div>
</div>

<script>
    document.getElementById('import_side').style.backgroundColor= "#ff7770"
    document.getElementById('import_side').style.color= "white"
</script>
<%@include file="templates/footer.jsp"%>