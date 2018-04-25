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
            <label class="layui-form-label">请选择栏目</label>
            <div class="layui-input-block">
                <div class="ztree " id="des_school" style="width: 182px;float: left;margin-left: 20px;"></div>
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








        //监听提交
        form.on('submit(demo1)', function(data){

            var coluId = "";
            coluId = $("#coluId").val();

            if(coluId == ""){
                layer.msg("请选择要转移到的栏目");
                return false;
            }
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

    });


    var setting = {
        data: {//表示tree的数据格式
            simpleData: {
                enable: true,//表示使用简单数据模式
                idKey: "id",//设置之后id为在简单数据模式中的父子节点关联的桥梁
                pidKey: "pId",//设置之后pid为在简单数据模式中的父子节点关联的桥梁和id互相对应
                rootId: "null"//pid为null的表示根节点
            }
        },
        callback: {
            onCheck: zTreeOnClick
        },
        view: {//表示tree的显示状态
            fontCss : {color:"#adaeb2",fontsize:"16px"},
            selectMulti: false//表示禁止多选
        },
        check: {//表示tree的节点在点击时的相关设置
            enable: true,//是否显示radio/checkbox
            chkStyle: "radio",//值为checkbox或者radio表示
            chkboxType: {"Y": "ps", "N": "ps"},//表示父子节点的联动效果
            radioType: "all"//设置tree的分组
        },
        async: {
            enable: true,
            type: "post",
            dataType: "json",
            url: "${pageContext.request.contextPath}/column/tree"
        }

    };

    function initTree() {

        $.fn.zTree.init($("#des_school"), setting, null);
    }
    $(function () {
        initTree();

    });


    /**
     * 点击回调事件
     * */
    function zTreeOnClick(event, treeId, treeNode) {
        coluId = treeNode.id;
        coluName = treeNode.name;

        $("#coluId").val(coluId);
        $("#coluName").val(coluName);

        /*console.log(treeNode);
         console.log(treeId);
         console.log(treeNode.id);*/
    }
    ;


    /**
     * 异步获取回调事件
     * @param event
     * @param treeId
     * @param treeNode
     */
    function zTreeAsyncSuccess(event, treeId, treeNode) {

        var treeObj = $.fn.zTree.getZTreeObj("des_school");
        var nodes = treeObj.getCheckedNodes(true);

        var deps = '';
        var depIds = '';
        var b = nodes.length;
        for (var i = 0; i < b; i++) {
            var node = nodes[i];
            if (!node.isParent) {
                deps = deps + "【" + node.name + "】 ";
                depIds = depIds + node.id + ',';
            }
            treeObj.checkNode(nodes[i], true, true); //选中子节点后级联勾选父节点
        }
        $("#organizerNames").val(deps);
        $("#organizerIds").val(depIds);
    }

</script>
</html>
