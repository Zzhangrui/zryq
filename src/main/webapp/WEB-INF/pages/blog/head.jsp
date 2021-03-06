<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/8/24
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="header">
    <div class="header-wrap">
        <h1 class="logo pull-left">
            <a href="${pageContext.request.contextPath}/blog/index">
                <img src="${pageContext.request.contextPath}/assets/blog/images/logo.png" alt="" class="logo-img">
                <img src="${pageContext.request.contextPath}/assets/blog/images/logo-text.png" alt="" class="logo-text">
            </a>
        </h1>
        <form class="layui-form blog-seach pull-left" action="">
            <div class="layui-form-item blog-sewrap">
                <div class="layui-input-block blog-sebox">
                    <i class="layui-icon layui-icon-search" id="search"></i>
                    <input type="text" name="title" id="title" lay-verify="title" autocomplete="off"  class="layui-input">
                </div>
            </div>
        </form>
        <div class="blog-nav pull-right">
            <ul class="layui-nav pull-left">
                <li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath}/blog/index">首页</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/blog/index">留言</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/blog/index">关于</a></li>
            </ul>
            <a href="${pageContext.request.contextPath}/fly/user/index" class="personal pull-left">
                <i class="layui-icon layui-icon-username"></i>
            </a>
        </div>
        <div class="mobile-nav pull-right" id="mobile-nav">
            <a href="javascript:;">
                <i class="layui-icon layui-icon-more"></i>
            </a>
        </div>
    </div>
    <ul class="pop-nav" id="pop-nav">
        <li><a href="${pageContext.request.contextPath}/blog/index">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/blog/index">留言</a></li>
        <li><a href="${pageContext.request.contextPath}/blog/index">关于</a></li>
    </ul>
</div>
<script type="text/javascript">
    function index() {
        var artTitle = document.getElementById("title").value;
        window.location.href='${pageContext.request.contextPath}/blog/index?artTitle='+artTitle;
    }
</script>
</html>
