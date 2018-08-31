layui.use(['form', 'layer', 'element', 'laypage','upload'], function () {
    var $ = layui.jquery
        , element = layui.element
        , form = layui.form
        , layer = layui.layer
        , upload= layui.upload
    ;

    /**
     * 修改基本信息
     */
    form.on('submit(base-info)', function(data){
        $.ajax({
            url:contextPath+"/fly/user/baseInfo",
            data:data.field,
            type:'post',
            dataType:'json',
            success: function (res) {
                if(res.success){
                    layer.msg("编辑成功");
                    setTimeout(function(){

                    },2000);
                }else {
                    layer.alert(res.message);
                }
            }
        });
        return false;
    });

    /**
     * 修改密码
     */
    form.on('submit(password)', function(data){
        $.ajax({
            url:contextPath+"/fly/user/password",
            data:data.field,
            type:'post',
            dataType:'json',
            success: function (res) {
                if(res.success){
                    layer.msg("编辑成功");
                    setTimeout(function(){

                    },2000);
                }else {
                    layer.alert(res.message);
                }
            }
        });
        return false;
    });

    //普通图片上传
    var uploadInst = upload.render({
        elem: '#upload-img-btn'
        ,accept:'images'
        ,size:1024
        ,data:{dirPath:'user/logo'}
        ,url: contextPath+'/fly/user/img'
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#user-img').attr('src', result); //图片链接（base64）
            });
        }
        ,done: function(res){
            //如果上传失败
            if(res.code > 0){
                return layer.msg('上传失败');
            }
            //上传成功
        }
        ,error: function(){
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });
});
