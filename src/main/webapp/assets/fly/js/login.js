layui.use(['form','layer','element'], function() {
    var $ = layui.jquery
        , element = layui.element
        ,form = layui.form
        , layer = layui.layer;


    $(".verify-code").on("click",function () {
        $(this).attr("src",contextPath+"/verifyCode/captcha/login?"+Math.random());
    });

    form.on('submit(login)',function(data){
        console.log(data.field);
        $.ajax({
            url:contextPath+"/fly/login",
            type:'post',
            dataType:'json',
            data:data.field,
            success:function(res){
                if(res.success){
                    window.location.href=contextPath+"/fly/user/index";
                }else{
                    layer.msg(res.message);
                    $("#l-ver-code").click();
                }
            }
        });
        return false;
    });

    form.on('submit(register)',function(data){
        $.ajax({
            url:contextPath+"/fly/register",
            type:'post',
            dataType:'json',
            data:data.field,
            success:function(res){
                console.log(res);
                if(res.success){
                    window.location.href=contextPath+"/fly/user/index";
                }else{
                    layer.msg(res.message);
                    $("#r-ver-code").click();
                }
            }
        });
        return false;
    });
});

