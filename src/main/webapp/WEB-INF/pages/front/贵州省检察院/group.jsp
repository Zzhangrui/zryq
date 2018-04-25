<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/11/23
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>列表页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/templates/贵州省检察院/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/templates/贵州省检察院/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/templates/贵州省检察院/css/menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css"/>
    <!--解决ie低版本不兼容h5新标签,不支持placeholder问题-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/html5shiv.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/slides.min.jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/jquery.placeholder.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
</head>
<body>
<!--头部star-->
<div id="header">
    <div class="logo"><img src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/img/logo.png" alt=""></div>
</div>
<!--头部end-->

<!--主体star-->
<div id="section">
    <!--导航-->
    <div class="nav">
        <ul>
            <li class=""><a href="${pageContext.request.contextPath}/${group.webId}/index">首页</a></li>
            <c:forEach items="${topColumnList}" var="topColumn">

                <li <c:if test="${topColumn.id eq column.id}"> class="index"</c:if> ><a href="${pageContext.request.contextPath}/${topColumn.webId}/list/${topColumn.id}">${topColumn.coluName}</a></li>
            </c:forEach>
            <%--<li><a href="" target="">系统通知</a></li>
            <li><a href="" target="">工作报告</a></li>
            <li><a href="" target="">内部刊物</a></li>
            <li><a href="" target="">资讯中心</a></li>
            <li><a href="" target="">机关管理规定</a></li>
            <li><a href="" target="">法规规章</a></li>--%>
        </ul>
    </div>
    <div class="list_content content fff">
        <!--面包屑导航-->
        <div class="listNav">
            <div class="breadNav rt of">
                <ul class="of">
                    <li class="MyLocation"><a href="">我的位置 :</a></li>
                    <li><a href="${pageContext.request.contextPath}/${group.webId}/index">首页 ></a></li>
                    <li><a href="">${group.groupName} </a></li>
                </ul>
            </div>
            <p class='listTit'><span class="shenglue">${group.groupName}</span></p>

        </div>
        <!--列表-->
        <div class="list of">
           <%-- <ul class="expmenu lf">
                <li>
                    <div class="header">
                        <span class="label">首页  </span>
                        <span class="arrow up"></span>
                    </div>
                    <ul class="menu" style="display:block;">
                        <c:forEach items="${topColumnList}" var="topColumn">
                            <li><i></i><a href="${pageContext.request.contextPath}/${topColumn.webId}/list/${topColumn.id}">${topColumn.coluName}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>--%>
            <!--右侧内容-->
            <div class="RTcont lf">
                <ul class="" id="art_list">
                </ul>
                <div>
                    <table id="article" class="layui-table" lay-filter="test" lay-skin="nob"></table>

                    <div id="page" style="text-align: center;"></div>
                </div>
            </div>
            <!--右侧内容end-->
        </div>
        <!--分页-->
        <div class="Paging"></div>
    </div>
</div>
<!--主体end-->

<!--尾部star-->
<div id="footer">
    <!--关于我们-->
    <div class="AboutUs of">
        <div class="content">
            <ul class="of">
                <li><a href="">关于我们 |</a></li>
                <li><a href="">联系我们 |</a></li>
                <li><a href="">法律声明 |</a></li>
                <li><a href="">网站地图 |</a></li>
                <li><a href="">后台管理</a></li>
            </ul>
        </div>
    </div>
    <!--技术支持-->
    <div class="JSZC">
        <div class="content">
            <ul class="of">
                <li>
                    <p>版权所有：贵州省人民检察院版权所有</p>
                </li>
                <li>
                    <span>技术支持：江苏连邦信息技术有限公司</span>
                    <p>建议使用1024*768分辨率，IE7.0以上版本浏览器浏览</p>
                </li>
            </ul>
        </div>
    </div>
</div>
<!--尾部end-->
<script type="text/javascript">
    var layer = "";
    var form = "";
    var table = "";
    var laypage = "";
    var coluId = "";
    var coluName = "";
    layui.use(['layer', 'form', 'table', 'laypage'], function () {
        layer = layui.layer, form = layui.form, table = layui.table, laypage = layui.laypage;

        putData("1", coluId);


        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if (layEvent === 'edit') { //编辑
                var id = data.id;
                modify_show(id);
            } else if (layEvent === 'publish') { //发布
                var id = data.id;
                updateState("确认要发布该信息？", id, "4");
            } else if (layEvent === 'view') { //查看
                var id = data.id;
                view(id);
            }
        });

    });


    //全局页面
    var initNum = "0";
    /**
     * 填充数据
     * */

    function putData(pageNum, coluId) {
        $.getJSON('${pageContext.request.contextPath}/${group.webId}/groupData/${group.id}', {
            pageNum: pageNum //向服务端传的参数
        }, function (res) {
            var data = res.data;
            var len = data.length;
            initNum = pageNum;  //当前页码存到全局变量中
            //自定义样式

            var html = "";

            console.log();
            if (res.data.length < 1) {
                html = "<li style='text-align: center;'>暂未发布相关信息</li>"
            } else {
                $.each(res.data, function (index, value) {

                    var time = value.publishTime;

                    if (time != null && time.length > 11) {
                        time = time.substring(0, 11);
                    }

                    var url = "${pageContext.request.contextPath}/" + value.webId + "/detail/" + value.id;
                    html = html + "<li><span>" + time + "</span><a href='" + url + "'>" + value.artTitle + "</a></li>";
                    /*var optinon = "<option value=\""+value.id+"\">"+value.webName+"</option>";
                     jQuery("#webId").append(optinon);*/
                });
            }


            $("#art_list").html(html);

            laypage.render({
                elem: 'page'
                , count: res.count
                , theme: '#1E9FFF'
                , curr: pageNum
                , jump: function (obj, first) {
                    if (!first) {
                        putData(obj.curr, coluId);
                    }
                }
            });


            /*table.render({
             elem: '#article' //指定原始表格元素选择器（推荐id选择器）
             /!*, height: 450 //容器高度
             ,width: 650*!/
             ,id: 'idTest'
             , data: data
             , cols: [[
             {checkbox: true}
             ,{field: 'artTitle', title: '标题', width: 200, sort: false}
             , {field: 'artDigest', title: '摘要', width: 200, sort: false}
             , {field: 'createTime', title: '创建时间', width: 200, sort: true}
             , {field: 'createTime', title: '创建人', width: 200, sort: true}
             , {field: 'coluName', title: '所属栏目', width: 200, sort: true}
             , {fixed: 'right', title: '操作', width: 153, align: 'center', templet: '#barDemo'}
             ]] //设置表头
             //,…… //更多参数参考右侧目录：基本参数选项
             });*/
        });
    }
    ;

</script>


<script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/policeSystem.js"></script>
</body>
</html>