<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/9/4
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>我的消息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fly/css/global.css">
</head>
<body>


<jsp:include page="head.jsp"/>

<div class="layui-container fly-marginTop fly-user-main">
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
        <li class="layui-nav-item">
            <a href="home.html">
                <i class="layui-icon">&#xe609;</i>
                我的主页
            </a>
        </li>
        <li class="layui-nav-item">
            <a href="index.html">
                <i class="layui-icon">&#xe612;</i>
                用户中心
            </a>
        </li>
        <li class="layui-nav-item">
            <a href="set.html">
                <i class="layui-icon">&#xe620;</i>
                基本设置
            </a>
        </li>
        <li class="layui-nav-item layui-this">
            <a href="message.html">
                <i class="layui-icon">&#xe611;</i>
                我的消息
            </a>
        </li>
    </ul>

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>


    <div class="fly-panel fly-panel-user" pad20>
        <div class="layui-tab layui-tab-brief" lay-filter="user" id="LAY_msg" style="margin-top: 15px;">
            <button class="layui-btn layui-btn-danger" id="LAY_delallmsg">清空全部消息</button>
            <div  id="LAY_minemsg" style="margin-top: 10px;">
                <!--<div class="fly-none">您暂时没有最新消息</div>-->
                <ul class="mine-msg">
                    <li data-id="123">
                        <blockquote class="layui-elem-quote">
                            <a href="/jump?username=Absolutely" target="_blank"><cite>Absolutely</cite></a>回答了您的求解<a target="_blank" href="/jie/8153.html/page/0/#item-1489505778669"><cite>layui后台框架</cite></a>
                        </blockquote>
                        <p><span>1小时前</span><a href="javascript:;" class="layui-btn layui-btn-small layui-btn-danger fly-delete">删除</a></p>
                    </li>
                    <li data-id="123">
                        <blockquote class="layui-elem-quote">
                            系统消息：欢迎使用 layui
                        </blockquote>
                        <p><span>1小时前</span><a href="javascript:;" class="layui-btn layui-btn-small layui-btn-danger fly-delete">删除</a></p>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</div>



<jsp:include page="foot.jsp"/>


<script src="${pageContext.request.contextPath}/assets/fly/js/center.message.js"></script>


<script>
</script>

</body>
</html>
