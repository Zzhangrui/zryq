<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/11/1
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增文章</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css"/>
</head>
<body>
<div>
    <form class="layui-form" action="" style="padding: 20px;">
        <div class="layui-form-item">
            <label class="layui-form-label">站点名称</label>
            <div class="layui-input-block">
                <input type="text" name="webName" lay-verify="title" autocomplete="off" placeholder="请输入站点名称" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">站点域名</label>
            <div class="layui-input-block">
                <input type="text" name="webAddress"  autocomplete="off" placeholder="请输入域名" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">站点编码</label>
            <div class="layui-input-block">
                <input type="text" name="webCode"  autocomplete="off" placeholder="请输入编码" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">所属站点</label>
                <div class="layui-input-inline">
                    <select name="parentId" lay-verify="webId" id="webId" lay-search>
                        <option value="">直接选择或搜索选择</option>
                    </select>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">站点模板</label>
                <div class="layui-input-inline">
                    <select name="tempId" lay-verify="webTemp" id="webTemp" lay-search>
                        <option value="">直接选择或搜索选择</option>
                        <option value="1">贵州省检察院</option>
                        <option value="2">贵阳市检察院</option>
                        <option value="3">遵义市检察院</option>
                        <option value="4">六盘水市检察院</option>
                        <option value="5">安顺市检察院</option>
                        <option value="6">毕节市检察院</option>
                        <option value="7">铜仁市检察院</option>
                        <option value="8">黔西南自治州检察院</option>
                        <option value="9">黔东南自治州检察院</option>
                        <option value="10">黔南自治州检察院</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">站点描述</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入摘要" id="digest" name="webDes" class="layui-textarea"></textarea>
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
    layui.use(['form', 'layedit', 'laydate', 'layer', 'jquery', 'upload'], function () {
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate
                , upload = layui.upload;
        var $ = layui.$; //重点处


        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 1) {
                    return '站点名称不能为空';
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
                url: "${pageContext.request.contextPath}/web/${url}",
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
