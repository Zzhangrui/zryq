var laypage ="";
layui.use(['form', 'layer', 'element', 'laypage'], function () {
    var $ = layui.jquery
        , element = layui.element
        , form = layui.form
        , layer = layui.layer
    ;
    laypage = layui.laypage;

    //监听提交
    form.on('submit(post-edit)', function(data){
        data.field.content =  editor.html();
        $.ajax({
            url:contextPath+"/fly/post/edit",
            data:data.field,
            type:'post',
            dataType:'json',
            success: function (res) {
                if(res.success){
                    layer.msg("编辑成功");
                    setTimeout(function(){
                        window.location.href=contextPath+"/fly/user/index";
                    },2000);
                }else {
                    layer.alert("提交失败，请刷新后再试");
                }
            }
        });
        return false;
    });
});

jQuery(document).ready(function () {
    KindEditor.ready(function(K) {
        window.editor = K.create('#editor_id',{
            uploadJson : contextPath+'/upload_json.jsp',
            fileManagerJson : contextPath+'/file_manager_json.jsp',
            allowFileManager : false,
            items : [
                'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
                'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                'anchor', 'link', 'unlink', '|', 'about'
            ]
        });
    });
});
