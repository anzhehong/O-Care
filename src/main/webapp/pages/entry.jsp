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
    <div class="ui grid">
        <div class="eight wide column">
            <form class="ui form" method="post">

                <h4 class="ui dividing header">入职信息</h4>


                <div class="field" >
                    <label>姓名：</label>

                    <div class="ui input">
                        <input type="text" name="name" placeholder="请输入姓名">
                    </div>
                    </br>
                </div>
                <div class="field">
                    <div class="ui input">
                        <label>地址：</label>
                        <input type="text" name="address" placeholder="请输入正确的地址">
                    </div>
                    </br>
                </div>

                <div class="field">
                    <div class="ui input">
                        <label>电话：</label>
                        <input type="text" name="phone" placeholder="请输入您的电话">
                    </div>
                    </br>
                </div>

                <div class="field">
                    <div class="ui input">
                        <label>身份证号：</label>
                        <input type="text" name="ID" placeholder="请输入身份证号">
                    </div>
                </div>

                <label>部门：</label>

                <div class="field">
                    <div class="ui dropdown" name="department">
                        <div class="text">请选择</div>
                        <i class="dropdown icon"></i>

                        <div class="menu">
                            <div class="item">护工班组</div>
                            <div class="item">人事经理室</div>
                        </div>
                    </div>
                </div>
                <%--<label>部门：</label>--%>
                <%--<select class="ui fluid dropdown" name="department">--%>
                <%--<option value="">请选择</option>--%>
                <%--<option value="AL">胡工班组</option>--%>
                <%--<option value="AL">人事经理室</option>--%>
                <%--</select>--%>
                <%--</br>--%>
                <%--</br>--%>
                <div class="field">
                    <label>职位：</label>

                    <div class="ui dropdown" name="position">
                        <div class="text">请选择</div>
                        <i class="dropdown icon"></i>

                        <div class="menu">
                            <div class="item">护工班组</div>
                            <div class="item">人事经理室</div>
                        </div>
                    </div>
                </div>
                <%--</br>--%>
                <%--</br>--%>
                <div class="field">
                    <label>上级主管：</label>

                    <div class="ui dropdown">
                        <div class="text">请选择</div>
                        <i class="dropdown icon"></i>

                        <div class="menu" name="superior">
                            <div class="item">张三</div>
                            <div class="item">李四</div>
                        </div>
                    </div>
                </div>
                <%--</br>--%>
                <%--</br>--%>

                <label>合同时间：</label>
                <div class="ui grid field">


                    <div class="ui input eight wide column">

                        <input type="text" name="start_time" placeholder="开始时间(2000.1.1)">
                    </div>

                    <div class="ui input eight wide column">
                        <input type="text" name="finish_time" placeholder="结束时间(2000.1.2)">
                    </div>
                </div>
                <%--</br>--%>
                <div class="field">
                    <div class="ui checkbox">
                        <input type="checkbox" name="checked" tabindex="0" class="hidden">
                        <label>I agree to the Terms and Conditions</label>
                    </div>
                </div>
                <%--</br>--%>
                <%--</br>--%>
                <div class="field">

                    <div class="three ui fluid buttons">
                        <div class="ui button">人事合同预览</div>
                        <div class="ui button">合同签订上传</div>
                        <div class="ui button">工作证打印</div>
                    </div>
                </div>
                <%--</br>--%>
                <%--</br>--%>


                <div class="ui fluid positive large submit button">
                    保存
                </div>


                <div class="ui error message"></div>


            </form>
        </div>
        <div class="eight wide column">
            <label>身份证正反面</label>
            <div>

                    <input type="file" id="imgUpload" name="imgUpload" multiple />

                 <!--允许file控件接受的文件类型-->
                <!--<input type="file" id="imgUpload" name="imgUpload" accept="image/*" multiple/>-->
                <div id="destination" style="width:200px;height:200px;border:1px solid #adadad;">
                    <img src="nopic.jpg" />
                </div>
            </div>

        </div>
    </div>
</div>

    <script type="text/javascript">
        //处理file input加载的图片文件
        $(document).ready(function(e) {
            //判断浏览器是否有FileReader接口
            if(typeof FileReader =='undefined')
            {
                $("#destination").css({'background':'none'}).html('亲,您的浏览器还不支持HTML5的FileReader接口,无法使用图片本地预览,请更新浏览器获得最好体验');
                //如果浏览器是ie
                if($.browser.msie===true)
                {
                    //ie6直接用file input的value值本地预览
                    if($.browser.version==6)
                    {
                        $("#imgUpload").change(function(event){
                            //ie6下怎么做图片格式判断?
                            var src = event.target.value;
                            //var src = document.selection.createRange().text;        //选中后 selection对象就产生了 这个对象只适合ie
                            var img = '<img src="'+src+'" width="200px" height="200px" />';
                            $("#destination").empty().append(img);
                        });
                    }
                    //ie7,8使用滤镜本地预览
                    else if($.browser.version==7 || $.browser.version==8)
                    {
                        $("#imgUpload").change(function(event){
                            $(event.target).select();
                            var src = document.selection.createRange().text;
                            var dom = document.getElementById('destination');
                            //使用滤镜 成功率高
                            dom.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src= src;
                            dom.innerHTML = '';
                            //使用和ie6相同的方式 设置src为绝对路径的方式 有些图片无法显示 效果没有使用滤镜好
                            /*var img = '<img src="'+src+'" width="200px" height="200px" />';
                             $("#destination").empty().append(img);*/
                        });
                    }
                }
                //如果是不支持FileReader接口的低版本firefox 可以用getAsDataURL接口
                else if($.browser.mozilla===true)
                {
                    $("#imgUpload").change(function(event){
                        //firefox2.0没有event.target.files这个属性 就像ie6那样使用value值 但是firefox2.0不支持绝对路径嵌入图片 放弃firefox2.0
                        //firefox3.0开始具备event.target.files这个属性 并且开始支持getAsDataURL()这个接口 一直到firefox7.0结束 不过以后都可以用HTML5的FileReader接口了
                        if(event.target.files)
                        {
                            //console.log(event.target.files);
                            for(var i=0;i<event.target.files.length;i++)
                            {
                                var img = '<img src="'+event.target.files.item(i).getAsDataURL()+'" width="200px" height="200px"/>';
                                $("#destination").empty().append(img);
                            }
                        }
                        else
                        {
                            //console.log(event.target.value);
                            //$("#imgPreview").attr({'src':event.target.value});
                        }
                    });
                }
            }
            else
            {
                // version 1
                /*$("#imgUpload").change(function(e){
                 var file = e.target.files[0];
                 var fReader = new FileReader();
                 //console.log(fReader);
                 //console.log(file);
                 fReader.onload=(function(var_file)
                 {
                 return function(e)
                 {
                 $("#imgPreview").attr({'src':e.target.result,'alt':var_file.name});
                 }
                 })(file);
                 fReader.readAsDataURL(file);
                 });*/

                //单图上传 version 2
                /*$("#imgUpload").change(function(e){
                 var file = e.target.files[0];
                 var reader = new FileReader();
                 reader.onload = function(e){
                 //displayImage($('bd'),e.target.result);
                 //alert('load');
                 $("#imgPreview").attr({'src':e.target.result});
                 }
                 reader.readAsDataURL(file);
                 });*/
                //多图上传 input file控件里指定multiple属性 e.target是dom类型
                $("#imgUpload").change(function(e){
                    for(var i=0;i<e.target.files.length;i++)
                    {
                        var file = e.target.files.item(i);
                        //允许文件MIME类型 也可以在input标签中指定accept属性
                        //console.log(/^image\/.*$/i.test(file.type));
                        if(!(/^image\/.*$/i.test(file.type)))
                        {

                            continue;            //不是图片 就跳出这一次循环
                        }
//实例化FileReader API
                        var freader = new FileReader();
                        freader.readAsDataURL(file);
                        freader.onload=function(e)
                        {
                            var img = '<img src="'+e.target.result+'" width="200px" height="200px"/>';
                            $("#destination").empty().append(img);
                        };

                    }
                });

                //处理图片拖拽的代码
                var destDom = document.getElementById('destination');
                destDom.addEventListener('dragover',function(event){
                    event.stopPropagation();
                    event.preventDefault();
                },false);

                destDom.addEventListener('drop',function(event){
                    event.stopPropagation();
                    event.preventDefault();
                    var img_file = event.dataTransfer.files.item(0);                //获取拖拽过来的文件信息 暂时取一个
                    //console.log(event.dataTransfer.files.item(0).type);
                    if(!(/^image\/.*$/.test(img_file.type)))
                    {
                        alert('您还未拖拽任何图片过来,或者您拖拽的不是图片文件');
                        return false;
                    }
                    fReader = new FileReader();
                    fReader.readAsDataURL(img_file);
                    fReader.onload = function(event){
                        destDom.innerHTML='';
                        destDom.innerHTML = '<img src="'+event.target.result+'" width="200px" height="200px"/>';
                    };
                },false);
            }
        });
    </script>
<%--<script src="/OCare/Assets/JS/jquery-1.11.2.min.js"></script>--%>
<%--<script src="/OCare/Assets/JS/semantic.min.js"></script>--%>
<%--<script src="/OCare/Assets/JS/01.js"></script>--%>

<script type="text/javascript">
    $(document).ready(function () {
        $('.ui.dropdown')
                .dropdown()
        ;
        $('.ui.checkbox')
                .checkbox()
        ;

        $('.ui.form')
                .form({

                    name: {
                        identifier: 'name',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter your name'
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
                                type: 'empty',
                                prompt: 'Please enter your phone'
                            }
                        ]
                    },
                    ID: {
                        identifier: 'ID',
                        rules: [
                            {
                                type: 'empty',
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
                    },

                        start_time: {
                            identifier: 'start_time',
                            rules: [
                                {
                                    type: 'empty',
                                    prompt: 'Please enter '
                                }
                            ]
                        },
                    finish_time: {
                        identifier: 'finish_time',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter '
                            }
                        ]
                    }


                })
        ;
    })
</script>
<%@include file="templates/footer.jsp" %>