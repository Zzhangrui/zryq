var laypage ="";
layui.use(['form', 'layer', 'element', 'laypage'], function () {
    var $ = layui.jquery
        , element = layui.element
        , form = layui.form
        , layer = layui.layer
    ;
    laypage = layui.laypage;

    $(".layui-clear>li,.end-excellent>a").on('click',function () {
        var dom = $(this);
        var allDom = dom.siblings();
        console.log(allDom);
        $(this).siblings().each(function (i, item) {
            $(item).removeClass("layui-this");
        });
        dom.addClass("layui-this");
        getPost(0);
    });

    getPost(0);
});
var initPageNum = "";

function getPost(pageNum) {
    var cateId = $(".layui-clear>li.layui-this").attr("cateId");
    var end = $(".end.layui-this").attr("end");
    if(undefined == cateId){
        cateId = null;
    }
    if(undefined == end){
        end = null;
    }
    var excellent = null;
    if($(".excellent").hasClass("layui-this")){
        excellent = 1;
    }
    var loadIndex = layer.load(1, {
        shade: [0.1,'#fff'] //0.1透明度的白色背景
    });
    $.ajax({
        url: contextPath + "/fly/post/data",
        type: 'post',
        dataType: 'json',
        data: {pageNum: pageNum,categoryId:cateId,end:end,excellent:excellent},
        success: function (res) {
            var data = res.list;
            console.log(res);
            var len = data.length;
            initPageNum = pageNum;  //当前页码存到全局变量中
            //自定义样式
            laypage.render({
                elem: 'LAY_page-post'
                , count: res.total
                , theme: '#1E9FFF'
                , curr: pageNum
                , jump: function (obj, first) {
                    if (!first) {
                        getPost(obj.curr);
                    }
                }
            });
            var html = "";
            if (len > 0) {
                for (var i = 0; i < len; i++) {
                    var post = data[i];
                    var end = post.end==1?"已结":"未结";
                    html += '<li>\n' +
                        '                        <a href="'+contextPath+'/fly/post/detail/'+post.id+'" class="fly-avatar">\n' +
                        '                            <img src="'+contextPath+'/'+post.createUserImg+'"\n' +
                        '                                 alt="贤心">\n' +
                        '                        </a>\n' +
                        '                        <h2>\n' +
                        '                            <a class="layui-badge">'+post.categoryName+'</a>\n' +
                        '                            <a href="'+contextPath+'/fly/post/detail/'+post.id+'">'+post.title+'</a>\n' +
                        '                        </h2>\n' +
                        '                        <div class="fly-list-info">\n' +
                        '                            <a href="'+contextPath+'/fly/post/detail/'+post.id+'" link>\n' +
                        '                                <cite>'+post.createUserName+'</cite>\n' +
                        '                                <!--\n' +
                        '                                <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>\n' +
                        '                                <i class="layui-badge fly-badge-vip">VIP3</i>\n' +
                        '                                -->\n' +
                        '                            </a>\n' +
                        '                            <span>'+post.updateTime+'</span>\n' +

                        '                            <span class="layui-badge fly-badge-accept layui-hide-xs">'+end+'</span>' +
                       /* '                            <span class="fly-list-nums">\n' +
                        '                                <i class="iconfont icon-pinglun1" title="回答"></i> 66\n' +
                        '                              </span>\n' +*/
                        '                        </div>\n' +
                        '                        <div class="fly-list-badge">\n' ;
                        if(1==post.top){
                            html += '                            <span class="layui-badge layui-bg-black">置顶</span>\n' ;
                        }
                        if(1==post.excellent){
                            html += '                            <span class="layui-badge layui-bg-red">精帖</span>' ;
                        }

                        html +='                        </div>\n' +
                        '                    </li>'
                }
                $("#post-list").html(html);
            } else {
                html = '<li>\n' +
                    '                            <a class="jie-title" target="_blank">尚未发布帖子</a>\n' +
                    '                        </li>'
                $("#post-list").html(html);
            }
            layer.close(loadIndex);
        }
    })
}


