<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/10/24
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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
            <ul class="submenu">
                <li><i class="fa fa-angle-right"></i><a href="notification.html">通知公告</a></li>
                <li><i class="fa fa-angle-right"></i><a href="#">会议管理</a></li>
                <li><i class="fa fa-angle-right"></i><a href="#">公车管理</a></li>
                <li><i class="fa fa-angle-right"></i><a href="#">公务接待</a></li>
                <li><i class="fa fa-angle-right"></i><a href="#">公文管理</a></li>
                <li><i class="fa fa-angle-right"></i><a href="leave.html">请休假</a></li>
                <li><i class="fa fa-angle-right"></i><a href="#">投票管理</a></li>
                <li><i class="fa fa-angle-right"></i><a href="#">添加更多</a></li>
            </ul>
        </li>
        <li>
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
        </li>
    </ul>
    <!--end-->
    <!--折叠-->
    <div id="fold_con">
        <a href="javascript:void(0)"  class="fold_open "><i class="fa fa-caret-right fa-lg"></i></a>
        <a href="javascript:void(0)"  class="fold_close active"><i class="fa fa-caret-left fa-lg"></i></a>
    </div>
    <!--折叠-->
</div>


