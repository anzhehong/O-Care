$('#context1 .menu .item')
    .tab({
        context: $('#context1')
    })
;

var aFunction = function()
{
    $('.modal').modal({
        detachable: true,
        closable: false,
        transition: 'fade up',
        onApprove : function() {
            $('.ui.form').submit();
            return false;
        }
    });

    $(".login").on("click", function(){
        //Resets form input fields
        $('.ui.form').trigger("reset");
        //Resets form error messages
        $('.ui.form .field.error').removeClass( "error" );
        $('.ui.form.error').removeClass( "error" );
        $('.modal').modal('show');
    });
}
$(document).ready( aFunction );

$('.LegalPerson-sign-in').on('submit', function(e){
    e.preventDefault();
    $.ajax({
        url:'http://localhost:8080/OCare/app/logon',
        type:'post',
        async: false,
        data:{
            phoneNum:$('#LegalPerson_username').val(),
            password:$('#LegalPerson_password').val(),
            role:4
        },
        datatype:'JSONP',
        success:function(data){
            if(data.error == true){
                document.getElementById("LegalPerson_login_errorMsg").style.display="";
                document.getElementById('LegalPerson_login_errorMsg').innerText = data.errorMsg;
            }else if(data.accountType == "LegalPerson"){
                document.getElementById("LegalPerson_login_errorMsg").style.display="none";
                document.forms[0].action = "/OCare/pages/agentManagement.jsp";
                document.forms[0].submit();
            }
        },
        error:function(data){
            alert("login failed")
        }
    });
})

$('.admin-sign-in').on('submit', function(e){
    e.preventDefault();
    $.ajax({
        url:'http://localhost:8080/OCare/app/adminlogon',
        type:'post',
        async: false,
        data:{
            phoneNum:$('#adminname').val(),
            password:$('#adminpassword').val()
        },
        datatype:'JSONP',
        success:function(data){
            if(data.error == true){
                document.getElementById("admin_login_errorMsg").style.display="";
                document.getElementById('admin_login_errorMsg').innerText = data.errorMsg;
            }else if(data.accountType == "Admin"){
                document.getElementById("admin_login_errorMsg").style.display="none";
                document.forms[0].action = "/OCare/pages/homepage.jsp";
                document.forms[0].submit();
            }
        },
        error:function(data){
            alert("login failed")
        }
    });
})

var formValidationRules =
{
    legalpersonname: {
        identifier : 'LegalPerson_username',
        rules: [
            {
                type   : 'empty',
                prompt : '请输入手机号'
            }
        ]
    },
    eldername: {
        identifier : 'Elder_username',
        rules: [
            {
                type   : 'empty',
                prompt : '请输入手机号'
            }
        ]
    },
    employeename: {
        identifier : 'Employee_username',
        rules: [
            {
                type   : 'empty',
                prompt : '请输入手机号'
            }
        ]
    },
    monitername: {
        identifier : 'Monitor_username',
        rules: [
            {
                type   : 'empty',
                prompt : '请输入手机号'
            }
        ]
    },
    volenteername: {
        identifier : 'Volenteer_username',
        rules: [
            {
                type   : 'empty',
                prompt : '请输入手机号'
            }
        ]
    },
    adminname: {
        identifier : 'adminname',
        rules: [
            {
                type   : 'empty',
                prompt : '请输入手机号'
            }
        ]
    },
    password: {
        identifier : 'Monitor_password',
        //Below line sets it so that it only validates when input is entered, and won't validate on blank input
        optional   : true,
        rules: [
            {
                type   : 'empty',
                prompt : '请输入密码'
            }
        ]
    },
    adminpassword: {
        identifier : 'adminpassword',
        //Below line sets it so that it only validates when input is entered, and won't validate on blank input
        optional   : true,
        rules: [
            {
                type   : 'empty',
                prompt : '请输入密码'
            }
        ]
    },
    employeepassword: {
        identifier : 'Employee_password',
        //Below line sets it so that it only validates when input is entered, and won't validate on blank input
        optional   : true,
        rules: [
            {
                type   : 'empty',
                prompt : '请输入密码'
            }
        ]
    },
    elderpassword: {
        identifier : 'Elder_password',
        //Below line sets it so that it only validates when input is entered, and won't validate on blank input
        optional   : true,
        rules: [
            {
                type   : 'empty',
                prompt : '请输入密码'
            }
        ]
    },
    monitorpassword: {
        identifier : 'Monitor_password',
        //Below line sets it so that it only validates when input is entered, and won't validate on blank input
        optional   : true,
        rules: [
            {
                type   : 'empty',
                prompt : '请输入密码'
            }
        ]
    },
    volenteerpassword: {
        identifier : 'Volenteer_password',
        //Below line sets it so that it only validates when input is entered, and won't validate on blank input
        optional   : true,
        rules: [
            {
                type   : 'empty',
                prompt : '请输入密码'
            }
        ]
    }
}

//var formSettings =
//{
//    onSuccess : function()
//    {
//            $('.modal').modal('hide');
//    }
//}


$('.ui.form').form(formValidationRules);


