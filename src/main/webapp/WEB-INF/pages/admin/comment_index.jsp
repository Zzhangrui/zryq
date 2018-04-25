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
    <title>评论模块</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1"/>
    <!-- <link rel="stylesheet" href="bootstrap/css/bootstrap-responsive.css"/> -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/css/validate.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css"/>
    <style>
        #right{
            position: relative;
            left: 850px;

        }
    </style>
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
                    <li>
                        <div class="link">
                            <i class="fa fa-address-card-o"></i>
                            工作管理
                            <i class="fa fa-angle-down"></i>
                        </div>
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
                                <li><a href="">评论管理  </a></li>
                               <%-- <li><a href="">通知公告</a></li>--%>
                            </ul>


                            <!--面包屑导航 当前位置 end-->
                            <!---->
                            <div class="public_wrap">
                                <ul class="sub_nav">
                                    <li class="active"><a href="javascript:;">通知公告</a></li>
                                </ul>

                                <article>
                                    <div class="btn_box" >
                                        <%--<div id="right" >--%>
                                            <%--<input type="text" size="25px" id="search" id="search"placeholder="搜索从这里开始...">--%>
                                            <%--<div style=" position:absolute;z-index:1500;background-color:#fff;width:185px;height:100px;border:1px solid #ccc;"></div>--%>
                                            <%--<button type="submit" class="layui-btn layui-btn-mini" >搜索</button>--%>
                                        <%--</div>--%>
                                        <button id="comment-undo" class="layui-btn layui-btn-danger layui-btn-small" ><i class="layui-icon "></i>批量删除</button>

                                        </div>


                                    <div style="margin-top: 10px;" >
                                        <button type="submit" class="layui-btn " style="float:right;" onclick="putData(1)">搜索</button>
                                        <input type="text" class="layui-input" id="search" style="width: 15%;height: 38px;float:right; margin-right: 10px;">
                                        <span style="float:right;padding-top: 8px;">请输入评论内容:</span>

                                    </div>
                                    <div class="mt-10">


                                        <div>
                                            <table id="comment" class="layui-table" lay-filter="test" lay-skin="nob"></table>

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
            if (layEvent === 'sub') {
                var id =data.id;
                layer.confirm('审核是否通过？', {
                    btn: ['是','否'] //按钮
                }, function(){
                    layer.msg('通过', {icon: 1});
                    updateState("审核通过",id,1);
                }, function() {
                    layer.msg('不通过', {icon: 2});
                    updateState("审核不通过",id,2);
                });

            }
        });

    });


    //全局页面
    var initNum = "0";
    /**
     * 填充数据
     * */

    function putData(pageNum) {
        $.getJSON('${pageContext.request.contextPath}/comment/data', {
            search:$("#search").val(),
            title: $("#title").val(),
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
                elem: '#comment' //指定原始表格元素选择器（推荐id选择器）
                /*, height: 450 //容器高度
                 ,width: 650*/
                ,id: 'idTest'
                , data: data
                , cols: [[
                    {checkbox: true}
                    ,{field: 'commContent', title: '评论内容', width: 200, sort: false}
                    , {field: 'userId', title: '用户编号', width: 200, sort: false}
                    , {field: 'commTime', title: '评论时间', width: 200, sort: true}
                    , {field: 'webId', title: '站点编号', width: 200, sort: true}
                    , {fixed: 'right', title: '操作', width: 153, align: 'center', templet: '#barDemo'}
                ]] //设置表头
                //,…… //更多参数参考右侧目录：基本参数选项
            });
        });
    }
    ;

    jQuery(function ($) {
        $('input, textarea').placeholder();


        $("#comment-undo").click(function () {
            console.log(table);
            var checkStatus = table.checkStatus('idTest'); //test即为基础参数id对应的值
            var data = checkStatus.data;
            var length = data.length;
            if(length==0){
                layer.msg("请选择要删除的数据");
                return;
            }else{
                layer.confirm("确认要删除这"+length+"条数据么？", function (index) {
                    var ids = "";
                    for(var i =0 ;i<length;i++){
                        ids = ids+ data[i].id+",";
                    }

                    $.ajax({
                        url:"${pageContext.request.contextPath}/undo",
                        type:"post",
                        data : {'ids':ids},
                        dataType:"json",
                        success:function(res){
                            if(res.success){
                                layer.msg("操作成功");
                                putData(initNum); //重新加载table
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

    });




    /**
     * 更新状态
     * @param msg
     * @param id
     * @param state
     */
    function  updateState(msg,id,state){
        layer.confirm(msg, function (index) {
            $.ajax({
                url:"${pageContext.request.contextPath}/comment/update/"+id+"/"+state,
                type:"post",
                dataType:"json",
                success:function(res){
                    if(res.success){
                        layer.msg("操作成功");
                        putData(initNum); //重新加载table
                    }else{
                        layer.alert("操作失败，请刷新后再试")
                    }
                }
            });
            //layer.close(index);
        });
    }





</script>
<script type="text/html" id="barDemo">

    {{#  if(d.commState == 0 || d.commState == 3){ }}
    <a class="layui-btn layui-btn-mini  layui-btn-warm" lay-event="sub">审核</a>
    {{#  } else if(d.commState == 1){ }}
    <a class="layui-btn  layui-btn-mini layui-btn-warm ">审核通过</a>
    {{#  } else if(d.commState == 2){ }}
    <a class="layui-btn layui-btn-mini  layui-btn-warm" >审核不通过</a>
    {{#  } else if(d.commState == 4){ }}
    <a class="layui-btn  layui-btn-mini layui-btn-disabled ">查看</a>
    {{#  } else { }}
    <a class="layui-btn layui-btn-mini  layui-btn-warm" lay-event="sub">审核</a>
    {{#  } }}


    <%--<a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini layui-btn-radius layui-btn-normal" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini layui-btn-radius layui-btn-danger" lay-event="del">删除</a>--%>
</script>
</body>
</html>
