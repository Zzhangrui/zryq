<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/8/29
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fly/css/global.css">
</head>
<body>

<jsp:include page="head.jsp"/>

<div class="layui-container fly-marginTop">
    <div class="fly-panel" pad20 style="padding-top: 5px;">
        <!--<div class="fly-none">没有权限</div>-->
        <div class="layui-form layui-form-pane">
            <div class="layui-tab layui-tab-brief" lay-filter="user">
                <ul class="layui-tab-title">
                    <li class="layui-this">发表新帖<!-- 编辑帖子 --></li>
                </ul>
                <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
                    <div class="layui-tab-item layui-show">
                        <form class="layui-form" action="" style="padding: 20px;">
                            <input type="hidden" name="id" value="${article.id}">
                            <div class="layui-form-item">
                                <div class="layui-col-md3">
                                    <label class="layui-form-label">所在专栏</label>
                                    <div class="layui-input-block">
                                        <select lay-verify="required" name="coluId" lay-filter="column">
                                            <option></option>
                                            <c:forEach items="${columnList}" var="column" begin="0" end="10">
                                                <option value="${column.id}" <c:if test="${column.id eq article.coluId}"> selected</c:if>>${column.coluName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="layui-col-md9">
                                    <label for="L_title" class="layui-form-label">标题</label>
                                    <div class="layui-input-block">
                                        <input type="text" id="L_title" name="artTitle" value="${article.artTitle}" required lay-verify="required" autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                            </div>


                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">摘要</label>
                                <div class="layui-input-block">
                                    <textarea placeholder="不输入则自动获取文章前15个字" id="digest" name="artDigest" value="${article.artDigest}" class="layui-textarea"></textarea>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <label class="layui-form-label">来源</label>
                                    <div class="layui-input-inline">
                                        <input type="tel" name="artFrom" value="${article.artFrom}"  autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-inline">
                                    <label class="layui-form-label">作者</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="artAuthor" value="${article.artAuthor}"  autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                            </div>

                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">内容</label>
                                <div class="layui-input-block">
                                    <textarea placeholder="请输入内容" style="height: 340px;" name="artContent" id="editor_id" class="layui-textarea">${article.artContent}</textarea>
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <label class="layui-form-label">评论</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="openCommen" value="1" title="放开" <c:if test="${article.openCommen eq '1'}">checked=""</c:if> >
                                    <input type="radio" name="openCommen" value="2" title="禁止" <c:if test="${article.openCommen eq '2'}">checked=""</c:if>>
                                    <input type="radio" name="openCommen" value="3" title="审查" <c:if test="${article.openCommen eq '3'}">checked=""</c:if>>
                                    <input type="radio" name="openCommen" value="4" title="过滤" <c:if test="${article.openCommen eq '4'}">checked=""</c:if>>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit="" lay-filter="article-edit">保存</button>
                                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="foot.jsp"/>


<script src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/assets/admin/lib/kindeditor/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/assets/admin/lib/kindeditor/lang/zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/assets/fly/js/article.edit.js"></script>

<script>
    var contextPath = "${pageContext.request.contextPath}";
</script>

</body>
</html>
