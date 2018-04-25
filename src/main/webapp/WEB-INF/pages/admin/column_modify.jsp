<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/11/2
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>栏目编辑</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css"/>
</head>
<body>
<div>
    <form class="layui-form" action="" style="padding: 20px;">
        <input type="hidden" value="${column.id}" name="id">
        <div class="layui-form-item">
            <label class="layui-form-label">栏目名称</label>
            <div class="layui-input-block">
                <input type="text" name="coluName" value="${column.coluName}" value="" lay-verify="title" autocomplete="off" placeholder="请输入站点名称" class="layui-input">
            </div>
        </div>


        <%--<div class="layui-form-item">
            <label class="layui-form-label">栏目类型</label>
            <div class="layui-input-block">
                <input type="radio" name="coluType" value="1" title="默认栏目" disabled="">
                <input type="radio" name="coluType" value="2" title="灵活栏目" checked="">
            </div>
        </div>--%>

        <div class="layui-form-item">
            <label class="layui-form-label">栏目图片</label>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test1" style="float: left;">选择图片</button>
                <img id="colu-logo" width="254" height="80" style="margin-left: 10px;" <c:if test="${not empty column.coluImgPath}"> src="${pageContext.request.contextPath}/${column.coluImgPath}" </c:if>>
                <div class="layui-upload-list">
                    <img class="layui-upload-img" id="demo1">
                    <p id="demoText"></p>

                </div>
            </div>
        </div>



        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">栏目描述</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入描述信息" id="digest" name="coluDes" class="layui-textarea">${column.coluDes}</textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
            </div>
        </div>
    </form>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
<script>

    var domain = document.domain;
    console.log(domain);
    layui.use(['form', 'layedit', 'laydate', 'layer', 'jquery', 'upload'], function () {
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate
                , upload = layui.upload;
        var $ = layui.$; //重点处


        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            ,url: '${pageContext.request.contextPath}/upload/'
            ,data: {"dirPath":"colu_logo"}
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                /*obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）

                });*/
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                //上传成功
                console.log(res);

                //todo 域名地址
                var logoSrc = "http://localhost:8080/cms/"+res.url;
                $("#colu-logo").attr('src',logoSrc);
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });


        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function (data) {
            layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(demo1)', function (data) {
            $.ajax({
                url: "${pageContext.request.contextPath}/column/${url}",
                data: data.field,
                type: 'post',
                dataType: 'json',
                success: function (res) {
                    if (res.success) {
                        layer.msg("编辑成功，2秒后页面自动刷新");
                        setTimeout(function () {
                            //top.location.reload();  //直接刷新父页面
                            //当你在iframe页面关闭自身时
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                        }, 2000);
                    } else {
                        layer.alert("提交失败，请刷新后再试");
                    }
                }
            });
            return false;
        });


    });


</script>
</html>
