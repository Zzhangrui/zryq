<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/11/8
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>信息转移</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/zTree/v3/css/zTreeStyle/zTreeStyle.css"/>
</head>
<body>
<div>
    <form class="layui-form" action="" style="padding: 20px;">
        <input type="hidden" name="ids" value="${ids}">
        <input type="hidden" name="coluId" id="coluId">


        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">请选择站点</label>
            <div class="layui-input-block">
                <select name="webId" lay-verify="webId" id="webId" lay-search>
                    <option value="">直接选择或搜索选择</option>
                </select>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate','layer','jquery','upload'], function(){
        var form = layui.form
                ,layer = layui.layer
        var $ = layui.$; //重点处


        //自定义验证规则
        form.verify({
            webId: function(value){
                if(value==''){
                    return '请选择要共享的站点';
                }
            }
        });

        //监听提交
        form.on('submit(demo1)', function(data){

            $.ajax({
                url:"${pageContext.request.contextPath}/article/${url}",
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

        $.ajax({
           url:"${pageContext.request.contextPath}/web/getWebInfo",
            type:"post",
            dataType:"json",
            success:function(res){
                if(res.success){
                    $.each(res.data, function(index, value) {
                        console.log(value);
                        var optinon = "<option value=\""+value.id+"\">"+value.webName+"</option>";
                        jQuery("#webId").append(optinon);
                    });
                    form.render('select');
                }else{
                    layer.msg("获取站点信息异常，请刷新后重试");
                }
            }
        });

    });


</script>
</html>
