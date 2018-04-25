<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/10/25
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="main_con">
        <div id="header">
            <div class="logo_wrap">
                <a href="">贵州省检察院门户网站群</a>
            </div>
            <div class="head_menu_wrap">
                <div class="top_wrap">
                    <%--<div class="lf lf_nav">
                        <!--<a href="">菜单管理</a>-->
                        <!--上次登录时间-->
                        <a href="#" class="lastTime">您上次登录的时间：2017-01-06 19:31</a>
                    </div>--%>
                    <div class="rt rt_nav">
                       <%-- <a href=""><i i class="fa fa-search " aria-hidden="true">&nbsp;&nbsp;</i>搜索</a>
                        <a href="">帮助中心</a>--%>
                        <a href="${pageContext.request.contextPath}/${userWebId}/index">返回前台</a>
                        <%--<a href="">更新缓存</a>--%>
                        <%--<a href="" >
                            <i class="fa fa-bell" aria-hidden="true">
                                <span class="messageAlert">5</span>
                            </i>
                        </a>--%>
                        <div id="user_box">
                            <!--用户姓名-->
                            <a class="">
                                ${currentUser.username}
                                <i class="fa fa-sort-desc"></i>
                                <i class="fa fa-user-circle-o"></i>
                            </a>

                            <!--系统管理员<a class="">系统管理员</a>-->
                            <div class="user-info-memu">
                                <div class="memu_list">
                                    <%--<a href="">基本资料</a>
                                    <a href="">实名认证</a>
                                    <a href="">安全设置</a>--%>
                                    <a href="${pageContext.request.contextPath}/logout">注销登录</a>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="btm_con" id="head_main_nav_wrap">
                    <div id="slider_box">
                        <ul id="js-slider_ul">
                            <li class=''>
                                <a href='${pageContext.request.contextPath}/article/index'>
                                    <p><i class="fa fa-2x fa-home"></i></p>
                                    <strong>首页</strong>
                                </a>
                            </li>
                            <li class=''>
                                <a href='${pageContext.request.contextPath}/article/index'>
                                    <p><i class="fa fa-2x fa-newspaper-o"></i></p>
                                    <strong>信息管理</strong>
                                </a>
                            </li>
                            <li class=''>
                                <a href='${pageContext.request.contextPath}/column/index'>
                                    <p><i class="fa fa-2x fa-cog"></i></p>
                                    <strong>栏目管理</strong>
                                </a>
                            </li>
                            <li class=''>
                                <a href='${pageContext.request.contextPath}/web/index'>
                                    <p><i class="fa fa-2x fa-object-group"></i></p>
                                    <strong>站点管理</strong>
                                </a>
                            </li>

                            <li class=''>
                                <a href='${pageContext.request.contextPath}/template/index'>
                                    <p><i class="fa fa-2x fa-list-alt"></i></p>
                                    <strong>模板管理</strong>
                                </a>
                            </li>

                            <li class=''>
                                <a href='${pageContext.request.contextPath}/group/index'>
                                    <p><i class="fa fa-2x fa-sitemap"></i></p>
                                    <strong>机构管理</strong>
                                </a>
                            </li>

                            <li class=''>
                                <a href='${pageContext.request.contextPath}/user/index'>
                                    <p><i class="fa fa-2x fa-id-card-o"></i></p>
                                    <strong>用户管理</strong>
                                </a>
                            </li>
                            <li class=''>
                                <a href=''>
                                    <p><i class="fa fa-2x fa-line-chart"></i></p>
                                    <strong>数据统计</strong>
                                </a>
                            </li>
                            <li class=''>
                                <a href=''>
                                    <p><i class="fa fa-2x fa-gears "></i></p>
                                    <strong>系统管理</strong>
                                </a>
                            </li>
                            <li class=''>
                                <a href='${pageContext.request.contextPath}/comment/index'>
                                    <p><i class="fa fa-2x fa-pencil"></i></p>
                                    <strong>评论管理</strong>
                                </a>
                            </li>
                            <%--<li class=''>
                                <a href=''>
                                    <p><i class="fa fa-2x fa-desktop"></i></p>
                                    <strong>办事大厅</strong>
                                </a>
                            </li>
                            <li class=''>
                                <a href=''>
                                    <p><i class="fa fa-2x fa-envelope-o"></i></p>
                                    <strong>信箱管理</strong>
                                </a>
                            </li>
                            <li class=''>
                                <a href=''>
                                    <p><i class="fa fa-2x fa-handshake-o"></i></p>
                                    <strong>快速理赔</strong>
                                </a>
                            </li>
                            <li class=''>
                                <a href=''>
                                    <p><i class="fa fa-2x fa-car"></i></p>
                                    <strong>自助移车</strong>
                                </a>
                            </li>
                            <li class=''>
                                <a href=''>
                                    <p><i class="fa fa-2x fa-comments"></i></p>
                                    <strong>在线调查</strong>
                                </a>
                            </li>
                            <li class=''>
                                <a href=''>
                                    <p><i class="fa fa-2x fa-bar-chart-o "></i></p>
                                    <strong>投票模块</strong>
                                </a>
                            </li>
                            <li class=''>
                                <a href=''>
                                    <p><i class="fa fa-2x fa-list-alt"></i></p>
                                    <strong>信息表单</strong>
                                </a>
                            </li>


                            <li class=''>
                                <a href=''>
                                    <p><i class="fa fa-2x fa-users"></i></p>
                                    <strong>民意征集</strong>
                                </a>
                            </li>--%>
                        </ul>
                    </div>
                    <!--<span id="slider_lf_btn" class="fa fa-chevron-left fa-2x"></span>-->
                    <span id="slider_rt_btn" class="fa fa-list-ul" aria-hidden="true"></span>
                </div>
            </div>
        </div>
    </div>
</header>
