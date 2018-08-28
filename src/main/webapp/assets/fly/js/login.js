layui.use(['form','layer','element'], function() {
    var $ = layui.jquery
        , element = layui.element
        ,form = layui.form
        , layer = layui.layer;


    $(".verify-code").on("click",function () {
        $(this).attr("src",contextPath+"/verifyCode/captcha/login?"+Math.random());
    });

    form.on('submit(login)',function(data){
        $.ajax({
            url:contextPath+"/fly/login",
            type:'post',
            dataType:'json',
            data:data.field,
            success:function(res){
                if(res.success){
                    layer.msg("成功");
                }else{
                    layer.msg(res.message);
                }
            }
        })
        return false;
    });
});

