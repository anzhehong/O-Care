<%--
  Created by IntelliJ IDEA.
  User: 重书
  Date: 2015/10/20
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp" %>
<%@include file="templates/sidebar.jsp" %>
<link rel="stylesheet" href="/OCare/Assets/CSS/homepage.css">
<div class="ui container Entry">
    <div class="ui form">
        <div class="inline fields">
            <div class="three wide field"><label>请输入查找内容：</label></div>
            <%--<div class="three wide field">--%>
                <%--<div class="ui dropdown">--%>
                    <%--<div class="text">请选择</div>--%>
                    <%--<i class="dropdown icon"></i>--%>

                    <%--<div class="menu">--%>
                        <%--<div class="item">列出所有在职人员</div>--%>
                        <%--<div class="item">身份证号</div>--%>
                        <%--<div class="item">合同编号</div>--%>
                        <%--<div class="item">电话号码</div>--%>
                        <%--<div class="item">联系地址</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>

            <div class="six wide field">
                <div class="ui icon input">
                    <input type="text" id="input1" placeholder="请输入查询内容..."/>

                </div>
            </div>
            <div class="three wide field">
            <div class="ui positive submit button" id ="search">
                搜索
            </div>
              </div>
        </div>
    </div>
    <div class="inline fields">
        <table class="ui striped table">
            <thead id="title">
            <tr >
                <th>工号</th>
                <th>合同编号</th>
                <th class="one wide">职员姓名</th>
                <th>职员身份证号</th>
                <th>职员电话</th>
                <th>职员部门</th>
                <th>部门主管</th>
                <th>职员岗位</th>
                <th>合同执行情况</th>
                <th>合同起止日期</th>
                <th>联系地址</th>
                <th>最新考核情况</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employee}" var="var">
                <tr class="left aligned">
                    <td>
                            ${var.id}
                    </td>
                    <td>
                            T432252
                    </td>
                    <td>
                            ${var.name}
                    </td>
                    <td>
                            352372387
                    </td>
                    <td>
                            ${var.phone}
                    </td>
                    <td>
                            ${var.department}
                    </td>
                    <td>${var.superior}
                    </td>
                    <td>
                        ${var.position}
                    </td>
                    <td>
                            ${var.status}
                    </td>
                    <td>
                            ${var.contract_start}
                        ~ ${var.contract_end}
                    </td>
                    <td>
                        ${var.address}
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </br>
        <button class="ui basic green button"><i class="icon cloud"></i>信息导出</button>
    </div>
</div>
<script type="text/javascript">
    jQuery (function ($)
    {
        var title=$('#title');
        var table = $ ('table'), text = $ ('#input1');
        $ ('#search').click (function ()
        {
            if(text.val()== ""){
                table.find('tr').show();
            }
            else {

                table.find('tr').hide();
                title.find('tr').show();
                table.find('tr:contains("' + text.val() + '")').show();

            }
        });
    });
</script>

<script type="text/javascript">

    $('.ui.dropdown')
            .dropdown()
    ;
    $('.ui.checkbox')
            .checkbox()
    ;


    $('.ui.form')
            .form({
                field: {
                    name: {
                        identifier: 'name',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter your name'
                            }
                        ]
                    },
                    reason: {
                        identifier: 'reason',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter your reason'
                            }
                        ]
                    },
                    address: {
                        identifier: 'address',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter your address'
                            }
                        ]
                    },
                    phone: {
                        identifier: 'phone',
                        rules: [
                            {
                                type: 'integer',
                                prompt: 'Please enter your phone'
                            }
                        ]
                    },
                    ID: {
                        identifier: 'ID',
                        rules: [
                            {
                                type: 'integer',
                                prompt: 'Please enter your ID'
                            }
                        ]
                    },
                    skills: {
                        identifier: 'skills',
                        rules: [
                            {
                                type: 'minCount[2]',
                                prompt: 'Please select at least two skills'
                            }
                        ]
                    },
                    position: {
                        identifier: 'position',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please select a position'
                            }
                        ]
                    },
                    superior: {
                        identifier: 'superior',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please select a superior'
                            }
                        ]
                    },
                    department: {
                        identifier: 'department',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please select a department'
                            }
                        ]
                    },
                    username: {
                        identifier: 'username',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a username'
                            }
                        ]
                    },
                    password: {
                        identifier: 'password',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a password'
                            },
                            {
                                type: 'minLength[6]',
                                prompt: 'Your password must be at least {ruleValue} characters'
                            }
                        ]
                    },
                    checked: {
                        identifier: 'checked',
                        rules: [
                            {
                                type: 'checked',
                                prompt: 'You must agree to the terms and conditions'
                            }
                        ]
                    }
                }
            })
    ;
</script>
<%@include file="templates/footer.jsp" %>