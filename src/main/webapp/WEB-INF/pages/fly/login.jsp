<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/8/27
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登入</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fly/css/global.css">
</head>
<body>

<jsp:include page="head.jsp"/>

<div class="layui-container fly-marginTop">
    <div class="fly-panel fly-panel-user" pad20>
        <div class="layui-tab layui-tab-brief" lay-filter="user">
            <ul class="layui-tab-title">
                <li class="layui-this">登入</li>
                <li>注册</li>
                <li>找回密码</li>
            </ul>
            <div class=" layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
                <div class="layui-tab-item layui-show">
                    <div class="layui-form layui-form-pane">
                        <form method="post" class="layui-form" id="login-form">
                            <div class="layui-form-item">
                                <label for="L_email" class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="L_email" name="email" lay-verify="email"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_pass" class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="L_pass" name="password"
                                           lay-verify="required" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_vercode" class="layui-form-label">人类验证</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="L_vercode" name="verifyCode"
                                           lay-verify="required" placeholder="请输入后面的验证码"
                                           autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid">
                                    <span style="color: #c00;"><img id="l-ver-code" code-type="login"
                                                                    class="verify-code"
                                                                    style="margin-top: -8px;height: 35px;"
                                                                    src="${pageContext.request.contextPath}/verifyCode/captcha/login"/></span>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn" lay-filter="login" lay-submit>立即登录
                                </button>
                                <span style="padding-left:20px;">
                                    <a id="forget-a" style="cursor: pointer">忘记密码？</a>
                                    </span>
                            </div>
                            <div class="layui-form-item fly-form-app">
                                <span>或者使用社交账号登入</span>
                                <a href=""
                                   onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})"
                                   class="iconfont icon-qq" title="QQ登入"></a>
                                <a href=""
                                   onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})"
                                   class="iconfont icon-weibo" title="微博登入"></a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="layui-tab-item ">
                    <div class="layui-form layui-form-pane">
                        <form method="post" class="layui-form" id="register-form">
                            <div class="layui-form-item">
                                <label for="r_email" class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="r_email" name="email" lay-verify="email"
                                           autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">将会成为您唯一的登入名</div>
                            </div>
                            <div class="layui-form-item">
                                <label for="r_username" class="layui-form-label">昵称</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="r_username" name="nickName"
                                           lay-verify="required" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="r_pass" class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="r_pass" name="password"
                                           lay-verify="required" autocomplete="off"
                                           class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                            </div>
                            <div class="layui-form-item">
                                <label for="r_repass" class="layui-form-label">确认密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="r_repass" name="rePassword"
                                           lay-verify="required" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_vercode" class="layui-form-label">人类验证</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="r_vercode" name="verifyCode"
                                           lay-verify="required" placeholder="请输入后面的验证码"
                                           autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid">
                                    <span style="color: #c00;"><img id="r-ver-code" code-type="register"
                                                                    class="verify-code"
                                                                    style="margin-top: -8px;height: 35px;"
                                                                    src="${pageContext.request.contextPath}/verifyCode/captcha/register"/></span>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn" lay-filter="register" lay-submit>立即注册
                                </button>
                            </div>
                            <div class="layui-form-item fly-form-app">
                                <span>或者直接使用社交账号快捷注册</span>
                                <a href=""
                                   onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})"
                                   class="iconfont icon-qq" title="QQ登入"></a>
                                <a href=""
                                   onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})"
                                   class="iconfont icon-weibo" title="微博登入"></a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="layui-tab-item ">
                    <div class="layui-form layui-form-pane">
                        <form method="post" class="layui-form" id="forget-form">
                            <div class="layui-form-item">
                                <label for="f_email" class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="f_email" name="email" required
                                           lay-verify="required" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="f_vercode" class="layui-form-label">人类验证</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="f_vercode" name="verifyCode" required
                                           lay-verify="required" placeholder="请回答后面的问题"
                                           autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid">
                                    <span style="color: #c00;"><img id="f-ver-code" code-type="forget"
                                                                    class="verify-code"
                                                                    style="margin-top: -8px;height: 35px;"
                                                                    src="${pageContext.request.contextPath}/verifyCode/captcha/forget"/></span>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn" alert="1" lay-filter="forget" lay-submit>
                                    提交
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="foot.jsp"/>

<script src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/fly/js/login.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
<script>
    var contextPath = "${pageContext.request.contextPath}";
</script>

</body>
</html>
