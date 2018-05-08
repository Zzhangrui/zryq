<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/10/19
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/layui/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/layui/jquery.placeholder.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/jquery.validation/1.14.0/jquery.validate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/jquery.validation/1.14.0/validate-methods.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/jquery.validation/1.14.0/messages_zh.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/admin/js/jquery.form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/admin/js/xadmin.js"></script>
</head>
<body class="login-bg">

<div class="login">
    <div class="message">cms-后台登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form" id="loginForm" action="${pageContext.request.contextPath }/dologin">
        <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit" id="login">
        <hr class="hr20" >
    </form>
</div>

<script>
    var layer = "";
    var layerIndex = "";
    layui.use(['layer'], function () {
        layer = layui.layer;
    });

    $(function(){
        $('input,textarea').placeholder();

        $("#login").click(function(){
            layerIndex = layer.load(1);
        });

        $("#loginForm").validate({
            rules:{
                username:{
                    required:true,
                    minlength:2,
                    maxlength:255
                },
                password:{
                    required:true,
                    maxlength:255
                },

            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                $("#loginForm").ajaxSubmit({
                    dataType: 'json',
                    //type: 'post', // 提交方式 get/post
                    // url: 'your url', // 需要提交的 url
                    success: function(res) { // data 保存提交后返回的数据，一般为 json 数据
                        // 此处可对 data 作相关处理
                        //var index = parent.layer.getFrameIndex(window.name);
                        //parent.$('#ref').click();
                        if(res.success){
                            top.location = "${pageContext.request.contextPath}/index";
                        }else{
                            layer.close(layerIndex);
                            parent.layer.msg(res.message,{icon:2,time:3000});
                        }
                    }
                });
            }
        });
    });


</script>


<!-- 底部结束 -->

</body>
</html>
