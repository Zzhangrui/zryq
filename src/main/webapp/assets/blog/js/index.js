/**
 * 填充数据
 * */
function init(pageNum) {
    $.ajax({
        url: contextPath + '/blog/data',
        type: 'post',
        dataType: 'json',
        data: {artTitle: $("#title").val(), pageNum: pageNum},
        success: function (res) {
            var data = res.data;
            var len = data.length;
            initNum = pageNum;  //当前页码存到全局变量中
            //加载分页 自定义样式
            laypage.render({
                elem: 'page'
                , count: res.count
                , theme: '#1E9FFF'
                , curr: pageNum
                , jump: function (obj, first) {
                    if (!first) {
                        init(obj.curr);
                    }
                }
            });
            //加载数据
            var html = "";
            if (data.length > 0) {
                var items = data.forEach(function (item, index, data) {
                    html += '<div class="item">\n' +
                        '                <div class="item-box  layer-photos-demo3 layer-photos-demo">\n' +
                        '                    <h3><a href="' + contextPath + '/blog/detail/' + item.id + '">' + item.artTitle + '</a></h3>\n' +
                        '                    <h5>发布于：<span>' + item.publishTime + '</span></h5>\n' +
                        '                    <p>' + item.artDigest + '</p>\n';
                    if (null != item.firstPicPath) {
                        html += '                    <img src="' + item.firstPicPath + '" alt="">\n';
                    }
                    html += '                </div>\n' +
                        '                <div class="comment count">\n' +
                        '                    <a href="javascript:;" artId="' + item.id + '" class="comment-event">评论</a>\n' +
                        '                    <a href="javascript:;" likeCount="' + item.id + '"class="like" likeValue="点赞">点赞</a>\n' +
                        '                </div>\n' +
                        '            </div>'
                })
            } else {
                html = '<div class="item" style="text-align: center"><h2>没有你想看的信息，不要瞎搜索、谢谢</h2></div>'
            }
            $(".art-content").html(html);
            //绑定点赞
            initLikeEvent();
        }
    })
};

$(function () {
    $("#title").val(title);
    //加载数据
    init(initNum, title);

    $("#search").click(function () {
        init(initNum);
    });

    $(".announcement").click(function () {
        layer.msg('把思念寄托远方 ，愿你无恙', {
            icon: 6
            , time: 3000
        })
    })
});

