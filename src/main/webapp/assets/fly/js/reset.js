layui.use(['form','layer','element'], function() {
    var $ = layui.jquery
        , element = layui.element
        ,form = layui.form
        , layer = layui.layer;

    form.on('submit(reset)',function(data){
        console.log(data.field);
        $.ajax({
            url:contextPath+"/fly/reset",
            type:'post',
            dataType:'json',
            data:data.field,
            success:function(res){
                if(res.success){
                    layer.msg("重置成功，请重新登录");
                }else{
                    layer.msg(res.message);
                }
            }
        });
        return false;
    });
});

