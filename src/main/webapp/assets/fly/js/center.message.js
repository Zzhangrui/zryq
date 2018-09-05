var laypage ="";
var element = "";
var initPageNum ="";
layui.use(['form', 'layer', 'element', 'laypage'], function () {
    var $ = layui.jquery
        , form = layui.form
        , layer = layui.layer
    ;
    laypage = layui.laypage;
    element = layui.element;
    getMessage(0);

    $("#clean-message").on('click',function () {
        layer.msg("正在开发中")
    })
});

function getMessage(pageNum) {
    $.ajax({
        url:contextPath+"/fly/user/message",
        type:'post',
        dataType:'json',
        success:function (res) {
           if(res.list.length>0){
               var data = res.list;
               var len = data.length;
               initPageNum = pageNum;  //当前页码存到全局变量中
               //自定义样式
               laypage.render({
                   elem: 'LAY_page-message'
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
               for( i in data){
                   var message = data[i];
                   html+='<div class="layui-collapse" >\n' +
                       '  <div class="layui-colla-item">\n' +
                       '    <h2 class="layui-colla-title">'+message.sendUserName+'<em class="" style="float: right">'+data[i].createTime+'</em></h2>' +
                       '    <div class="layui-colla-content "><p>'+message.content+'</p>';

                       if(data[i].replyList.length>0){
                       html = getHtml(data[i].replyList,html);
                       }
                   html+= '<button class="layui-btn layui-btn-warm reply" sendUserId ='+message.sendUserId+' parentId = '+message.id+'  style="margin-top: 10px">回复</button></div></div></div>'
                   +'<hr class="layui-bg-cyan">'
               }
               $("#LAY_minemsg").html(html);
               element.render('collapse');//重新渲染折叠包

               //绑定监听
               $(".reply").on('click',function () {
                   var parentId = $(this).attr("parentId");
                   var receiveId = $(this).attr("sendUserId");
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
                       ' <button class="layui-btn layui-btn-normal" id="subMessage" onclick="submitMessage('+receiveId+','+parentId+')">提交</button>' +
                       '</div>'
                   });
               })
           }
        }
    })
}

function getHtml(data,html){
    if(data!=null && data.length>0){
        for( i in data){
            html+='<div class="layui-collapse">\n' +
                '  <div class="layui-colla-item">\n' +
                '    <h2 class="layui-colla-title">'+data[i].sendUserName+'<em class="" style="float: right">'+data[i].createTime+'</em></h2>' +
                '    <div class="layui-colla-content "><p>'+data[i].content+'</p>'

            ;
            html = getHtml(data[i].replyList,html);
            html += '<button class="layui-btn layui-btn-warm reply" sendUserId ='+data[i].sendUserId+' parentId = '+data[i].id+'  style="margin-top: 10px" >回复</button></div></div></div>';
        }
    }
    return html;
}

//提交评论
function submitMessage(receiveId,parentId) {
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
        data: {receiveId: receiveId,parentId:parentId, content: $("#content").val()},
        success: function (res) {
            layer.close(index);
            if (res.code == '1000') {
                layer.msg("留言成功");
                getMessage(initPageNum);
                setTimeout(function () {
                    layer.closeAll();
                }, 2000);
            } else {
                layer.msg(res.message);
            }
        }
    })
}
