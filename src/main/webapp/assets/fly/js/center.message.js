var laypage ="";
layui.use(['form', 'layer', 'element', 'laypage'], function () {
    var $ = layui.jquery
        , element = layui.element
        , form = layui.form
        , layer = layui.layer
    ;
    laypage = layui.laypage;
    getMessage(0);
});

function getMessage() {
    $.ajax({
        url:contextPath+"/fly/user/message",
        type:'post',
        dataType:'json',
        success:function (res) {
            console.log(res);
        }
    })
}
