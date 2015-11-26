<%--
  Created by IntelliJ IDEA.
  User: douyutong
  Date: 2015/10/26
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
          <tbody id="company_list">

          </tbody>
        </table>

        <a href="/OCare/pages/applyCompany.jsp" style="float:right;margin-top: 20px">
          <button class="ui inverted teal button"><i class="add icon"></i>注册机构</button>
        </a>
      </div>

    </div>
</div>
<script>
    $( document ).ready(function get_list(){
                $.ajax({
                    url:'http://localhost:8080/OCare/app/getCompanyByLegalPersonId',
                    type:'POST',
                    async: false,
                    data:{
                        status:'LegalPerson',
                        id:'20151126'
                    },
                    success:function(data){
                        var list = data.companyList[0].id;
                        console.log(list);
                        for (var i = 0; i < data.companyList.length;i++){
                            $("<tr> <td>data.companyList[i].id</td> <td>data.companyList[i].name</td> <td>data.companyList[i].address</td> </tr>").appendTo("#company_list");
                        }

                        alert(data.errorMsg);
                    },
                    error:function(data){
                        alert("can not get the data");
                    }
                })
            })
</script>

<div class="footer" style="position: absolute;">
    @ copyright Tongji University
</div>

</body>
</html>
