<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/11/9
  Time: 15:15
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
                    <li>
                        <div class="link">
                            <i class="fa fa-address-card-o"></i>
                            模板管理
                            <i class="fa fa-angle-down"></i>
                        </div>
                        <%--<ul class="submenu">
                            <li><i class="fa fa-angle-right"></i><a href="notification.html">通知公告</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">会议管理</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">公车管理</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">公务接待</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">公文管理</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="leave.html">请休假</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">投票管理</a></li>
                            <li><i class="fa fa-angle-right"></i><a href="#">添加更多</a></li>
                        </ul>--%>
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
                                <li><a href="">模板管理 > </a></li>
                                <%--<li><a href="notification.html">通知公告</a></li>--%>
                            </ul>
                            <!--面包屑导航 当前位置 end-->
                            <!---->
                            <div class="public_wrap">
                                <ul class="sub_nav">
                                    <li class="active"><a href="javascript:;">模板管理</a></li>
                                </ul>
                                <article>
                                    <%--<div class="btn_box">
                                        &lt;%&ndash;<button id="art-add" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i>新增站点</button>&ndash;%&gt;
                                        &lt;%&ndash; <button id="art-undo" class="layui-btn layui-btn-danger layui-btn-small" ><i class="layui-icon "></i>批量撤稿</button>&ndash;%&gt;
                                    </div>--%>
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
<script>


    var layer = "";
    var form = "";
    var table = "";
    var laypage = "";
    layui.use(['layer', 'form', 'table', 'laypage'], function () {
        layer = layui.layer, form = layui.form, table = layui.table, laypage = layui.laypage;

        putData("1");


        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if (layEvent === 'view') { //编辑
                var id = data.id;
                var url = data.tempPath;
                view(id,url);
            }

        });

    });


    //全局页面
    var initNum = "0";
    /**
     * 填充数据
     * */

    function putData(pageNum) {
        $.getJSON('${pageContext.request.contextPath}/template/data', {
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
                        putData(obj.curr);
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
                    ,{field: 'tempName', title: '模板名称', width: 200, sort: false}
                    , {field: 'tempDes', title: '模板描述', width: 200, sort: false}
                    , {field: 'view', title: '模板预览', width: 200, sort: false,align: 'center',toolbar: '#view'}
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
                title: '站点新增',
                closeBtn: '2',
                area: ['80%', '80%'],
                content: '${pageContext.request.contextPath}/web/add_show', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                end:function(){
                    putData(initNum);
                }
            });
        });
    });


    function modify_show(id){
        layer.open({
            type: 2,
            title: '站点编辑',
            closeBtn: '2',
            area: ['80%', '80%'],
            content: '${pageContext.request.contextPath}/web/modify_show/'+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            end:function(){
                putData(initNum);
            }
        });
    }


    /**
     * 预览
     * */
    function view(id,url){
        window.open("${pageContext.request.contextPath}");
    }



</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-mini  layui-btn-normal" lay-event="edit">修改模板</a>
</script>
<script type="text/html" id="view">


    <a lay-event="view" style="cursor: pointer;"><i class="layui-icon">&#xe64c;预览</i></a>

</script>
</body>
</html>
