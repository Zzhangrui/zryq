<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/4/28
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <li><span class="fa fa-map-marker fa-2x"></span>&nbsp;<span>您当前的位置：</span></li>
                                <li><a class="local-site" href="">个人信息</a></li>
                            </ul>
                            <!--面包屑导航 当前位置 end-->
                            <!---->
                            <div class="public_wrap">
                                <ul class="sub_nav">
                                    <li class="active"><a class="local-site" href="javascript:;">个人信息</a></li>
                                    <%--<li><a class="local-site" href="javascript:;">角色信息</a></li>--%>
                                </ul>

                                <article id="roleMessage">

                                    <div class="mt-10">
                                        <div>
                                            <form class="layui-form layui-form-pane" action="">

                                                <div class="layui-form-item">
                                                    <label class="layui-form-label">登陆名</label>
                                                    <div class="layui-input-inline">
                                                        <input type="text" value="${self.username}"  autocomplete="off" class="layui-input" disabled>
                                                    </div>
                                                </div>
                                                <div class="layui-form-item">
                                                    <label class="layui-form-label">机构名称</label>
                                                    <div class="layui-input-inline">
                                                        <input type="text" value="${self.groupName}"  autocomplete="off" class="layui-input" disabled>
                                                    </div>
                                                </div>
                                                <div class="layui-form-item">
                                                    <label class="layui-form-label">真实姓名</label>
                                                    <div class="layui-input-inline">
                                                        <input type="text" name="trueName" lay-verify="required" value="${self.trueName}" placeholder="请输入" autocomplete="off" class="layui-input" >
                                                    </div>
                                                </div>
                                                <div class="layui-form-item">
                                                    <label class="layui-form-label">原密码</label>
                                                    <div class="layui-input-inline">
                                                        <input type="password" name="oldPassword" id="old-password" placeholder="请输入原密码" autocomplete="off" class="layui-input">
                                                    </div>
                                                </div>
                                                <div class="layui-form-item">
                                                    <label class="layui-form-label">新密码</label>
                                                    <div class="layui-input-inline">
                                                        <input type="password" id="new-password1" name="newPassword1" lay-verify="password" placeholder="请输入新密码" autocomplete="off" class="layui-input">
                                                    </div>
                                                </div>
                                                <div class="layui-form-item">
                                                    <label class="layui-form-label">重复新密码</label>
                                                    <div class="layui-input-inline">
                                                        <input type="password" id="new-password2" name="newPassword2" lay-verify="password" placeholder="请重复输入新密码" autocomplete="off" class="layui-input">
                                                    </div>
                                                </div>
                                                <div class="layui-form-item">
                                                    <button class="layui-btn" lay-submit="" lay-filter="save">提交</button>
                                                </div>
                                            </form>
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

        form.verify({
            trueName: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,password: function(value){
                if(value!=""){
                    var oldPassword = $("#old-password").val();
                    if(oldPassword==""){
                        return '修改密码需要提供原始密码';
                    }
                    if($("#new-password2").val()!=$("#new-password1").val()){
                        return '两次输入密码不一致';
                    }
                }
            }
        });

        //监听保存提交
        form.on('submit(save)', function(data){
            console.log(data);
            $.ajax({
                url:'${pageContext.request.contextPath}/user/self',
                data:{'trueName':data.field.trueName,'oldPassword':data.field.oldPassword,'newPassword1':data.field.newPassword1,'newPassword2':data.field.newPassword2},
                type:'post',
                dataType:'json',
                traditional: true ,
                success: function (res) {
                    if(res.success){
                        layer.msg(res.message);
                        setTimeout(function(){
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                        },2000);
                    }else {
                        layer.alert(res.message);
                    }
                }
            });
            return false;
        });
    });
</script>
<script type="text/html" id="barRoleDemo">
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="assign">角色分配</a>
    <a class="layui-btn layui-btn-xs  layui-btn-danger" lay-event="remove">删除</a>
</script>
<script type="text/html" id="view">


    <a lay-event="view" style="cursor: pointer;"><i class="layui-icon">&#xe64c;预览</i></a>

</script>
</body>
</html>
