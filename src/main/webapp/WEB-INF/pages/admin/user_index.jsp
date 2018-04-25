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
<jsp:include page="head.jsp"></jsp:include>
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
                                <li><a href="">用户管理  >  </a></li>
                                <li><a class="local-site" href="">用户角色</a></li>
                            </ul>
                            <!--面包屑导航 当前位置 end-->
                            <!---->
                            <div class="public_wrap">
                                <ul class="sub_nav">
                                    <li class="active"><a class="local-site" href="javascript:;">用户信息</a></li>
                                    <%--<li><a class="local-site" href="javascript:;">角色信息</a></li>--%>
                                </ul>
                                <article id="userMessage">
                                    <div class="btn_box">
                                        <button id="user-add" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i>新增用户</button>
                                    </div>
                                    <div class="mt-10">
                                        <div>
                                            <table id="userTable" class="layui-table" lay-filter="testUser" lay-skin="nob"></table>
                                            <div id="userPage" style="text-align: center;"></div>
                                        </div>
                                    </div>
                                </article>
                                <%--<article style="display: none" id="roleMessage">
                                    <div class="mt-10">
                                        <div>
                                            <table id="roleTable" class="layui-table" lay-filter="testRole" lay-skin="nob"></table>
                                            <div id="rolePage" style="text-align: center;"></div>
                                        </div>
                                    </div>
                                </article>--%>
                            </div>
                            <!---->
                        </div>
                        <!--内容 end-->
                    </div>
                    <!--页面底部 star-->
                    <footer>
                        <div id="foot">
                            <div id="search_color_wrap" class="lf">
                                <span>选择色系：</span>
                                <div class="color_box">
                                    <a class="color1"></a>
                                    <a class="color2 "></a>
                                    <a class="color3"> </a>
                                    <a class="color4"></a>
                                    <a class="color5"></a>
                                    <a class="color6"></a>
                                    <a class="color7"></a>
                                    <a class="color8"></a>
                                </div>
                            </div>
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
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script>


    var layer = "";
    var form = "";
    var table = "";
    var laypage = "";
    layui.use(['layer', 'form', 'table', 'laypage'], function () {
        layer = layui.layer, form = layui.form, table = layui.table, laypage = layui.laypage;

        putData(0,"1",username);
        putData(1,"1",null);

        table.on('tool(testUser)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if (layEvent === 'edit') { //编辑
                var id =data.id;
                modify_show(id);
            }else if(layEvent === 'del') { //删除
                console.log(data);
                var id =data.id;
                deleteById("确定删除用户"+data.trueName+"吗？",id,"4");
            }else  if(layEvent === 'view'){ //预览
                var id =data.id;
                view(id);
            }
        });
        table.on('tool(testRole)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            console.log(data);
            var layEvent = obj.event; //获得 lay-event 对应的值
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if (layEvent === 'assign') {
                layer.msg("这个功能发工资再开发");
            }
        });

    });


    //全局页面
    var initUserNum = "0", initRoleNum = "0";
    var username;
    /**
     * 填充数据
     * */

    function putData(type,pageNum,username) {
        if (type === 0) {
            $.getJSON('${pageContext.request.contextPath}/user/data', {
                username: username,
                pageNum: pageNum //向服务端传的参数
            }, function (res) {
                var data = res.data;
                var len = data.length;
                initUserNum = pageNum;  //当前页码存到全局变量中
                //自定义样式
                laypage.render({
                    elem: 'userPage'
                    , count: res.count
                    , theme: '#1E9FFF'
                    , curr: pageNum
                    , jump: function (obj, first) {
                        if (!first) {
                            putData(type, obj.curr,username);
                        }
                    }
                });
                table.render({
                    elem: '#userTable' //指定原始表格元素选择器（推荐id选择器）
                    /*, height: 450 //容器高度
                     ,width: 650*/
                    ,id: 'idTest'
                    , data: data
                    , cols: [[
                        {checkbox: true}
                        ,{field: 'username', title: '登录名', width: 250, sort: false}
                        , {field: 'trueName', title: '真实姓名', width: 250, sort: false}
                        , {field: 'groupName', title: '所属机构', width: 250, sort: false,}
                        , {fixed: 'right', title: '操作', width: 372, align: 'center', templet: '#barDemo'}
                    ]] //设置表头
                });
            });
        } else if (type === 1) {
            $.getJSON('${pageContext.request.contextPath}/role/data', {
                pageNum: pageNum //向服务端传的参数
            }, function (res) {
                var data = res.data;
                var len = data.length;
                initRoleNum = pageNum;  //当前页码存到全局变量中
                //自定义样式
                laypage.render({
                    elem: 'rolePage'
                    , count: res.count
                    , theme: '#1E9FFF'
                    , curr: pageNum
                    , jump: function (obj, first) {
                        if (!first) {
                            putData(type,obj.curr,null);
                        }
                    }
                });
                table.render({
                    elem: '#roleTable' //指定原始表格元素选择器（推荐id选择器）
                    /*, height: 450 //容器高度
                     ,width: 650*/
                    ,id: 'roleTest'
                    , data: data
                    , cols: [[
                        {field: 'roleName', title: '角色名', width: 400, sort: false}
                        , {field: 'roleDes', title: '角色描述', width: 400, sort: false}
                        , {fixed: 'right', title: '操作', width: 372, align: 'center', templet: '#barRoleDemo'}
                    ]] //设置表头
                });
            });
        }
    }
    ;

    jQuery(function ($) {
        $('input, textarea').placeholder();

        $("#user-add").click(function () {
            layer.open({
                type: 2,
                title: '新增用户',
                closeBtn: '2',
                area: ['50%', '50%'],
                content: '${pageContext.request.contextPath}/user/add',
                end:function(){
                    putData(0,initUserNum,username);
                    initTree();
                }
            });
        });

        $(".sub_nav").find("li").eq(0).click(function () {
           $(".sub_nav").find("li").eq(0).addClass("active");
           $(".sub_nav").find("li").eq(1).removeClass("active");
           $("#userMessage").show();
           $("#roleMessage").hide();
        });
        $(".sub_nav").find("li").eq(1).click(function () {
            $(".sub_nav").find("li").eq(1).addClass("active");
            $(".sub_nav").find("li").eq(0).removeClass("active");
            $("#userMessage").hide();
            $("#roleMessage").show();
        });

    });


    /**
     * 编辑
     * */
    function modify_show(id){
        layer.open({
            type: 2,
            title: '编辑用户',
            closeBtn: '2',
            area: ['50%', '50%'],
            content: '${pageContext.request.contextPath}/user/edit/'+id,
            end:function(){
                putData(0,initUserNum,username);
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
                url:"${pageContext.request.contextPath}/user/delete",
                type:"post",
                dataType:"json",
                traditional: true,
                data:{"userIds":id},
                success:function(res){
                    if(res.success){
                        layer.msg("操作成功");
                        putData(0,initUserNum,username); //重新加载table
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
    function view(id){
        layer.msg("功能正在开发");
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
            url: "${pageContext.request.contextPath}/group/tree"
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
    };


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


    {{#  if(d.coluDefault != 1 ){ }}
    <a class="layui-btn layui-btn-mini  layui-btn-normal" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini  layui-btn-danger" lay-event="del">删除</a>
    {{#  } }}

</script>
<script type="text/html" id="barRoleDemo">


    {{#  if(d.coluDefault != 1 ){ }}
    <a class="layui-btn layui-btn-mini  layui-btn-normal" lay-event="assign">角色分配</a>
    {{#  } }}

</script>
<script type="text/html" id="view">


    <a lay-event="view" style="cursor: pointer;"><i class="layui-icon">&#xe64c;预览</i></a>

</script>
</body>
</html>
