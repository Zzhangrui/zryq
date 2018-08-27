<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/8/24
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Z&Q轻博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/blog/css/mian.css">
</head>
<body class="lay-blog">
<jsp:include page="head.jsp"/>
<div class="container-wrap">
    <div class="container">
        <div class="contar-wrap">
            <h4 class="item-title">
                <p class="announcement"><i class="layui-icon layui-icon-speaker"></i>公告：<span style="cursor: pointer">遇见你、很高兴。</span></p>
            </h4>
            <div class="art-content">
            <div class="item">
                <div class="item-box  layer-photos-demo1 layer-photos-demo">
                    <h3><a href="details.html">拥有诗意的心态,才能拥有诗意的生活</a></h3>
                    <h5>发布于：<span>刚刚</span></h5>
                    <p>父爱如山，不善表达。回想十多年前，总记得父亲有个宽厚的肩膀，小小的自己跨坐在上面，越过人山人海去看更广阔的天空，那个时候期望自己有一双翅膀，能够像鸟儿一样飞得高，看得远。虽然父亲有时会和自己开玩笑，但在做错事的时候会受到严厉的训斥。父亲有双粗糙的大手掌，手把手教我走路、骑车，却会在该放手的时刻果断地放开让自己去大胆尝试，那个时候期望快快长大，能够做自己想做的事，不用受父亲的“控制”。父亲是智慧树，他无所不知、无所不晓，虽然你有十万个为什么，但是也难不倒他。</p>
                    <img src="${pageContext.request.contextPath}/assets/blog/images/item.png" alt="">
                </div>
                <div class="comment count">
                    <a href="details.html#comment">评论</a>
                    <a href="javascript:;" class="like">点赞</a>
                </div>
            </div>
            <div class="item">
                <div class="item-box  layer-photos-demo2 layer-photos-demo">
                    <h3><a href="details.html">拥有诗意的心态,才能拥有诗意的生活</a></h3>
                    <h5>发布于：<span>刚刚</span></h5>
                    <p>父爱如山，不善表达。回想十多年前，总记得父亲有个宽厚的肩膀，小小的自己跨坐在上面，越过人山人海去看更广阔的天空，那个时候期望自己有一双翅膀，能够像鸟儿一样飞得高，看得远。虽然父亲有时会和自己开玩笑，但在做错事的时候会受到严厉的训斥。父亲有双粗糙的大手掌，手把手教我走路、骑车，却会在该放手的时刻果断地放开让自己去大胆尝试，那个时候期望快快长大，能够做自己想做的事，不用受父亲的“控制”。父亲是智慧树，他无所不知、无所不晓，虽然你有十万个为什么，但是也难不倒他。</p>
                    <img src="${pageContext.request.contextPath}/assets/blog/images/item.png" alt="">
                </div>
                <div class="comment count">
                    <a href="details.html#comment">评论</a>
                    <a href="javascript:;" class="like">点赞</a>
                </div>
            </div>
            <div class="item">
                <div class="item-box  layer-photos-demo3 layer-photos-demo">
                    <h3><a href="details.html">拥有诗意的心态,才能拥有诗意的生活</a></h3>
                    <h5>发布于：<span>刚刚</span></h5>
                    <p>父爱如山，不善表达。回想十多年前，总记得父亲有个宽厚的肩膀，小小的自己跨坐在上面，越过人山人海去看更广阔的天空，那个时候期望自己有一双翅膀，能够像鸟儿一样飞得高，看得远。虽然父亲有时会和自己开玩笑，但在做错事的时候会受到严厉的训斥。父亲有双粗糙的大手掌，手把手教我走路、骑车，却会在该放手的时刻果断地放开让自己去大胆尝试，那个时候期望快快长大，能够做自己想做的事，不用受父亲的“控制”。父亲是智慧树，他无所不知、无所不晓，虽然你有十万个为什么，但是也难不倒他。</p>
                    <img src="${pageContext.request.contextPath}/assets/blog/images/item.png" alt="">
                </div>
                <div class="comment count">
                    <a href="details.html#comment">评论</a>
                    <a href="javascript:;" class="like">点赞</a>
                </div>
            </div>
            </div>
        </div>
        <div id="page" style="text-align: center;"></div>
    </div>
</div>
<jsp:include page="foot.jsp"/>
<script src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/assets/blog/js/common.js"></script>
<script src="${pageContext.request.contextPath}/assets/blog/js/index.js"></script>
<script>
   layui.config({
        base: '${pageContext.request.contextPath}/assets/blog/js/'
    }).use('common');
   var contextPath = '${pageContext.request.contextPath}';
   var title = '${title}';
</script>

</body>
</html>
