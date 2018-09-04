<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/8/28
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="fly-header layui-bg-black">
    <div class="layui-container">
        <a class="fly-logo" href="/">
            <img src="${pageContext.request.contextPath}/assets/fly/images/logo.png" alt="layui">
        </a>
        <ul class="layui-nav fly-nav layui-hide-xs">
            <li class="layui-nav-item layui-this">
                <a href="${pageContext.request.contextPath}/fly/post/index"><i class="iconfont icon-jiaoliu"></i>交流</a>
            </li>
            <li class="layui-nav-item">
                <a href="${pageContext.request.contextPath}/blog/index"><i class="layui-icon layui-icon-website"></i>博客</a>
            </li>
            <li class="layui-nav-item">
                <a href="${pageContext.request.contextPath}/fly/user/home/${sessionScope.flyUser.uuid}" target="_blank"><i class="layui-icon layui-icon-home"></i>我的主页</a>
            </li>
        </ul>

        <c:if test="${ empty sessionScope.flyUser}" >
        <ul class="layui-nav fly-nav-user">
            <!-- 未登入的状态 -->
            <li class="layui-nav-item">
                <a class="iconfont icon-touxiang layui-hide-xs" href="user/login.html"></a>
            </li>
            <li class="layui-nav-item">
                <a href="${pageContext.request.contextPath}/fly/login">登入</a>
            </li>
            <li class="layui-nav-item">
                <a href="${pageContext.request.contextPath}/fly/login">注册</a>
            </li>
            <li class="layui-nav-item layui-hide-xs">
                <a href="${pageContext.request.contextPath}/fly/login" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" title="QQ登入" class="iconfont icon-qq" id="qqLogin"></a>
            </li>
            <li class="layui-nav-item layui-hide-xs">
                <a href="/app/weibo/" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" title="微博登入" class="iconfont icon-weibo"></a>
            </li>
        </ul>
        </c:if>
        <c:if test="${not empty sessionScope.flyUser}" >
        <ul class="layui-nav fly-nav-user">
            <!-- 登入后的状态 -->
            <li class="layui-nav-item">
                <a class="fly-nav-avatar" href="javascript:;">
                    <cite class="layui-hide-xs">${flyUser.nickName}</cite>
                    <i class="iconfont icon-renzheng layui-hide-xs" title="认证信息：普通用户"></i>
                    <i class="layui-badge fly-badge-vip layui-hide-xs">VIP${flyUser.level}</i>
                    <img src="${pageContext.request.contextPath}/${flyUser.imgPath}">
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/fly/user/set"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/fly/user/index"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息<span id="unRead" class="layui-badge" style="display:none;height: 13px;line-height: 15px;margin: -6px 0px 0">6</span></a></dd>
                    <dd><a href="${pageContext.request.contextPath}/fly/user/home/${sessionScope.flyUser.uuid}"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
                    <hr style="margin: 5px 0;">
                    <dd><a href="${pageContext.request.contextPath}/fly/logout" style="text-align: center;">退出</a></dd>
                </dl>
            </li>
        </ul>
        </c:if>
    </div>
</div>
</body>
<%--<script type="text/javascript"  charset="utf-8"
        src="http://connect.qq.com/qc_jssdk.js"
        data-appid="1107805874"
        data-redirecturi="http://localhost:8088/cms/fly/user/index"

>
</script>
<script type="text/javascript">
    //调用QC.Login方法，指定btnId参数将按钮绑定在容器节点中
    QC.Login({
            //btnId：插入按钮的节点id，必选
            btnId:"qqLogin",
            //用户需要确认的scope授权项，可选，默认all
            scope:"all"
        }, function(reqData, opts){//登录成功

        console.log(opts);
            //根据返回数据，更换按钮显示状态方法
            var dom = document.getElementById(opts['btnId']),
                _logoutTemplate=[
                    //头像
                    '<span><img src="{figureurl}" class="{size_key}"/></span>',
                    //昵称
                    '<span>{nickname}</span>',
                    //退出
                    '<span><a href="javascript:QC.Login.signOut();">退出</a></span>'
                ].join("");
            dom && (dom.innerHTML = QC.String.format(_logoutTemplate, {
                nickname : QC.String.escHTML(reqData.nickname), //做xss过滤
                figureurl : reqData.figureurl
            }));
        }, function(opts){//注销成功
            alert('QQ登录 注销成功');
        }
    );

</script>--%>
<script src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/common/tool.js"></script>
<script src="${pageContext.request.contextPath}/assets/fly/js/head.js"></script>
<script>
    var contextPath = "${pageContext.request.contextPath}";
</script>
</html>
