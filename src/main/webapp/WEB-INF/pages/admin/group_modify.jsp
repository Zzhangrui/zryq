<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/11/1
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增机构</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css"/>
</head>
<body>
<div>
    <form class="layui-form" action="" style="padding: 20px;">
        <input type="hidden" name="id" value="${group.id}">
        <div class="layui-form-item">
            <label class="layui-form-label">机构名称</label>
            <div class="layui-input-block">
                <input type="text" name="groupName" value="${group.groupName}" lay-verify="title" autocomplete="off" placeholder="请输入机构名称" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">机构编码</label>
            <div class="layui-input-block">
                <input type="text" name="groupCode"  value="${group.groupCode}" autocomplete="off" placeholder="请输入机构编码" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">

            <div class="layui-inline">
                <label class="layui-form-label">上级机构</label>
                <div class="layui-input-inline">
                    <select name="parentId"  lay-search="">
                        <option value="">直接选择或搜索选择</option>

                        <c:forEach items="${groupList}" var="group1">
                            <option value="${group1.id}" <c:if test="${group1.id eq group.parentId}"> selected</c:if> >${group1.groupName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入机构描述"  style="height: 100px;" name="groupDes" id="editor_id" class="layui-textarea">${group.groupDes}</textarea>
            </div>
        </div>



        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate','layer','jquery','upload'], function(){
        var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate
                ,upload = layui.upload;
        var $ = layui.$; //重点处




        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 2){
                    return '机构名称至少得两个字符';
                }
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(demo1)', function(data){

            $.ajax({
                url:"${pageContext.request.contextPath}/group/${url}",
                data:data.field,
                type:'post',
                dataType:'json',
                success: function (res) {
                    if(res.success){
                        layer.msg("编辑成功，2秒后页面自动刷新");
                        setTimeout(function(){
                            //top.location.reload();  //直接刷新父页面
                            //当你在iframe页面关闭自身时
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                        },2000);
                    }else {
                        layer.alert("提交失败，请刷新后再试");
                    }
                }
            });
            return false;
        });




    });


</script>
</html>
