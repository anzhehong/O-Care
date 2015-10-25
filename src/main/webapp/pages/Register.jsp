<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/10/15
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@include file="templates/header.jsp"%>

<div style="width:1250px;margin:30px auto">
  <div class="ui ordered steps" style="margin: 10px 410px">
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

  <div id="context1" style="width:1250px">
    <div class="ui secondary menu" style="margin:10px 500px">
      <a class="item active" data-tab="first">机构注册</a>
      <a class="item " data-tab="second">个人注册</a>
    </div>
    <!-------------------------------------------->
                  <!--机构注册-->
    <!-------------------------------------------->
    <div class="ui tab segment active" data-tab="first">
      <table style="margin: 30px 100px;">
        <tr style="line-height: 80px;">
          <td>机构名称:</td>
          <td>
            <div class="ui input"><input type="text" id="angent_name" style="width:300px"></div>
          </td>
          <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">营业执照上传</button></td>
          <td><div class="ui input"><input type="text" id="licence_pic" style="width:300px"></div></td>
        </tr>
        <tr style="line-height: 80px;">
          <td>组织结构代码证号：</td>
          <td>
            <div class="ui input"><input type="text" id="angent_code" style="width:300px"></div>
          </td>
          <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">组织代码证上传</button></td>
          <td><div class="ui input"><input type="text" id="code_pic" style="width:300px"></div></td>
        </tr>
        <tr style="line-height: 80px;">
          <td>法人姓名：</td>
          <td>
            <div class="ui input"><input type="text" id="legalperson_name" style="width:300px"></div>
          </td>
          <td></td>
          <td></td>
        </tr>
        <tr style="line-height: 80px;">
          <td>法人身份证号：</td>
          <td>
            <div class="ui input"><input type="text" id="legalperson_id" style="width:300px"></div>
          </td>
          <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">身份证上传</button></td>
          <td><div class="ui input"><input type="text" id="id_pic" style="width:300px"></div></td>
        </tr>
        <tr style="line-height: 80px;">
          <td>法人手机号：</td>
          <td>
            <div class="ui input"><input type="text" id="legalperson_tel" style="width:300px"></div>
          </td>
          <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">获取验证码</button></td>
          <td><div class="ui input"><input type="text" id="verification" style="width:300px"></div></td>
        </tr>
        <tr style="line-height: 80px;">
          <td>密码</td>
          <td>
            <div class="ui input"><input type="password" id="password" style="width:300px"></div>
          </td>
          <td></td>
          <td></td>
        </tr>
        <tr style="line-height: 80px;">
          <td>再次输入密码</td>
          <td>
            <div class="ui input"><input type="password" id="confirm" style="width:300px"></div>
          </td>
          <td></td>
          <td></td>
        </tr>
      </table>

      <button class="ui teal button" id="agent_submit" style="margin-left: 600px">提交</button>
    </div>
    <!-------------------------------------------->
                  <!--机构注册结束-->
    <!-------------------------------------------->

    <div class="ui tab segment active" data-tab="second">
      <div class="ui top attached tabular menu">
        <a class="active item" data-tab="second/a">监护人</a>
        <a class="item" data-tab="second/b">志愿者</a>
      </div>
    <!-------------------------------------------->
                  <!--监护人注册-->
    <!-------------------------------------------->
      <div class="ui bottom attached active tab segment" data-tab="second/a">
        <table style="margin: 30px auto;">
          <tr style="line-height: 80px;">
            <td>姓名：</td>
            <td>
              <div class="ui input"><input type="text" id="guardian_name" style="width:300px"></div>
            </td>
          </tr>
          <tr>
            <td>性别：</td>
            <td>
              <div class="ui form" id="guardian_gender">
                <div class="grouped inline fields">
                    <div class="field" style="display: inline-block;">
                      <div class="ui radio checkbox">
                        <label>男</label>
                        <input name="gender" value="male" checked="checked" type="radio" >
                      </div>
                    </div>
                    <div class="field" style="display: inline-block;">
                      <div class="ui radio checkbox">
                        <label>女</label>
                        <input name="gender" value="female" type="radio">
                      </div>
                    </div>
                  </div>
                </div>
            </td>
          </tr>
          <tr style="line-height: 80px;">
            <td>出生年月：</td>
            <td>
              <div class="ui selection dropdown">
                <input type="hidden" name="Year">
                <div class="default text">选择年份</div>
                <i class="dropdown icon"></i>
                <div class="menu">
                  <div class="item" data-value="1">1960</div>
                  <div class="item" data-value="1">1961</div>
                  <div class="item" data-value="1">1962</div>
                  <div class="item" data-value="1">1963</div>
                  <div class="item" data-value="1">1964</div>
                  <div class="item" data-value="1">1965</div>
                  <div class="item" data-value="1">1966</div>
                  <div class="item" data-value="1">1967</div>
                  <div class="item" data-value="1">1968</div>
                  <div class="item" data-value="1">1969</div>
                  <div class="item" data-value="1">1970</div>
                  <div class="item" data-value="1">1971</div>
                  <div class="item" data-value="1">1972</div>
                  <div class="item" data-value="1">1973</div>
                  <div class="item" data-value="1">1974</div>
                  <div class="item" data-value="1">1975</div>
                  <div class="item" data-value="1">1976</div>
                  <div class="item" data-value="1">1977</div>
                  <div class="item" data-value="1">1978</div>
                  <div class="item" data-value="1">1979</div>
                  <div class="item" data-value="1">1980</div>
                  <div class="item" data-value="1">1981</div>
                  <div class="item" data-value="1">1982</div>
                  <div class="item" data-value="1">1983</div>
                  <div class="item" data-value="1">1984</div>
                  <div class="item" data-value="1">1985</div>
                  <div class="item" data-value="1">1986</div>
                  <div class="item" data-value="1">1987</div>
                  <div class="item" data-value="1">1988</div>
                  <div class="item" data-value="1">1989</div>
                  <div class="item" data-value="1">1990</div>
                  <div class="item" data-value="1">1991</div>
                  <div class="item" data-value="1">1992</div>
                  <div class="item" data-value="1">1993</div>
                  <div class="item" data-value="1">1994</div>
                  <div class="item" data-value="1">1995</div>
                  <div class="item" data-value="1">1996</div>
                  <div class="item" data-value="1">1997</div>
                  <div class="item" data-value="1">1998</div>
                  <div class="item" data-value="1">1999</div>
                  <div class="item" data-value="1">2000</div>
                  <div class="item" data-value="1">2001</div>
                  <div class="item" data-value="1">2002</div>
                  <div class="item" data-value="1">2003</div>
                  <div class="item" data-value="1">2004</div>
                  <div class="item" data-value="1">2005</div>
                  <div class="item" data-value="1">2006</div>
                  <div class="item" data-value="1">2007</div>
                  <div class="item" data-value="1">2008</div>
                  <div class="item" data-value="1">2009</div>
                  <div class="item" data-value="1">2010</div>
                </div>
              </div>
            </td>
            <td>
              <div class="ui selection dropdown">
                <input type="hidden" name="Month">
                <div class="default text">选择月份</div>
                <i class="dropdown icon"></i>
                <div class="menu">
                  <div class="item" data-value="Jan">1</div>
                  <div class="item" data-value="Feb">2</div>
                  <div class="item" data-value="Mar">3</div>
                  <div class="item" data-value="Apr">4</div>
                  <div class="item" data-value="May">5</div>
                  <div class="item" data-value="Jun">6</div>
                  <div class="item" data-value="Jul">7</div>
                  <div class="item" data-value="Aug">8</div>
                  <div class="item" data-value="Sep">9</div>
                  <div class="item" data-value="Oct">10</div>
                  <div class="item" data-value="Nov">11</div>
                  <div class="item" data-value="Dec">12</div>
                </div>
              </div>
            </td>
          </tr>
          <tr>
            <td>监护老人姓名：</td>
            <td>
              <div class="ui input"><input type="text" id="elder_name" style="width:300px"></div>
            </td>
            <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">合照上传</button></td>
            <td><div class="ui input"><input type="text" id="together_pic" style="width:300px"></div></td>
          </tr>

          <tr style="line-height: 80px;">
            <td>身份证号：</td>
            <td>
              <div class="ui input"><input type="text" id="guardian_id" style="width:300px"></div>
            </td>
            <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">身份证上传</button></td>
            <td><div class="ui input"><input type="text" id="guardian_pic" style="width:300px"></div></td>
          </tr>
          <tr style="line-height: 80px;">
            <td>手机号：</td>
            <td>
              <div class="ui input"><input type="text" id="guardian_tel" style="width:300px"></div>
            </td>
            <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">获取验证码</button></td>
            <td><div class="ui input"><input type="text" id="guardian_verification" style="width:300px"></div></td>
          </tr>
          <tr style="line-height: 80px;">
            <td>密码</td>
            <td>
              <div class="ui input"><input type="password" id="guardian_password" style="width:300px"></div>
            </td>
            <td></td>
            <td></td>
          </tr>
          <tr style="line-height: 80px;">
            <td>再次输入密码</td>
            <td>
              <div class="ui input"><input type="password" id="guardian_confirm" style="width:300px"></div>
            </td>
            <td></td>
            <td></td>
          </tr>
        </table>
        <button class="ui teal button" id="guardian_submit" style="margin-left: 600px">提交</button>
      </div>
      <!-------------------------------------------->
                   <!--监护人注册结束-->
      <!-------------------------------------------->

      <!-------------------------------------------->
                    <!--志愿者注册-->
      <!-------------------------------------------->
      <div class="ui bottom attached tab segment" data-tab="second/b">
        <table style="margin: 30px auto;">
          <tr style="line-height: 80px;">
            <td>姓名：</td>
            <td>
              <div class="ui input"><input type="text" id="volenteer_name" style="width:300px"></div>
            </td>
          </tr>
          <tr>
            <td>性别：</td>
            <td>
              <div class="ui form">
                <div class="grouped inline fields">
                  <div class="field" style="display: inline-block;">
                    <div class="ui radio checkbox">
                      <label>男</label>
                      <input name="gender" value="male" checked="checked" type="radio">
                    </div>
                  </div>
                  <div class="field" style="display: inline-block;">
                    <div class="ui radio checkbox">
                      <label>女</label>
                      <input name="gender" value="female" type="radio">
                    </div>
                  </div>
                </div>
              </div>
            </td>
          </tr>
          <tr style="line-height: 80px;">
            <td>出生年月：</td>
            <td>
              <div class="ui selection dropdown">
                <input type="hidden" name="Year">
                <div class="default text">选择年份</div>
                <i class="dropdown icon"></i>
                <div class="menu">
                  <div class="item" data-value="1">1960</div>
                  <div class="item" data-value="1">1961</div>
                  <div class="item" data-value="1">1962</div>
                  <div class="item" data-value="1">1963</div>
                  <div class="item" data-value="1">1964</div>
                  <div class="item" data-value="1">1965</div>
                  <div class="item" data-value="1">1966</div>
                  <div class="item" data-value="1">1967</div>
                  <div class="item" data-value="1">1968</div>
                  <div class="item" data-value="1">1969</div>
                  <div class="item" data-value="1">1970</div>
                  <div class="item" data-value="1">1971</div>
                  <div class="item" data-value="1">1972</div>
                  <div class="item" data-value="1">1973</div>
                  <div class="item" data-value="1">1974</div>
                  <div class="item" data-value="1">1975</div>
                  <div class="item" data-value="1">1976</div>
                  <div class="item" data-value="1">1977</div>
                  <div class="item" data-value="1">1978</div>
                  <div class="item" data-value="1">1979</div>
                  <div class="item" data-value="1">1980</div>
                  <div class="item" data-value="1">1981</div>
                  <div class="item" data-value="1">1982</div>
                  <div class="item" data-value="1">1983</div>
                  <div class="item" data-value="1">1984</div>
                  <div class="item" data-value="1">1985</div>
                  <div class="item" data-value="1">1986</div>
                  <div class="item" data-value="1">1987</div>
                  <div class="item" data-value="1">1988</div>
                  <div class="item" data-value="1">1989</div>
                  <div class="item" data-value="1">1990</div>
                  <div class="item" data-value="1">1991</div>
                  <div class="item" data-value="1">1992</div>
                  <div class="item" data-value="1">1993</div>
                  <div class="item" data-value="1">1994</div>
                  <div class="item" data-value="1">1995</div>
                  <div class="item" data-value="1">1996</div>
                  <div class="item" data-value="1">1997</div>
                  <div class="item" data-value="1">1998</div>
                  <div class="item" data-value="1">1999</div>
                  <div class="item" data-value="1">2000</div>
                  <div class="item" data-value="1">2001</div>
                  <div class="item" data-value="1">2002</div>
                  <div class="item" data-value="1">2003</div>
                  <div class="item" data-value="1">2004</div>
                  <div class="item" data-value="1">2005</div>
                  <div class="item" data-value="1">2006</div>
                  <div class="item" data-value="1">2007</div>
                  <div class="item" data-value="1">2008</div>
                  <div class="item" data-value="1">2009</div>
                  <div class="item" data-value="1">2010</div>
                </div>
              </div>
            </td>
            <td>
              <div class="ui selection dropdown">
                <input type="hidden" name="Month">
                <div class="default text">选择月份</div>
                <i class="dropdown icon"></i>
                <div class="menu">
                  <div class="item" data-value="Jan">1</div>
                  <div class="item" data-value="Feb">2</div>
                  <div class="item" data-value="Mar">3</div>
                  <div class="item" data-value="Apr">4</div>
                  <div class="item" data-value="May">5</div>
                  <div class="item" data-value="Jun">6</div>
                  <div class="item" data-value="Jul">7</div>
                  <div class="item" data-value="Aug">8</div>
                  <div class="item" data-value="Sep">9</div>
                  <div class="item" data-value="Oct">10</div>
                  <div class="item" data-value="Nov">11</div>
                  <div class="item" data-value="Dec">12</div>
                </div>
              </div>
            </td>
          </tr>
          <tr style="line-height: 80px;">
            <td>身份证号：</td>
            <td>
              <div class="ui input"><input type="text" id="volenteer_id" style="width:300px"></div>
            </td>
            <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">身份证上传</button></td>
            <td><div class="ui input"><input type="text" id="vid_pic" style="width:300px"></div></td>
          </tr>
          <tr style="line-height: 80px;">
            <td>手机号：</td>
            <td>
              <div class="ui input"><input type="text" id="vol_tel" style="width:300px"></div>
            </td>
            <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">获取验证码</button></td>
            <td><div class="ui input"><input type="text" id="vol_verification" style="width:300px"></div></td>
          </tr>
          <tr style="line-height: 80px;">
            <td>密码</td>
            <td>
              <div class="ui input"><input type="password" id="vol_password" style="width:300px"></div>
            </td>
            <td></td>
            <td></td>
          </tr>
          <tr style="line-height: 80px;">
            <td>再次输入密码</td>
            <td>
              <div class="ui input"><input type="password" id="vol_confirm" style="width:300px"></div>
            </td>
            <td></td>
            <td></td>
          </tr>
        </table>
        <button class="ui teal button" id="vol_submit" style="margin-left: 600px">提交</button>
      </div>
      <!-------------------------------------------->
                 <!--志愿者注册结束-->
      <!-------------------------------------------->
    </div>

  <script>
    $('#context1 .menu .item')
            .tab({
              context: $('#context1')
            })
    ;
    $('.ui.dropdown')
            .dropdown()
    ;
    $('.ui.radio.checkbox')
            .checkbox()
    ;
  </script>


</div>
<%@include file="templates/footer.jsp"%>