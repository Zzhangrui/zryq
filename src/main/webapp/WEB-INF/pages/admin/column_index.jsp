<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/11/1
  Time: 17:27
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
                            <i class="fa fa-address-card-o"></i>
                            栏目管理
                            <i class="fa fa-angle-down"></i>
                        </div>
                        <ul class="submenu" style="display: block">
                            <%--<li><i class="fa fa-angle-right"></i><a href="notification.html">通知公告</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">会议管理</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">公车管理</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">公务接待</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">公文管理</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="leave.html">请休假</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">投票管理</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">添加更多</a></li>--%>
                            <div class="ztree " id="des_school" style="width: 182px;float: left;margin-left: 20px;"></div>
                        </ul>
                    </li>
                   <%-- <li>
                        <div class="link">
                            <i class="fa fa-envelope-o"></i>
                            消息管理
                            <i class="fa fa-angle-down"></i>
                        </div>
                        <ul class="submenu">
                            <li><i class="fa fa-angle-right"></i><a href="#">应用消息</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="message.html">通讯消息</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">消息设置</a></li>
                        </ul>
                    </li>
                    <li>
                        <div class="link">
                            <i class="fa fa-users"></i>
                            服务管理
                            <i class="fa fa-angle-down"></i>
                        </div>
                        <ul class="submenu">
                            <li><i class="fa fa-angle-right"></i><a href="#">律师预约</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">代表委员联络</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">投诉建议</a></li>
                        </ul>
                    </li>
                    <li>
                        <div class="link">
                            <i class="fa fa-cog"></i>
                            系统管理
                            <i class="fa fa-angle-down"></i>
                        </div>
                        <ul class="submenu">
                            <li><i class="fa fa-angle-right"></i><a href="#">安全管理</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">用户管理</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">系统配置</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">系统日志</a></li>
                        </ul>
                    </li>--%>
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
                                <li><a href="">栏目管理  >  </a></li>
                                <li><a class="local-site" href="">所有栏目</a></li>
                            </ul>
                            <!--面包屑导航 当前位置 end-->
                            <!---->
                            <div class="public_wrap">
                                <ul class="sub_nav">
                                    <li class="active"><a class="local-site" href="javascript:;">所有栏目</a></li>
                                </ul>
                                <article>
                                    <div class="btn_box">
                                        <button id="art-add" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i>新增栏目</button>
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
                    <jsp:include page="foot.jsp"/>
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
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script>


    var layer = "";
    var form = "";
    var table = "";
    var laypage = "";
    layui.use(['layer', 'form', 'table', 'laypage'], function () {
        layer = layui.layer, form = layui.form, table = layui.table, laypage = layui.laypage;

        putData("1",parentId);


        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if (layEvent === 'edit') { //编辑
                var id =data.id;
                modify_show(id);
            }else if(layEvent === 'del') { //删除
                var id =data.id;
                deleteById("删除会级联删除子栏目，确认删除么？",id,"4");
            }else  if(layEvent === 'view'){ //预览
                view(data);
            }
        });

    });


    //全局页面
    var initNum = "0";
    var parentId = "";
    /**
     * 填充数据
     * */

    function putData(pageNum,parentId) {
        $.getJSON('${pageContext.request.contextPath}/column/data', {
            parentId:parentId,
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
                        putData(obj.curr,parentId);
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
                    ,{field: 'coluName', title: '栏目名称', width: 200, sort: false}
                    , {field: 'coluDes', title: '栏目描述', width: 200, sort: false}
                    , {field: 'view', title: '栏目链接', width: 200, sort: false,align: 'center',toolbar: '#view'}
                    /*, {field: 'parentId', title: '父级栏目', width: 200, sort: true}
                    , {field: 'positon', title: '栏目位置', width: 200, sort: true}*/
                    , {fixed: 'right', title: '操作', width: 153, align: 'center', templet: '#barDemo'}
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
                title: '新增栏目',
                closeBtn: '2',
                area: ['80%', '80%'],
                content: '${pageContext.request.contextPath}/column/add_show?parentId='+parentId, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                end:function(){
                    putData(initNum,parentId);
                    initTree();
                }
            });
        });



    });


    /**
     * 编辑
     * */
    function modify_show(id){
        layer.open({
            type: 2,
            title: '编辑文章',
            closeBtn: '2',
            area: ['80%', '80%'],
            content: '${pageContext.request.contextPath}/column/modify_show/'+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            end:function(){
                putData(initNum,parentId);
                initTree();
            }
        });
    }

    /**
     * 删除
     * @param msg
     * @param id
     * @param state
     */
    function  deleteById(msg,id,state){
        layer.confirm(msg, function (index) {
            $.ajax({
                url:"${pageContext.request.contextPath}/column/delete",
                type:"post",
                dataType:"json",
                data:{"ids":id},
                success:function(res){
                    if(res.success){
                        layer.msg("操作成功");
                        putData(initNum,parentId); //重新加载table
                        initTree(); //重新加载树
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
    function view(data){
        window.open("${pageContext.request.contextPath}/"+data.webId+"/list/"+data.id);
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
            /*otherParam: ["matterId", "${matter.id}"],*/
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

        $(".local-site").text(treeNode.name);
        parentId = treeNode.id;

        putData(initNum,parentId);

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

    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="edit">编辑</a>
    {{#  if(d.coluDefault != 1 ){ }}

    <a class="layui-btn layui-btn-danger layui-btn-xs  layui-btn-danger" lay-event="del">删除</a>
    {{#  } }}

</script>
<script type="text/html" id="view">


    <a lay-event="view" style="cursor: pointer;"><i class="layui-icon">&#xe64c;预览</i></a>

</script>
</body>
</html>
