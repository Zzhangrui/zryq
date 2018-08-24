var element = ""
    , form = ""
    , laypage = ""
    , laytpl = "";
//全局页面
var initNum = "0";
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
    exports('index', {});
});

function initLikeEvent(){
//点赞
    //绑定点赞
    $(".like").on('click', function () {
        var dom = $(this);
        if(dom.attr('likeValue') == '点赞'){
            $.ajax({
                url:contextPath+"/blog/doLike",
                type:'post',
                dataType:'json',
                data:{id:$(this).attr("likeCount")},
                success:function () {
                    layer.msg('点赞成功', {
                        icon: 1
                        , time: 1000
                    });
                    dom.attr("likeValue","已点赞");
                    dom.text("已点赞");
                    dom.css('color','red');
                }
            });
        }else{
            layer.msg('请勿重复点赞', {
                icon: 2
                , time: 1000
            })
        }
    });
}
