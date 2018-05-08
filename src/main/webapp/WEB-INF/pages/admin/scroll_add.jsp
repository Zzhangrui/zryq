<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/5/8
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/css/validate.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/zTree/v3/css/zTreeStyle/zTreeStyle.css"/>
    <!--&lt;!&ndash;[if lt IE be9]>-->
    <!--<script src="Public/Admin/js/html5shiv.min.js"></script>-->
    <!--<script src="Public/Admin/js/respond.min.js"></script>-->
    <!--<![endif]&ndash;&gt;-->
    <style>
        .table-bordered > thead > tr > th {
            border-bottom-width: 1px;
            text-align: center;
            font-weight: 600;
        }
        li {
            display: flow-root;
        }
    </style>
    <title>Scroll配置</title>
</head>
<body>
<form class="layui-form layui-form-pane" style="padding: 5px;margin-left: 110px;" >
    <input type="hidden" name="id" value="${scrollInfo.id}"/>

    <input type="hidden" name="scrollPicPath" id="scrollPicPath" value="${scrollInfo.scrollPicPath}">
    <div class="layui-form-item">
        <label class="layui-form-label">标题</label>
        <div class="layui-input-inline">
            <input type="text" name="scrollTitle" lay-verify="scrollTitle" value="${scrollInfo.scrollTitle}"   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">描述</label>
        <div class="layui-input-inline">
            <input type="text" name="scrollDesc" lay-verify="scrollDesc" value="${scrollInfo.scrollDesc}"   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-upload">
        <button type="button" class="layui-btn" id="scrollPic">上传图片</button>
        <div class="layui-upload-list">
            <img class="layui-upload-img" id="pic-view"<c:if test="${not empty scrollInfo.scrollPicPath }">src="${pageContext.request.contextPath}/${scrollInfo.scrollPicPath}"</c:if>   >
            <p id="demoText"></p>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">关联地址</label>
        <div class="layui-input-inline">
            <input type="text" name="url" lay-verify="" value="${scrollInfo.url}"   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="save">提交</button>
        </div>
    </div>
</form>
<!--主体部分 end-->
<script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
<!--<script src="bootstrap/js/bootstrap.min.js"></script>-->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/admin/js/head_main_nav.js"></script>
<!--解决IE支持placeholder的方法-->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/admin/js/jquery.placeholder.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script>
    layui.use(['form','layer','upload'], function(){
        var form = layui.form, layer = layui.layer, $ = layui.$,upload = layui.upload;
        /*form.verify({
            scrollTitle: function(value){
                if(value.length < 1){
                    return '角色名称不能为空';
                }
            }
        });*/
        var url="${pageContext.request.contextPath}/scroll/${url}";
        //监听保存提交
        form.on('submit(save)', function(data){
            if($("#scrollPicPath").val()==undefined || $("#scrollPicPath").val()==""){
                layer.msg("请上传图片");
                return ;
            }

            $.ajax({
                url:url,
                data:data.field,
                type:'post',
                dataType:'json',
                traditional: true ,
                success: function (res) {
                    if(res.success){
                        layer.msg(res.message);
                        setTimeout(function(){
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                        },2000);
                    }else {
                        layer.alert(res.message);
                    }
                }
            });
            return false;
        });

        //指定允许上传的文件类型
        var uploadInst = upload.render({
            elem: '#scrollPic'
            ,url: '${pageContext.request.contextPath}/upload'
            ,size:20480    //20M
            ,data:{dirPath:"scroll"}
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#pic-view').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                if(res.code =="0"){
                    //var fileHtml = "";
                    //fileHtml = fileHtml + "<a style='margin-left:10px;font-size:16px;'>"+res.fileName+"<i onclick='clearFile()' class='layui-icon' style='font-size: 22px;margin-left: 22px;cursor: pointer;'>&#x1006;</i> </a>";
                    //$("#file-clean").html(fileHtml);
                    $("#scrollPicPath").val(res.url);
                }
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
    });

</script>
</body>
</html>
