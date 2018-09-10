<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/8/28
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fly/css/global.css">
</head>
<body style="margin-top: 65px;">

<jsp:include page="head.jsp"/>

<div class="fly-home fly-panel" style="background-image: url();">
    <img src="${pageContext.request.contextPath}/${friendUser.imgPath}" alt="贤心">
    <i class="iconfont icon-renzheng" title=""></i>
    <h1>
        ${friendUser.nickName}
        <c:if test="${friendUser.sex eq 0}">
            <i class="iconfont icon-nan"></i>
        </c:if>
        <c:if test="${friendUser.sex eq 1}">
            <i class="iconfont icon-nv"></i>
        </c:if>
        <i class="layui-badge fly-badge-vip">VIP${friendUser.level}</i>
        <!--
        <span style="color:#c00;">（管理员）</span>
        <span style="color:#5FB878;">（社区之光）</span>
        <span>（该号已被封）</span>
        -->
    </h1>

    <p style="padding: 10px 0; color: #5FB878;">认证信息：普通用户</p>

    <p class="fly-home-info">
        <i class="iconfont icon-kiss" title="飞吻"></i><span style="color: #FF7200;">66666 飞吻</span>
        <i class="iconfont icon-shijian"></i><span> <fmt:formatDate pattern="yyyy-MM-dd"
                                                                    value="${friendUser.createTime}"/> 加入</span>
        <i class="iconfont icon-chengshi"></i><span>来自${friendUser.address}</span>
    </p>

    <p class="fly-home-sign">${friendUser.sign}</p>

    <c:if test="${sessionScope.flyUser.id eq friendUser.id}">

    </c:if>
    <div class="fly-sns" data-user="">
        <a href="javascript:;" class="layui-btn layui-btn-warm " id="attention"><i class="layui-icon layui-icon-star" style="font-size: 16px"></i>关注</a>
        <a href="javascript:;" class="layui-btn layui-btn-danger " id="attention-cancel" style="display: none"><i class="layui-icon layui-icon-star-fill" style="font-size: 16px"></i>取消关注</a>
        <a href="javascript:;" class="layui-btn layui-btn-normal fly-imActive"
           id="chat"><i class="layui-icon layui-icon-reply-fill" style="font-size: 16px"></i>留言</a>
    </div>

</div>

<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md6 fly-home-jie">
            <div class="fly-panel">
                <h3 class="fly-panel-title">${friendUser.nickName} 最近的博客</h3>

                <ul class="jie-row" style="min-height: 410px">
                    <c:if test="${not empty articleList}">
                        <c:forEach items="${articleList}" var="article">
                            <li>
                                <a href="${pageContext.request.contextPath}/blog/detail/${article.id}"
                                   class="jie-title"
                                   style="color: #4F99CF;"> ${article.artTitle}</a>
                                <i style="float: right"><fmt:formatDate
                                        value="${article.publishTime}" pattern="yyyy-MM-dd"/></i>
                                    <%--<em class="layui-hide-xs">1136阅/27答</em> --%>
                            </li>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty articleList}">
                        <div class="fly-none"
                             style="min-height: 50px; padding:30px 0; height:auto;"><i
                                style="font-size:14px;">没有发表任何博客</i></div>
                    </c:if>

                </ul>
            </div>
        </div>

        <div class="layui-col-md6 fly-home-da">
            <div class="fly-panel">
                <h3 class="fly-panel-title">${friendUser.nickName} 最近的帖子</h3>
                <ul class="home-jieda" style="min-height: 410px">
                    <c:if test="${not empty postList}">
                        <c:forEach items="${postList}" var="flyPost">
                            <li>
                                <a href="${pageContext.request.contextPath}/fly/post/detail/${flyPost.id}"
                                   class="jie-title"> ${flyPost.title}</a>
                                <i style="float: right;font-size: 12px; color: #999;font-style: normal;"><fmt:formatDate value="${flyPost.updateTime}" pattern="yyyy-MM-dd"/></i>
                                    <%--<em class="layui-hide-xs">1136阅/27答</em> --%>
                            </li>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty postList}">
                        <div class="fly-none"
                             style="min-height: 50px; padding:30px 0; height:auto;"><i
                                style="font-size:14px;">没有发表任何帖子</i></div>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>

<jsp:include page="foot.jsp"/>


<script src="${pageContext.request.contextPath}/assets/fly/js/center.home.js"></script>
<script>
    var contextPath = "${pageContext.request.contextPath}";
    var receiveId  = "${friendUser.id}";
</script>

</body>
</html>
