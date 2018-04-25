<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/11/22
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>文章详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/templates/贵州省检察院/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/templates/贵州省检察院/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/templates/贵州省检察院/css/menu.css">
    <!--解决ie低版本不兼容h5新标签,不支持placeholder问题-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/html5shiv.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/slides.min.jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/jquery.placeholder.js"></script>
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
            <li class=""><a href="${pageContext.request.contextPath}/${article.webId}/index">首页</a></li>
            <c:forEach items="${topColumnList}" var="topColumn">

                <li <c:if test="${topColumn.id eq article.coluId}"> class="index"</c:if> ><a href="${pageContext.request.contextPath}/${topColumn.webId}/list/${topColumn.id}">${topColumn.coluName}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="list_content content fff">
        <!--面包屑导航-->
        <div class="listNav">
            <div class="breadNav rt of">
                <ul class="of">
                    <li class="MyLocation"><a href="">我的位置 :</a></li>
                    <li><a href="${pageContext.request.contextPath}/${article.webId}/index">首页 ></a></li>
                    <li><a href="${pageContext.request.contextPath}/${article.webId}/list/${article.coluId}">${article.coluName} </a></li>
                </ul>
            </div>
            <p class='listTit'><span class="shenglue">${article.coluName}</span></p>

        </div>
        <!--列表-->
        <div class="list of">
            <ul class="expmenu lf">
                <li>
                    <div class="header">
                        <span class="label" >首页  </span>
                        <span class="arrow up"></span>
                    </div>
                    <ul class="menu" style="display:block;">
                        <c:forEach items="${topColumnList}" var="topColumn">
                            <li><i></i><a href="${pageContext.request.contextPath}/${topColumn.webId}/list/${topColumn.id}">${topColumn.coluName}</a></li>
                            <%-- <li><a href="${pageContext.request.contextPath}/${topColumn.webId}/list/${topColumn.id}">${topColumn.coluName}</a></li>--%>
                        </c:forEach>
                        <%--<li><i></i><a href="javascript:void(0)">系统通知</a></li>
                        <li><i></i><a href="javascript:void(0)">工作报告</a></li>
                        <li><i></i><a href="javascript:void(0)">内部刊物</a></li>
                        <li><i></i><a href="javascript:void(0)">资讯中心</a></li>
                        <li><i></i><a href="javascript:void(0)">机关管理规定 </a></li>
                        <li><i></i><a href="javascript:void(0)">法规规章</a></li>--%>
                    </ul>
                </li>
                <!-- <li>
                    <div class="header">
                        <span class="label">栏目</span>
                        <span class="arrow down"></span>
                    </div>
                    <ul class="menu">
                        <li><i></i><a href="javascript:void(0)">系统通知</a></li>
                    </ul>
                </li> -->
            </ul>
            <!--右侧内容-->
            <div class="RTcont lf">
                <p class="RtTiT">${article.artTitle}</p>
                <div class="source">
                    <c:if test="${not empty article.artFrom}">
                        <span>来源:${article.artFrom}</span>
                    </c:if>

                    <c:if test="${not empty article.artAuthor}">
                        <span>作者:${article.artAuthor}</span>
                    </c:if>


                    <span>发布时间：<fmt:formatDate value="${article.publishTime }" type="date"/></span>
                    <%--<span>浏览（${click}）</span>--%>
                </div>
                <div class="WZdetails">
                    ${article.artContent}
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




<script  type="text/javascript" src="${pageContext.request.contextPath}/assets/templates/贵州省检察院/js/policeSystem.js"></script>
</body>
</html>
