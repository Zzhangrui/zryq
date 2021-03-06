var laypage ="";
layui.use(['form', 'layer', 'element', 'laypage'], function () {
    var $ = layui.jquery
        , element = layui.element
        , form = layui.form
        , layer = layui.layer
        ;
    laypage = layui.laypage;
    getSelfArticle(0);
    getSelfLike(0);
    getPost(0);
});

var selfArticlePageNum = "";
var selfLikePageNum = "";
var postPageNum = "";

function getSelfArticle(pageNum) {
    $.ajax({
        url: contextPath + "/fly/user/selfArticle",
        type: 'post',
        dataType: 'json',
        data: {pageNum: pageNum},
        success: function (res) {
            var data = res.list;
            console.log(res);
            var len = data.length;
            selfArticlePageNum = pageNum;  //当前页码存到全局变量中
            //自定义样式
            laypage.render({
                elem: 'LAY_page-article'
                , count: res.total
                , theme: '#1E9FFF'
                , curr: pageNum
                , jump: function (obj, first) {
                    if (!first) {
                        getSelfArticle(obj.curr);
                    }
                }
            });
            var html = "";
            if (len > 0) {
                $("#total-article").html(res.total);
                for (var i = 0; i < len; i++) {
                    var article = data[i];
                    html += '<li>\n' +
                        '                            <a class="jie-title" href="'+contextPath+'/blog/detail/'+article.id+'" target="_blank">' + article.artTitle + '</a>\n' +
                        '                            <i>' + article.createTime + '</i>\n' +
                        '                            <a class="mine-edit" href="'+contextPath+'/fly/user/edit'+'?id='+article.id+'"  style="cursor: pointer">编辑</a>\n' +
                        /*'                            <em>661阅/10答</em>\n' +*/
                        '                        </li>'
                }
                $("#self-article").html(html);
            } else {
                $("#total-article").html(0);
                html = '<li>\n' +
                    '                            <a class="jie-title" target="_blank">尚未发布文章</a>\n' +
                    '                        </li>'
                $("#self-article").html(html);
            }
        }
    })
}

function getSelfLike(pageNum) {
    $.ajax({
        url: contextPath + "/fly/user/selfLike",
        type: 'post',
        dataType: 'json',
        data: {pageNum: pageNum},
        success: function (res) {
            var data = res.list;
            var len = data.length;
            selfLikePageNum = pageNum;  //当前页码存到全局变量中
            //自定义样式
            laypage.render({
                elem: 'LAY_page-like'
                , count:  res.total
                , theme: '#1E9FFF'
                , curr: pageNum
                , jump: function (obj, first) {
                    if (!first) {
                        getSelfLike(obj.curr);
                    }
                }
            });
            var html = "";
            if (len > 0) {
                $("#total-like").html(res.total);
                for (var i = 0; i < len; i++) {
                    var article = data[i];
                    html += '<li>\n' +
                        '                            <a class="jie-title"  href="'+contextPath+'/blog/detail/'+article.id+'"  target="_blank">' + article.artTitle + '</a>\n' +
                        '<i>'+article.createTime+'</i> '+
                        '                        </li>'
                }
                $("#self-like").html(html);
            } else {
                $("#total-like").html(0);
                html = '<li>\n' +
                    '                            <a class="jie-title" target="_blank">尚未收藏文章</a>\n' +
                    '                        </li>'
                $("#self-like").html(html);
            }
        }
    })
}

function getPost(pageNum) {
    $.ajax({
        url: contextPath + "/fly/post/data",
        type: 'post',
        dataType: 'json',
        data: {pageNum: pageNum,createUserId:createUserId},
        success: function (res) {
            var data = res.list;
            var len = data.length;
            postPageNum = pageNum;  //当前页码存到全局变量中
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
                $("#total-post").html(res.total);
                for (var i = 0; i < len; i++) {
                    var article = data[i];
                    html += '<li>\n' +
                        '                            <a class="jie-title" href="'+contextPath+'/fly/post/detail/'+article.id+'" target="_blank">' + article.title + '</a>\n' +
                        '                            <i>' + article.createTime + '</i>\n' +
                        '                            <a class="mine-edit" href="'+contextPath+'/fly/post/edit'+'?id='+article.id+'"  style="cursor: pointer">编辑</a>\n' +
                        /*'                            <em>661阅/10答</em>\n' +*/
                        '                        </li>'
                }
                $("#post").html(html);
            } else {
                $("#total-post").html(0);
                html = '<li>\n' +
                    '                            <a class="jie-title" target="_blank">尚未发布帖子</a>\n' +
                    '                        </li>'
                $("#post").html(html);
            }
        }
    })
}

