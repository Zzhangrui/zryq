<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/6/21
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title></title>
</head>
<body>
<form class="layui-form layui-form-pane" style="padding: 5px;margin-left: 110px;" >
    <input type="hidden" name="id" value="${metalCategory.id}"/>

    <div class="layui-form-item">
        <label class="layui-form-label">名称</label>
        <div class="layui-input-inline">
            <input type="text" name="cateName" lay-verify="required" value="${metalCategory.cateName}"   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">描述</label>
        <div class="layui-input-inline">
            <input type="text" name="cateDesc" lay-verify="scrollDesc" value="${metalCategory.cateDesc}"   autocomplete="off" class="layui-input">
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
        var url="${pageContext.request.contextPath}/metalCate/${url}";
        //监听保存提交
        form.on('submit(save)', function(data){
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


    });

</script>
</body>
</html>
