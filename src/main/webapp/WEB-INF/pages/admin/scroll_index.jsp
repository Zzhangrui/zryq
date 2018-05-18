<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/5/8
  Time: 11:39
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
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/admin/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/css/validate.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/zTree/v3/css/zTreeStyle/zTreeStyle.css"/>
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
            <%--<div id="con_main_nav">
                <!--改版之后的left_menu start-->
                <div style="text-align:center;clear:both"></div>
                <ul id="accordion" class="accordion">
                    <li class="open">
                        <div class="link">
                            <i class="fa fa-address-card-o"></i>
                            角色管理
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
            </div>--%>
            <!--左侧主导航-->
            <!--右侧内容区-->
            <div id="con_box" style="margin-left: -182px;">
                <div class="con_wrap">
                    <div id="con_box_con">
                        <!--内容 star-->
                        <div id="section_name">
                            <!--面包屑导航 当前位置 star-->
                            <ul class="bread_wrap">
                                <li><span
                                        class="fa fa-map-marker fa-2x"></span>&nbsp;<span>您当前的位置：</span>
                                </li>
                                <li><a class="local-site" href="">首页scroll</a></li>
                            </ul>
                            <!--面包屑导航 当前位置 end-->
                            <!---->
                            <div class="public_wrap">
                                <ul class="sub_nav">
                                    <li class="active"><a class="local-site" href="javascript:;">scroll信息</a>
                                    </li>
                                    <%--<li><a class="local-site" href="javascript:;">角色信息</a></li>--%>
                                </ul>

                                <article id="roleMessage">
                                    <div class="btn_box">
                                        <button id="scroll-add"
                                                class="layui-btn layui-btn-normal layui-btn-small">
                                            <i class="layui-icon"></i>新增
                                        </button>
                                    </div>
                                    <div class="mt-10">
                                        <div>
                                            <table id="scrollTable" class="layui-table"
                                                   lay-filter="scroll-table" lay-skin="nob"></table>
                                            <div id="rolePage" style="text-align: center;"></div>
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
                            <div id="search_color_wrap" class="lf">

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
    <div id='prevModal'>
        <img id='img_prev'/>
    </div>
</section>
<!--主体部分 end-->
<script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
<!--<script src="bootstrap/js/bootstrap.min.js"></script>-->
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/admin/js/head_main_nav.js"></script>
<!--解决IE支持placeholder的方法-->
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/admin/js/jquery.placeholder.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/common/tool.js"></script>
<script>

    var layer = "";
    var form = "";
    var table = "";
    var laypage = "";
    var initPageNum = "1";
    layui.use(['layer', 'form', 'table', 'laypage'], function () {
        layer = layui.layer, form = layui.form, table = layui.table, laypage = layui.laypage;

        putData(initPageNum);


        table.on('tool(scroll-table)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if (layEvent === 'assign') {
                modify_show(data.id);
            } else if (layEvent === 'remove') {
                deleteById("确认要删除吗？", data.id);
            } else if (layEvent === 'view') {
                view(data);
            }
        });
        //监听锁定操作
        form.on('checkbox(using)', function (obj) {
            console.log(obj);
            var id = this.value;
            var status = obj.elem.checked ? "1":"0";
            console.log(status);
            $.ajax({
                url:'${pageContext.request.contextPath}/scroll/edit',
                data:{id:id,status:status},
                type:'post',
                dataType:'json',
                traditional: true ,
                success: function (res) {
                    if(res.success){
                        layer.msg("修改成功");
                    }else {
                        layer.msg("修改失败");
                        putData(initPageNum);
                    }
                    form.render('checkbox');
                },error:function () {
                    layer.msg("服务器故障");
                    putData(initPageNum);
                }
            });
            // layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        });

    });


    /**
     * 填充数据
     * */

    function putData(pageNum) {
        $.getJSON('${pageContext.request.contextPath}/scroll/data', {
            pageNum: pageNum //向服务端传的参数
        }, function (res) {
            var data = res.data;
            initPageNum = pageNum;  //当前页码存到全局变量中
            //自定义样式
            laypage.render({
                elem: 'rolePage'
                , count: res.count
                , theme: '#1E9FFF'
                , curr: pageNum
                , jump: function (obj, first) {
                    if (!first) {
                        putData(obj.curr);
                    }
                }
            });
            table.render({
                elem: '#scrollTable' //指定原始表格元素选择器（推荐id选择器）
                , id: 'scroll-1'

                , data: data
                , cols: [[
                    {field: 'pic', title: '图片', templet: '#img',  align: 'center',sort: false}
                    , {field: 'scrollTitle', title: '标题', sort: false}
                    , {field: 'scrollDesc', title: '描述', sort: false}
                    , {field: 'updateTime', title: '更新时间', sort: false}
                    , {field: 'use', title: '启用状态', sort: false,  align: 'center',templet: '#use'}
                    , {fixed: 'right', title: '操作', align: 'center', templet: '#barRoleDemo'}
                ]] //设置表头
            });
        });
    }
    ;

    jQuery(function ($) {
        $('input, textarea').placeholder();

        $("#scroll-add").click(function () {
            layer.open({
                type: 2,
                title: '新增',
                closeBtn: '2',
                area: ['50%', '50%'],
                content: '${pageContext.request.contextPath}/scroll/add',
                end: function () {
                    putData(initPageNum);
                }
            });
        });

    });


    /**
     * 编辑
     * */
    function modify_show(id) {
        layer.open({
            type: 2,
            title: '修改',
            closeBtn: '2',
            area: ['50%', '50%'],
            content: '${pageContext.request.contextPath}/scroll/edit/' + id,
            end: function () {
                putData(initPageNum);
            }
        });
    }

    /**
     * 删除
     * @param msg
     * @param id
     * @param state
     */
    function deleteById(msg, id) {
        layer.confirm(msg, function (index) {
            $.ajax({
                url: "${pageContext.request.contextPath}/scroll/delete/" + id,
                type: "post",
                dataType: "json",
                traditional: true,
                success: function (res) {
                    if (res.success) {
                        layer.msg("操作成功");
                        putData(initPageNum); //重新加载table
                    } else {
                        layer.alert("操作失败，请刷新后再试")
                    }
                }
            });
        });
    }

    /**
     * 预览
     * */
    function view(data) {
        var dataArr = new Array();
        var pData = {
            alt: "",
            pid: data.id,
            src: "${pageContext.request.contextPath}/" + data.scrollPicPath,
            thumb: "${pageContext.request.contextPath}/" + data.scrollPicPath
        };

        dataArr.push(pData);
        var photoJson = {
            title: "预览",
            id: data.id,
            start: 0,
            data: dataArr
        };

        layer.photos({
            photos: photoJson
            , anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
        });
    }
</script>
<script type="text/html" id="barRoleDemo">
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="assign">编辑</a>
    <a class="layui-btn layui-btn-xs  layui-btn-danger" lay-event="remove">删除</a>
</script>
<script type="text/html" id="view">

    <a lay-event="view1" style="cursor: pointer;"><i class="layui-icon">&#xe64c;预览</i></a>

</script>
<script type="text/html" id="img">
    <img src="${pageContext.request.contextPath}/{{ d.scrollPicPath }}" lay-event="view">
</script>
<script type="text/html" id="use">
    <input type="checkbox" name="status" value="{{d.id}}" title="启用" lay-filter="using" {{
           d.status== 1 ? 'checked' : '' }}>
</script>

</body>
</html>

