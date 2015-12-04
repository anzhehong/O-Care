/**
 * Created by douyutong on 2015/12/2.
 */
$('.leagal-submit').on('click',function(e){
    e.preventDefault();
    $.ajax({
        url: 'http://localhost:8080/OCare/app/register/legalperson',
        type: 'get',
        cache: false,
        async: false,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        processData: false,
        data: 'lpId='+$('#legalperson_id').val()+'&lpName='+$('#legalperson_name').val()+'&lpPhone='+$('#legalperson_tel').val()+'&lpEmail='+$('#legalperson_email').val()+'&lpPassword='+$('#legalperson_password').val()+'&lpImage='+$('#id_image').val(),
        dataType: 'JSON',
        success: function(data){
            if(data.error == true){
                alert(data.errorMsg);
            }
            var sent_code = $('#verification').val();
            if( sent_code != code || sent_code == ""){
                alert("verify code is empty/wrong!")
            }
            else{
                alert("Modified!");
                document.forms[0].action = "/OCare/pages/index.jsp";
                document.forms[0].submit();
            }
        },
        error:function(data){
            alert("submit failed!");
        }
    });
})