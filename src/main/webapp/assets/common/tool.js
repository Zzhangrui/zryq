$(function () {
    //.ajaxError事件定位到document对象，文档内所有元素发生ajax请求异常，都将冒泡到document对象的ajaxError事件执行处理
    $(document).ajaxError(
        //所有ajax请求异常的统一处理函数，处理
        function (event, xhr, options, exc) {
            //console.log(JSON.stringify(xhr)+'|'+'|'+exc);
            switch (xhr.status) {
                case 401:
                    // 未授权异常
                    layer.msg("系统拒绝：您没有权限操作。");
                    break;

                case 500:
                    layer.msg("服务端错误：请联系管理员。");
                    break;
            }
        }
    );
});

function ajax(url, param, type, dataType) {
    return $.ajax({
        dataType: dataType || 'JSON',
        url: url,
        data: param || {},
        type: type || 'GET',
        contentType: "application/json"
    });
}
function ajaxHtml(url, param, type) {
    return $.ajax({
        dataType: 'html',
        url: url,
        data: param || {},
        type: type || 'GET'
    });
}
var tool = {
    handleAjax: function (url, param, type) {
        return ajax(url, param, type).then(function (resp) {
            return resp;
        }, function (resp, textStatus, error) {
            //console.log(JSON.stringify(resp) + '|' +textStatus+'|'+error);
            //toastr.warning(resp.responseText);
            return resp; // 打印状态码
        });
    },

    handleAjaxHtml: function (url, param, type) {
        return ajaxHtml(url, param, type).then(function (resp) {
            return resp;
        }, function (resp) {
            return resp; // 打印状态码
        });
    }
}



var DateUtil = {
    _formatDate : function(date) {
        var month = date.getMonth()+1 < 10? '0'+(date.getMonth()+1):date.getMonth()+1;
        var day = date.getDate()<10?'0'+date.getDate():date.getDate();
        var hours = date.getHours()<10?'0'+date.getHours():date.getHours();
        var min = date.getMinutes()<10?'0'+date.getMinutes():date.getMinutes();
        var sec = date.getSeconds()<10?'0'+date.getSeconds():date.getSeconds();
        return date.getFullYear()+"-"+month+"-"+day+" "+hours+":"+min+":"+sec;
    },
    //获取与当前时间相比前面间隔时间
    _formatLastSpaceDate : function(day){
        var time = new Date().getTime()-day*24*60*60*1000;
        var newDate = new Date(time);
        return DateUtil._formatDate(newDate)
    }
}



