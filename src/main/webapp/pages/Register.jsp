<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/10/15
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@include file="templates/header.jsp"%>

<div style="width:1250px;margin:30px 250px">
  <div class="ui ordered steps" style="margin: 10px 300px">
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

  <div id="context1" style="width:1000px">
    <div class="ui secondary menu">
      <a class="item" data-tab="first">机构注册</a>
      <a class="item active" data-tab="second">个人注册</a>
    </div>

    <div class="ui tab segment active" data-tab="second">
      <div class="ui top attached tabular menu">
        <a class="item" data-tab="second/a">监护人</a>
        <a class="item" data-tab="second/b">志愿者</a>
      </div>
      <div class="ui bottom attached tab segment" data-tab="second/a">2A1212</div>
      <div class="ui bottom attached tab segment" data-tab="second/b">2B1212</div>
    </div>
  </div>
  <script>
    $('#context1 .menu .item')
            .tab({
              context: $('#context1')
            })
    ;
  </script>

  <table>
  <tr>
    <td>机构名称:</td>
    <td>
      <div class="ui input"><input type="text" id="angent_name" style="width:300px"></div>
    </td>
    <td><button class="ui teal button" style="width: 200px;">营业执照上传</button></td>
    <td><div class="ui input"><input type="text" id="licence_pic" style="width:300px"></div></td>
  </tr>
  <tr>
      <td>组织结构代码证号：</td>
      <td>
        <div class="ui input"><input type="text" id="angent_code" style="width:300px"></div>
      </td>
    <td><button class="ui teal button" style="width: 200px;">组织代码证上传</button></td>
    <td><div class="ui input"><input type="text" id="code_pic" style="width:300px"></div></td>
  </tr>
  <tr>
    <td>法人姓名：</td>
    <td>
      <div class="ui input"><input type="text" id="legalperson_name" style="width:300px"></div>
    </td>
    <td></td>
    <td></td>
  </tr>
  <tr>
  <td>法人身份证号：</td>
  <td>
    <div class="ui input"><input type="text" id="legalperson_id" style="width:300px"></div>
  </td>
    <td><button class="ui teal button" style="width: 200px;">身份证上传</button></td>
    <td><div class="ui input"><input type="text" id="id_pic" style="width:300px"></div></td>
  </tr>
  <tr>
    <td>法人手机号：</td>
    <td>
      <div class="ui input"><input type="text" id="legalperson_tel" style="width:300px"></div>
    </td>
    <td><button class="ui teal button" style="width: 200px;">获取验证码</button></td>
    <td><div class="ui input"><input type="text" id="verification" style="width:300px"></div></td>
  </tr>
  <tr>
  <td>密码</td>
  <td>
    <div class="ui input"><input type="password" id="password" style="width:300px"></div>
  </td>
  <td></td>
  <td></td>
  </tr>
  <tr>
    <td>再次输入密码</td>
    <td>
      <div class="ui input"><input type="password" id="confirm" style="width:300px"></div>
    </td>
    <td></td>
    <td></td>
  </tr>
</table>

  <button class="ui teal button" style="margin: 10px 400px">提交</button>
</div>
<%@include file="templates/footer.jsp"%>