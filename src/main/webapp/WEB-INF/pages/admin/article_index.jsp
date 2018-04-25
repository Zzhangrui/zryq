<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/10/24
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1"/>
    <!-- <link rel="stylesheet" href="bootstrap/css/bootstrap-responsive.css"/> -->
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
</head>
<body>
<!--头部 star-->
<%--<jsp:include page="head.jsp"></jsp:include>--%>
<!--头部 end-->

<!--主体部分  star-->
<section>
    <div class="main_con">
        <div id="contaner">
            <!--左侧主导航-->
            <div id="con_main_nav">
                <!--改版之后的left_menu start-->
                <div style="text-align:center;clear:both"></div>
                <ul id="accordion" class="accordion">

                    <li class="open">
                        <div class="link">
                            <i class="fa fa-envelope-o"></i>
                            栏目分类
                            <i class="fa fa-angle-down"></i>
                        </div>
                        <ul class="submenu" style="display: block">
                            <div class="ztree " id="des_school" style="width: 182px;float: left;margin-left: 20px;"></div>
                        </ul>
                    </li>

                </ul>
                <!--end-->
                <!--折叠-->
                <div id="fold_con">
                    <a href="javascript:void(0)" class="fold_open "><i class="fa fa-caret-right fa-lg"></i></a>
                    <a href="javascript:void(0)" class="fold_close active"><i class="fa fa-caret-left fa-lg"></i></a>
                </div>
                <!--折叠-->
            </div>
            <!--左侧主导航-->
            <!--右侧内容区-->
            <div id="con_box">
                <div class="con_wrap">
                    <div id="con_box_con">
                        <!--内容 star-->
                        <div id="section_name">
                            <!--面包屑导航 当前位置 star-->
                            <ul class="bread_wrap">
                                <li><span class="fa fa-map-marker fa-2x"></span>&nbsp;<span>您当前的位置：</span></li>
                                <li><a href="">工作管理 > </a></li>
                                <li><a href="">信息管理</a></li>
                            </ul>
                            <!--面包屑导航 当前位置 end-->
                            <!---->
                            <div class="public_wrap">
                                <ul class="sub_nav">
                                    <li class="active"><a href="javascript:;">信息管理</a></li>
                                </ul>
                                <article>
                                    <div class="btn_box">
                                        <button id="art-add" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i>新增文章</button>
                                        <button id="art-undo" class="layui-btn layui-btn-danger layui-btn-small" ><i class="layui-icon "></i>批量撤稿</button>
                                        <button id="art-move" class="layui-btn layui-btn-small" ><i class="layui-icon">&#xe681;</i>信息转移</button>
                                        <button id="art-share" class="layui-btn layui-btn-warm layui-btn-small" ><i class="layui-icon">&#xe641;</i>信息共享</button>
                                    </div>
                                    <div class="mt-10">


                                        <div>
                                            <table id="article" class="layui-table" lay-filter="test" lay-skin="nob"></table>

                                            <div id="page" style="text-align: center;"></div>
                                        </div>
                                    </div>
                                </article>
                            </div>
                            <!---->
                        </div>
                        <!--内容 end-->
                    </div>
                    <!--页面底部 star-->
                    <footer>
                        <div id="foot">

                            <div id="bp" class="rt">图形化页面系统 2017 版本</div>
                        </div>
                    </footer>
                    <!--页面底部 end-->
                </div>
            </div>
            <!--右侧内容区-->
        </div>
    </div>
</section>
<!--主体部分 end-->
<script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
<!--<script src="bootstrap/js/bootstrap.min.js"></script>-->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/admin/js/head_main_nav.js"></script>
<!--解决IE支持placeholder的方法-->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/admin/js/jquery.placeholder.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script>


    var layer = "";
    var form = "";
    var table = "";
    var laypage = "";
    var coluId = "";
    var coluName = "";
    var laytpl="";
    layui.use(['layer', 'form', 'table', 'laypage','laytpl'], function () {
        layer = layui.layer, form = layui.form, table = layui.table, laypage = layui.laypage, laytpl = layui.laytpl;

        putData("1",coluId);


       table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
         var data = obj.data; //获得当前行数据
         var layEvent = obj.event; //获得 lay-event 对应的值
         var tr = obj.tr; //获得当前行 tr 的DOM对象
           var id =data.id;
          if (layEvent === 'edit') { //编辑
              modify_show(id);
         }else if(layEvent === 'publish') { //发布
              updateState("确认要发布该信息？",id,"4");
          }else if(layEvent === 'view'){ //查看
              view(data);
          }else if(layEvent === 'cancel'){
              updateState("确认要撤稿该信息？",id,"5");
          }
         });

    });


    //全局页面
    var initNum = "0";
    /**
     * 填充数据
     * */

    function putData(pageNum,coluId) {
        $.getJSON('${pageContext.request.contextPath}/article/data', {
            title: $("#title").val(),
            coluId:coluId,
            pageNum: pageNum //向服务端传的参数
        }, function (res) {
            var data = res.data;
            var len = data.length;
            initNum = pageNum;  //当前页码存到全局变量中
            //自定义样式
            laypage.render({
                elem: 'page'
                , count: res.count
                , theme: '#1E9FFF'
                , curr: pageNum
                , jump: function (obj, first) {
                    if (!first) {
                        putData(obj.curr,coluId);
                    }
                }
            });
            table.render({
                elem: '#article' //指定原始表格元素选择器（推荐id选择器）
                /*, height: 450 //容器高度
                 ,width: 650*/
                ,id: 'idTest'
                , data: data
                , cols: [[
                    {checkbox: true}
                    ,{field: 'artTitle', title: '标题', width: '20%', sort: false}
                    , {field: 'artDigest', title: '摘要', width: '25%', sort: false}
                    , {field: 'createTime', title: '创建时间', width: '15%', sort: true,templet:function(d){
                            return d.createTime.substr(0,16);
                        }}
                    , {field: 'createUsername', title: '创建人', width: '10%', sort: true}
                    , {field: 'coluName', title: '所属栏目',  sort: true}
                     , {fixed: 'right', title: '操作', width: '20%', align: 'center', templet: '#barDemo'}
                ]] //设置表头
                //,…… //更多参数参考右侧目录：基本参数选项
            });
        });
    }
    ;

    jQuery(function ($) {
        $('input, textarea').placeholder();

        $("#art-add").click(function () {
            layer.open({
                type: 2,
                title: '新增文章',
                closeBtn: '2',
                area: ['80%', '80%'],
                content: '${pageContext.request.contextPath}/article/add_show?coluId='+coluId+'&coluName='+coluName, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                end:function(){
                    putData(initNum,coluId);
                }
            });
        });

        $("#art-undo").click(function () {
            var checkStatus = table.checkStatus('idTest'); //test即为基础参数id对应的值
            var data = checkStatus.data;
            var length = data.length;
            if(length==0){
                layer.msg("请选择要撤稿的数据");
                return;
            }else{
                layer.confirm("确认要撤稿这"+length+"条数据么？", function (index) {
                    var ids = "";
                    for(var i =0 ;i<length;i++){
                        ids = ids+ data[i].id+",";
                    }

                    $.ajax({
                        url:"${pageContext.request.contextPath}/article/undo",
                        type:"post",
                        data : {'ids':ids},
                        dataType:"json",
                        success:function(res){
                            if(res.success){
                                layer.msg("操作成功");
                                putData(initNum,coluId); //重新加载table
                            }else{
                                layer.alert("操作失败，请刷新后再试")
                            }
                        }
                    });

                    console.log(checkStatus.data) //获取选中行的数据
                    console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件


                    console.log(checkStatus.isAll ) //表格是否全选
                });
            }

            return ;
        });


        /**
         * 信息转移
         * */
        $("#art-move").click(function () {
            var checkStatus = table.checkStatus('idTest'); //test即为基础参数id对应的值
            var data = checkStatus.data;
            var length = data.length;
            if(length==0){
                layer.msg("请选择要移动的数据");
                return;
            }else{
                var ids = "";
                for(var i =0 ;i<length;i++){
                    ids = ids+ data[i].id+",";
                }
                layer.open({
                    type: 2,
                    title: '信息转移',
                    closeBtn: '2',
                    area: ['500px', '350px'],
                    content: '${pageContext.request.contextPath}/article/move_show?ids='+ids, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    end:function(){
                        putData(initNum,coluId);
                    }
                });
            }

            return ;
        });

        $("#art-share").click(function () {
            var checkStatus = table.checkStatus('idTest'); //test即为基础参数id对应的值
            var data = checkStatus.data;
            var length = data.length;
            if(length==0){
                layer.msg("请选择要共享的数据");
                return;
            }else{
                var ids = "";
                for(var i =0 ;i<length;i++){
                    ids = ids+ data[i].id+",";
                }
                layer.open({
                    type: 2,
                    title: '信息共享',
                    closeBtn: '2',
                    area: ['500px', '350px'],
                    content: '${pageContext.request.contextPath}/article/share_show?ids='+ids, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    end:function(){
                        putData(initNum,coluId);
                    }
                });
            }

            return ;
        });

    });


    function modify_show(id){
        layer.open({
            type: 2,
            title: '编辑文章',
            closeBtn: '2',
            area: ['80%', '80%'],
            content: '${pageContext.request.contextPath}/article/modify_show/'+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            end:function(){
                putData(initNum,coluId);
            }
        });
    }

    /**
     * 更新状态
     * @param msg
     * @param id
     * @param state
     */
    function  updateState(msg,id,state){
        layer.confirm(msg, function (index) {
            $.ajax({
                url:"${pageContext.request.contextPath}/article/update/"+id+"/"+state,
                type:"post",
                dataType:"json",
                success:function(res){
                    if(res.success){
                        layer.msg("操作成功");
                        putData(initNum,coluId); //重新加载table
                    }else{
                        layer.alert("操作失败，请刷新后再试")
                    }
                }
            });
            //layer.close(index);
        });
    }


    /**
     * 预览
     * */
    function view (data){

        window.open("${pageContext.request.contextPath}/"+data.webId+"/detail/"+data.id);
    }



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
            onClick: zTreeOnClick
        },
        view: {//表示tree的显示状态
            fontCss : {color:"#adaeb2",fontsize:"16px"},
            selectMulti: false//表示禁止多选
        },
        check: {//表示tree的节点在点击时的相关设置
            enable: false,//是否显示radio/checkbox
            chkStyle: "checkbox",//值为checkbox或者radio表示
            chkboxType: {"Y": "ps", "N": "ps"},//表示父子节点的联动效果
            radioType: "level"//设置tree的分组
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
        initNum = "1";
        putData(initNum,coluId);

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
<script type="text/html" id="barDemo">

    {{#  if(d.artState == 0 || d.artState == 3){ }}
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-xs  layui-btn-warm" lay-event="publish">发布</a>
   <%-- <a class="layui-btn layui-btn-mini  layui-btn-warm" lay-event="sub">提交</a>--%>
    {{#  } else if(d.artState == 1){ }}
    <a class="layui-btn  layui-btn-xs layui-btn-disabled ">审核中</a>
    {{#  } else if(d.artState == 2){ }}
    <a class="layui-btn layui-btn-xs  layui-btn-warm" lay-event="publish">发布</a>
    {{#  } else if(d.artState == 4){ }}
    <a class="layui-btn  layui-btn-xs layui-btn-normal " lay-event="view">查看</a>
    <a class="layui-btn  layui-btn-xs  " lay-event="cancel">撤稿</a>
    {{#  } else { }}
   <%-- <a class="layui-btn layui-btn-mini  layui-btn-normal" lay-event="edit">编辑</a>--%>
    <a class="layui-btn layui-btn-xs  layui-btn-warm" lay-event="publish">重新发布</a>
    {{#  } }}

    <%--<a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini layui-btn-radius layui-btn-normal" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini layui-btn-radius layui-btn-danger" lay-event="del">删除</a>--%>
</script>
</body>
</html>
