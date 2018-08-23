<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/6/21
  Time: 11:12
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
                    <jsp:include page="foot.jsp"/>
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
    var tables;
    layui.use(['layer', 'form', 'table', 'laypage'], function () {
        layer = layui.layer, form = layui.form, table = layui.table, laypage = layui.laypage;



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

         tables = table.render({
            elem: '#scrollTable' //指定原始表格元素选择器（推荐id选择器）
            , id: 'scroll-1'
            , url:'${pageContext.request.contextPath}/metalCate/data'
            ,method:'post'
            ,request:{
                pageName:'pageNum',
                limitName:'pageSize'
            },page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                    layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                        //,curr: 5 //设定初始在第 5 页
                        ,groups: 1 //只显示 1 个连续页码
                        ,first: false //不显示首页
                        ,last: false //不显示尾页
                     }
            , cols: [[
                {field: 'id', title: 'ID',   align: 'center',sort: false}
                , {field: 'cateName', title: '类别名称', sort: false}
                , {field: 'cateDesc', title: '描述', sort: false}
                , {field: 'createTime', title: '更新时间', sort: false}
                , {field: 'updateTime', title: '更新时间', sort: false}
                , {fixed: 'right', title: '操作', align: 'center', templet: '#barRoleDemo'}
            ]] //设置表头
        });

    });

    jQuery(function ($) {
        $('input, textarea').placeholder();

        $("#scroll-add").click(function () {
            layer.open({
                type: 2,
                title: '新增',
                closeBtn: '2',
                area: ['50%', '50%'],
                content: '${pageContext.request.contextPath}/metalCate/add',
                end: function () {
                    tables.reload();
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
            content: '${pageContext.request.contextPath}/metalCate/modify/' + id,
            end: function () {
                tables.reload();
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
                url: "${pageContext.request.contextPath}/metalCate/delete/" + id,
                type: "post",
                dataType: "json",
                traditional: true,
                success: function (res) {
                    if (res.success) {
                        layer.msg("操作成功");
                        tables.reload(); //重新加载table
                    } else {
                        layer.alert("操作失败，请刷新后再试")
                    }
                }
            });
        });
    }
</script>
<script type="text/html" id="barRoleDemo">
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="assign">编辑</a>
    <a class="layui-btn layui-btn-xs  layui-btn-danger" lay-event="remove">删除</a>
</script>
</body>
</html>
