var element = ""
    , form = ""
    , laypage = ""
    , laytpl = "";
//全局页面
var initNum = "0";

var artId = "";
layui.define(['element', 'form', 'laypage', 'jquery', 'laytpl'], function (exports) {
    element = layui.element;
    form = layui.form;
    laypage = layui.laypage;
    laytpl = layui.laytpl;


    //end 评论的特效


    // start点赞图标变身
    $('#LAY-msg-box').on('click', '.info-img', function () {
        $(this).addClass('layblog-this');
    });


    //输出test接口
    exports('common', {});
});

function initLikeEvent() {
//点赞
    //绑定点赞
    $(".like").on('click', function () {
        var dom = $(this);
        if (dom.attr('likeValue') == '点赞') {
            $.ajax({
                url: contextPath + "/blog/doLike",
                type: 'post',
                dataType: 'json',
                data: {id: $(this).attr("likeCount")},
                success: function () {
                    layer.msg('点赞成功', {
                        icon: 1
                        , time: 1000
                    });
                    dom.attr("likeValue", "已点赞");
                    dom.text("已点赞");
                    dom.css('color', 'red');
                }
            });
        } else {
            layer.msg('请勿重复点赞', {
                icon: 2
                , time: 1000
            })
        }
    });


    //打开评论
    $(".comment-event").on('click', function () {
        var dom = $(this);
        artId = dom.attr('artId');
        layer.open({
            type: 1,
            id: 'common-layer',
            skin: 'layui-layer-demo', //样式类名
            closeBtn: 2, //关闭按钮
            area: ['500px', '240px'],
            anim: 0,
            shadeClose: true, //开启遮罩关闭
            content: '<div class="layui-form-item layui-form-text" style="margin: 10px;">\n' +
            '<textarea  class="layui-textarea" id="comment"  style="resize:none" placeholder="写点什么啊"></textarea>\n' +
            '</div>\n' +
            '<div class="btnbox" style="margin-right: 12px;float: right">\n' +
            ' <button class="layui-btn layui-btn-normal" id="subComment" onclick="submitComment()">提交</button>' +
            '</div>'
        });
    });
}


//提交评论
function submitComment() {
    if (artId == "") {
        layer.msg("参数异常");
        return;
    }
    $.ajax({
        url: contextPath + '/blog/submitComment',
        type: 'post',
        dataType: 'json',
        data: {articleId: artId, commContent: $("#comment").val()},
        success: function (res) {
            if (res.code == '1000') {
                layer.msg("评论成功");
                setTimeout(function () {
                    layer.closeAll();
                }, 2000);
            } else {
                layer.msg(res.message);
            }
        }
    })
}
