<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/11/21
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>贵州省检察院</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/templates/贵州省检察院/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/templates/贵州省检察院/css/style.css">
    <!--解决ie低版本不兼容h5新标签,不支持placeholder问题-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/html5shiv.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/slides.min.jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/jquery.placeholder.js"></script>

    <style type="text/css" >
        .TBTB {
            height: auto;
        }
    </style>

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
            <li class="index"><a href="${pageContext.request.contextPath}/${webInfo.id}/index">首页</a></li>
            <c:forEach items="${topColumnList}" var="topColumn">

                <li><a href="${pageContext.request.contextPath}/${topColumn.webId}/list/${topColumn.id}">${topColumn.coluName}</a></li>
            </c:forEach>
            <%--<li><a href="" target="">系统通知</a></li>
            <li><a href="" target="">工作报告</a></li>
            <li><a href="" target="">内部刊物</a></li>
            <li><a href="" target="">资讯中心</a></li>
            <li><a href="" target="">机关管理规定</a></li>
            <li><a href="" target="">法规规章</a></li>--%>
        </ul>
    </div>
    <!--部门导航-->
    <div class="department_nav content">
        <img src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/img/bumennav.png" alt="">
        <ul class="of">
            <c:forEach items="${groupList}" var="group">
                <li><a href="${pageContext.request.contextPath}/${webInfo.id}/group/${group.id}" target="">${group.groupName}</a></li>

            </c:forEach>

           <%-- <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">政治部</a></li>
            <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">办公室</a></li>
            <li><a href="" target="">刑事执行检察处 </a></li>
            <li><a href="" target="">民行处</a></li>
            <li><a href="" target="">控告处</a></li>
            <li><a href="" target="">申诉处</a></li>
            <li><a href="" target="">预防处</a></li>
            <li><a href="" target="">未检处</a></li>
            <li><a href="" target="">技术处</a></li>
            <li><a href="" target="">研究室</a></li>
            <li><a href="" target="">监察处</a></li>
            <li><a href="" target="">计财处</a></li>
            <li><a href="" target="">机关党办</a></li>
            <li><a href="" target="">案管办</a></li>
            <li><a href="" target="">目标办</a></li>
            <li><a href="" target="">基建办</a></li>
            <li><a href="" target="">服务中心</a></li>
            <li><a href="" target="">信息中心</a></li>--%>
        </ul>
    </div>
    <div class="content">
        <!--首页轮播 start-->
        <div id="index_banner" class="lf">
            <div id="slides">
                <div class="slides_container">
                    <c:forEach items="${picArticleList}" var="picArticle">
                        <div>
                            <a href="${pageContext.request.contextPath}/${picArticle.webId}/detail/${picArticle.id}" target="_blank">
                                <img src="${picArticle.firstPicPath}" width="620" height="332" alt="Slide 1">
                            </a>
                            <div class="caption" style="bottom:0">
                                <p>${picArticle.artTitle}</p>
                            </div>
                        </div>
                    </c:forEach>


                </div>
                <a href="#" class="prev"><</a>
                <a href="#" class="next">></a>
            </div>
        </div>
        <!--首页轮播end-->
        <!--首页选项卡start-->
        <div class="index_news rt">
            <div class="news_tab">
                <ul class="tab-hd">
                    <li class="active">${tzgg.coluName}<i></i></li>
                    <li>${zhyw.coluName}<i></i></li>
                    <li>${gddt.coluName}<i></i></li>
                </ul>
                <div class="tab-bd">
                    <div class="hidden thisclass">
                        <!--头条-->

                        <c:forEach items="${tzgg.articleList}" var="article" varStatus="status" end="0">
                            <div class="headline">
                                <p class="headline_tit shenglue">
                                    <a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}"> ${article.artTitle}
                                    </a>
                                </p>
                                <div class="headline_cont">
                                    <p>${article.artDigest}
                                        <a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}" class="more">【详情】</a>
                                    </p>
                                </div>
                            </div>
                        </c:forEach>

                        <ul>
                            <c:forEach items="${tzgg.articleList}" var="article" varStatus="status" begin="1">
                                <li><a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}">${article.artTitle} </a><span><fmt:formatDate value="${article.publishTime}" type="date" /></span></li>
                            </c:forEach>
                            <%--<li><a href="">贵州省检察院出台公诉司法裁量工作指导意见 </a><span>[07-17]</span></li>
                            <li><a href="">省院邀请75名大学生零距离了解检察工作 </a> <span>[07-17]</span></li>
                            <li><a href="">全省检察机关侦监公诉工作研讨会召开</a> <span>[07-17]</span></li>
                            <li><a href="">省院开展保障律师执业权利主题检察开放日活动 </a> <span>[07-17]</span></li>
                            <li><a href="">省院召开党员代表大会选举产生机关纪委委员</a> <span>[07-17]</span></li>
                            <li><a href="">省院贯彻落实全国检察机关智慧检务工作会精神 </a> <span>[07-17]</span></li>--%>
                        </ul>
                    </div>
                    <div class="hidden">  <%--综合要闻--%>
                        <!--头条-->

                        <c:forEach items="${zhyw.articleList}" var="article" varStatus="status" end="0">
                            <div class="headline">
                                <p class="headline_tit shenglue">
                                    <a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}"> ${article.artTitle}
                                    </a>
                                </p>
                                <div class="headline_cont">
                                    <p>${article.artDigest}
                                        <a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}" class="more">【详情】</a>
                                    </p>
                                </div>
                            </div>
                        </c:forEach>

                        <ul>
                            <c:forEach items="${zhyw.articleList}" var="article" varStatus="status" begin="1">
                                <li><a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}">${article.artTitle} </a><span><fmt:formatDate value="${article.publishTime}" type="date" /></span></li>
                            </c:forEach>
                            <%--<li><a href="">贵州省检察院出台公诉司法裁量工作指导意见 </a><span>[07-17]</span></li>
                            <li><a href="">省院邀请75名大学生零距离了解检察工作 </a> <span>[07-17]</span></li>
                            <li><a href="">全省检察机关侦监公诉工作研讨会召开</a> <span>[07-17]</span></li>
                            <li><a href="">省院开展保障律师执业权利主题检察开放日活动 </a> <span>[07-17]</span></li>
                            <li><a href="">省院召开党员代表大会选举产生机关纪委委员</a> <span>[07-17]</span></li>
                            <li><a href="">省院贯彻落实全国检察机关智慧检务工作会精神 </a> <span>[07-17]</span></li>--%>
                        </ul>
                    </div>
                    <div class="hidden"><!--头条--> <%--各地动态--%>

                        <c:forEach items="${gddt.articleList}" var="article" varStatus="status" end="0">
                            <div class="headline">
                                <p class="headline_tit shenglue">
                                    <a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}"> ${article.artTitle}
                                    </a>
                                </p>
                                <div class="headline_cont">
                                    <p>${article.artDigest}
                                        <a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}" class="more">【详情】</a>
                                    </p>
                                </div>
                            </div>
                        </c:forEach>

                        <ul>
                            <c:forEach items="${gddt.articleList}" var="article" varStatus="status" begin="1">
                                <li><a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}">${article.artTitle} </a><span><fmt:formatDate value="${article.publishTime}" type="date" /></span></li>
                            </c:forEach>
                            <%--<li><a href="">贵州省检察院出台公诉司法裁量工作指导意见 </a><span>[07-17]</span></li>
                            <li><a href="">省院邀请75名大学生零距离了解检察工作 </a> <span>[07-17]</span></li>
                            <li><a href="">全省检察机关侦监公诉工作研讨会召开</a> <span>[07-17]</span></li>
                            <li><a href="">省院开展保障律师执业权利主题检察开放日活动 </a> <span>[07-17]</span></li>
                            <li><a href="">省院召开党员代表大会选举产生机关纪委委员</a> <span>[07-17]</span></li>
                            <li><a href="">省院贯彻落实全国检察机关智慧检务工作会精神 </a> <span>[07-17]</span></li>--%>
                        </ul></div>
                </div>
            </div>
        </div>
        <!--首页选项卡end-->
    </div>
    <!--登录/检索-->
    <div class="content login search">
        <!--登录-->
        <div class="login_box lf">
            <p class="loginTit"><span>系统登录</span></p>
            <form action="" method="" name="">
                <input type="text" id="username" placeholder="请输入登录名">
                <input type="password" id="password" placeholder="请输入登录密码" class="pwd">
                <button type="button" id="sub">登录</button>
            </form>
        </div>
        <!--检索-->
        <div class="search_box">
            <form action="" method="" name="">
                <input type="text" placeholder="请输入检索文字">
                <button type="submit">站内检索</button>
            </form>
        </div>
        <!--栏目 各地风采-->
        <div class="column_box lf" style="width: 838px;height:190px;margin:10px 0 0 12px;">
            <p class="column_Tit of">
                <a href="${pageContext.request.contextPath}/${jcfc1.webId}/list/${jcfc1.id}" class="more rt">更多 >></a>
                <span class="shenglue lf">${jcfc1.coluName}</span>
            </p>
            <ul class="column_list of">
                <c:forEach items="${jcfc1.articleList}" var="article">
                    <li><span><fmt:formatDate value="${article.publishTime }" type="date"/></span><a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}">${article.artTitle}</a></li>
                </c:forEach>
            </ul>
        </div>
        <!--栏目end-->
    </div>
    <!--登录/检索-->
    <!--领导讲话-->
    <div class="content LDtalk of">
        <div class="column_box lf of" style="width: 98%">
            <p class="column_Tit of">
                <a href="${pageContext.request.contextPath}/${jcfc2.webId}/list/${jcfc2.id}" class="more rt">更多 >></a>
                <span class="shenglue lf">${jcfc2.coluName}</span>
            </p>
            <ul class="column_list of">

                <c:forEach items="${jcfc2.articleList}" var="article">
                    <li><span><fmt:formatDate value="${article.publishTime }" type="date"/></span><a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}">${article.artTitle}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <!--领导讲话-->
    <!--专题专栏-->
    <div class="content ztReport">
        <img src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/img/ztzl.png" alt="" class="lf">
        <div class="box lf">
            <div class="picbox">
                <ul class="piclist mainlist">
                    <c:forEach items="${picColumnList}" var="column">
                        <li><a href="${pageContext.request.contextPath}/${column.webId}/list/${column.id}" target="_blank"><img src="${pageContext.request.contextPath}/${column.coluImgPath}" width="254" height="80" /></a></li>
                    </c:forEach>
                    <%--<li><a href="" target="_blank"><img src="img/1.jpg" width="254" height="80" /></a></li>
                    <li><a href="" target="_blank"><img src="img/2.jpg" width="254" height="80"/></a></li>
                    <li><a href="" target="_blank"><img src="img/3.jpg" width="254" height="80"/></a></li>
                    <li><a href="" target="_blank"><img src="img/4.jpg" width="254" height="80"/></a></li>
                    <li><a href="" target="_blank"><img src="img/1.jpg" width="254" height="80"/></a></li>
                    <li><a href="" target="_blank"><img src="img/2.jpg" width="254" height="80"/></a></li>
                    <li><a href="" target="_blank"><img src="img/3.jpg" width="254" height="80"/></a></li>
                    <li><a href="" target="_blank"><img src="img/4.jpg" width="254" height="80"/></a></li>--%>
                </ul>
                <ul class="piclist swaplist"></ul>
            </div>
            <div class="og_prev"></div>
            <div class="og_next"></div>
        </div>
    </div>
    <!--专题专栏-->
    <!--办公室通报-->
    <div class="content TBTB">
        <!--1-->
        <div class="column_box lf of">
            <p class="column_Tit of">
                <a href="${pageContext.request.contextPath}/${jcfc3.webId}/list/${jcfc3.id}" class="more rt">更多 >></a>
                <span class="shenglue lf">${jcfc3.coluName}</span>
            </p>
            <ul class="column_list w100 of">
                <c:forEach items="${jcfc3.articleList}" var="article">
                    <li><span><fmt:formatDate value="${article.publishTime }" type="date"/></span><a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}">${article.artTitle}</a></li>
                </c:forEach>
                <%--<li><span>2017-10-13</span><a href="">贵州省检察院出台公诉司法指导意见</a></li>
                <li><span>2017-10-13</span><a href="">省院邀请75名大学生零距离检察工作</a></li>
                <li><span>2017-10-13</span><a href="">贵州省检察院出台公诉司法指导意见</a></li>
                <li><span>2017-10-13</span><a href="">省院邀请75名大学生零距离检察工作</a></li>
                <li><span>2017-10-13</span><a href="">全省检察机关侦监公诉工作研讨会</a></li>
                <li><span>2017-10-13</span><a href="">全省检察机关侦监公诉工作研讨会</a></li>--%>
            </ul>
        </div>
        <!--2-->
        <div class="column_box rt of">
            <p class="column_Tit of">
                <a href="${pageContext.request.contextPath}/${jcfc4.webId}/list/${jcfc4.id}" class="more rt">更多 >></a>
                <span class="shenglue lf">${jcfc4.coluName}</span>
            </p>
            <ul class="column_list w100 of">
                <c:forEach items="${jcfc4.articleList}" var="article">
                    <li><span><fmt:formatDate value="${article.publishTime }" type="date"/></span><a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}">${article.artTitle}</a></li>
                </c:forEach>
                <%--<li><span>2017-10-13</span><a href="">贵州省检察院出台公诉司法指导意见</a></li>
                <li><span>2017-10-13</span><a href="">省院邀请75名大学生零距离检察工作</a></li>
                <li><span>2017-10-13</span><a href="">贵州省检察院出台公诉司法指导意见</a></li>
                <li><span>2017-10-13</span><a href="">省院邀请75名大学生零距离检察工作</a></li>
                <li><span>2017-10-13</span><a href="">全省检察机关侦监公诉工作研讨会</a></li>
                <li><span>2017-10-13</span><a href="">全省检察机关侦监公诉工作研讨会</a></li>--%>
            </ul>
        </div>
        <!--3-->
        <div class="column_box lf of">
            <p class="column_Tit of">
                <a href="${pageContext.request.contextPath}/${jcfc5.webId}/list/${jcfc5.id}" class="more rt">更多 >></a>
                <span class="shenglue lf">${jcfc5.coluName}</span>
            </p>
            <ul class="column_list w100 of">
                <c:forEach items="${jcfc5.articleList}" var="article">
                    <li><span><fmt:formatDate value="${article.publishTime }" type="date"/></span><a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}">${article.artTitle}</a></li>
                </c:forEach>
                <%--<li><span>2017-10-13</span><a href="">贵州省检察院出台公诉司法指导意见</a></li>
                <li><span>2017-10-13</span><a href="">省院邀请75名大学生零距离检察工作</a></li>
                <li><span>2017-10-13</span><a href="">贵州省检察院出台公诉司法指导意见</a></li>
                <li><span>2017-10-13</span><a href="">省院邀请75名大学生零距离检察工作</a></li>
                <li><span>2017-10-13</span><a href="">全省检察机关侦监公诉工作研讨会</a></li>
                <li><span>2017-10-13</span><a href="">全省检察机关侦监公诉工作研讨会</a></li>--%>
            </ul>
        </div>
        <!--4-->
        <div class="column_box rt of">
            <p class="column_Tit of">
                <a href="${pageContext.request.contextPath}/${jcfc6.webId}/list/${jcfc6.id}" class="more rt">更多 >></a>
                <span class="shenglue lf">${jcfc6.coluName}</span>
            </p>
            <ul class="column_list w100 of">
                <c:forEach items="${jcfc6.articleList}" var="article">
                    <li><span><fmt:formatDate value="${article.publishTime }" type="date"/></span><a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}">${article.artTitle}</a></li>
                </c:forEach>
               <%-- <li><span>2017-10-13</span><a href="">贵州省检察院出台公诉司法指导意见</a></li>
                <li><span>2017-10-13</span><a href="">省院邀请75名大学生零距离检察工作</a></li>
                <li><span>2017-10-13</span><a href="">贵州省检察院出台公诉司法指导意见</a></li>
                <li><span>2017-10-13</span><a href="">省院邀请75名大学生零距离检察工作</a></li>
                <li><span>2017-10-13</span><a href="">全省检察机关侦监公诉工作研讨会</a></li>
                <li><span>2017-10-13</span><a href="">全省检察机关侦监公诉工作研讨会</a></li>--%>
            </ul>
        </div>
        <c:if test="${not empty lhColumnList}">
            <c:forEach items="${lhColumnList}" var="lhColumn" varStatus="status">
                <div class="column_box <c:if test="${status.index%2==0}">lf</c:if><c:if test="${status.index%2!=0}">rt</c:if> of">
                    <p class="column_Tit of">
                        <a href="${pageContext.request.contextPath}/${lhColumn.webId}/list/${lhColumn.id}" class="more rt">更多 >></a>
                        <span class="shenglue lf">${lhColumn.coluName}</span>
                    </p>
                    <ul class="column_list w100 of">
                        <c:forEach items="${lhColumn.articleList}" var="article">
                            <li><span><fmt:formatDate value="${article.publishTime }" type="date"/></span><a href="${pageContext.request.contextPath}/${article.webId}/detail/${article.id}">${article.artTitle}</a></li>
                        </c:forEach>
                            <%-- <li><span>2017-10-13</span><a href="">贵州省检察院出台公诉司法指导意见</a></li>
                             <li><span>2017-10-13</span><a href="">省院邀请75名大学生零距离检察工作</a></li>
                             <li><span>2017-10-13</span><a href="">贵州省检察院出台公诉司法指导意见</a></li>
                             <li><span>2017-10-13</span><a href="">省院邀请75名大学生零距离检察工作</a></li>
                             <li><span>2017-10-13</span><a href="">全省检察机关侦监公诉工作研讨会</a></li>
                             <li><span>2017-10-13</span><a href="">全省检察机关侦监公诉工作研讨会</a></li>--%>
                    </ul>
                </div>
            </c:forEach>

        </c:if>

    </div>
    <!--办公室通报-->
    <!--应用链接-->
    <div class="content YYlink">
        <div class="column_box of">
            <p class="column_Tit of">
                <!-- <a href="" class="more rt">更多 >></a> -->
                <span class="shenglue lf">应用链接</span>
            </p>
            <ul class="linkbox of">
                <li class="link1"><a href="">统一业务应用系统</a></li>
                <li class="link2"><a href="">软件下载</a></li>
                <li class="link3"><a href="">发布信息统计</a></li>
                <li class="link4"><a href="">发布信息查询</a></li>
            </ul>
        </div>
    </div>
    <!--应用链接end-->
    <!--各地链接-->
    <div class="department_nav content">
        <img src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/img/gdlink.png" alt="">
        <ul class="of GDlink">
            <li><a href="" target="">贵州省人民检察院 </a></li>
            <li><a href="" target="">贵阳市人民检察院</a></li>
            <li><a href="" target="">六盘水市人民检察院 </a></li>
            <li><a href="" target="">遵义市人民检察院  </a></li>
            <li><a href="" target="">安顺市人民检察院</a></li>
            <li><a href="" target="">黔西南州人民检察院</a></li>
            <li><a href="" target="">毕节市人民检察院</a></li>
            <li><a href="" target="">黔东南州人民检察院</a></li>
            <li><a href="" target="">黔东南州人民检察院</a></li>
            <li><a href="" target="">铜仁市人民检察院</a></li>
        </ul>
    </div>
    <!--各地链接end-->
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
    $(document).ready(function(){
        $("#sub").click(function(){
            var username = $("#username").val();

            var password = $("#password").val();

            if(username==""){
                alert("请输入登陆名");
                return false;
            }
            if(password==""){
                alert("请输入密码");
                return false;
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/dologin",
                type:"post",
                dataType:"json",
                data: {"username":username,"password":password},
                success:function(res){
                    if(res.success){
                        top.location = "${pageContext.request.contextPath}/article/index";
                    }else{
                        alert(res.message);
                    }
                }
            })


        });
    });

</script>


<script  type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/policeSystem.js"></script>
</body>
</html>
