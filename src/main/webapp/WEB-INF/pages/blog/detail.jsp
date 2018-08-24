<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/8/24
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>评论-闲言轻博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/blog/css/mian.css">
</head>
<body class="lay-blog">
<jsp:include page="head.jsp"/>
<div class="container-wrap">
    <div class="container container-message container-details">
        <div class="contar-wrap">
            <div class="item">
                <div class="item-box  layer-photos-demo1 layer-photos-demo">
                    <h3><a href="details.html">${artilce.artTitle}</a></h3>
                    <h5>发布于：<span>${article.publishTime}</span></h5>
                    <h5>来源：<span>${article.artFrom}</span>作者：<span>${article.artAuthor}</span></h5>
                    ${article.artContent}
                    <div class="count layui-clear">
                        <span class="pull-left">阅读 <em>${article.readCount}</em></span>
                        <span class="pull-right like" likeCount="${article.id}" likeValue="点赞"><i class="layui-icon layui-icon-praise"></i><em>${article.likeCount}</em></span>
                    </div>
                </div>
            </div>
            <a name="comment"> </a>
            <div class="comt layui-clear">
                <a href="javascript:;" class="pull-left">评论</a>
                <a href="comment.html" class="pull-right">写评论</a>
            </div>
            <div id="LAY-msg-box">
                <div class="info-item">
                    <img class="info-img" src="../res/static/images/info-img.png" alt="">
                    <div class="info-text">
                        <p class="title count">
                            <span class="name">一片空白</span>
                            <span class="info-img like"><i class="layui-icon layui-icon-praise"></i>5.8万</span>
                        </p>
                        <p class="info-intr">父爱如山，不善表达。回想十多年前，总记得父亲有个宽厚的肩膀，小小的自己跨坐在上面，越过人山人海去看更广阔的天空，那个时候期望自己有一双翅膀，能够像鸟儿一样飞得高，看得远。虽然父亲有时会和自己开玩笑，但在做错事的时候会受到严厉的训斥。父亲有双粗糙的大手掌。</p>
                    </div>
                </div>
                <div class="info-item">
                    <img class="info-img" src="../res/static/images/info-img.png" alt="">
                    <div class="info-text">
                        <p class="title count">
                            <span class="name">一片空白</span>
                            <span class="info-img like"><i class="layui-icon layui-icon-praise"></i>5.8万</span>
                        </p>
                        <p class="info-intr">父爱如山，不善表达。回想十多年前，总记得父亲有个宽厚的肩膀，小小的自己跨坐在上面，越过人山人海去看更广阔的天空，那个时候期望自己有一双翅膀，能够像鸟儿一样飞得高，看得远。虽然父亲有时会和自己开玩笑，但在做错事的时候会受到严厉的训斥。父亲有双粗糙的大手掌。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"/>
<script src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/assets/blog/js/common.js"></script>
<script>
layui.config({
    base: '${pageContext.request.contextPath}/assets/blog/js/'
}).use('index');
var contextPath = '${pageContext.request.contextPath}';
initLikeEvent();
</script>
</body>
</html>
