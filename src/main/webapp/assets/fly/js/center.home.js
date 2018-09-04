var laypage ="";
layui.use(['form', 'layer', 'element', 'laypage'], function () {
    var $ = layui.jquery
        , element = layui.element
        , form = layui.form
        , layer = layui.layer
    ;
    laypage = layui.laypage;


    $("#chat").on("click",function () {
        layer.open({
            type: 1,
            id: 'common-layer',
            skin: 'layui-layer-demo', //样式类名
            closeBtn: 2, //关闭按钮
            area: ['500px', '240px'],
            anim: 0,
            shadeClose: true, //开启遮罩关闭
            content: '<div class="layui-form-item layui-form-text" style="margin: 10px;">\n' +
            '<textarea  class="layui-textarea" id="content"  style="resize:none" placeholder="请输入留言内容"></textarea>\n' +
            '</div>\n' +
            '<div class="btnbox" style="margin-right: 12px;float: right">\n' +
            ' <button class="layui-btn layui-btn-normal" id="subMessage" onclick="submitMessage()">提交</button>' +
            '</div>'
        });
    })
});

//提交评论
function submitMessage() {
    if ($("#content").val() == "") {
        layer.msg("请填写留言内容");
        $("#content").focus();
        return;
    }
    //loading层
    var index = layer.load(1, {
        shade: [0.1,'#fff'] //0.1透明度的白色背景
    });
    $.ajax({
        url: contextPath + '/fly/user/sendMessage',
        type: 'post',
        dataType: 'json',
        data: {receiveId: receiveId, content: $("#content").val()},
        success: function (res) {
            layer.close(index);
            if (res.code == '1000') {
                layer.msg("留言成功");
                setTimeout(function () {
                    layer.closeAll();
                }, 2000);
            } else {
                layer.msg(res.message);
            }
        }
    })
}
