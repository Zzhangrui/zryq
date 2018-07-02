<%--
  Created by IntelliJ IDEA.
  User: rui.zhang
  Date: 2018/6/21
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/assets/echarts/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/admin/js/jquery-1.9.1.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 1000px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '价格变化表'
        },
        tooltip: {},
        legend: {
            data:['元/吨']
        },
        xAxis: {
            type: 'category',
            data: []
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name: '元/吨',
            type: 'line',
            smooth: true,
            data: []
        }]
    };
    myChart.setOption(option);
    $.ajax({
        url:'${pageContext.request.contextPath}/metalDetail/view/${id}',
        type:'post',
        dataType:'json',
        success:function (data) {
            // 填入数据
            console.log(data.data.yAxisData);
            console.log(data.data);
            myChart.setOption({
                xAxis: {
                    data: data.data.xAxisData
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '元/吨',
                    type: 'line',
                    smooth: true,
                    data: data.data.yAxisData
                }]
            });
            // 使用刚指定的配置项和数据显示图表。
        }
    });



</script>
</body>
</html>
