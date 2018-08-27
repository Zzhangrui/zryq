var pageNum = 0;
layui.use('flow', function() {
    var flow = layui.flow;
    flow.load({
        elem: '#LAY_comment2' //流加载容器
        ,isAuto: false
        ,isLazyimg: false
        ,done: function(page, next){ //加载下一页
            console.log("aaa");
            $.ajax({
                url:contextPath+"/blog/getComment",
                data:
                    {id:id,
                    pageNum:page
                    },
                type:'post',
                dataType:'json',
                success:function (res) {
                    setTimeout(function(){
                        var lis = [];
                        var data = res.list;
                        for(var i = 0; i < data.length; i++){
                            var comment = data[i];
                            var html = '<div class="info-item">\n' +
                                '                    <img class="info-img" src="'+contextPath+'/assets/blog/images/kk.jpg" height="68" width="68" alt="">\n' +
                                '                    <div class="info-text">\n' +
                                '                        <p class="title count">\n' +
                                '                            <span class="name">'+comment.userIp+'</span>\n' +
                                '                            <span class="info-img like"><i class="layui-icon layui-icon-praise"></i>5.8万</span>\n' +
                                '                        </p>\n' +
                                '                        <p class="info-intr">'+comment.commContent+'</p>\n' +
                                '                    </div>\n' +
                                '                </div>'
                            lis.push(html)
                        }
                        next(lis.join(''), page < res.pages); //假设总页数为 6
                    }, 500);
                }
            })

        }
    });
});
