<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
    <title>${artilce.artTitle}</title>
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
                    <h5>发布于：<span><fmt:formatDate type="both"
                                                  dateStyle="medium" timeStyle="medium"
                                                  value="${article.publishTime}" /></span></h5>
                    <h5>来源：<span>${article.artFrom}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者：<span>${article.artAuthor}</span></h5>
                    ${article.artContent}
                    <div class="count layui-clear">
                        <span class="pull-left">阅读 <em>${article.readCount}</em></span>
                        <span class="pull-right like" likeCount="${article.id}" likeValue="点赞"><i class="layui-icon layui-icon-praise"></i><em>${article.likeCount}</em></span>
                    </div>
                </div>
            </div>
            <a name="comment"> </a>
            <div class="comt layui-clear">
                <a href="javascript:;" class="pull-left " >评论</a>
                <a href="javascript:;" class="pull-right comment-event" artId="${article.id}">写评论</a>
            </div>
            <div id="LAY_comment2">
            </div>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"/>
<script src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/assets/blog/js/common.js"></script>
<script src="${pageContext.request.contextPath}/assets/blog/js/detail.js"></script>
<script>
layui.config({
    base: '${pageContext.request.contextPath}/assets/blog/js/'
}).use('common');
var contextPath = '${pageContext.request.contextPath}';
var id = "${article.id}";
initLikeEvent();
</script>
</body>
</html>
