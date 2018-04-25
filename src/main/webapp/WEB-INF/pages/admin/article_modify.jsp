<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/11/1
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增文章</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui/css/layui.css"/>
</head>
<body>
<div>
    <form class="layui-form" action="" style="padding: 20px;">
        <input type="hidden" name="id" value="${article.id}">
        <div class="layui-form-item">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-block">
                <input type="text" name="artTitle" value="${article.artTitle}" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">摘要</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入摘要"  id="digest" name="artDigest" class="layui-textarea">${article.artDigest}</textarea>
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
                    <input type="text" name="artAuthor"  value="${article.artAuthor}" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">内容</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容"  style="height: 340px;" name="artContent" id="editor_id" class="layui-textarea">${article.artContent}</textarea>
            </div>
        </div>

        <%--<div class="layui-form-item">
            <label class="layui-form-label">文件上传</label>
            <div class="layui-input-block">
                <button type="button" class="layui-btn" id="test3"><i class="layui-icon"></i>请选择文件</button><span id="file-clean">
            <c:if test="${not empty studyResource.fileName && not empty studyResource.filePath}">
                <a style='margin-left:10px;font-size:16px;'>${studyResource.fileName}<i onclick='clearFile()' class='layui-icon' style='font-size: 22px;margin-left: 22px;cursor: pointer;'>&#x1006;</i> </a>
            </c:if>
        </span>
            </div>
        </div>

        <div class="layui-upload">
            <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button>
            <div class="layui-upload-list">
                <table class="layui-table">
                    <thead>
                    <tr><th>文件名</th>
                        <th>大小</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr></thead>
                    <tbody id="demoList"></tbody>
                </table>
            </div>
            <button type="button" class="layui-btn" id="testListAction">开始上传</button>
        </div>--%>


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
                <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/assets/admin/lib/kindeditor/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/assets/admin/lib/kindeditor/lang/zh-CN.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate','layer','jquery','upload'], function(){
        var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate
                ,upload = layui.upload;
        var $ = layui.$; //重点处




        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            data.field.artContent =  editor.html();
            $.ajax({
                url:"${pageContext.request.contextPath}/article/${url}",
                data:data.field,
                type:'post',
                dataType:'json',
                success: function (res) {
                    if(res.success){
                        layer.msg("编辑成功，2秒后页面自动刷新");
                        setTimeout(function(){
                            //top.location.reload();  //直接刷新父页面
                            //当你在iframe页面关闭自身时
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                        },2000);
                    }else {
                        layer.alert("提交失败，请刷新后再试");
                    }
                }
            });
            return false;
        });

        //指定允许上传的文件类型
        upload.render({
            elem: '#test3'
            ,url: '${pageContext.request.contextPath}/upload'
            ,accept: 'file' //普通文件
            ,size:20480    //20M
            ,data:{dirPath:"study"}
            ,done: function(res){
                if(res.code =="0"){
                    var fileHtml = "";
                    fileHtml = fileHtml + "<a style='margin-left:10px;font-size:16px;'>"+res.fileName+"<i onclick='clearFile()' class='layui-icon' style='font-size: 22px;margin-left: 22px;cursor: pointer;'>&#x1006;</i> </a>";
                    $("#file-clean").html(fileHtml);
                    $("#fileName").val(res.fileName);
                    $("#filePath").val(res.url);
                }
            }
        });

        var demoListView = $('#demoList')
                ,uploadListIns = upload.render({
            elem: '#testList'
            ,url: '${pageContext.request.contextPath}/upload'
            ,data:{dirPath:"article"}
            ,accept: 'file'
            ,multiple: true
            ,auto: false
            ,bindAction: '#testListAction'
            ,choose: function(obj){
                var files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function(index, file, result){
                    var tr = $(['<tr id="upload-'+ index +'">'
                        ,'<td>'+ file.name +'</td>'
                        ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                        ,'<td>等待上传</td>'
                        ,'<td>'
                        ,'<button class="layui-btn layui-btn-mini demo-reload layui-hide">重传</button>'
                        ,'<button class="layui-btn layui-btn-mini layui-btn-danger demo-delete">删除</button>'
                        ,'</td>'
                        ,'</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function(){
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function(){
                        delete files[index]; //删除对应的文件
                        tr.remove();
                    });

                    demoListView.append(tr);
                });
            }
            ,done: function(res, index, upload){
                if(res.code == 0){ //上传成功
                    var tr = demoListView.find('tr#upload-'+ index)
                            ,tds = tr.children();
                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html(''); //清空操作
                    delete files[index]; //删除文件队列已经上传成功的文件
                    return;
                }
                this.error(index, upload);
            }
            ,error: function(index, upload){
                var tr = demoListView.find('tr#upload-'+ index)
                        ,tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });


    });

    jQuery(document).ready(function () {
        KindEditor.ready(function(K) {
            window.editor = K.create('#editor_id',{
                uploadJson : '${pageContext.request.contextPath }/upload_json.jsp',
                fileManagerJson : '${pageContext.request.contextPath }/file_manager_json.jsp',
                allowFileManager : false,
                items : [
                    'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                    'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                    'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                    'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                    'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                    'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
                    'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                    'anchor', 'link', 'unlink', '|', 'about'
                ]
            });
        });
    });
</script>
</html>
