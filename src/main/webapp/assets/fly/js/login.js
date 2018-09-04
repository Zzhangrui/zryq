layui.use(['form','layer','element'], function() {
    var $ = layui.jquery
        , element = layui.element
        ,form = layui.form
        , layer = layui.layer;


    $(".verify-code").on("click",function () {
        var type = $(this).attr("code-type");
        $(this).attr("src",contextPath+"/verifyCode/captcha/"+type+"?"+Math.random());
    });

    form.on('submit(login)',function(data){
        var index = layer.load(1, {
            shade: [0.1,'#fff'] //0.1透明度的白色背景
        });
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
                    layer.close(index);
                    $("#l-ver-code").click();
                }
            }
        });
        return false;
    });

    form.on('submit(register)',function(data){
        var index = layer.load(1, {
            shade: [0.1,'#fff'] //0.1透明度的白色背景
        });
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
                    layer.close(index);
                    $("#r-ver-code").click();
                }
            }
        });
        return false;
    });

    form.on('submit(forget)',function(data){
        var index = layer.load(1, {
            shade: [0.1,'#fff'] //0.1透明度的白色背景
        });
        $.ajax({
            url:contextPath+"/fly/forget",
            type:'post',
            dataType:'json',
            data:data.field,
            success:function(res){
                if(res.success){
                    $("#f-ver-code").click();
                    layer.msg("重置链接已发至您邮箱，请根据邮件提示进行重置密码");
                }else{
                    layer.msg(res.message);
                    layer.close(index);
                    $("#f-ver-code").click();
                }
            }
        });
        return false;
    });

    $("#forget-a").on('click',function () {
        layer.msg("吃屎去吧，密码都能忘，呆逼");
    })
});

